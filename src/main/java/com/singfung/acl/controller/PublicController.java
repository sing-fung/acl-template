package com.singfung.acl.controller;

import com.singfung.acl.model.dto.PartnerDTO;
import com.singfung.acl.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class PublicController {
    private PartnerService partnerService;

    @Autowired
    public PublicController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/permission1")
    public ResponseEntity<?> permission1(@RequestBody PartnerDTO dto) {
        partnerService.permission1(dto);
        return ResponseEntity.ok(null);
    }
}
