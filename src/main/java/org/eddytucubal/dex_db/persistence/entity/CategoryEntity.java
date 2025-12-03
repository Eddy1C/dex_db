package org.eddytucubal.dex_db.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "name_category", length = 150, nullable = false)
    private String nameCategory;

    @Column(name = "description_category", length = 300)
    private String descriptionCategory;

    @Column(name = "type_category", length = 50, nullable = false)
    private String typeCategory; // INCOME / EXPENSE

    // Si es NULL → es global
    // Si tiene User → es propia del usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UserEntity user;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MotionEntity> movements;
}