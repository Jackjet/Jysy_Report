package cn.coderss.jysy.utility;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/24
 * Time: 上午10:21
 * Blog: http://www.coderss.cn
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
    public DateUtil() {
    }

    public static boolean isParseDate(String date) {
        String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(date);
        boolean dateFlag = m.matches();
        return dateFlag;
    }
}
