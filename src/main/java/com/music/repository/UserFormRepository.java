package com.music.repository;

import com.music.model.UserForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFormRepository extends JpaRepository<UserForm,Integer> {
}
