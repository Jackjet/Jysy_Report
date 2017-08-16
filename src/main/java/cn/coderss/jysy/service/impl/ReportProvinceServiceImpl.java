package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.domain.JysyProvinceModel;
import cn.coderss.jysy.service.ReportProvinceService;
import cn.coderss.jysy.utility.FileUtilitys;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/6/30
 * Time: 下午2:56
 * Blog: http://www.coderss.cn
 */
@Service
public class ReportProvinceServiceImpl implements ReportProvinceService {
    public static HashMap<String,ArrayList<JysyProvinceModel>> excelData;
    public static ArrayList<String> provinceList = new ArrayList<String>();
    private Iterator<JysyProvinceModel> models;
    //用户统计城市与城市之间的行数
    public static LinkedHashMap<String,String> cityRowLength;
    //当前的位置
    public static String nowStart;
    public static String nowEnd;
    Integer surplus = 0;

    public void readExcel(String inputFile) {
        InputStream inputStream = null;
        Workbook wb = null;
        excelData = new HashMap<String, ArrayList<JysyProvinceModel>>();
        try {
            inputStream = new FileInputStream(inputFile);
            wb = new XSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            String nowProvinceStr = "";
            ArrayList<JysyProvinceModel> arrayModel = null;
            while (rows.hasNext()){
                Row row = rows.next();
                //跳过第一行
                if(row.getCell(0) != null && row.getCell(0).toString().equals("省")){
                    continue;
                }

                //替换省份数据
                if (!row.getCell(0).toString().equals("") && !row.getCell(0).toString().equals(nowProvinceStr)){
                    //替换数据
                    nowProvinceStr = row.getCell(0).toString();
                    arrayModel = new ArrayList<JysyProvinceModel>();
                    excelData.put(nowProvinceStr, arrayModel);
                    provinceList.add(nowProvinceStr);
                }
                //新增model
                try {
                    JysyProvinceModel model = new JysyProvinceModel(
                            row.getCell(0) != null ? row.getCell(0).getStringCellValue() : "",
                            row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "",
                            row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "",
                            row.getCell(3) != null ? Integer.valueOf(row.getCell(3).getStringCellValue()).toString() : "",
                            row.getCell(4) != null ? Integer.valueOf(row.getCell(4).getStringCellValue()).toString() : "",
                            row.getCell(5) != null ? Integer.valueOf(row.getCell(5).getStringCellValue()).toString() : "",
                            row.getCell(6) != null ? Integer.valueOf(row.getCell(6).getStringCellValue()).toString() : "",
                            row.getCell(7) != null ? Integer.valueOf(row.getCell(7).getStringCellValue()).toString() : "",
                            row.getCell(8) != null ? row.getCell(8).toString().indexOf(")") != -1? row.getCell(8).toString() : Integer.valueOf(row.getCell(8).getStringCellValue()).toString() : "");
                    if (arrayModel != null){
                        arrayModel.add(model);
                    }
                }
                catch (Exception ex){
                    System.out.println(row.getCell(0) != null ? row.getCell(0).toString() : "");
                }

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void writeExcel(String filepath) {
        //当前日期
        String nowHour = new SimpleDateFormat("M月d日 H:mm:s").format(new Date());
        //表头高度
        int headHeight = 5;

        FileOutputStream stream = null;
        try {
            Iterator<String> provinceIterator = provinceList.iterator();
            while (provinceIterator.hasNext()){
                cityRowLength = new LinkedHashMap<String, String>();
                nowStart = "1";

                //数据
                String provinceStr = provinceIterator.next();
                String cityStr = "";
                ArrayList<JysyProvinceModel> arrayModel = excelData.get(provinceStr);
                Iterator<JysyProvinceModel> models = arrayModel.iterator();


                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet();
                //表格样式
                //表头一
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,9));//合并单元格
                //表头二
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 0,9));//合并单元格
                //省份合并
                sheet.addMergedRegion(new CellRangeAddress(headHeight, arrayModel.size()+4, 0,0));//合并单元格


                //单元格样式
                XSSFCellStyle cellStyle = wb.createCellStyle();
                //生成一个字体
                Font font=wb.createFont();
//                font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);//字体增粗
                font.setFontHeightInPoints((short) 18);//字号


                cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);//左右居中
                cellStyle.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);//上下剧中
                //把字体应用到当前的样式
                cellStyle.setFont(font);



