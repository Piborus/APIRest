package com.lampp.hire.service;

import com.lampp.hire.models.Hire;
import com.lampp.hire.repository.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
public class HireService {

    @Autowired
    private HireRepository hireRepository;

    @Autowired
    private Hire hire;

    public HireService(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }


    public Long shortenUrl(String originalUrl) {
        String shortKey = Base64.getUrlEncoder().withoutPadding().encodeToString(UUID.randomUUID().toString().getBytes()).substring(0, 6);
        hire.setOriginalUrl(originalUrl);
        hire.setShortUrl(shortKey);
        hireRepository.save(hire);
        return hire.getId();
    }

    public String expandUrl(Long id) {
        Hire urlMapping = hireRepository.findById(id).orElse(null);
        return urlMapping != null ? urlMapping.getOriginalUrl() : null;
    }


//    public String expandUrl(String shortUrl) throws ShortenedUrlNotFoundException {
//        Hire urlEntity = urlRepository.findByShortUrl(shortUrl);
//
//        if (urlEntity == null || !urlEntity.isAtivo()) {
//            throw new ShortenedUrlNotFoundException("SHORTENED URL NOT FOUND");
//        }
//
//        // Retorne a URL original
//        return urlEntity.getOriginalUrl();
//    }
//
//    public Hire shortenUrl(String originalUrl, String customAlias) throws CustomAliasAlreadyExistsException {
//        // Verifique se o CUSTOM_ALIAS já existe
//        Hire existingUrl = urlRepository.findByShortUrl(customAlias);
//        if (existingUrl != null) {
//            throw new CustomAliasAlreadyExistsException("CUSTOM ALIAS ALREADY EXISTS");
//        }
//
//        Hire urlEntity = new Hire();
//        urlEntity.setOriginalUrl(originalUrl);
//        urlEntity.setReponseTime(LocalDateTime.now());
//
//        if (customAlias != null) {
//            urlEntity.setShortUrl(customAlias);
//        } else {
//            String shortUrl = generateShortUrl(originalUrl);
//            urlEntity.setShortUrl(shortUrl);
//        }
//
//        urlEntity.setAtivo(true);
//
//        return urlRepository.save(urlEntity);
//    }
//
//    private String generateShortUrl(String originalUrl) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            byte[] bytes = md.digest(originalUrl.getBytes(StandardCharsets.UTF_8));
//
//            // Converta o hash em base64
//            String base64Hash = Base64.getEncoder().encodeToString(bytes);
//
//            // Pegue os primeiros 6 caracteres do base64 como alias curto
//            return base64Hash.substring(0, 6);
//        } catch (NoSuchAlgorithmException e) {
//            // Lide com exceções, por exemplo, lançando uma exceção personalizada
//            throw new RuntimeException("Erro ao gerar o alias curto");
//        }
//    }



}
