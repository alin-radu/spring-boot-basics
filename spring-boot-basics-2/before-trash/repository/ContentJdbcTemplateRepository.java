package com.dev.spring_boot_basics_3.repository;

import com.dev.spring_boot_basics_3.model.Content;
import com.dev.spring_boot_basics_3.model.Status;
import com.dev.spring_boot_basics_3.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/*
 * JdbcTemplate: A Spring class that simplifies database operations using JDBC.
 * This instance is used for executing SQL queries.
 */

@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // getContent
    public Content getContent(int id) {
        String sql = "SELECT * FROM Content " +
                "WHERE id=?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
    }

    // getAllContent
    public List<Content> getAllContent() {
        String sql = "SELECT * FROM Content";

        return jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
    }

    // createContent
    public void createContent(String title, String desc, Status status, Type contentType, String URL) {
        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, URL) " +
                "VALUES (?, ?, ?, ?, NOW(), ?)";

        jdbcTemplate.update(sql, title, desc, status, contentType, URL);
    }

    // updateContent
    public void updateContent(int id, String title, String desc, Status status, Type contentType, String URL) {
        String sql = "UPDATE Content SET title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? " +
                "WHERE id=?";

        jdbcTemplate.update(sql, title, desc, status, contentType, URL, id);
    }

    // deleteContent
    public void deleteContent(int id) {
        String sql = "DELETE FROM Content " +
                "WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    // mapRow
    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Content(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("desc"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("content_type")),
                rs.getObject("date_created", LocalDateTime.class),
                rs.getObject("date_updated", LocalDateTime.class),
                rs.getString("url")
        );
    }
}