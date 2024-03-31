package com.tradesphere.app.model.entity;

import com.tradesphere.app.constant.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idRole;

    @Enumerated(EnumType.STRING)
    private ERole roleName;

}
