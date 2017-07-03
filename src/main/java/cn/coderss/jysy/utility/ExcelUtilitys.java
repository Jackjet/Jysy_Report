package cn.coderss.jysy.utility;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/3
 * Time: 下午2:34
 * Blog: http://www.coderss.cn
 */
public class ExcelUtilitys {
    public static String writeExcel(String filepath, ArrayList<LinkedHashMap<String, String>> dataList){
        //当前日期
        String now = new SimpleDateFormat("Y-MM-dd H:mm:s").format(new Date());
        FileOutputStream stream = null;
        try {
            Iterator<LinkedHashMap<String, String>> dataIterator = dataList.iterator();
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet();
            int rowIndex = 0;
            while (dataIterator.hasNext()) {
                LinkedHashMap<String,String> map = dataIterator.next();
                XSSFRow row = sheet.createRow(rowIndex ++);
                int columnIndex = 0 ;
                for (Map.Entry<String,String> entry : map.entrySet()){
                    row.createCell(columnIndex++).setCellValue(entry.getValue());
                }
            }
            FileUtilitys.makeDir(filepath);
            String fileName = filepath+"/"+now+".xlsx";
            stream = new FileOutputStream(new File(fileName));
            wb.write(stream);
            return fileName;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
