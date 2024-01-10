package org.dto;

import java.util.Arrays;

public class StudentDto {

    private String name;
    private String eng;
    private String[] lang;
    private String comment;
    private int age;

    public StudentDto() {
    }

    public StudentDto(String name, String eng, String[] lang, String comment, int age) {
        this.name = name;
        this.eng = eng;
        this.lang = lang;
        this.comment = comment;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String[] getLang() {
        return lang;
    }

    public void setLang(String[] lang) {
        this.lang = lang;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", eng='" + eng + '\'' +
                ", lang=" + Arrays.toString(lang) +
                ", comment='" + comment + '\'' +
                ", age=" + age +
                '}';
    }
}
