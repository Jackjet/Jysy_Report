package cn.coderss.jysy.service.impl;

import cn.coderss.jysy.domain.JysyModel;
import cn.coderss.jysy.service.ReportDetailService;
import cn.coderss.jysy.utility.Character2PinyinUtil;
import cn.coderss.jysy.utility.FileUtilitys;
import org.apache.poi.ss.usermodel.Cell;
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
 * Time: 下午3:03
 * Blog: http://www.coderss.cn
 */
@Service
public class ReportDetailServiceImpl implements ReportDetailService {
    public static HashMap<String, ArrayList<JysyModel>> data = new HashMap<String, ArrayList<JysyModel>>();
    public static ArrayList<String> array_province = new ArrayList<String>();
    public static ArrayList<String> head_title = new ArrayList<String>();
    @Override
    public void readExcel(String filename) throws IOException {
        InputStream inputStream = null;
        Workbook wb = null;
        try {
            inputStream = new FileInputStream(filename);
            wb = new XSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()){
                Row row = rows.next();
                String province = row.getCell(0).toString();
                if (!province.equals("省") && !array_province.contains(province)){
                    array_province.add(province);
                }
                if (province.equals("省")){
                    Iterator<Cell> cells = row.cellIterator();
                    while (cells.hasNext()){
                        head_title.add(cells.next().toString());
                    }
                }
            }

            for (String province_str: array_province) {
                Sheet sheet1 = wb.getSheetAt(0);
                Iterator<Row> rows1 = sheet1.rowIterator();
                ArrayList<JysyModel> da = new ArrayList<JysyModel>();
                while (rows1.hasNext()){
                    Row row = rows1.next();
                    if(province_str.equals(row.getCell(0).toString())){
                        JysyModel model = new JysyModel(row.getCell(0).toString(),
                                row.getCell(1)==null ? "" : row.getCell(1).toString(),
                                row.getCell(2)==null ? "" : row.getCell(2).toString(),
                                row.getCell(3)==null ? "" : row.getCell(3).toString(),
                                row.getCell(4)==null ? "" : row.getCell(4).toString(),
                                row.getCell(5)==null ? "" : row.getCell(5).toString(),
                                row.getCell(6)==null ? "" : row.getCell(6).toString(),
                                row.getCell(7)==null ? "" : row.getCell(7).toString(),
                                row.getCell(8)==null ? "" : row.getCell(8).toString(),
                                row.getCell(9)==null ? "" : row.getCell(9).toString(),
                                row.getCell(10)==null ? "" : row.getCell(10).toString(),
                                row.getCell(11)==null ? "" : row.getCell(11).toString(),
                                row.getCell(12)==null ? "" : row.getCell(12).toString(),
                                row.getCell(13)==null ? "" : row.getCell(13).toString(),
                                row.getCell(14)==null ? "" : row.getCell(14).toString(),
                                row.getCell(15)==null ? "" : row.getCell(15).toString(),
                                row.getCell(16)==null ? "" : row.getCell(16).toString(),
                                row.getCell(17)==null ? "" : row.getCell(17).toString(),
                                row.getCell(18)==null ? "" : row.getCell(18).toString(),
                                row.getCell(19)==null ? "" : row.getCell(19).toString(),
                                row.getCell(20)==null ? "" : row.getCell(20).toString(),
                                row.getCell(21)==null ? "" : row.getCell(21).toString(),
                                row.getCell(22)==null ? "" : row.getCell(22).toString()
                        );
                        da.add(model);
                    }
                }
                data.put(province_str,da);
            }


        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally {
            inputStream.close();
        }
    }

    @Override
    public void writeExcel(String filepath) throws IOException {
        FileOutputStream outStream = null;
        for (String provinceName:array_province) {
            ArrayList<JysyModel> arr = data.get(provinceName);
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("tmp");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,head_title.size()));//合并单元格


            XSSFCellStyle cellStyle = wb.createCellStyle();
            cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中

            XSSFRow head_top = sheet.createRow(0);
            XSSFCell top_cell = head_top.createCell(0);
            top_cell.setCellValue(provinceName + "在线培训学员注册与学习情况统计表");
            top_cell.setCellStyle(cellStyle);



            XSSFRow head = sheet.createRow(1);
            for (int i=0;i <head_title.size(); i++){
                head.createCell(i).setCellValue(head_title.get(i));
            }

            for(int i=0; i<arr.size();i++){
                XSSFRow row = sheet.createRow(i+2);
                row.createCell(0).setCellValue(arr.get(i).getProvinceName());
                row.createCell(1).setCellValue(arr.get(i).getCityName());
                row.createCell(2).setCellValue(arr.get(i).getCountyName());
                row.createCell(3).setCellValue(arr.get(i).getSchoolName());
                row.createCell(4).setCellValue(arr.get(i).getDanwei_1());
                row.createCell(5).setCellValue(arr.get(i).getDanwei_2());
                row.createCell(6).setCellValue(arr.get(i).getUserName());
                row.createCell(7).setCellValue(arr.get(i).getFullName());
                row.createCell(8).setCellValue(arr.get(i).getSex());
                row.createCell(9).setCellValue(arr.get(i).getBirthDay());
                row.createCell(10).setCellValue(arr.get(i).getMail());
                row.createCell(11).setCellValue(arr.get(i).getZhiWu());
                row.createCell(12).setCellValue(arr.get(i).getSignWays());
                row.createCell(13).setCellValue(arr.get(i).getCreatetime());
                row.createCell(14).setCellValue(arr.get(i).getPaySatatus());
                row.createCell(15).setCellValue(arr.get(i).getPayWays());
                row.createCell(16).setCellValue(arr.get(i).getPayTimes());
                row.createCell(17).setCellValue(arr.get(i).getFapiao());
                row.createCell(18).setCellValue(arr.get(i).getDetailAddress());
                row.createCell(19).setCellValue(arr.get(i).getFinishTime());
                row.createCell(20).setCellValue(arr.get(i).getCerStatus());
                row.createCell(21).setCellValue(arr.get(i).getCerTime());
                row.createCell(22).setCellValue(arr.get(i).getCerCode());
            }
            if (provinceName != "省"){
                if (filepath.charAt(filepath.length()-1) == '/'){
                    outStream = new FileOutputStream(filepath+ Character2PinyinUtil.getInstance().character2Pinyin(provinceName)+".xlsx");
                }
                else{
                    outStream = new FileOutputStream(filepath+"/"+Character2PinyinUtil.getInstance().character2Pinyin(provinceName)+".xlsx");
                }

                wb.write(outStream);
                outStream.close();
            }
        }
    }

    @Override
    public String doExcel(MultipartFile file) throws UnsupportedEncodingException {
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
                this.writeExcel(dirs);

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
}
