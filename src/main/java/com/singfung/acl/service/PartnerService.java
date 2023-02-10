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

    public Partner addPartner(PartnerDTO dto) {
        validatePartnerDTO(dto);

        if(partnerRepository.findByAppId(dto.getAppId()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "appId already exists");
        }

        Partner partner = new Partner();
        partner.setAppId(dto.getAppId());
        partner.setApiKey(bCryptPasswordEncoder.encode(dto.getApiKey()));
        partner.setCreateTime(new Date());
        partner.setTs(new Date());

        return partnerRepository.save(partner);
    }

    public Partner validateAuthentication(PartnerDTO dto) {
        validatePartnerDTO(dto);

        Partner partner = partnerRepository.findByAppId(dto.getAppId());
        if (partner == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid appId");
        }

        if(!bCryptPasswordEncoder.matches(dto.getApiKey(), partner.getApiKey())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authentication failed");
        }

        return partner;
    }

    private void validatePartnerDTO(PartnerDTO partnerDTO) {
        String appId = partnerDTO.getAppId();
        if (appId == null || appId.length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "appId could neither be null nor empty");
        }

        String apiKey = partnerDTO.getApiKey();
        if (apiKey == null || apiKey.length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "apiKey could neither be null nor empty");
        }
    }
}
