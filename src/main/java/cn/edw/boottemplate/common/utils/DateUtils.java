package cn.edw.boottemplate.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author lianchen.zhang
 */
public class DateUtils {

    /**
     * 校验日期格式是否合法
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被接受，并转换成2007-03-01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
