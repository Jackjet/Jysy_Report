package cn.coderss.jysy.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/17
 * Time: 下午1:22
 * Blog: http://www.coderss.cn
 */
public class UuidStr {
    public static String getUuidStr(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
        StringBuilder uuidStr = new StringBuilder();
        uuidStr.append(dateFormat.format(new Date()));
        uuidStr.append(new Random().nextInt(100));
        return uuidStr.toString();
    }
}