                int i=0;
                while (models.hasNext()){
                    JysyProvinceModel model = models.next();
                    //建立头部
                    XSSFRow headRow_1 = sheet.createRow(0);
                    XSSFCell headRow_1_cell = headRow_1.createCell(0);
                    headRow_1_cell.setCellValue(new XSSFRichTextString("2016年"+provinceStr+"在线培训学员报名情况汇总表"));
                    headRow_1_cell.setCellStyle(cellStyle);

                    XSSFRow headRow_2 = sheet.createRow(1);
                    XSSFCell headRow_2_cell = headRow_2.createCell(0);
                    headRow_2_cell.setCellValue(new XSSFRichTextString("统计时间为：8月18日0:00 - "+nowHour));


                    XSSFRow headRow_3 = sheet.createRow(2);

                    XSSFCell headRow_3_cell_1 = headRow_3.createCell(3);
                    headRow_3_cell_1.setCellValue(new XSSFRichTextString("合计"));
                    //单元格样式位置
                    XSSFCellStyle headRow_3_cell_1_style = wb.createCellStyle();
                    headRow_3_cell_1_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_3_cell_1_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_3_cell_1.setCellStyle(headRow_3_cell_1_style);

                    XSSFCell headRow_3_cell_2 = headRow_3.createCell(4);


                    //单元格样式位置
                    XSSFCellStyle headRow_3_cell_2_style = wb.createCellStyle();
                    headRow_3_cell_2_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_3_cell_2_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_3_cell_2.setCellStyle(headRow_3_cell_2_style);

                    headRow_3_cell_2.setCellValue(new XSSFRichTextString("学校情况"));


                    XSSFRow headRow_4 = sheet.createRow(3);


                    XSSFCell headRow_4_cell_2 = headRow_4.createCell(4);
                    //单元格样式位置
                    XSSFCellStyle headRow_4_cell_2_style = wb.createCellStyle();
                    headRow_4_cell_2_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_2_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_2.setCellStyle(headRow_4_cell_2_style);
                    headRow_4_cell_2.setCellValue(new XSSFRichTextString("高等教育"));

                    XSSFCell headRow_4_cell_3 = headRow_4.createCell(5);
                    //单元格样式位置
                    XSSFCellStyle headRow_4_cell_3_style = wb.createCellStyle();
                    headRow_4_cell_3_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_3_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_3.setCellStyle(headRow_4_cell_3_style);
                    headRow_4_cell_3.setCellValue(new XSSFRichTextString("中等职业教育"));

                    XSSFCell headRow_4_cell_4 = headRow_4.createCell(6);
                    //单元格样式位置
                    XSSFCellStyle headRow_4_cell_4_style = wb.createCellStyle();
                    headRow_4_cell_4_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_4_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_4.setCellStyle(headRow_4_cell_4_style);
                    headRow_4_cell_4.setCellValue(new XSSFRichTextString("基础教育"));


                    XSSFCell headRow_4_cell_5 = headRow_4.createCell(7);
                    //单元格样式位置
                    XSSFCellStyle headRow_4_cell_5_style = wb.createCellStyle();
                    headRow_4_cell_5_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_5_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_5.setCellStyle(headRow_4_cell_5_style);
                    headRow_4_cell_5.setCellValue(new XSSFRichTextString("科研机构人数"));

                    XSSFCell headRow_4_cell_6 = headRow_4.createCell(8);
                    //单元格样式位置
                    XSSFCellStyle headRow_4_cell_6_style = wb.createCellStyle();
                    headRow_4_cell_6_style.setVerticalAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_6_style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                    headRow_4_cell_6.setCellStyle(headRow_4_cell_6_style);
                    headRow_4_cell_6.setCellValue(new XSSFRichTextString("教育行政管理人员"));

                    XSSFRow headRow_5 = sheet.createRow(4);
                    XSSFCell headRow_5_1 = headRow_5.createCell(0);
                    headRow_5_1.setCellValue(new XSSFRichTextString("统计项"));

                    XSSFCell headRow_5_2 = headRow_5.createCell(1);
                    headRow_5_2.setCellValue(new XSSFRichTextString("地市名称"));

                    XSSFCell headRow_5_3 = headRow_5.createCell(2);
                    headRow_5_3.setCellValue(new XSSFRichTextString("县名称"));


                    //如果城市不一致与上一个
                    if(!model.getCity().equals("")&& !cityStr.equals(model.getCity().toString())){
                        cityRowLength.put(cityStr+"_end", String.valueOf(i));
                        cityStr = model.getCity().toString();
                        cityRowLength.put(cityStr+"_start", String.valueOf(i));
                    }
                    if (i == arrayModel.size()-1){
                        cityRowLength.put(cityStr+"_end", String.valueOf(i+1));
                    }

                    XSSFRow row = sheet.createRow(i+headHeight);
                    //省份样式
                    if (i == 0){
                        XSSFCell provinceCell = row.createCell(0);

                        //单元格样式位置
                        XSSFCellStyle provinceCellStyle = wb.createCellStyle();
                        provinceCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
                        provinceCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                        provinceCell.setCellStyle(provinceCellStyle);

                        provinceCell.setCellValue(model.getProvince().toString());
                    }
                    else{
                        row.createCell(0).setCellValue(model.getProvince().toString());
                    }


                    //城市样式
                    if (i == 0){
                        XSSFCell cityCell = row.createCell(1);

                        //单元格样式背景色
//                        XSSFCellStyle cityCellStyle = wb.createCellStyle();
//                        cityCellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
//                        cityCellStyle.setFillPattern(XSSFCellStyle.THIN_FORWARD_DIAG);
//                        cityCell.setCellStyle(cityCellStyle);

                        cityCell.setCellValue("合计");
                    }
                    else if(!model.getCity().equals("")){
                        XSSFCell cityCell = row.createCell(1);

                        //单元格样式位置
                        XSSFCellStyle provinceCellStyle = wb.createCellStyle();
                        provinceCellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
                        provinceCellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
                        cityCell.setCellStyle(provinceCellStyle);

                        cityCell.setCellValue(model.getCity().toString());
                    }
                    else{
                        row.createCell(1).setCellValue(model.getCity().toString());
                    }


                    //区县样式
                    if (i == 1){
                        XSSFCell countryCell = row.createCell(2);


                        countryCell.setCellValue("小计");
                    }else{
                        row.createCell(2).setCellValue(model.getContry().toString());
                    }

                    row.createCell(3).setCellValue(model.getSum().toString());
                    row.createCell(4).setCellValue(model.getHight().toString());
                    row.createCell(5).setCellValue(model.getMiddle().toString());
                    row.createCell(6).setCellValue(model.getBase().toString());
                    row.createCell(7).setCellValue(model.getSen().toString());
                    row.createCell(8).setCellValue(model.getManager().toString());
                    i++;
                }

