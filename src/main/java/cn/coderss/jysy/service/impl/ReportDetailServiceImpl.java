package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.domain.JysyModel;
import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.utility.FileUtilitys;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.apache.poi.ss.usermodel.Cell;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午3:03
 * Blog: http://www.coderss.cn
 */
@Service
public class ReportDetailServiceImpl implements ReportDetailService {
    public static HashMap<String, ArrayList<JysyModel>> data = new HashMap<String, ArrayList<JysyModel>>();
    public static ArrayList<String> array_province = new ArrayList<String>();
    public static ArrayList<String> head_title = new ArrayList<String>();
    Logger logger = LoggerFactory.getLogger(ReportDetailServiceImpl.class);




    @Override
    public void readExcel(String filename) throws IOException {
        InputStream inputStream = null;
        Workbook wb = null;
        try {
            inputStream = new FileInputStream(filename);
            wb = new XSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()){
                Row row = rows.next();
                String province = row.getCell(0).toString();
                if (!province.equals("省") && !array_province.contains(province)){
                    array_province.add(province);
                }
                if (province.equals("省")){
                    Iterator<Cell> cells = row.cellIterator();
                    while (cells.hasNext()){
                        head_title.add(cells.next().toString());
                    }
                }
            }

            for (String province_str: array_province) {
                Sheet sheet1 = wb.getSheetAt(0);
                Iterator<Row> rows1 = sheet1.rowIterator();
                ArrayList<JysyModel> da = new ArrayList<JysyModel>();
                while (rows1.hasNext()){
                    Row row = rows1.next();
                    if(province_str.equals(row.getCell(0).toString())){
                        JysyModel model = new JysyModel(row.getCell(0).toString(),
                                row.getCell(1)==null ? "" : row.getCell(1).toString(),
                                row.getCell(2)==null ? "" : row.getCell(2).toString(),
                                row.getCell(3)==null ? "" : row.getCell(3).toString(),
                                row.getCell(4)==null ? "" : row.getCell(4).toString(),
                                row.getCell(5)==null ? "" : row.getCell(5).toString(),
                                row.getCell(6)==null ? "" : row.getCell(6).toString(),
                                row.getCell(7)==null ? "" : row.getCell(7).toString(),
                                row.getCell(8)==null ? "" : row.getCell(8).toString(),
                                row.getCell(9)==null ? "" : row.getCell(9).toString(),
                                row.getCell(10)==null ? "" : row.getCell(10).toString(),
                                row.getCell(11)==null ? "" : row.getCell(11).toString(),
                                row.getCell(12)==null ? "" : row.getCell(12).toString(),
                                row.getCell(13)==null ? "" : row.getCell(13).toString(),
                                row.getCell(14)==null ? "" : row.getCell(14).toString(),
                                row.getCell(15)==null ? "" : row.getCell(15).toString(),
                                row.getCell(16)==null ? "" : row.getCell(16).toString(),
                                row.getCell(17)==null ? "" : row.getCell(17).toString(),
                                row.getCell(18)==null ? "" : row.getCell(18).toString(),
                                row.getCell(19)==null ? "" : row.getCell(19).toString(),
                                row.getCell(20)==null ? "" : row.getCell(20).toString(),
                                row.getCell(21)==null ? "" : row.getCell(21).toString(),
                                row.getCell(22)==null ? "" : row.getCell(22).toString()
                        );
                        da.add(model);
                    }
                }
                data.put(province_str,da);
            }


        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            inputStream.close();
        }
    }

    @Override
    public String readOnlineExcel(List<LinkedHashMap<String, String>> onlineData,String region,String statistics,
                                  String sign_ways,String pay_ways,String startDate,String endDate) throws IOException {
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("tmp");
        XSSFRow headRow = sheet.createRow(0);
        for (int j=0; j<head_title.size(); j++){
            headRow.createCell(j).setCellValue(head_title.get(j));
        }
        for (int i=0; i<onlineData.size(); i++){
            LinkedHashMap<String,String> map = onlineData.get(i);
            XSSFRow row = null;
            //省份统计限制
            if(!map.get("province").equals(region) && !region.equals("全国")){
                continue;
            }
            //注册方式限制
            if(!map.get("sign_ways").equals(sign_ways) && !sign_ways.equals("all")){
                continue;
            }
            //支付方式限制
            if(!map.get("pay_ways").equals(pay_ways) && !pay_ways.equals("all")){
                continue;
            }
            //如果是统计方式为注册用户或者支付用户
            Date pay_time = new Date(map.get("pay_time"));
            Date createtime = new Date(map.get("createtime"));
            try {
                if(statistics.equals("支付用户") && (
                        !(pay_time.getTime() < dateFormat.parse(endDate).getTime())
                        || !(pay_time.getTime() > dateFormat.parse(startDate).getTime())
                )
                        ){
                    continue;
                }
                else if(statistics.equals("注册用户") && (
                        !(createtime.getTime() < dateFormat.parse(endDate).getTime())
                        || !(createtime.getTime() > dateFormat.parse(startDate).getTime())
                        )){
                    continue;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            row = sheet.createRow(i+1);
            int index = 0;
            for (Map.Entry<String,String> m : map.entrySet()){
                row.createCell(index++).setCellValue(m.getValue());
            }
        }


        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String nowTime = format.format(new Date());
        String datePath = "downloads/"+nowTime;
        String uuid = UUID.randomUUID().toString();
        String dirs = datePath +"/"+uuid +"/";
        FileUtilitys.makeDir(dirs);
        String filepath = datePath +"/"+uuid+"/detail.xlsx";
        FileOutputStream outStream = new FileOutputStream(filepath);
        wb.write(outStream);
        outStream.flush();
        outStream.close();
        try {
            this.readExcel(filepath);
            this.writeExcel(dirs);

            //打包传送出来
            FileUtilitys.fileToZip(dirs, dirs, nowTime);

            return "redirect:/report/" + dirs + nowTime + ".zip";
        } catch (Exception e) {
            return "上传失败 " + filepath + " => " + e.getMessage();
        }

    }

    @Override
    public void writeExcel(String filepath) throws IOException {
        FileOutputStream outStream = null;
        for (String provinceName:array_province) {
            ArrayList<JysyModel> arr = data.get(provinceName);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("tmp");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,head_title.size()));//合并单元格


            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中

            XSSFRow head_top = sheet.createRow(0);
            XSSFCell top_cell = head_top.createCell(0);
            top_cell.setCellValue(provinceName + "在线培训学员注册与学习情况统计表");
            top_cell.setCellStyle(cellStyle);



            XSSFRow head = sheet.createRow(1);
            for (int i=0;i <head_title.size(); i++){
                head.createCell(i).setCellValue(head_title.get(i));
            }

            for(int i=0; i<arr.size();i++){
                XSSFRow row = sheet.createRow(i+2);
                row.createCell(0).setCellValue(arr.get(i).getProvinceName());
                row.createCell(1).setCellValue(arr.get(i).getCityName());
                row.createCell(2).setCellValue(arr.get(i).getCountyName());
                row.createCell(3).setCellValue(arr.get(i).getSchoolName());
                row.createCell(4).setCellValue(arr.get(i).getDanwei_1());
                row.createCell(5).setCellValue(arr.get(i).getDanwei_2());
                row.createCell(6).setCellValue(arr.get(i).getUserName());
                row.createCell(7).setCellValue(arr.get(i).getFullName());
                row.createCell(8).setCellValue(arr.get(i).getSex());
                row.createCell(9).setCellValue(arr.get(i).getBirthDay());
                row.createCell(10).setCellValue(arr.get(i).getMail());
                row.createCell(11).setCellValue(arr.get(i).getZhiWu());
                row.createCell(12).setCellValue(arr.get(i).getSignWays());
                row.createCell(13).setCellValue(arr.get(i).getCreatetime());
                row.createCell(14).setCellValue(arr.get(i).getPaySatatus());
                row.createCell(15).setCellValue(arr.get(i).getPayWays());
                row.createCell(16).setCellValue(arr.get(i).getPayTimes());
                row.createCell(17).setCellValue(arr.get(i).getFapiao());
                row.createCell(18).setCellValue(arr.get(i).getDetailAddress());
                row.createCell(19).setCellValue(arr.get(i).getFinishTime());
                row.createCell(20).setCellValue(arr.get(i).getCerStatus());
                row.createCell(21).setCellValue(arr.get(i).getCerTime());
                row.createCell(22).setCellValue(arr.get(i).getCerCode());
            }
            if (provinceName != "省"){
                if (filepath.charAt(filepath.length()-1) == '/'){
                    try {
                        outStream = new FileOutputStream(filepath+ PinyinHelper.convertToPinyinString(provinceName, "", PinyinFormat.WITHOUT_TONE)+".xlsx");
                    } catch (PinyinException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        outStream = new FileOutputStream(filepath+"/"+PinyinHelper.convertToPinyinString(provinceName, "", PinyinFormat.WITHOUT_TONE)+".xlsx");
                    } catch (PinyinException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    logger.info("文件地址:"+PinyinHelper.convertToPinyinString(provinceName, "", PinyinFormat.WITHOUT_TONE)+".xlsx -- "+provinceName);
                } catch (PinyinException e) {
                    e.printStackTrace();
                }
                wb.write(outStream);
                outStream.flush();
                outStream.close();
            }
        }
    }

    @Override
    public String doExcel(MultipartFile file) throws UnsupportedEncodingException {
        String fileEncode = System.getProperty("file.encoding");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String nowTime = format.format(new Date());
        String datePath = "downloads/"+nowTime;
        String uuid = UUID.randomUUID().toString();
        String fileName = datePath +"/"+uuid+"/"+ file.getOriginalFilename();
        String dirs = datePath +"/"+uuid +"/";
        FileUtilitys.makeDir(dirs);
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(fileName)));
                stream.write(bytes);
                stream.close();

                this.readExcel(fileName);
                this.writeExcel(dirs);

                //打包传送出来
                FileUtilitys.fileToZip(dirs, dirs, nowTime);

                return "redirect:/report/" + dirs + nowTime + ".zip";
            } catch (Exception e) {
                return "上传失败 " + fileName + " => " + e.getMessage();
            }
        } else {
            return "上传失败 " + fileName + " 因为文件为空";
        }
    }
}
