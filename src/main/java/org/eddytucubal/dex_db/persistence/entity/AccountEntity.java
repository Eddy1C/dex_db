package org.eddytucubal.dex_db.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Accounts")
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_account;
    @Column(length = 150, nullable = false)
    private String name_account;
    @Column(nullable = false)
    private double balance_account;
    @Column(nullable = false)
    private LocalDate date_update_account;
    @Column(length = 200, nullable = false)
    private String banck_account;
    @Column(length = 200, nullable = false)
    private String type_account;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity user;
}