                //进行城市合并
                //直辖市合并
                if(cityRowLength.size()==2){
                    sheet.addMergedRegion(new CellRangeAddress(headHeight+1, arrayModel.size()+headHeight-1, 1,1));//合并单元格
                }

                //其他城市合并
                cityRowLength.forEach((key, value) -> {
                    if (!key.equals("_end") && key.endsWith("_start")) {
                        nowStart = value;
                    } else if (key.endsWith("_end")) {
                        nowEnd = value;
                        if (!nowEnd.equals("1")) {
                            //合并单元格
                            sheet.addMergedRegion(new CellRangeAddress(Integer.valueOf(nowStart).intValue() + headHeight,
                                    Integer.valueOf(nowEnd).intValue() + headHeight - 1, 1, 1));
                        }
                    }
                });

                //合并各类头部的单元格 - 空格
                sheet.addMergedRegion(new CellRangeAddress(2, 3, 0,2));

                //合并各类头部的单元格 - 合计
                sheet.addMergedRegion(new CellRangeAddress(2, 3, 3,3));

                //合并各类头部的单元格 - 学校情况
                sheet.addMergedRegion(new CellRangeAddress(2, 2, 4,6));


                String fileName = filepath+ PinyinHelper.convertToPinyinString("省份统计 - "+provinceStr, "", PinyinFormat.WITHOUT_TONE)+".xlsx";
                stream = new FileOutputStream(new File(fileName));
                wb.write(stream);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String readOnlineExcel(List<LinkedHashMap<String, String>> onlineData,
                                  List<LinkedHashMap<String, String>> province,
                                  String myFilePath, String nowTime) throws IOException {
        String fileName = myFilePath+ "all.xlsx";
        String dirs = myFilePath;
        FileUtilitys.makeDir(dirs);

        /**
         * all
         */
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("tmp");
        XSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("省");
        headRow.createCell(1).setCellValue("市");
        headRow.createCell(2).setCellValue("县");
        headRow.createCell(3).setCellValue("总人数");
        headRow.createCell(4).setCellValue("高教人数");
        headRow.createCell(5).setCellValue("中职人数");
        headRow.createCell(6).setCellValue("基教人数");
        headRow.createCell(7).setCellValue("科研机构人数");
        headRow.createCell(8).setCellValue("管理人数");

        for (int i=0; i<onlineData.size(); i++){
            XSSFRow row = sheet.createRow(i+1);
            LinkedHashMap<String,String> map = onlineData.get(i);
            int index = 0;
            for (Map.Entry<String,String> m : map.entrySet()){
                row.createCell(index++).setCellValue(m.getValue());
            }
        }
        FileOutputStream outStream = new FileOutputStream(fileName);
        wb.write(outStream);
        outStream.flush();
        outStream.close();


        /**
         * province
         */
        XSSFWorkbook wbProvince = new XSSFWorkbook();
        XSSFSheet sheetProvince = wbProvince.createSheet("tmp");
        XSSFRow headRowProvince = sheetProvince.createRow(0);
        headRowProvince.createCell(0).setCellValue("省");
        headRowProvince.createCell(1).setCellValue("总人数");
        headRowProvince.createCell(2).setCellValue("高教人数");
        headRowProvince.createCell(3).setCellValue("中职人数");
        headRowProvince.createCell(4).setCellValue("基教人数");
        headRowProvince.createCell(5).setCellValue("科研机构人数");
        headRowProvince.createCell(6).setCellValue("管理人数");

        LinkedHashMap<String, Integer> sumMap = new LinkedHashMap<String, Integer>(){{
            put("sum", 0);
            put("hight_edu", 0);
            put("sec_edu", 0);
            put("base_edu", 0);
            put("sci_edu", 0);
            put("surplus", 0);
        }};

        for (int i=0; i<province.size(); i++){
            XSSFRow rowProvince = sheetProvince.createRow(i+2);
            LinkedHashMap<String,String> map = province.get(i);
            int index = 0;
            for (Map.Entry<String,String> m : map.entrySet()){
                rowProvince.createCell(index++).setCellValue(m.getValue());
                sumData(sumMap, m);
            }
        }
        sumMap.put("surplus", sumMap.get("sum")- surplus);
        //做全国的分析
        createCountryRow(sheetProvince, sumMap);


        String provinceFileName = myFilePath+ "province.xlsx";
        FileOutputStream outStreamProvince = new FileOutputStream(provinceFileName);
        wbProvince.write(outStreamProvince);
        outStreamProvince.flush();
        outStreamProvince.close();


        try {
            this.readExcel(fileName);
            this.writeExcel(dirs);

            //打包传送出来
            //FileUtilitys.fileToZip(dirs, dirs, nowTime);

            //清空数据
            clearData();

            return "redirect:/report/" + dirs + nowTime + ".zip";
        } catch (Exception e) {
            return "上传失败 " + fileName + " => " + e.getMessage();
        }
    }

