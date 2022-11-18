package com.music.repository;

import com.music.model.Admin;
import com.music.model.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Integer> {
    @Query(value = "SELECT c FROM SuperAdmin c WHERE c.superAdminId=?1 AND c.password=?2")
    List<SuperAdmin> searchSuper(@Param("adminId") int superAdminId, @Param("password") String password);
}
