package com.chubby.demo.controller;

import com.chubby.demo.constant.ApiUrlConstant;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {


    @Override
    public String getErrorPath() {
        return ApiUrlConstant.ERROR_PATH;
    }

    @RequestMapping(value = ApiUrlConstant.ERROR_PATH)
    public String error() {
        return "error";
    }
}
