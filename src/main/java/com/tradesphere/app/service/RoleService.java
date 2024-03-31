package com.tradesphere.app.service;

import com.tradesphere.app.constant.ERole;
import com.tradesphere.app.model.entity.Role;

public interface RoleService {
    Role getOrSave(ERole role);
}
