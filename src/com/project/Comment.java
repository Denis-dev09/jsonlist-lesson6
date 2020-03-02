package com.project;

public class Comment {
    private int postID;
    private int id;
    private String name;
    private String email;
    private String body;

    public Comment(int postID, int id, String name, String email, String body) {
        this.postID = postID;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostID() {
        return postID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public void printAll() {
        System.out.println("ID" + this.id);
    }




}
