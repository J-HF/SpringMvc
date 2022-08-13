package com.utils;

import com.pojo.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        String msg = "Sorry,系统发生异常";
        if(e instanceof MyException){
            msg = ((MyException)e).getMsg();
        }
        ModelAndView mav = new ModelAndView();
//
        mav.addObject("msg",msg);
        mav.setViewName("msg");
        return mav;
    }
}
