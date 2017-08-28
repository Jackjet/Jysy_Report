package cn.coderss.jysy.utility;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/24
 * Time: 上午10:20
 * Blog: http://www.coderss.cn
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UuidStr {
    public UuidStr() {
    }

    public static String getUuidStr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        StringBuilder uuidStr = new StringBuilder();
        uuidStr.append(dateFormat.format(new Date()));
        uuidStr.append((new Random()).nextInt(100));
        return uuidStr.toString();
    }
}

