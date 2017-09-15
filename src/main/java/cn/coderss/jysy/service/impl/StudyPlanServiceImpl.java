package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.dao.StudyPlanDetailData;
import cn.coderss.jysy.dao.StudyPlanNameCode;
import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import cn.coderss.jysy.service.StudyPlanService;
import cn.coderss.jysy.utility.FileUtilitys;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

    @Autowired
    StudyPlanNameCode nameCodeRepository;

    /**
     * 存储相关
     * 用户名->学习计划/scorm/证书
     */
    List<LinkedHashMap<String,String>> userDataList = new LinkedList<>();

    Logger logger = LoggerFactory.getLogger(StudyPlanServiceImpl.class);
    StudyPlanDetailReqModel model;
    //学习计划编码->学习计划名称&scorm名称
    HashMap<String, String> studyPlanScormName = new HashMap<>();
    HashMap<String, String> studyPlanName = new HashMap<>();

    @Override
    public void doExecl(StudyPlanDetailReqModel model, String fileName) throws Exception {
        this.model = model;
        userDataList= this.doGetExcelData();
        Iterator<LinkedHashMap<String,String>> mapIterator = userDataList.iterator();
        List<String> excludeArr = Arrays.asList("studyplan_name", "studyplan_code", "scorm_name", "pay_time", "createtime");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date pay_time = null;
        Date createtime = null;
        String code ;
        LinkedHashMap<String,String> map;
        Iterator<Map.Entry<String,String>> entryIterator;
        Map.Entry<String,String> entry;

        while (mapIterator.hasNext()){
            map = mapIterator.next();
            //加入到studyPlanCerDataMap
            for (String field : repository.getOuterFields()){
                code = field.substring(0, field.indexOf("_"));
                if(field.contains("studyplan_name") && !studyPlanName.containsKey(code)){
                    map.get(field);
                    studyPlanName.put(code, map.get(field));
                }
                if(field.contains("scorm_name") && !studyPlanScormName.containsKey(code)){
                    studyPlanScormName.put(code, map.get(field));
                }
            }
            //清除掉
            repository.getOuterFields().clear();

            //注册人群过滤
            if(map.get("createtime") != null) {
                createtime = new Date(dateFormat.parse((map.get("createtime")).toString()).getTime());
            }
            if(map.get("createtime") == null && model.getPeople().equals("注册用户")) {
                mapIterator.remove();
                continue;
            }
            if(map.get("pay_time") != null) {
                pay_time = new Date(dateFormat.parse((map.get("pay_time")).toString()).getTime());
            }

            if(model.getPeople().equals("支付用户") && map.get("pay_time") == null) {
                mapIterator.remove();
                continue;
            }
            if((model.getPeople().equals("支付用户") && (pay_time.compareTo(dateFormat.parse(model.getEndDate())) > 0 ||
                    pay_time.compareTo(dateFormat.parse(model.getStartDate())) < 0)) || (model.getPeople().equals("注册用户") &&
                    (createtime.compareTo(dateFormat.parse(model.getEndDate())) > 0 || createtime.compareTo(dateFormat.parse(model.getStartDate())) < 0))) {
                mapIterator.remove();
                continue;
            }

            //排除省份
            if(!model.getRegion().equals("全国")&& (map.get("province") == null || !map.get("province").equals(model.getRegion()))){
                mapIterator.remove();
                continue;
            }


            entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()){
                entry = entryIterator.next();
                for (String excludeStr: excludeArr){
                    if(entry.getKey().contains(excludeStr)){
                        entryIterator.remove();
                    }
                }
            }
        }

        //输出文件
        this.writeExcel(fileName);
        clearData();
    }


    public void initStudyPlanAndScormName(){
        LinkedHashMap<String,String> data = nameCodeRepository.getNameAndCode();
        for (String code: this.model.getCode().split(",")){
            if (data.get(code) == null) continue;
            String[] value = data.get(code).split(",");
            if(value.length == 1) {
                value = Arrays.copyOf(value, value.length+1);
                value[value.length-1] = "";
            };
            if(!studyPlanName.containsKey(code) || studyPlanName.get(code) == null){
                studyPlanName.put(code, value[0]);
            }
            if(!studyPlanScormName.containsKey(code) || studyPlanScormName.get(code) == null){
                studyPlanScormName.put(code, value[1]);
            }
        }
    }


    @Override
    public void writeExcel(String fileName) throws IOException {
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
                    value.append(entry.getValue().equals("0")?"未获得":"已获得");
                }
                else if(entry.getValue() == null && entry.getKey().contains("certificate_status")){
                    value.append("未获得");
                }
                else if(entry.getValue()!=null){
                    value.append(entry.getValue());
                }
                row.createCell(indexCell).setCellValue(value.toString());
                entryIterator.remove();
                indexCell ++;
            }
            mapIterator.remove();
            index++;
        }
        //强制一下gc
        Runtime.getRuntime().gc();
        //头部完善
        buildHeadRow(sheet, workbook);

        //检测内存是否需要继续下去
        detectionOfMemory();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();

        String needZipDir = fileName.substring(0, fileName.lastIndexOf("/"));
        fileName = fileName.replace(".xlsx", "");
        String purpose = fileName.substring(fileName.indexOf("/"), fileName.length());

        FileUtilitys.fileToZip(needZipDir, "report_down", purpose);
        logger.info("导出完成");
    }

    public void detectionOfMemory(){
        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        logger.info("totalMemory:"+totalMemory+",freeMemory:"+freeMemory);
    }

    public void buildHeadRow(XSSFSheet sheet, XSSFWorkbook workbook){
        //将后面的空行移动到前方
        int emptyLine = 3;
        for (int i=0; i<emptyLine;i++){
            if(i>sheet.getLastRowNum()){
                sheet.createRow(i);
            }
            else{
                sheet.shiftRows(i, sheet.getLastRowNum(), 1,true,false);
            }
        }

        //处理学习计划编码头部
        writeHeadRowStudyPlanCode(sheet, workbook);
        //处理详情信息
        wirteDetailRow(sheet, workbook);
        //处理顶部头部信息
        writeTitle(sheet, workbook);
    }

    void dealMerge(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol){
        sheet.addMergedRegion(new CellRangeAddress(firstRow,lastRow,firstCol,lastCol));
    }

    public void writeHeadRowStudyPlanCode(XSSFSheet sheet, XSSFWorkbook workbook){
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        List<String> codeList = Arrays.asList(model.getCode().split(","));
        int i=0;
        for (String code:codeList){
            if(i==0){
                if(!studyPlanName.containsKey(code) || studyPlanName.get(code) == null)
                    initStudyPlanAndScormName();
                logger.info("studyPlanName:"+studyPlanName.toString());
                dealMerge(sheet, 1, 1, (i*4+8),(i*4+11));
                dealCell(sheet, 1, (i*4+8), studyPlanName.get(code), style);
                wirteScormCerRow(sheet.createRow(2), i, code);
            }
            else{
                dealMerge(sheet, 1, 1, (i*4+8),(i*4+11));
                dealCellWithRow(sheet.getRow(1),  1, (i*4+8), studyPlanName.get(code), style);
                wirteScormCerRow(sheet.getRow(2), i, code);
            }
            i ++;
        }
    }

    public void wirteScormCerRow(XSSFRow row, int i, String code){
        if(!studyPlanScormName.containsKey(code) || studyPlanScormName.get(code) == null)
            initStudyPlanAndScormName();
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


    void clearData(){
        studyPlanScormName.clear();
        studyPlanScormName.clear();
        userDataList.clear();
        Runtime.getRuntime().gc();
    }
}
