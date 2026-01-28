package com.dev.spring_boot_basics_3.repository;

import com.dev.spring_boot_basics_3.model.Content;
import com.dev.spring_boot_basics_3.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// not required because it is an interface of the base repositories ListCrudRepository
public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    // building custom query using query derivation
    List<Content> findAllByTitleContains(String keyword);

    // building custom query using @query annotation
    @Query("""
            SELECT * FROM content
            WHERE status = :status
            """)
    List<Content> findAllByStatus(@Param("status") Status status);
}
