package cn.edw.boottemplate.exceptionhandler;

import cn.edw.boottemplate.common.exception.BizCodeEnum;
import cn.edw.boottemplate.common.utils.R;
import cn.edw.boottemplate.common.utils.RRException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


/**
 * TODO RestControllerAdvice
 * @author lianchen.zhang
 */
@RestControllerAdvice(basePackages = "cn.edw.boottemplate.controller")
public class ExceptionControllerAdvice {

    private final Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class);

    /**
     * 参数非法（效验参数）异常 MethodArgumentNotValidException
     * @param e 由springMVC抛出
     * @return R
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R handleValidException(MethodArgumentNotValidException e) {
        logger.error("数据效验出现问题{},异常类型{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String,String> errMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getMessage())
                .setData(errMap);
    }

    /**
     * 业务异常，一般是客户端参数错误
     */
    @ExceptionHandler(RRException.class)
    public R handleCustomException(RRException e){
        return R.error(e.getMsg());
    }

    /**
     * 其余未处理的异常
     */
//    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {

        logger.error("系统未处理的异常：{}",throwable.toString());

        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getMessage());
    }

}
