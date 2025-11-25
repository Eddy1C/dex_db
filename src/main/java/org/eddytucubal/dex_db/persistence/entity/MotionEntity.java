package org.eddytucubal.dex_db.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Movements")
@Data
public class MotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_motion;
    @Column(nullable = false)
    private LocalDateTime date_time_motion;
    @Column(nullable = false)
    private double amount_motion;
    @Column(length = 200, nullable = false)
    private String trade_motion;
    @Column(length = 150, nullable = false)
    private String type_motion;
    @Column(length = 150, nullable = false)
    private String category_motion;
    @Column
    private String description_motion;
    @Column
    private String id_motion_api;

    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private AccountEntity account;

}
