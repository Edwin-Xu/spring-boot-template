package cn.edw.boottemplate.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author lianchen.zhang
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R setData(Object data) {
        put("data", data);
        return this;
    }

    /**
     * 利用fast json进行反序列化
     */
    public <T> T getData(TypeReference<T> typeReference) {
        //默认是map
        Object data = get("data");
        String jsonString = JSON.toJSONString(data);
        return JSON.parseObject(jsonString, typeReference);
    }

    /**
     * 利用fast json进行反序列化
     */
    public <T> T getData(String key, TypeReference<T> typeReference) {
        //默认是map
        Object data = get(key);
        String jsonString = JSON.toJSONString(data);
        return JSON.parseObject(jsonString, typeReference);
    }

    public R() {
        put("success", true);
        put("msg", "success");
    }

    public static R error() {
        return error("未知异常，请联系管理员");
    }


    public static R error(String msg) {
        R r = new R();
        r.put("success", false);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
