package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session")
    private Long idSession;

    // Dispositivo desde donde inició sesión
    @Column(name = "device_session", length = 150)
    private String deviceSession;

    // Sistema operativo del dispositivo
    @Column(name = "operating_system_session", length = 150)
    private String operatingSystemSession;

    // IP del dispositivo
    @Column(name = "ip_device_session", length = 150, nullable = false)
    private String ipDeviceSession;

    // Token único de sesión (no el JWT, este es interno, como identificador)
    @Column(name = "token_session", length = 200, nullable = false, unique = true)
    private String tokenSession;

    // True = activa | False = cerrada
    @Column(name = "active_session", nullable = false)
    private boolean activeSession;

    // Fecha y hora en que inició sesión
    @Column(name = "start_date_time_session", nullable = false)
    private LocalDateTime startDateTimeSession;

    // Última interacción del usuario
    @Column(name = "last_date_time_session", nullable = false)
    private LocalDateTime lastDateTimeSession;

    // Opcional: fecha de expiración automática de la sesión
    @Column(name = "expiration_date_time_session")
    private LocalDateTime expirationDateTimeSession;

    // Tipo de sesión (WEB, ANDROID, IOS, DESKTOP, API…)
    @Column(name = "session_platform", length = 100)
    private String sessionPlatform;

    // Relación con el usuario dueño de la sesión
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity user;

}