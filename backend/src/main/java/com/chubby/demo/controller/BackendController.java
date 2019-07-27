package com.chubby.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController
@RequestMapping("/")
public class BackendController {

    @RequestMapping(value = "{:^(?!index\\.html|api).$}")
    public RedirectView redirectApi() {
        log.info("URL entered directly into the Browser, so we need to redirect...");
        return new RedirectView("/");
    }
}
