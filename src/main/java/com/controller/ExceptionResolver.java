package com.controller;

import com.util.accessExcetpion.AccessException;
import com.util.common.Constants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@ControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler(value = AccessException.class)
    public ModelAndView resolveMathException(AccessException exception) throws IOException {
        String viewName = "401";
        return commonResolve(viewName, exception);
    }

    private ModelAndView commonResolve(String viewName, Exception exception) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(Constants.ATTR_NAME_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
