package com.music.repository;
import com.music.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "SELECT c FROM Admin c WHERE c.adminId=?1 AND c.password=?2")
    List<Admin> search(@Param("adminId") int adminId, @Param("password") String password);
}
