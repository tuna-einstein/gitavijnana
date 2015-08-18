package com.usp.gitavijnana.shared.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
@Entity
public class Sloka implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true) @Id
    private Key key;


    private int chapter;

    private int slokaNum;

    private String english = "";

    private String sanskrit = "";

    private String audioLink = "";

    private String sanskritToEnglish = "";
    
    private String englishTranslation = "";

    @Attribute(version = true)
    private Long version;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Sloka other = (Sloka) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getSlokaNum() {
        return slokaNum;
    }

    public void setSlokaNum(int slokaNum) {
        this.slokaNum = slokaNum;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSanskrit() {
        return sanskrit;
    }

    public void setSanskrit(String sanskrit) {
        this.sanskrit = sanskrit;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }

    public String getSanskritToEnglish() {
        return sanskritToEnglish;
    }

    public void setSanskritToEnglish(String sanskritToEnglish) {
        this.sanskritToEnglish = sanskritToEnglish;
    }

    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }
}
