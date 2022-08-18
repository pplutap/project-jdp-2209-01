package com.kodilla.ecommercee.domain;

public class UserDTO {
    private long id;
    private String name;
    private String status;
    private long userKey;

    public UserDTO(long id, String name, String status, long userKey) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.userKey = userKey;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public long getUserKey() {
        return userKey;
    }
}
