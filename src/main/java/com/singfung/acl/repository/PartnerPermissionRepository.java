package com.singfung.acl.repository;

import com.singfung.acl.model.entity.PartnerPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PartnerPermissionRepository extends JpaRepository<PartnerPermission, Serializable>
{}