package com.singfung.acl.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "partner")
@Data
public class Partner {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "app_id", nullable = false, unique = true, length = 25)
    String appId;

    @Column(name = "api_key", nullable = false, length = 256)
    @JsonIgnore
    String apiKey;

    @Column(name = "create_time", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @Column(name = "ts", nullable = false, length = 50)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date ts;
}
