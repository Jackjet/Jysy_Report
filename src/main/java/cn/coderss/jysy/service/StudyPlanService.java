package cn.coderss.jysy.service;

import cn.coderss.jysy.reqmodel.StudyPlanDetailReqModel;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/29
 * Time: 上午9:58
 * Blog: http://www.coderss.cn
 */
public interface StudyPlanService {
    public void doExecl(StudyPlanDetailReqModel model, String filePath) throws Exception;
    public void writeExcel(String filePath) throws IOException;
    public List<LinkedHashMap<String,String>> doGetExcelData();
}
