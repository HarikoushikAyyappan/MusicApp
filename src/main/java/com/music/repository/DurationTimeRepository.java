package com.music.repository;

import com.music.model.Duration;
import com.music.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationTimeRepository extends JpaRepository<Duration,Integer> {
    @Query(nativeQuery = false,value = "SELECT c FROM Duration c WHERE c.timeDuration=?1")
    Duration getDurationByTime(@Param("timeDuration") float timeDuration);
}
