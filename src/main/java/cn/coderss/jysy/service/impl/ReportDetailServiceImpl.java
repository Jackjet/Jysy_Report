package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.domain.JysyModel;
import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.utility.FileUtilitys;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

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

    public String readOnlineExcel(List<LinkedHashMap<String, String>> onlineData, String region, String statistics, String sign_ways,
                                  String pay_ways, String startDate, String endDate, String myFilePath, String nowTime) throws Exception {
        head_title.addAll(Arrays.asList("省", "市","县","单位","单位类型_1","单位类型_2",
                "用户名","姓名","性别","出生年月","邮箱","职务","报名方式","注册时间",
                "支付状态","支付方式","支付时间","发票信息","详细地址","已完成课时","证书获得状态","证书获得时间","证书编码"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        XSSFWorkbook wb = new XSSFWorkbook();
        StringBuilder sheetStr = new StringBuilder();
        XSSFSheet sheet = wb.createSheet(sheetStr.append(startDate).append("_").append(endDate).toString());
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
        //todo 这里要增加一个/var/www
        String filepath = myFilePath + "分省学员情况统计表.xlsx";
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
            this.writeExcel(myFilePath,startDate,endDate);
            if(!region.equals("全国")){
                this.delThreeExcel(myFilePath);
            }
            FileUtilitys.fileToZip(myFilePath, myFilePath, nowTime);
            this.clearData();

            return myFilePath + nowTime + ".zip";
        } catch (Exception var23) {
            return "上传失败 " + filepath + " => " + var23.getMessage();
        }
    }

    public void writeExcel(String filepath, String startDate,String endDate) throws Exception {
        FileOutputStream outStream = null;
        Iterator var3 = array_province.iterator();

        while(var3.hasNext()) {
            String provinceName = (String)var3.next();
            ArrayList<JysyModel> arr = (ArrayList)data.get(provinceName);
            XSSFWorkbook wb = new XSSFWorkbook();
            StringBuilder sheetStr = new StringBuilder();
            XSSFSheet sheet = wb.createSheet(sheetStr.append(startDate).append("_").append(endDate).toString());
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
                JysyModel model = arr.get(i);
                Class modelClass = model.getClass();

                int fieldIndex = 0;
                for (Field field:modelClass.getFields()){
                    row.createCell(fieldIndex).setCellValue(field.get(model).toString());
                    fieldIndex++;
                }
            }

            if(!provinceName.equals("省") && !provinceName.equals("")) {
                StringBuilder fileStringBuilder = new StringBuilder();
                fileStringBuilder.append(filepath);
                if(filepath.charAt(filepath.length() - 1) != 47) {
                    fileStringBuilder.append("/");
                }
                fileStringBuilder.append(provinceName).append(startDate.replace("-","")).append("_").append(endDate.replace("-","")).append(".xlsx");
                outStream = new FileOutputStream(fileStringBuilder.toString());
                this.logger.info("文件地址:" + provinceName + ".xlsx -- " + provinceName);
                wb.write(outStream);
                outStream.flush();
                outStream.close();
            }
        }

    }

    public String doExcel(MultipartFile file, String myFilePath) throws UnsupportedEncodingException {
        //future to do some thing
        return null;
    }

    public void clearData() {
        array_province.clear();
        data.clear();
        head_title.clear();
    }

    public void delThreeExcel(String filePath){
        File allFile = new File(filePath+"全国分省学员人数汇总表.xlsx");
        allFile.delete();
        File provinceFile = new File(filePath+"各省学员报名情况统计汇总表.xlsx");
        provinceFile.delete();
        File detailFile = new File(filePath+"分省学员情况统计表.xlsx");
        detailFile.delete();
    }

}
