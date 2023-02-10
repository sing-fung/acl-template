package com.singfung.acl.service;

import com.singfung.acl.model.dto.PartnerDTO;
import com.singfung.acl.model.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private PartnerService partnerService;

    @Autowired
    public BusinessService(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    public void doBusiness(PartnerDTO dto) {
        Partner partner = partnerService.validateAuthentication(dto);

        // do something
    }
}
