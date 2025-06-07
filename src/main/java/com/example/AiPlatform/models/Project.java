package com.example.AiPlatform.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal budget;
    private String deadline;
    private String status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
