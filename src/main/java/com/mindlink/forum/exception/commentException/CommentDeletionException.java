package com.mindlink.forum.exception.commentException;

public class CommentDeletionException extends RuntimeException {

    private Long commentId;

    public CommentDeletionException(Long commentId) {
        super("Failed to delete comment with ID: " + commentId);
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }
}
