package com.example.demodao;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Task {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty content;
    private SimpleStringProperty lvl_education;
    private SimpleStringProperty field_of_study;
    private SimpleStringProperty gender;

    public Task(int id, String name, String content, String lvl_education, String field_of_study, String gender) {
        this.id= new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.content = new SimpleStringProperty(content);
        this.lvl_education = new SimpleStringProperty(lvl_education);
        this.field_of_study =  new SimpleStringProperty(field_of_study);
        this.gender = new SimpleStringProperty(gender);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getContent() {
        return content.get();
    }

    public SimpleStringProperty contentProperty() {
        return content;
    }

    public void setContent(String content) {
        this.content.set(content);
    }

    public String getLvl_education() {
        return lvl_education.get();
    }

    public SimpleStringProperty lvl_educationProperty() {
        return lvl_education;
    }

    public void setLvl_education(String lvl_education) {
        this.lvl_education.set(lvl_education);
    }

    public String getField_of_study() {
        return field_of_study.get();
    }

    public SimpleStringProperty field_of_studyProperty() {
        return field_of_study;
    }

    public void setField_of_study(String field_of_study) {
        this.field_of_study.set(field_of_study);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }
}
