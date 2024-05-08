package com.example.se2Assignment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String theaterName;
    private String address;
    private String imageUrl;
    private String a_section;
    private String b_section;
    private String vip_section;
    private String description;

    public Theater(long id, String theaterName, String address, String imageUrl,
                   String a_section, String b_section, String vip_section, String description) {
        this.id = id;
        this.theaterName = theaterName;
        this.address = address;
        this.imageUrl = imageUrl;
        this.a_section = a_section;
        this.b_section = b_section;
        this.vip_section = vip_section;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getA_section() {
        return a_section;
    }

    public void setA_section(String a_section) {
        this.a_section = a_section;
    }

    public String getB_section() {
        return b_section;
    }

    public void setB_section(String b_section) {
        this.b_section = b_section;
    }

    public String getVip_section() {
        return vip_section;
    }

    public void setVip_section(String vip_section) {
        this.vip_section = vip_section;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
