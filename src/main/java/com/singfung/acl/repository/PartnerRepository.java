package com.singfung.acl.repository;

import com.singfung.acl.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Serializable>
{
    Partner findByAppId(String appId);
}