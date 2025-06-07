package com.example.AiPlatform.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "freelancers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Freelancer {

    @Id
    private Long id; //совпадает с user.id
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

    protected boolean canEqual(final Object other) {
        return other instanceof Freelancer;
    }
}