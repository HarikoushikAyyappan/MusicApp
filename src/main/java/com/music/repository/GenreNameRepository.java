package com.music.repository;

import com.music.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreNameRepository extends JpaRepository<Genre,Integer> {
    @Query(nativeQuery = false,value = "SELECT c FROM Genre c WHERE c.genreName=?1")
    Genre getGenreByName(@Param("genreName") String genreName);
}
