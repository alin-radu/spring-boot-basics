package com.dev.spring_boot_basics_3.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value="tbl_content")
public record Content(
        @Id
        Integer id,

        @NotBlank
        @Column("str_title")
        String title,

        @NotBlank
        String description,

        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}
