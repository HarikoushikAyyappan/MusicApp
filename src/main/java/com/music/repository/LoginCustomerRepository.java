package com.music.repository;
import com.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginCustomerRepository extends JpaRepository<User,Integer> {
    @Query(nativeQuery = false,value = "SELECT c FROM User c WHERE c.userId=?1 AND c.password=?2")
    List<User> find(@Param("userId") int customerId, @Param("password") String password);

}
