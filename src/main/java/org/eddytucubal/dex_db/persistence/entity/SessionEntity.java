package org.eddytucubal.dex_db.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Sessions")
@Data
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_session;
    @Column (length = 150)
    private String device_sesion;
    @Column(length = 150)
    private String operating_system_session;
    @Column(length = 50, nullable = false)
    private String active_session;
    @Column(length = 150, nullable = false)
    private String ip_device_session;
    @Column(length = 200, nullable = false)
    private String token_session;
    @Column(nullable = false)
    private LocalDateTime start_date_time_session;
    @Column(nullable = false)
    private LocalDateTime last_date_time_session;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity user;
}
