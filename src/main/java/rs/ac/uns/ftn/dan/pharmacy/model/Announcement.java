package rs.ac.uns.ftn.dan.pharmacy.model;

import java.sql.Timestamp;

public class Announcement {
    private Long id;
    private String name;
    private String content;
    private Timestamp timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Announcement(Long id, String name, String content, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Announcement() {
    }
}
