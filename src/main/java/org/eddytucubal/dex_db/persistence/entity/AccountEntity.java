package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "name_account", length = 150, nullable = false)
    private String nameAccount;

    @Column(name = "balance_account", nullable = false)
    private double balanceAccount;

    @Column(name = "date_update_account", nullable = false)
    private LocalDate dateUpdateAccount;

    @Column(name = "bank_account", length = 200, nullable = false)
    private String bankAccount;

    @Column(name = "type_account", length = 200, nullable = false)
    private String typeAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    @JsonIgnore
    private CategoryEntity category;
}

