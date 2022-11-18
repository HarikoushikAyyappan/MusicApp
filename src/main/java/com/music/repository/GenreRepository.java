package com.music.repository;

import com.music.model.Genre;
import com.music.model.Song;
import com.music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {


}
