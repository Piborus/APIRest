package com.lampp.hire.controller;

import com.lampp.hire.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urls")
public class UrlController{

    @Autowired
    private UrlService urlService;


}
