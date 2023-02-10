package com.singfung.acl.controller;

import com.singfung.acl.model.dto.PartnerDTO;
import com.singfung.acl.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
public class BusinessController {
    private BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/business")
    public ResponseEntity<?> doBusiness(@RequestBody PartnerDTO dto) {
        businessService.doBusiness(dto);
        return ResponseEntity.ok(null);
    }
}
