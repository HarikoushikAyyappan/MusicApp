package com.music.repository;

import com.music.model.Duration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationRepository extends JpaRepository<Duration,Integer> {
}
