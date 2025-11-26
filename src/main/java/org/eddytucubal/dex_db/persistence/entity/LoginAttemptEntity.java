package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "login_attempts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginAttemptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attempt")
    private Long idAttempt;

    @Column(name = "attempt_date_time", nullable = false)
    private LocalDateTime attemptDateTime;

    @Column(name = "successful", nullable = false)
    private boolean successful;

    @Column(name = "reason", length = 150)
    private String reason;  // Ej: PASSWORD_INCORRECT, TOKEN_INVALID, etc.

    @Column(name = "ip_address", length = 100)
    private String ipAddress;

    @Column(name = "user_agent", length = 300)
    private String userAgent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private UserEntity user;
}
