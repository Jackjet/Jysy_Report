package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.service.ReportExecService;
import cn.coderss.jysy.utility.FileUtilitys;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/10
 * Time: 下午4:33
 * Blog: http://www.coderss.cn
 */
@Service
public class ReportExecServiceImpl implements ReportExecService{

    @Override
    public void readExcel(String filename) {
        try {
            FileInputStream inputStream = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()){
                Row row = rows.next();
                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()){
                    Cell cell = cells.next();
                    System.out.println(cell.getStringCellValue());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String doExcel(MultipartFile file) {
        String fileEncode = System.getProperty("file.encoding");
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String datePath = format.format(new Date());
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
                //打包传送出来
                FileUtilitys.fileToZip(dirs, dirs, datePath);

                return "成功上传" + dirs + datePath + ".zip";
            } catch (Exception e) {
                return "上传失败 " + fileName + " => " + e.getMessage();
            }
        } else {
            return "上传失败 " + fileName + " 因为文件为空";
        }
    }

    @Override
    public void test() {
        System.out.println("test");
    }

}
