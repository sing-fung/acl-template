package com.singfung.acl.service;

import com.singfung.acl.model.dto.PartnerDTO;
import com.singfung.acl.model.entity.Partner;
import com.singfung.acl.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class PartnerService {
    private PartnerRepository partnerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PartnerService(PartnerRepository partnerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.partnerRepository = partnerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Partner addPartner(PartnerDTO partnerDTO) {
        String appId = partnerDTO.getAppId();
        if (appId == null || appId.length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "appId could neither be null nor empty");
        }

        if(partnerRepository.findByAppId(appId) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "appId already exists");
        }

        String apiKey = partnerDTO.getApiKey();
        if (apiKey == null || apiKey.length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "apiKey could neither be null nor empty");
        }

        Partner partner = new Partner();
        partner.setAppId(appId);
        partner.setApiKey(bCryptPasswordEncoder.encode(partnerDTO.getApiKey()));
        partner.setCreateTime(new Date());
        partner.setTs(new Date());

        return partnerRepository.save(partner);
    }
}
