package com.bt.dao;

import com.bt.domain.UserRole;

import java.util.List;

public interface UserRoleDao {
    public List<UserRole> getUserRoles();
    public UserRole getUserRoleById(int id);
    public int saveUserRole(UserRole u);
    public void persistUserRole(UserRole u);
    public UserRole updateUserRole(UserRole u, String newName);
    public UserRole mergeUserRole(UserRole u,String newName);
}
