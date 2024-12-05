CREATE SEQUENCE seq_note_id
    START WITH 1
    INCREMENT BY 1;
CREATE TABLE note
(
    ID   BIGINT DEFAULT nextval('seq_note_id'),
    TITLE VARCHAR(200) NOT NULL CHECK (LENGTH(TITLE) >= 3),
    CONTENT VARCHAR(2000) NOT NULL CHECK (LENGTH(TITLE) >= 3),
    CONSTRAINT pk_client_id PRIMARY KEY (ID)
);