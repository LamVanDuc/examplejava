package com.movie.t2108a.model;

public class Netflix {


    private long id;
    private String title;
    private String category;
    private String actor;
    private String language;
    private String publishingYear;
    private String publishingCompany;
    private String time;


    public Netflix(long id, String title, String category, String actor, String language, String publishingYear, String publishingCompany, String time) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.actor = actor;
        this.language = language;
        this.publishingYear = publishingYear;
        this.publishingCompany = publishingCompany;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String display(){
        System.out.printf("id: %-5d | %-30s | time: %sp",getId(),getTitle(), getTime());
        return "";
    }
}
