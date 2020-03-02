package com.project;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GetRequest request = Unirest.get("https://jsonplaceholder.typicode.com/comments");
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        JsonNode json = jsonResponse.getBody();
        List list = json.getArray().toList();
        List<Comment> commentList = new ArrayList<>();

        for (Object element : list) {
            JSONObject jsonObject = (JSONObject) element;
            int postId = jsonObject.getInt("postId");
            int id = jsonObject.getInt("id");
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");
            String body = jsonObject.getString("body");
            Comment myComment = new Comment(postId, id, name, email, body);
            commentList.add(myComment);
        }

        Scanner reader = new Scanner(System.in);
        System.out.println("Write number of ID:");
        int input = reader.nextInt();

        for(int i = 0; i < commentList.size(); i++) {
            if (commentList.get(i).getId() == input) {
                System.out.println("PostID: " + commentList.get(i).getPostID());
                System.out.println("ID: " + commentList.get(i).getId());
                System.out.println("Name: " + commentList.get(i).getName());
                System.out.println("Email: " + commentList.get(i).getEmail());
                System.out.println("Body: " + commentList.get(i).getBody());
            }
        }
    }
}
