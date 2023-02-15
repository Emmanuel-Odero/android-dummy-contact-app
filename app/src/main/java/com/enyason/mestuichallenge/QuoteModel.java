package com.enyason.mestuichallenge;

import com.google.gson.JsonObject;

public class QuoteModel {

    private final String id;
    private final String author;
    private final String dateAdded;
    private final String content;
    private String[] tags;

    public QuoteModel(JsonObject jsonObject) {
        this.id = jsonObject.get("_id").getAsString();
        this.author = jsonObject.get("author").getAsString();
        this.dateAdded = jsonObject.get("dateAdded").getAsString();
        this.content = jsonObject.get("content").getAsString();
//        this.tags =  jsonObject.getJSONArray("author");;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getContent() {
        return content;
    }

    public String[] getTags() {
        return tags;
    }

}
