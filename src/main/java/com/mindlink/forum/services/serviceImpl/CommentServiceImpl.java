package com.mindlink.forum.services.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindlink.forum.models.Comment;
import com.mindlink.forum.models.DTO.CommentDtos.CommentCreateDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentGetDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentUpdateDto;
import com.mindlink.forum.models.Post;
import com.mindlink.forum.models.User;
import com.mindlink.forum.repositories.CommentRepository;
import com.mindlink.forum.repositories.PostRepository;
import com.mindlink.forum.repositories.UserRepository;
import com.mindlink.forum.services.CommentService;
import com.mindlink.forum.utils.CommentMapper;

import jakarta.transaction.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;
    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository,UserRepository userRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    @Transactional
    public CommentGetDto createComment(CommentCreateDto comment) {

        Post post = postRepository.findById(comment.getPostId())
                .orElseThrow(()-> new IllegalArgumentException("Post not found"));

        User user = userRepository.findById(comment.getUserId())
                .orElseThrow(()-> new IllegalArgumentException("User not found"));

        Comment commentEntity = new Comment();
        commentEntity.setContent(comment.getContent());
        commentEntity.setPost(post);
        commentEntity.setUser(user);
        commentEntity.setFechaCreacion(LocalDateTime.now());

        Comment savedComment = commentRepository.save(commentEntity);
        return commentMapper.commentToCommentGetDto(savedComment);
    }

    @Override
    public CommentGetDto getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(commentMapper::commentToCommentGetDto)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with ID: " + id));

    }

    @Override
    public List<CommentGetDto> getAllComments() {
        return commentMapper.commentsToCommentGetDto(commentRepository.findAll());
    }

    @Transactional
    @Override
    public CommentGetDto updateComment(Long id,CommentUpdateDto comment) {
        Comment commentOptional = commentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Comment not found"));

        commentOptional.setContent(comment.getContent());
        Comment updatedComment = commentRepository.save(commentOptional);

        return commentMapper.commentToCommentGetDto(updatedComment);
    }

    @Override
    @Transactional
    public void deleteComment(Long id) {
        if(!commentRepository.existsById(id)){
            throw new IllegalArgumentException("Comment not found");
        }
        commentRepository.deleteById(id);
    }
}
