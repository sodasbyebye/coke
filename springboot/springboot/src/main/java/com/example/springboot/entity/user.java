package com.example.springboot.entity;

import jakarta.annotation.Generated;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;
    
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    @Column(name = "email", length = 100, unique = true)
    private String email;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "avatar", length = 255)
    private String avatar;
    
    @Column(name = "status", columnDefinition = "tinyint default 1")
    private Integer status;
    
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // 自动设置时间（在持久化前执行）
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    // 自动更新时间（在更新时执行）
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}