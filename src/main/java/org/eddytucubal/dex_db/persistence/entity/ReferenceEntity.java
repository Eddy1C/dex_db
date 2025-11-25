package org.eddytucubal.dex_db.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDate;

@Entity
@Table(name = "Referens")
@Data
public class ReferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_url;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private LocalDate date_url;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity user;
}
