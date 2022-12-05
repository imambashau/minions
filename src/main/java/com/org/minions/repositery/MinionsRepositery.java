package com.org.minions.repositery;

import com.org.minions.model.MinionsMode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinionsRepositery extends JpaRepository<MinionsMode,Integer> {
    MinionsMode findByCharacters(String  characters);
}
