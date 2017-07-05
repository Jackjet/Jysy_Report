package cn.coderss.jysy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/5
 * Time: 下午3:42
 * Blog: http://www.coderss.cn
 */
@RestController
@RequestMapping("/wechat")
public class WechatServiceDel {

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public static HashMap<String,String> delService(String content){
        String regex = "([a-z]|[A-Z]|[0-9])*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        StringBuilder stringBuilder = new StringBuilder();
        while (m.find()){
            if(!m.group().equals("")){
                stringBuilder.append("'"+m.group()+"',");
            }
        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        return new HashMap<String,String>(){{
            put("message", stringBuilder.toString());
        }};
    }

    public static void main(String[] args) {
        System.out.println(WechatServiceDel.delService("FUZN2813\t颜金土\n" +
                "FUZGR536\t林金珠\n" +
                "FUZSD017\t黄丽萍\n" +
                "FUZT1468\t庄碧华\n" +
                "FUZT4387\t陈秀梅\n" +
                "FUZT5616\t许爱平\n" +
                "FUZTE710\t赖雪君\n" +
                "FUZU0389\t施瑞珊\n" +
                "FUZY0150\t王文智\n" +
                "FUZK1838\t赖玉华\n" +
                "FUZK5099\t李莹香\n" +
                "FUZK2773\t何春芳\n" +
                "FUJH2210\t李菊女\n" +
                "FUZP0287\t季思恩\n" +
                "FUZG2525\t庄素琼\n" +
                "FUZTE218\t肖美英\n" +
                "FUZZ3630\t林志英\n" +
                "FUZZ8441\t王妥霞"));
    }
}
