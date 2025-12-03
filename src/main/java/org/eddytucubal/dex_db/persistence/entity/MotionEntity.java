package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movement")
    private Long idMovement;

    @Column(name = "date_time_movement", nullable = false)
    private LocalDateTime dateTimeMovement;

    @Column(name = "amount_movement", nullable = false)
    private double amountMovement;

    @Column(name = "trade_movement", length = 200)
    private String tradeMovement;

    @Column(name = "type_movement", length = 100, nullable = false)
    private String typeMovement; // ingreso / gasto / transferencia

    @Column(name = "description_movement", columnDefinition = "TEXT")
    private String descriptionMovement;

    @Column(name = "external_id_movement", length = 200)
    private String externalIdMovement;

    // CUENTA ORIGEN
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account_origin", nullable = false)
    @JsonIgnore
    private AccountEntity accountOrigin;

    // CUENTA DESTINO (null si no es transferencia)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account_destination")
    @JsonIgnore
    private AccountEntity accountDestination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category")
    @JsonIgnore
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account")
    @JsonIgnore
    private AccountEntity account;
}
