package com.github.jander99.micrometer;

import lombok.Data;

@Data
public class Comment {

    private int postId;

    private int id;

    private String name;

    private String email;

    private String body;
}
