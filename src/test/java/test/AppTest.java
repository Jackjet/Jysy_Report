package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with report.
 * User: shenwei
 * Date: 2017/8/31
 * Time: 下午1:07
 * Blog: http://www.coderss.cn
 */
public class AppTest {
    public static void main(String[] args) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>() {{
            add(new HashMap<String,String>(){{put("code","1");}});
            add(new HashMap<String,String>(){{put("code","2");}});
            add(new HashMap<String,String>(){{put("code","3");}});
        }};

        List<String> newList= list.stream().map(item->item.get("code")).collect(Collectors.toList());
        System.out.println(newList);
    }
}
