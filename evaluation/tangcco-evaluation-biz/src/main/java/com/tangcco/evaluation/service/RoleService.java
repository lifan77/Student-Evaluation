package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.pojo.Role;

public interface RoleService {
    Role findRole(String roleId, String password);
}
