package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "url")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_url")
    private Long idUrl;

    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @Column(name = "date_url", nullable = false)
    private LocalDate dateUrl;

    @Column(name = "search_type_url", nullable = false, length = 100)
    private String searchTypeUrl;

    @Column(name = "source_type_url", nullable = false, length = 50)
    private String sourceTypeUrl;

    @Column(name = "summary_url", length = 300)
    private String summaryUrl;

    @Column(name = "created_at_url", nullable = false)
    private LocalDateTime createdAtUrl;

    @Column(name = "updated_at_url", nullable = false)
    private LocalDateTime updatedAtUrl;

    @PrePersist
    protected void onCreate() {
        this.dateUrl = LocalDate.now();
        this.createdAtUrl = LocalDateTime.now();
        this.updatedAtUrl = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAtUrl = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity user;
}
