package com.singfung.acl.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acl_user_permission")
@Data
public class UserPermission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "permission_id")
    Integer permissionId;

    @Column(name = "create_time", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @Column(name = "ts", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date ts;
}
