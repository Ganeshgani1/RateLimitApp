package com.example.rateLimitApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private Long tps;
    private boolean recordDeleted=false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTps() {
        return tps;
    }

    public void setTps(Long tps) {
        this.tps = tps;
    }

    public boolean isRecordDeleted() {
        return recordDeleted;
    }

    public void setRecordDeleted(boolean recordDeleted) {
        this.recordDeleted = recordDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", tps=" + tps +
                ", recordDeleted=" + recordDeleted +
                '}';
    }
}
