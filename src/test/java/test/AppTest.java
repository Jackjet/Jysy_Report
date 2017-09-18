package test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/31
 * Time: 下午1:07
 * Blog: http://www.coderss.cn
 */
public class AppTest {
    public static void main(String[] args) throws IOException {
        String  a = "a.0";
        a.replaceAll(".0", "");
        System.out.println(a);
    }
}
