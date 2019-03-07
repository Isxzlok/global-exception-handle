package com.xiongya.global.execption.exception;

import com.xiongya.global.execption.entity.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类 （只能处理未捕获（往外抛）的异常）
 */
@ControllerAdvice   //确保此类被扫描并加载到spring容器中
public class GlobalExceptionHandle {


    /**
     * 处理所有系统异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)  //声明异常处理方法
    @ResponseBody
    public ErrorInfo<String> SystemErrorHandler(HttpServletRequest request, Exception e){
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setCode(100);
        errorInfo.setData("this is some data");
        errorInfo.setUrl(request.getRequestURI().toString());
        errorInfo.setMsg(e.getMessage());
        return errorInfo;
    }


    /**
     * 处理所有业务逻辑异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorInfo<String> BusinessErrorHandle(HttpServletRequest request, BusinessException e){
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setCode(101);
        errorInfo.setData("this is some data");
        errorInfo.setUrl(request.getRequestURL().toString());
        errorInfo.setMsg(e.getMessage());
        return errorInfo;
    }


}
