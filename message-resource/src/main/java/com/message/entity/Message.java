package com.message.entity;

/**
 * Created by user01 on 3/10/17.
 */
public class Message {

    public Message(String personId, String text, Type type) {
        this.personId = personId;
        this.text = text;
        this.type = type;
    }

    private String id;
    private String personId;
    private String text;
    private Type type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        POLITICAL, MASS_MEDIA, LOCAL_NEWS, PUBLIC_EVENT, WITNESS_GLOBAL_NEWS;
    }
}
