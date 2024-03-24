package com.tradesphere.app.model.entity;

import com.tradesphere.app.constant.EGender;
import com.tradesphere.app.constant.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mst_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private ERole role;

    @Column(nullable = false)
    private EGender gender;

    private Boolean deleted = Boolean.FALSE;
}
