package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name_user", length = 150, nullable = false)
    private String nameUser;

    @Column(name = "last_name_user", length = 150, nullable = false)
    private String lastNameUser;

    @Column(name = "email_user", length = 150, nullable = false, unique = true)
    private String emailUser;

    @Column(name = "password_user", length = 200, nullable = false)
    private String passwordUser;

    @Column(name = "date_income_user", nullable = false)
    private LocalDate dateIncomeUser;

    @Column(name = "birthdate_user", nullable = false)
    private LocalDate birthdateUser;

    @Column(name = "genre_user", length = 50, nullable = false)
    private String genreUser;

    @Column(name = "key_user", length = 25, nullable = false)
    private String keyUser;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<AccountEntity> accounts;
}
