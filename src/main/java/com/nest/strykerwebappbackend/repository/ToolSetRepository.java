package com.nest.strykerwebappbackend.repository;

import com.nest.strykerwebappbackend.entity.ToolSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolSetRepository extends JpaRepository<ToolSet,Long> {
    boolean existsByName(String name);

    @Query(value = "SELECT * FROM `tools` WHERE is_deleted=0",nativeQuery = true)
    List<ToolSet> findByDeletedFalse();

    @Query(value= " SELECT name FROM `category`",nativeQuery =true)
    public List<String> fetchCategory();
}
