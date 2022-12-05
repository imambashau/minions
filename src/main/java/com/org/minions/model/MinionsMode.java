package com.org.minions.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MinionsMode {
    @Id
    private int id;
    private String characters;
    private int perMarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public int getPerMarks() {
        return perMarks;
    }

    public void setPerMarks(int perMarks) {
        this.perMarks = perMarks;
    }
}
