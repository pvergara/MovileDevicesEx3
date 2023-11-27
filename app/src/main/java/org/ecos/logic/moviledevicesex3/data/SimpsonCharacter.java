package org.ecos.logic.moviledevicesex3.data;

import java.io.Serializable;

public class SimpsonCharacter implements Serializable {
    private final int characterId;
    private final String name;
    private final String fullName;
    private final int age;
    private final boolean isFemale;
    private final String nationality;
    private final String description;
    private final int imageResourceId;

    public SimpsonCharacter(int characterId, String name, String fullName, int age, boolean isFemale, String nationality, String description, int imageResourceId) {
        this.characterId = characterId;
        this.name = name;
        this.fullName = fullName;
        this.age = age;
        this.isFemale = isFemale;
        this.nationality = nationality;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
