package com.singfung.acl.controller;

import com.singfung.acl.model.dto.PartnerDTO;
import com.singfung.acl.model.entity.Partner;
import com.singfung.acl.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {
    private PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping()
    public ResponseEntity<?> partnerEnroll(@RequestBody PartnerDTO dto) {
        Partner response = partnerService.addPartner(dto);
        return ResponseEntity.ok(response);
    }
}
