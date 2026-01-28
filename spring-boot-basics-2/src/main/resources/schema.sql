CREATE TABLE IF NOT EXISTS Content
(
    id           INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    description  TEXT,
    status       VARCHAR(20)  NOT NULL,
    content_type VARCHAR(50)  NOT NULL,
    date_created TIMESTAMP    NOT NULL,
    date_updated TIMESTAMP,
    url          VARCHAR(255)
);


-- INSERT INTO Content (title, description, status, content_type, date_created)
-- VALUES ('My Blog Post, from Spring Data JDBC', 'My First blog post executed from Spring Data JDBC', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);
