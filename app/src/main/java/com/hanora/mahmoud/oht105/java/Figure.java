package com.hanora.mahmoud.oht105.java;

/**
 * Created by Muhammad on 6/14/2016.
 */
public class Figure {
    private int id;
    private String name;
    private String content;
    private String fromDate;
    private String toDate;
    private String frontNote;
    private String brief;
    private String image;

    public Figure() {
    }

    public Figure(int id, String name, String content, String fromDate, String toDate, String frontNote, String brief, String image) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.frontNote = frontNote;
        this.brief = brief;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFrontNote() {
        return frontNote;
    }

    public void setFrontNote(String frontNote) {
        this.frontNote = frontNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
