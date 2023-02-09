package com.singfung.acl.repository;

import com.singfung.acl.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>
{
    User findByAppId(String appId);
}