package com.lampp.hire.service;

import com.lampp.hire.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;


    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


}
