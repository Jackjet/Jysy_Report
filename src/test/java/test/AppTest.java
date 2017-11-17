package test;

import cn.coderss.jysy.App;
import cn.coderss.jysy.service.impl.ReportDetailServiceImpl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/31
 * Time: 下午1:07
 * Blog: http://www.coderss.cn
 */
public class AppTest {
    private ReportDetailServiceImpl service = new ReportDetailServiceImpl();
    private List<LinkedHashMap<String, String>> onlineData = new ArrayList<LinkedHashMap<String, String>>();

//    @Test
    public void toDoExcel() throws Exception {
        this.readSelfExcel("/Users/mac/Downloads/detail.xlsx");
        service.readOnlineExcel(onlineData,  "全国", "", "all",
                "all", "2017-06-25", "2017-11-15", "/Users/mac/Downloads/data",
                "");
    }

    public void readSelfExcel(String filename) throws IOException {
        InputStream inputStream = null;
        Workbook wb = null;
        inputStream = new FileInputStream(filename);
        wb = new XSSFWorkbook(inputStream);
        Sheet sheet = wb.getSheetAt(0);
        Iterator rows = sheet.rowIterator();
        LinkedHashMap<String,String> linkedHashMap;
        while(rows.hasNext()) {
            linkedHashMap = new LinkedHashMap<String,String>();
            Row row = (Row)rows.next();
            linkedHashMap.put("province", row.getCell(0) != null? row.getCell(0).toString():"");
            linkedHashMap.put("city", row.getCell(1) != null? row.getCell(1).toString():"");
            linkedHashMap.put("country", row.getCell(2) != null? row.getCell(2).toString():"");
            linkedHashMap.put("org_custom_name", row.getCell(3) != null? row.getCell(3).toString():"");
            linkedHashMap.put("org_name_second", row.getCell(4) != null? row.getCell(4).toString():"");
            linkedHashMap.put("org_name", row.getCell(5) != null? row.getCell(5).toString():"");
            linkedHashMap.put("name", row.getCell(6) != null? row.getCell(6).toString():"");
            linkedHashMap.put("fullname", row.getCell(7) != null? row.getCell(7).toString():"");
            linkedHashMap.put("sex", row.getCell(8) != null? row.getCell(8).toString():"");
            linkedHashMap.put("birthday", row.getCell(9) != null? row.getCell(9).toString():"");
            linkedHashMap.put("mail", row.getCell(10) != null? row.getCell(10).toString():"");
            linkedHashMap.put("position", row.getCell(11) != null? row.getCell(11).toString():"");
            linkedHashMap.put("sign_ways", row.getCell(12) != null? row.getCell(12).toString():"");
            linkedHashMap.put("createtime", row.getCell(13) != null? row.getCell(13).toString():"");
            linkedHashMap.put("order_states", row.getCell(14) != null? row.getCell(14).toString():"");
            linkedHashMap.put("pay_ways", row.getCell(15) != null? row.getCell(15).toString():"");
            linkedHashMap.put("pay_time", row.getCell(16) != null? row.getCell(16).toString():null);
            linkedHashMap.put("org_custom_name1", row.getCell(17) != null? row.getCell(17).toString():"");
            linkedHashMap.put("address", row.getCell(18) != null? row.getCell(18).toString():"");
            linkedHashMap.put("periods", row.getCell(19) != null? row.getCell(19).toString():"");
            linkedHashMap.put("cer_states", row.getCell(20) != null? row.getCell(20).toString():"");
            linkedHashMap.put("cer_time", row.getCell(21) != null? row.getCell(21).toString():null);
            linkedHashMap.put("cer_code", row.getCell(22) != null? row.getCell(22).toString():"");
            onlineData.add(linkedHashMap);
        }
    }
}


