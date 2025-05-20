package com.example.AiPlatform.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "freelancers")
@Data
@NoArgsConstructor
public class Freelancer {

    @Id
    private /*Long*/int id; //совпадает с user.id
    private String name;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String fullName;
    private String bio;
    private BigDecimal rating;
    private String portfolioUrl;
    private BigDecimal hourlyRate;
    private String location;
    private String phone;
    private String website;


    public Freelancer(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Freelancer;
    }



}