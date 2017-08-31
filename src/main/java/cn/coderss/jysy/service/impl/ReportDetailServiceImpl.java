package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.domain.JysyModel;
import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.utility.FileUtilitys;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReportDetailServiceImpl implements ReportDetailService {
    public static HashMap<String, ArrayList<JysyModel>> data = new HashMap();
    public static ArrayList<String> array_province = new ArrayList();
    public static ArrayList<String> head_title = new ArrayList();
    Logger logger = LoggerFactory.getLogger(ReportDetailServiceImpl.class);

    public ReportDetailServiceImpl() {
    }

    public void readExcel(String filename) throws Exception {
        this.logger.info("文件名:" + filename);
        InputStream inputStream = null;
        Workbook wb = null;
        inputStream = new FileInputStream(filename);
        wb = new XSSFWorkbook(inputStream);
        Sheet sheet = wb.getSheetAt(0);
        Iterator rows = sheet.rowIterator();

        String province_str;
        while(rows.hasNext()) {
            Row row = (Row)rows.next();
            province_str = row.getCell(0).toString();
            if(!province_str.equals("省") && !array_province.contains(province_str)) {
                array_province.add(province_str);
            }
        }

        Iterator var13 = array_province.iterator();

        while(var13.hasNext()) {
            province_str = (String)var13.next();
            Sheet sheet1 = wb.getSheetAt(0);
            Iterator<Row> rows1 = sheet1.rowIterator();
            ArrayList da = new ArrayList();

            while(rows1.hasNext()) {
                Row row = (Row)rows1.next();
                if(province_str.equals(row.getCell(0).toString())) {
                    JysyModel model = new JysyModel(row.getCell(0).toString(), row.getCell(1) == null?"":row.getCell(1).toString(), row.getCell(2) == null?"":row.getCell(2).toString(), row.getCell(3) == null?"":row.getCell(3).toString(), row.getCell(4) == null?"":row.getCell(4).toString(), row.getCell(5) == null?"":row.getCell(5).toString(), row.getCell(6) == null?"":row.getCell(6).toString(), row.getCell(7) == null?"":row.getCell(7).toString(), row.getCell(8) == null?"":row.getCell(8).toString(), row.getCell(9) == null?"":row.getCell(9).toString(), row.getCell(10) == null?"":row.getCell(10).toString(), row.getCell(11) == null?"":row.getCell(11).toString(), row.getCell(12) == null?"":row.getCell(12).toString(), row.getCell(13) == null?"":row.getCell(13).toString(), row.getCell(14) == null?"":row.getCell(14).toString(), row.getCell(15) == null?"":row.getCell(15).toString(), row.getCell(16) == null?"":row.getCell(16).toString(), row.getCell(17) == null?"":row.getCell(17).toString(), row.getCell(18) == null?"":row.getCell(18).toString(), row.getCell(19) == null?"":row.getCell(19).toString(), row.getCell(20) == null?"":row.getCell(20).toString(), row.getCell(21) == null?"":row.getCell(21).toString(), row.getCell(22) == null?"":row.getCell(22).toString());
                    da.add(model);
                }
            }

            data.put(province_str, da);
        }

        inputStream.close();
    }

    public String readOnlineExcel(List<LinkedHashMap<String, String>> onlineData, String region, String statistics, String sign_ways, String pay_ways, String startDate, String endDate, String myFilePath, String nowTime) throws Exception {
        head_title.add("省");
        head_title.add("市");
        head_title.add("县");
        head_title.add("单位");
        head_title.add("单位类型_1");
        head_title.add("单位类型_2");
        head_title.add("用户名");
        head_title.add("姓名");
        head_title.add("性别");
        head_title.add("出生年月");
        head_title.add("邮箱");
        head_title.add("职务");
        head_title.add("报名方式");
        head_title.add("注册时间");
        head_title.add("支付状态");
        head_title.add("支付方式");
        head_title.add("支付时间");
        head_title.add("发票信息");
        head_title.add("详细地址");
        head_title.add("已完成课时");
        head_title.add("证书获得状态");
        head_title.add("证书获得时间");
        head_title.add("证书编码");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("tmp");
        XSSFRow headRow = sheet.createRow(0);

        int row_index;
        for(row_index = 0; row_index < head_title.size(); ++row_index) {
            headRow.createCell(row_index).setCellValue((String)head_title.get(row_index));
        }

        row_index = 0;

        for(int i = 0; i < onlineData.size(); ++i) {
            LinkedHashMap<String, String> map = (LinkedHashMap)onlineData.get(i);
            XSSFRow row = null;
            if((map.get("province") == null || ((String)map.get("province")).equals(region) || region.equals("全国")) && (map.get("sign_ways") == null || ((String)map.get("sign_ways")).equals(sign_ways) || sign_ways.equals("all")) && (map.get("order_states") == null || ((String)map.get("order_states")).equals(pay_ways) || pay_ways.equals("all"))) {
                Date pay_time = null;
                Date createtime = null;
                if(map.get("pay_time") != null) {
                    pay_time = new Date(dateFormat.parse(((String)map.get("pay_time")).toString()).getTime());
                } else if(statistics.equals("支付用户") && pay_time == null) {
                    continue;
                }

                if(map.get("createtime") != null) {
                    createtime = new Date(dateFormat.parse(((String)map.get("createtime")).toString()).getTime());
                } else if(createtime == null && statistics.equals("注册用户")) {
                    continue;
                }

                if((pay_time == null || !statistics.equals("支付用户") || pay_time.compareTo(dateFormat.parse(endDate)) < 0 && pay_time.compareTo(dateFormat.parse(startDate)) > 0) && (createtime == null || !statistics.equals("注册用户") || createtime.compareTo(dateFormat.parse(endDate)) < 0 && createtime.compareTo(dateFormat.parse(startDate)) > 0)) {
                    row = sheet.createRow(row_index + 1);
                    ++row_index;
                    int index = 0;
                    Iterator var21 = map.entrySet().iterator();

                    while(var21.hasNext()) {
                        Entry<String, String> m = (Entry)var21.next();
                        row.createCell(index++).setCellValue((String)m.getValue());
                    }
                }
            }
        }

        this.logger.info("创建相关文件");
        String filepath = "/var/www/" + myFilePath + "detail.xlsx";
        FileOutputStream outStream = new FileOutputStream(filepath);
        wb.write(outStream);
        outStream.flush();
        outStream.close();
        this.logger.info("创建相关文件完成");
        onlineData.clear();
        Runtime.getRuntime().gc();
        this.logger.info("清楚onlineData成功");

        try {
            this.readExcel(filepath);
            this.writeExcel(myFilePath);
            FileUtilitys.fileToZip(myFilePath, myFilePath, nowTime);
            this.clearData();
            return myFilePath + nowTime + ".zip";
        } catch (Exception var23) {
            return "上传失败 " + filepath + " => " + var23.getMessage();
        }
    }

    public void writeExcel(String filepath) throws Exception {
        FileOutputStream outStream = null;
        Iterator var3 = array_province.iterator();

        while(var3.hasNext()) {
            String provinceName = (String)var3.next();
            this.logger.info("省份:" + provinceName);
            ArrayList<JysyModel> arr = (ArrayList)data.get(provinceName);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("tmp");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, head_title.size()));
            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment((short) 2);
            XSSFRow head_top = sheet.createRow(0);
            XSSFCell top_cell = head_top.createCell(0);
            top_cell.setCellValue(provinceName + "在线培训学员注册与学习情况统计表");
            top_cell.setCellStyle(cellStyle);
            XSSFRow head = sheet.createRow(1);

            int i;
            for(i = 0; i < head_title.size(); ++i) {
                head.createCell(i).setCellValue((String)head_title.get(i));
            }

            for(i = 0; i < arr.size(); ++i) {
                XSSFRow row = sheet.createRow(i + 2);
                row.createCell(0).setCellValue(((JysyModel)arr.get(i)).getProvinceName());
                row.createCell(1).setCellValue(((JysyModel)arr.get(i)).getCityName());
                row.createCell(2).setCellValue(((JysyModel)arr.get(i)).getCountyName());
                row.createCell(3).setCellValue(((JysyModel)arr.get(i)).getSchoolName());
                row.createCell(4).setCellValue(((JysyModel)arr.get(i)).getDanwei_1());
                row.createCell(5).setCellValue(((JysyModel)arr.get(i)).getDanwei_2());
                row.createCell(6).setCellValue(((JysyModel)arr.get(i)).getUserName());
                row.createCell(7).setCellValue(((JysyModel)arr.get(i)).getFullName());
                row.createCell(8).setCellValue(((JysyModel)arr.get(i)).getSex());
                row.createCell(9).setCellValue(((JysyModel)arr.get(i)).getBirthDay());
                row.createCell(10).setCellValue(((JysyModel)arr.get(i)).getMail());
                row.createCell(11).setCellValue(((JysyModel)arr.get(i)).getZhiWu());
                row.createCell(12).setCellValue(((JysyModel)arr.get(i)).getSignWays());
                row.createCell(13).setCellValue(((JysyModel)arr.get(i)).getCreatetime());
                row.createCell(14).setCellValue(((JysyModel)arr.get(i)).getPaySatatus());
                row.createCell(15).setCellValue(((JysyModel)arr.get(i)).getPayWays());
                row.createCell(16).setCellValue(((JysyModel)arr.get(i)).getPayTimes());
                row.createCell(17).setCellValue(((JysyModel)arr.get(i)).getFapiao());
                row.createCell(18).setCellValue(((JysyModel)arr.get(i)).getDetailAddress());
                row.createCell(19).setCellValue(((JysyModel)arr.get(i)).getFinishTime());
                row.createCell(20).setCellValue(((JysyModel)arr.get(i)).getCerStatus());
                row.createCell(21).setCellValue(((JysyModel)arr.get(i)).getCerTime());
                row.createCell(22).setCellValue(((JysyModel)arr.get(i)).getCerCode());
            }

            if(provinceName != "省") {
                if(filepath.charAt(filepath.length() - 1) == 47) {
                    if(provinceName.equals("陕西省")) {
                        outStream = new FileOutputStream(filepath + provinceName+ ".xlsx");
                    } else {
                        outStream = new FileOutputStream(filepath + provinceName + ".xlsx");
                    }
                } else if(provinceName.equals("陕西省")) {
                    outStream = new FileOutputStream(filepath + "/" + provinceName+ ".xlsx");
                } else {
                    outStream = new FileOutputStream(filepath + "/" + provinceName + ".xlsx");
                }

                this.logger.info("文件地址:" + provinceName + ".xlsx -- " + provinceName);
                wb.write(outStream);
                outStream.flush();
                outStream.close();
            }
        }

    }

    public String doExcel(MultipartFile file, String myFilePath) throws UnsupportedEncodingException {
        String fileEncode = System.getProperty("file.encoding");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String nowTime = format.format(new Date());
        String datePath = "downloads/" + nowTime;
        String uuid = UUID.randomUUID().toString();
        String fileName = datePath + "/" + uuid + "/" + file.getOriginalFilename();
        String dirs = datePath + "/" + uuid + "/";
        FileUtilitys.makeDir(dirs);
        if(!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
                stream.write(bytes);
                stream.close();
                this.readExcel(fileName);
                this.writeExcel(dirs);
                FileUtilitys.fileToZip(dirs, dirs, nowTime);
                this.clearData();
                return "redirect:/report/" + dirs + nowTime + ".zip";
            } catch (Exception var12) {
                return "上传失败 " + fileName + " => " + var12.getMessage();
            }
        } else {
            return "上传失败 " + fileName + " 因为文件为空";
        }
    }

    public void clearData() {
        array_province.clear();
        data.clear();
        head_title.clear();
    }
}
