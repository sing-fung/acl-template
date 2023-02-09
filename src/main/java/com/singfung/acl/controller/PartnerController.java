package com.singfung.acl.controller;

import com.singfung.acl.model.dto.PartnerDTO;
import com.singfung.acl.model.entity.Partner;
import com.singfung.acl.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {
    private PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping()
    public Partner partnerEnroll(@RequestBody PartnerDTO dto) {
        return partnerService.addPartner(dto);
    }
}
