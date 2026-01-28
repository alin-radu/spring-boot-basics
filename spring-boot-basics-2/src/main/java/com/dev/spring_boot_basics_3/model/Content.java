package com.dev.spring_boot_basics_3.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

// optional, required if needs another name for table
@Table(value="content")
public record Content(
        @Id
        Integer id,

        @NotBlank
//        optional, required if needs another name for column
        @Column("title")
        String title,

        @NotBlank
        String description,

        Status status,
        @Column("content_type")
        Type contentType,
        @Column("date_created")
        LocalDateTime dateCreated,
        @Column("date_updated")
        LocalDateTime dateUpdated,
        String url
) {
}
