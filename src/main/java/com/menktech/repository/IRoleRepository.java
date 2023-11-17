package com.menktech.repository;

import com.menktech.entity.Role;
import com.menktech.permissions.PermissionEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByName (PermissionEnum name);

}
