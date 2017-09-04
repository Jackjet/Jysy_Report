package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.dao.StudyPlanDetailData;
import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import cn.coderss.jysy.service.StudyPlanService;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/29
 * Time: 上午10:14
 * Blog: http://www.coderss.cn
 */
@Service("studyPlanService")
public class StudyPlanServiceImpl implements StudyPlanService{
    @Autowired
    StudyPlanDetailData repository;

    /**
     * 存储相关
     * 用户名->学习计划/scorm/证书
     */
    List<LinkedHashMap<String,String>> userDataList = new LinkedList<>();
    LinkedHashMap<String, String> studyPlanCerDataMap = new LinkedHashMap<>();

    Logger logger = LoggerFactory.getLogger(StudyPlanServiceImpl.class);
    StudyPlanDetailReqModel model;
    //学习计划编码->学习计划名称&scorm名称
    HashMap<String, String> studyPlanScormName = new HashMap<>();
    HashMap<String, String> studyPlanName = new HashMap<>();

    @Override
    public void doExecl(StudyPlanDetailReqModel model, String filePath) throws Exception {
        this.model = model;
        userDataList= this.doGetExcelData();
        Iterator<LinkedHashMap<String,String>> mapIterator = userDataList.iterator();
        List<String> excludeArr = Arrays.asList("studyplan_name", "studyplan_code", "scorm_name");
        while (mapIterator.hasNext()){
            LinkedHashMap<String,String> map = mapIterator.next();
            //加入到studyPlanCerDataMap
            for (String field : repository.getOuterFields()){
                String code = field.substring(0, field.indexOf("_"));
                if(field.contains("studyplan_name") && !studyPlanName.containsKey(code)){
                    map.get(field);
                    studyPlanName.put(code, map.get(field));
                }
                if(field.contains("scorm_name") && !studyPlanScormName.containsKey(code)){
                    studyPlanScormName.put(code, map.get(field));
                }
            }
            Iterator<Map.Entry<String,String>> entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()){
                Map.Entry<String,String> entry = entryIterator.next();
                for (String excludeStr: excludeArr){
                    if(entry.getKey().contains(excludeStr)){
                        entryIterator.remove();
                    }
                }
            }
        }

        //输出文件
        this.writeExcel(filePath);
    }



    @Override
    public void writeExcel(String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        int index=0;
        Iterator<LinkedHashMap<String,String>> mapIterator = userDataList.iterator();
        while (mapIterator.hasNext()){
            HashMap<String,String> mapData = mapIterator.next();
            XSSFRow row = sheet.createRow(index);
            Iterator<Map.Entry<String,String>> entryIterator = mapData.entrySet().iterator();
            //基本数据增添
            int indexCell = 0;
            while (entryIterator.hasNext()){
                Map.Entry<String,String> entry = entryIterator.next();
                StringBuilder value = new StringBuilder();
                if(entry.getValue() != null && entry.getKey().contains("certificate_status")){
                    value.append(entry.getValue().equals("0")?"未获得":"获得");
                }
                else if(entry.getValue()!=null){
                    value.append(entry.getValue());
                }
                row.createCell(indexCell).setCellValue(value.toString());
                indexCell ++;
            }
            index++;
        }
        //头部完善
        buildHeadRow(sheet, workbook);

        FileOutputStream fileOutputStream = new FileOutputStream(filePath+"/tt.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        logger.info("导出完成");
    }

    public void buildHeadRow(XSSFSheet sheet, XSSFWorkbook workbook){
        //将后面的空行移动到前方
        int emptyLine = 3;
        for (int i=0; i<emptyLine;i++){
            sheet.shiftRows(i, sheet.getLastRowNum(), 1,true,false);
        }

        //处理学习计划编码头部
        writeHeadRowStudyPlanCode(sheet);
        //处理详情信息
        wirteDetailRow(sheet, workbook);
        //处理顶部头部信息
        writeTitle(sheet, workbook);
    }

    void dealMerge(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol){
        sheet.addMergedRegion(new CellRangeAddress(firstRow,lastRow,firstCol,lastCol));
    }

    public void writeHeadRowStudyPlanCode(XSSFSheet sheet){
        List<String> codeList = Arrays.asList(model.getCode().split(","));
        int i=0;
        for (String code:codeList){
            if(i==0){
                dealMerge(sheet, 1, 1, (i*4+8),(i*4+11));
                dealCell(sheet, 1, (i*4+8), studyPlanName.get(code), null);
                wirteScormCerRow(sheet.createRow(2), i, code);
            }
            else{
                dealMerge(sheet, 1, 1, (i*4+8),(i*4+11));
                dealCellWithRow(sheet.getRow(1),  1, (i*4+8), studyPlanName.get(code), null);
                wirteScormCerRow(sheet.getRow(2), i, code);
            }
            i ++;
        }
    }

    public void wirteScormCerRow(XSSFRow row, int i, String code){
        String scormName = studyPlanScormName.get(code);
        dealCellWithRow(row,2, (i*4+8), scormName, null);
        dealCellWithRow(row,2, (i*4+9), "证书获得状态", null);
        dealCellWithRow(row,2, (i*4+10), "证书获得时间", null);
        dealCellWithRow(row,2, (i*4+11), "证书编码", null);
    }

    public void wirteDetailRow(XSSFSheet sheet,XSSFWorkbook workbook){
        List<String> data = Arrays.asList("省", "市", "县","单位","单位类型_1","单位类型_2","用户名","姓名");
        for (int i=0;i<data.size();i++){
            dealMerge(sheet, 1,2, i, i);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
            style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
            style.setWrapText(true);
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            style.setFont(font);
            XSSFCell cell = dealCellWithRow(sheet.getRow(1), 1, i, data.get(i), style);
        }
    }

    public void writeTitle(XSSFSheet sheet,XSSFWorkbook workbook){
        dealMerge(sheet, 0, 0,0, (8+model.getCode().split(",").length*4));
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        style.setFont(font);
        dealCellWithRow(sheet.createRow(0), 0, 0, "教师教育在线考核结果", style);
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

    @Override
    public List<LinkedHashMap<String,String>> doGetExcelData() {
        return repository.getData(this.model);
    }
}
