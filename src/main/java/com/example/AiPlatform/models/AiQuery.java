package com.example.AiPlatform.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ai_queries")
@Data
@NoArgsConstructor

public class AiQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String queryText;
    private String responseText;
    private LocalDateTime createdAt;

    @Column(name = "filePath", nullable = true)
    private String filePath;

    @Enumerated
    private QueryStatus status = QueryStatus.PENDING;

    public enum QueryStatus{
        PENDING, PROCESSING, COMPLETED, FAILED
    }
}
