package com.mindlink.forum.exception.postException;

public class PostUpdateException extends RuntimeException {
    private Long postId;

    public PostUpdateException(Long postId) {
        super("Post with ID: " + postId + " not found for update.");
        this.postId = postId;
    }

    public Long getPostId() {
        return postId;
    }
}
