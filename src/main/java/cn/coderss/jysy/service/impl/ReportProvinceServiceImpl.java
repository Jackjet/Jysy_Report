package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.domain.JysyProvinceModel;
import cn.coderss.jysy.service.ReportProvinceService;
import cn.coderss.jysy.utility.FileUtilitys;
import com.sun.corba.se.pept.transport.ReaderThread;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class ReportProvinceServiceImpl implements ReportProvinceService {
    public static HashMap<String, ArrayList<JysyProvinceModel>> excelData;
    public static ArrayList<String> provinceList = new ArrayList();
    private Iterator<JysyProvinceModel> models;
    public static LinkedHashMap<String, String> cityRowLength;
    public static String nowStart;
    public static String nowEnd;
    Integer surplus = Integer.valueOf(0);

    public ReportProvinceServiceImpl() {
    }

    public void readExcel(String inputFile) {
        InputStream inputStream = null;
        Workbook wb = null;
        excelData = new HashMap();

        try {
            inputStream = new FileInputStream(inputFile);
            wb = new XSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            String nowProvinceStr = "";
            ArrayList arrayModel = null;

            while(true) {
                Row row;
                do {
                    if(!rows.hasNext()) {
                        return;
                    }

                    row = (Row)rows.next();
                } while(row.getCell(0) != null && row.getCell(0).toString().equals("省"));

                if(!row.getCell(0).toString().equals("") && !row.getCell(0).toString().equals(nowProvinceStr)) {
                    nowProvinceStr = row.getCell(0).toString();
                    arrayModel = new ArrayList();
                    excelData.put(nowProvinceStr, arrayModel);
                    provinceList.add(nowProvinceStr);
                }

                try {
                    JysyProvinceModel model = new JysyProvinceModel(row.getCell(0) != null?row.getCell(0).getStringCellValue():"", row.getCell(1) != null?row.getCell(1).getStringCellValue():"", row.getCell(2) != null?row.getCell(2).getStringCellValue():"", row.getCell(3) != null?Integer.valueOf(row.getCell(3).getStringCellValue()).toString():"", row.getCell(4) != null?Integer.valueOf(row.getCell(4).getStringCellValue()).toString():"", row.getCell(5) != null?Integer.valueOf(row.getCell(5).getStringCellValue()).toString():"", row.getCell(6) != null?Integer.valueOf(row.getCell(6).getStringCellValue()).toString():"", row.getCell(7) != null?Integer.valueOf(row.getCell(7).getStringCellValue()).toString():"", row.getCell(8) != null?(row.getCell(8).toString().indexOf(")") != -1?row.getCell(8).toString():Integer.valueOf(row.getCell(8).getStringCellValue()).toString()):"");
                    if(arrayModel != null) {
                        arrayModel.add(model);
                    }
                } catch (Exception var10) {
                    System.out.println(row.getCell(0) != null?row.getCell(0).toString():"");
                }
            }
        } catch (Exception var11) {
            var11.printStackTrace();
        }
    }

    public void writeExcel(String filepath, String startDate, String endDate) {
        int headHeight = 5;
        FileOutputStream stream = null;

        try {
            Iterator provinceIterator = provinceList.iterator();

            while(provinceIterator.hasNext()) {
                cityRowLength = new LinkedHashMap();
                nowStart = "1";
                String provinceStr = (String)provinceIterator.next();
                String cityStr = "";
                ArrayList<JysyProvinceModel> arrayModel = (ArrayList)excelData.get(provinceStr);
                Iterator<JysyProvinceModel> models = arrayModel.iterator();
                XSSFWorkbook wb = new XSSFWorkbook();
                StringBuilder sheetStr = new StringBuilder();
                XSSFSheet sheet = wb.createSheet(sheetStr.append(startDate).append("_").append(endDate).toString());
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 9));
                sheet.addMergedRegion(new CellRangeAddress(headHeight, arrayModel.size() + 4, 0, 0));
                XSSFCellStyle cellStyle = wb.createCellStyle();
                Font font = wb.createFont();
                font.setFontHeightInPoints((short) 18);
                cellStyle.setAlignment((short) 2);
                cellStyle.setVerticalAlignment((short) 2);
                cellStyle.setFont(font);

                JysyProvinceModel model;
                for(int i = 0; models.hasNext(); ++i) {
                    model = (JysyProvinceModel)models.next();
                    XSSFRow headRow_1 = sheet.createRow(0);
                    XSSFCell headRow_1_cell = headRow_1.createCell(0);
                    StringBuilder headRowCellStr = new StringBuilder();
                    headRowCellStr.append(startDate.substring(0, 4)).append("年").append(provinceStr).append("在线培训学员报名情况汇总表");
                    headRow_1_cell.setCellValue(new XSSFRichTextString(headRowCellStr.toString()));
                    headRow_1_cell.setCellStyle(cellStyle);
                    XSSFRow headRow_2 = sheet.createRow(1);
                    XSSFCell headRow_2_cell = headRow_2.createCell(0);
                    headRow_2_cell.setCellValue(new XSSFRichTextString("统计时间为：" + startDate + " 00:00 - " + endDate + " 23:59"));
                    XSSFRow headRow_3 = sheet.createRow(2);
                    XSSFCell headRow_3_cell_1 = headRow_3.createCell(3);
                    headRow_3_cell_1.setCellValue(new XSSFRichTextString("合计"));
                    XSSFCellStyle headRow_3_cell_1_style = wb.createCellStyle();
                    headRow_3_cell_1_style.setVerticalAlignment((short) 2);
                    headRow_3_cell_1_style.setAlignment((short) 2);
                    headRow_3_cell_1.setCellStyle(headRow_3_cell_1_style);
                    XSSFCell headRow_3_cell_2 = headRow_3.createCell(4);
                    XSSFCellStyle headRow_3_cell_2_style = wb.createCellStyle();
                    headRow_3_cell_2_style.setVerticalAlignment((short) 2);
                    headRow_3_cell_2_style.setAlignment((short) 2);
                    headRow_3_cell_2.setCellStyle(headRow_3_cell_2_style);
                    headRow_3_cell_2.setCellValue(new XSSFRichTextString("学校情况"));
                    XSSFRow headRow_4 = sheet.createRow(3);
                    XSSFCell headRow_4_cell_2 = headRow_4.createCell(4);
                    XSSFCellStyle headRow_4_cell_2_style = wb.createCellStyle();
                    headRow_4_cell_2_style.setVerticalAlignment((short) 2);
                    headRow_4_cell_2_style.setAlignment((short) 2);
                    headRow_4_cell_2.setCellStyle(headRow_4_cell_2_style);
                    headRow_4_cell_2.setCellValue(new XSSFRichTextString("高等教育"));
                    XSSFCell headRow_4_cell_3 = headRow_4.createCell(5);
                    XSSFCellStyle headRow_4_cell_3_style = wb.createCellStyle();
                    headRow_4_cell_3_style.setVerticalAlignment((short) 2);
                    headRow_4_cell_3_style.setAlignment((short) 2);
                    headRow_4_cell_3.setCellStyle(headRow_4_cell_3_style);
                    headRow_4_cell_3.setCellValue(new XSSFRichTextString("中等职业教育"));
                    XSSFCell headRow_4_cell_4 = headRow_4.createCell(6);
                    XSSFCellStyle headRow_4_cell_4_style = wb.createCellStyle();
                    headRow_4_cell_4_style.setVerticalAlignment((short) 2);
                    headRow_4_cell_4_style.setAlignment((short) 2);
                    headRow_4_cell_4.setCellStyle(headRow_4_cell_4_style);
                    headRow_4_cell_4.setCellValue(new XSSFRichTextString("基础教育"));
                    XSSFCell headRow_4_cell_5 = headRow_4.createCell(7);
                    XSSFCellStyle headRow_4_cell_5_style = wb.createCellStyle();
                    headRow_4_cell_5_style.setVerticalAlignment((short) 2);
                    headRow_4_cell_5_style.setAlignment((short) 2);
                    headRow_4_cell_5.setCellStyle(headRow_4_cell_5_style);
                    headRow_4_cell_5.setCellValue(new XSSFRichTextString("科研机构人数"));
                    XSSFCell headRow_4_cell_6 = headRow_4.createCell(8);
                    XSSFCellStyle headRow_4_cell_6_style = wb.createCellStyle();
                    headRow_4_cell_6_style.setVerticalAlignment((short) 2);
                    headRow_4_cell_6_style.setAlignment((short) 2);
                    headRow_4_cell_6.setCellStyle(headRow_4_cell_6_style);
                    headRow_4_cell_6.setCellValue(new XSSFRichTextString("教育行政管理人员"));
                    XSSFRow headRow_5 = sheet.createRow(4);
                    XSSFCell headRow_5_1 = headRow_5.createCell(0);
                    headRow_5_1.setCellValue(new XSSFRichTextString("统计项"));
                    XSSFCell headRow_5_2 = headRow_5.createCell(1);
                    headRow_5_2.setCellValue(new XSSFRichTextString("地市名称"));
                    XSSFCell headRow_5_3 = headRow_5.createCell(2);
                    headRow_5_3.setCellValue(new XSSFRichTextString("县名称"));
                    if(!model.getCity().equals("") && !cityStr.equals(model.getCity().toString())) {
                        cityRowLength.put(cityStr + "_end", String.valueOf(i));
                        cityStr = model.getCity().toString();
                        cityRowLength.put(cityStr + "_start", String.valueOf(i));
                    }

                    if(i == arrayModel.size() - 1) {
                        cityRowLength.put(cityStr + "_end", String.valueOf(i + 1));
                    }

                    XSSFRow row = sheet.createRow(i + headHeight);
                    XSSFCell countryCell;
                    XSSFCellStyle provinceCellStyle;
                    if(i == 0) {
                        countryCell = row.createCell(0);
                        provinceCellStyle = wb.createCellStyle();
                        provinceCellStyle.setVerticalAlignment((short) 0);
                        provinceCellStyle.setAlignment((short) 2);
                        countryCell.setCellStyle(provinceCellStyle);
                        countryCell.setCellValue(model.getProvince().toString());
                    } else {
                        row.createCell(0).setCellValue(model.getProvince().toString());
                    }

                    if(i == 0) {
                        countryCell = row.createCell(1);
                        countryCell.setCellValue("合计");
                    } else if(!model.getCity().equals("")) {
                        countryCell = row.createCell(1);
                        provinceCellStyle = wb.createCellStyle();
                        provinceCellStyle.setVerticalAlignment((short) 0);
                        provinceCellStyle.setAlignment((short) 2);
                        countryCell.setCellStyle(provinceCellStyle);
                        countryCell.setCellValue(model.getCity().toString());
                    } else {
                        row.createCell(1).setCellValue(model.getCity().toString());
                    }

                    if(i == 1) {
                        countryCell = row.createCell(2);
                        countryCell.setCellValue("小计");
                    } else {
                        row.createCell(2).setCellValue(model.getContry().toString());
                    }

                    row.createCell(3).setCellValue(model.getSum().toString());
                    row.createCell(4).setCellValue(model.getHight().toString());
                    row.createCell(5).setCellValue(model.getMiddle().toString());
                    row.createCell(6).setCellValue(model.getBase().toString());
                    row.createCell(7).setCellValue(model.getSen().toString());
                    row.createCell(8).setCellValue(model.getManager().toString());
                }

                if(cityRowLength.size() == 2) {
                    sheet.addMergedRegion(new CellRangeAddress(headHeight + 1, arrayModel.size() + headHeight - 1, 1, 1));
                }

                cityRowLength.forEach((key, value) -> {
                    if(!key.equals("_end") && key.endsWith("_start")) {
                        nowStart = value;
                    } else if(key.endsWith("_end")) {
                        nowEnd = value;
                        if(!nowEnd.equals("1")) {
                            sheet.addMergedRegion(new CellRangeAddress(Integer.valueOf(nowStart).intValue() + headHeight, Integer.valueOf(nowEnd).intValue() + headHeight - 1, 1, 1));
                        }
                    }

                });
                sheet.addMergedRegion(new CellRangeAddress(2, 3, 0, 2));
                sheet.addMergedRegion(new CellRangeAddress(2, 3, 3, 3));
                sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 6));
                model = null;
                String fileName;
                fileName = filepath + "省份统计-" + provinceStr +startDate.replace("-","")+"_"+endDate.replace("-","")+ ".xlsx";

                System.out.println("province文件地址:" + fileName);
                stream = new FileOutputStream(new File(fileName));
                wb.write(stream);
            }
        } catch (Exception var44) {
            var44.printStackTrace();
        }

    }

    public String readOnlineExcel(List<LinkedHashMap<String, String>> onlineData, List<LinkedHashMap<String, String>> province, String myFilePath, String nowTime, String startDate, String endDate) throws IOException {
        String fileName = myFilePath + "各省学员报名情况统计汇总表.xlsx";
        String dirs = myFilePath;
        FileUtilitys.makeDir(myFilePath);
        XSSFWorkbook wb = new XSSFWorkbook();
        StringBuilder sheetStr = new StringBuilder();
        XSSFSheet sheet = wb.createSheet(sheetStr.append(startDate).append("_").append(endDate).toString());
        XSSFRow headRow = sheet.createRow(0);
        List data= Arrays.asList("省","市","县","总人数","高教人数","中职人数","基教人数","科研机构人数","管理人数");
        for (int j = 0; j< data.size();j++){
            headRow.createCell(j).setCellValue(data.get(j).toString());
        }

        for(int i = 0; i < onlineData.size(); ++i) {
            XSSFRow row = sheet.createRow(i + 1);
            LinkedHashMap<String, String> map = (LinkedHashMap)onlineData.get(i);
            int index = 0;
            Iterator var16 = map.entrySet().iterator();

            while(var16.hasNext()) {
                Map.Entry<String, String> m = (Map.Entry)var16.next();
                row.createCell(index++).setCellValue((String)m.getValue());
            }
        }

        System.out.println("文件地址:" + fileName);
        FileOutputStream outStream = new FileOutputStream(fileName);
        wb.write(outStream);
        outStream.flush();
        outStream.close();
        XSSFWorkbook wbProvince = new XSSFWorkbook();
        XSSFSheet sheetProvince = wbProvince.createSheet(sheetStr.toString());
        XSSFRow headRowProvince = sheetProvince.createRow(0);
        List headRowProvinceList = Arrays.asList("省","总人数","高教人数","中职人数","基教人数","科研机构人数","管理人数");
        for (int j=0; j<headRowProvinceList.size(); j++){
            headRowProvince.createCell(j).setCellValue(headRowProvinceList.get(j).toString());
        }
        LinkedHashMap<String, Integer> sumMap = new LinkedHashMap<String, Integer>() {
            {
                this.put("sum", Integer.valueOf(0));
                this.put("hight_edu", Integer.valueOf(0));
                this.put("sec_edu", Integer.valueOf(0));
                this.put("base_edu", Integer.valueOf(0));
                this.put("sci_edu", Integer.valueOf(0));
            }
        };

        for(int i = 0; i < province.size(); ++i) {
            XSSFRow rowProvince = sheetProvince.createRow(i + 2);
            LinkedHashMap<String, String> map = (LinkedHashMap)province.get(i);
            int index = 0;
            Iterator var21 = map.entrySet().iterator();

            while(var21.hasNext()) {
                Map.Entry<String, String> m = (Map.Entry)var21.next();
                rowProvince.createCell(index++).setCellValue((String)m.getValue());
                this.sumData(sumMap, m);
            }
        }

        sumMap.put("surplus", Integer.valueOf(((Integer)sumMap.get("sum")).intValue() - ((Integer)sumMap.get("hight_edu")).intValue() - ((Integer)sumMap.get("sec_edu")).intValue() - ((Integer)sumMap.get("base_edu")).intValue() - ((Integer)sumMap.get("sci_edu")).intValue()));
        this.createCountryRow(sheetProvince, sumMap);
        String provinceFileName = myFilePath + "全国分省学员人数汇总表.xlsx";
        FileOutputStream outStreamProvince = new FileOutputStream(provinceFileName);
        wbProvince.write(outStreamProvince);
        outStreamProvince.flush();
        outStreamProvince.close();
        onlineData.clear();
        Runtime.getRuntime().gc();
        dealHead(provinceFileName, startDate);
        try {
            this.readExcel(fileName);
            this.writeExcel(dirs, startDate, endDate);
            this.clearData();
            dealHeadWithAll(fileName, startDate);
            return "redirect:/report/" + dirs + nowTime + ".zip";
        } catch (Exception var23) {
            return "上传失败 " + fileName + " => " + var23.getMessage();
        }
    }

    public String doExcel(MultipartFile file, String myFilePath) throws UnsupportedEncodingException {
        //future to do some thing
        return null;
    }

    public void sumData(LinkedHashMap<String, Integer> sumMap, Map.Entry<String, String> m) {
        Iterator var3 = sumMap.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, Integer> sumMapEntry = (Map.Entry)var3.next();
            if(((String)sumMapEntry.getKey()).equals(m.getKey())) {
                Integer data = Integer.valueOf(((String)m.getValue()).equals("")?0:Integer.valueOf((String)m.getValue()).intValue());
                data = Integer.valueOf(data.intValue() + ((Integer)sumMapEntry.getValue()).intValue());
                sumMap.put(sumMapEntry.getKey(), data);
            }
        }

    }

    public void clearData() {
        excelData.clear();
        provinceList.clear();
        this.models = null;
    }

    public void createCountryRow(XSSFSheet sheetProvince, LinkedHashMap<String, Integer> sumMap) {
        XSSFRow rowProvince = sheetProvince.createRow(1);
        int index = 0;
        int var7 = index + 1;
        rowProvince.createCell(index).setCellValue("全国");
        Iterator var5 = sumMap.entrySet().iterator();

        while(var5.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry)var5.next();
            rowProvince.createCell(var7++).setCellValue((double)((Integer)entry.getValue()).intValue());
        }

    }


    public void dealHead(String fileName, String startDate) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(fileName)));
        XSSFSheet sheet = workbook.getSheetAt(0);


        //完美移动最后空行到第一行
        int emptyLine = 4;
        for (int i=0; i<emptyLine;i++){
            sheet.shiftRows(i, sheet.getLastRowNum(), 1,true,false);
        }

        //合并相关单元格
        dealMerge(sheet,0,1,0,6);
        dealMerge(sheet,2,2,0,6);
        dealMerge(sheet, 3,4,0,0);
        dealMerge(sheet, 3,4,1,1);
        dealMerge(sheet,3,4,5,5);
        dealMerge(sheet,3,4,6,6 );
        dealMerge(sheet,3,3,2,4 );

        /**
         * 样式美化
         */
        XSSFCellStyle rowFirstStyle = workbook.createCellStyle();
        rowFirstStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        rowFirstStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        rowFirstStyle.setWrapText(true);
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 13);
        rowFirstStyle.setFont(font);
        dealCell(sheet, 0, 0, startDate.substring(0,4)+"年全国教育事业统计在线培训 \n 全国分省学员人数汇总表", rowFirstStyle);


        StringBuilder time = new StringBuilder(sheet.getSheetName());
        time.insert(time.indexOf("_"), " 00:00");
        time.insert(time.length(), " 23:59 ");
        dealCell(sheet, 2, 0 ,"统计时间为:"+time.toString().replace("_","-"), null);


        XSSFCellStyle school = workbook.createCellStyle();
        school.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        school.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        XSSFRow schoolRow = dealCell(sheet, 3 , 2, "学校情况", school);


        XSSFCellStyle province = workbook.createCellStyle();
        province.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        province.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 0, "省", province);

        XSSFCellStyle sum = workbook.createCellStyle();
        sum.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        sum.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 1, "合计", sum);


        XSSFCellStyle scientific = workbook.createCellStyle();
        scientific.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        scientific.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 5, "科研机构人数", scientific);

        XSSFCellStyle admin = workbook.createCellStyle();
        admin.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        admin.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 6, "教育行政管理人员", admin);



        workbook.write(new FileOutputStream(new File(fileName)));
    }


    public  void dealHeadWithAll(String fileName,String startDate) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(fileName)));
        XSSFSheet sheet = workbook.getSheetAt(0);

        //完美移动最后空行到第一行
        int emptyLine = 4;
        for (int i=0; i<emptyLine;i++){
            sheet.shiftRows(i, sheet.getLastRowNum(), 1,true,false);
        }

        //合并相关单元格
        dealMerge(sheet,0,1,0,8);
        dealMerge(sheet,2,2,0,8);
        dealMerge(sheet, 3,4,3,3);
        dealMerge(sheet,3,4,7,7);
        dealMerge(sheet,3,4,8,8 );
        dealMerge(sheet,3,3,4,6 );

        /**
         * 样式美化
         */
        XSSFCellStyle rowFirstStyle = workbook.createCellStyle();
        rowFirstStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        rowFirstStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        rowFirstStyle.setWrapText(true);
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 13);
        rowFirstStyle.setFont(font);
        dealCell(sheet, 0, 0, startDate.substring(0,4)+"年全国教育事业统计在线培训 \n 各省学员报名情况统计汇总表", rowFirstStyle);


        StringBuilder time = new StringBuilder(sheet.getSheetName());
        time.insert(time.indexOf("_"), " 00:00");
        time.insert(time.length(), " 23:59 ");
        dealCell(sheet, 2, 0 ,"统计时间为:"+time.toString().replace("_","-"), null);


        XSSFCellStyle school = workbook.createCellStyle();
        school.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        school.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        XSSFRow schoolRow = dealCell(sheet, 3 , 4, "学校情况", school);


        XSSFCellStyle sum = workbook.createCellStyle();
        sum.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        sum.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 3, "合计", sum);


        XSSFCellStyle scientific = workbook.createCellStyle();
        scientific.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        scientific.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 7, "科研机构人数", scientific);

        XSSFCellStyle admin = workbook.createCellStyle();
        admin.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        admin.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        dealCellWithRow(schoolRow, 3, 8, "教育行政管理人员", admin);

//        XSSFRow row = dealCell(sheet, 5, 0,"统计项", null);
//        dealCellWithRow(row, 5,1,"地市名称",null);
//        dealCellWithRow(row, 5,2,"县名称",null);


        workbook.write(new FileOutputStream(new File(fileName)));
    }


    XSSFRow dealCell(XSSFSheet sheet, int rownum, int cellnum, String content, XSSFCellStyle style){
        XSSFRow row = sheet.createRow(rownum);
        XSSFCell cell = row.createCell(cellnum);
        cell.setCellValue(new XSSFRichTextString(content));
        if(style!= null){
            cell.setCellStyle(style);
        }
        return row;
    }

    XSSFCell dealCellWithRow(XSSFRow row, int rownum, int cellnum, String content, XSSFCellStyle style){
        XSSFCell cell = row.createCell(cellnum);
        cell.setCellValue(new XSSFRichTextString(content));
        if(style!= null){
            cell.setCellStyle(style);
        }
        return cell;
    }

    void dealMerge(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol){
        sheet.addMergedRegion(new CellRangeAddress(firstRow,lastRow,firstCol,lastCol));
    }

}
