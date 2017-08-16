package cn.coderss.jysy.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/16
 * Time: 下午1:59
 * Blog: http://www.coderss.cn
 */
public class DateUtil {
    public static boolean isParseDate(String date){
        String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(date);
        boolean dateFlag = m.matches();
        if (!dateFlag) {
            return false;
        }
        return true;
    }
}