    @Override
    public String doExcel(MultipartFile file, String myFilePath) throws UnsupportedEncodingException {
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

                //清理
                clearData();

                return "redirect:/report/" + dirs + nowTime + ".zip";
            } catch (Exception e) {
                return "上传失败 " + fileName + " => " + e.getMessage();
            }
        } else {
            return "上传失败 " + fileName + " 因为文件为空";
        }
    }

    public void sumData(LinkedHashMap<String, Integer> sumMap, Map.Entry<String, String> m){
        for (Map.Entry<String, Integer> sumMapEntry: sumMap.entrySet()){
            if(sumMapEntry.getKey().equals(m.getKey())){
                Integer data = m.getValue().equals("")? 0: Integer.valueOf(m.getValue());
                data += sumMapEntry.getValue();
                sumMap.put(sumMapEntry.getKey(), data);
            }
            else{
                //surplus
                sumMap.entrySet().stream().forEach(item->{
                    if(!item.getKey().equals("sum"))
                        surplus += item.getValue();
                });
            }
        }
    }


    public void clearData(){
        ReportProvinceServiceImpl.excelData = null;
        ReportProvinceServiceImpl.provinceList.clear();
    }


    public void createCountryRow(XSSFSheet sheetProvince,LinkedHashMap<String,Integer> sumMap){
        XSSFRow rowProvince = sheetProvince.createRow(1);
        int index = 0;
        rowProvince.createCell(index++).setCellValue("全国");
        for (Map.Entry<String, Integer> entry: sumMap.entrySet()){
            rowProvince.createCell(index++).setCellValue(entry.getValue());
        }
    }
}
