package cn.coderss.jysy.utility;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * Created with report.
 * User: shenwei
 * Date: 17/7/25
 * Time: 上午11:23
 * Blog: http://www.coderss.cn
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}

