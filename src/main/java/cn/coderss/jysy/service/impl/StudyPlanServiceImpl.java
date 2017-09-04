package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.dao.StudyPlanDetailData;
import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;
import cn.coderss.jysy.service.StudyPlanService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

    @Override
    public void doExecl(StudyPlanDetailReqModel model, String filePath) throws Exception {
        this.model = model;
        userDataList= this.doGetExcelData();
        Iterator<LinkedHashMap<String,String>> mapIterator = userDataList.iterator();
        List excludeArr = Arrays.asList("studyplan_name", "studyplan_code", "scorm_name");
        while (mapIterator.hasNext()){
            LinkedHashMap<String,String> map = mapIterator.next();
            //加入到studyPlanCerDataMap
            if(!studyPlanCerDataMap.containsKey(map.get("studyplan_name"))){
                studyPlanCerDataMap.put(map.get("studyplan_name"), map.get("scorm_name"));
            }
            Iterator<Map.Entry<String,String>> entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()){
                Map.Entry<String,String> entry = entryIterator.next();
                if(excludeArr.contains(entry.getKey())){
                    entryIterator.remove();
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
                if(entry.getValue() != null){
                    value.append(entry.getValue());
                }
                row.createCell(indexCell).setCellValue(value.toString());
                indexCell ++;
            }
            index++;
        }
        //头部完善
        buildHeadRow(sheet);

        FileOutputStream fileOutputStream = new FileOutputStream(filePath+"/tt.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        logger.info("导出完成");
    }

    public void buildHeadRow(XSSFSheet sheet){

    }

    @Override
    public List<LinkedHashMap<String,String>> doGetExcelData() {
        return repository.getData(this.model);
    }
}
