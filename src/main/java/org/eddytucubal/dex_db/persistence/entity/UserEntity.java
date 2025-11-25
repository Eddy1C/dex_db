package org.eddytucubal.dex_db.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    @Column(length = 150, nullable = false)
    private String name_user;
    @Column(length = 150, nullable = false)
    private String last_name_user;
    @Column(length = 150, unique = true, nullable = false)
    private String email_user;
    @Column(length = 200, unique = true, nullable = false)
    private String password_user;
    @Column(nullable = false)
    private LocalDate date_income_user;
    @Column(nullable = false)
    private LocalDate birthdate_user;
    @Column(length = 50,  nullable = false)
    private String genre_user;
    @Column(length =25, nullable = false)
    private String key_user;

    @OneToMany(mappedBy = "user")
    private List<AccountEntity> account;
}
