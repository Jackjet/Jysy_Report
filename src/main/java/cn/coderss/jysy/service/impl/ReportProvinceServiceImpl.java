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
                XSSFSheet sheet = wb.createSheet();
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
                    headRow_1_cell.setCellValue(new XSSFRichTextString("2016年" + provinceStr + "在线培训学员报名情况汇总表"));
                    headRow_1_cell.setCellStyle(cellStyle);
                    XSSFRow headRow_2 = sheet.createRow(1);
                    XSSFCell headRow_2_cell = headRow_2.createCell(0);
                    headRow_2_cell.setCellValue(new XSSFRichTextString("统计时间为：" + startDate + " 00:00 - " + endDate + " 03:00"));
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
                if(provinceStr.equals("陕西省")) {
                    fileName = filepath + "省份统计 - " + provinceStr + ".xlsx";
                } else {
                    fileName = filepath + "省份统计 - " +provinceStr + ".xlsx";
                }

                System.out.println("province文件地址:" + fileName);
                stream = new FileOutputStream(new File(fileName));
                wb.write(stream);
            }
        } catch (Exception var44) {
            var44.printStackTrace();
        }

    }

    public String readOnlineExcel(List<LinkedHashMap<String, String>> onlineData, List<LinkedHashMap<String, String>> province, String myFilePath, String nowTime, String startDate, String endDate) throws IOException {
        String fileName = myFilePath + "all.xlsx";
        String dirs = myFilePath;
        FileUtilitys.makeDir(myFilePath);
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
        XSSFSheet sheetProvince = wbProvince.createSheet("tmp");
        XSSFRow headRowProvince = sheetProvince.createRow(0);
        headRowProvince.createCell(0).setCellValue("省");
        headRowProvince.createCell(1).setCellValue("总人数");
        headRowProvince.createCell(2).setCellValue("高教人数");
        headRowProvince.createCell(3).setCellValue("中职人数");
        headRowProvince.createCell(4).setCellValue("基教人数");
        headRowProvince.createCell(5).setCellValue("科研机构人数");
        headRowProvince.createCell(6).setCellValue("管理人数");
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
        String provinceFileName = myFilePath + "province.xlsx";
        FileOutputStream outStreamProvince = new FileOutputStream(provinceFileName);
        wbProvince.write(outStreamProvince);
        outStreamProvince.flush();
        outStreamProvince.close();
        onlineData.clear();
        Runtime.getRuntime().gc();

        try {
            this.readExcel(fileName);
            this.writeExcel(dirs, startDate, endDate);
            this.clearData();
            return "redirect:/report/" + dirs + nowTime + ".zip";
        } catch (Exception var23) {
            return "上传失败 " + fileName + " => " + var23.getMessage();
        }
    }

    public String doExcel(MultipartFile file, String myFilePath) throws UnsupportedEncodingException {
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
                this.writeExcel(dirs, "", "");
                FileUtilitys.fileToZip(dirs, dirs, nowTime);
                this.clearData();
                return "redirect:/report/" + dirs + nowTime + ".zip";
            } catch (Exception var11) {
                return "上传失败 " + fileName + " => " + var11.getMessage();
            }
        } else {
            return "上传失败 " + fileName + " 因为文件为空";
        }
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
}
