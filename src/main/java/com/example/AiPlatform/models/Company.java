package com.example.AiPlatform.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company{
    @Id
    private Long id; //совпадает с user.id

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    private String name;
    private String description;
    private String industry;
    private String website;
    private String location;
    private String phone;

    public Company(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Company;
    }
}
