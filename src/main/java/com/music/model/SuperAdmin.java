package com.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="superadmin")
public class SuperAdmin {
    @Id
    @Column(name="superAdminId")
    private int superAdminId;
    @Column(name="superAdminName")
    private String superAdminName;
    @Column(name="role")
    private String role;
    @Column(name="password")
    private String password;

    public int getSuperAdminId() {
        return superAdminId;
    }

    public void setSuperAdminId(int superAdminId) {
        this.superAdminId = superAdminId;
    }

    public String getSuperAdminName() {
        return superAdminName;
    }

    public void setSuperAdminName(String superAdminName) {
        this.superAdminName = superAdminName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
