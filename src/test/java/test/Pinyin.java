package test;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/14
 * Time: 下午2:27
 * Blog: http://www.coderss.cn
 */
public class Pinyin {
    public static void main(String[] args) throws PinyinException {
        System.out.println(PinyinHelper.convertToPinyinString("绰绰有余", "", PinyinFormat.WITHOUT_TONE));
    }
}
