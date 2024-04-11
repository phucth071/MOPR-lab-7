package vn.hcmute.lab7.models;

import java.io.Serializable;

public class NotesModel implements Serializable {
    private int id;
    private String content;

    public NotesModel() {
    }

    public NotesModel(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public NotesModel(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
