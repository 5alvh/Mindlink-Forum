package com.mindlink.forum.services.serviceImpl;

import com.mindlink.forum.models.Comment;
import com.mindlink.forum.models.DTO.CommentDtos.CommentCreateDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentGetDto;
import com.mindlink.forum.models.DTO.CommentDtos.CommentUpdateDto;
import com.mindlink.forum.repositories.CommentRepository;
import com.mindlink.forum.repositories.PostRepository;
import com.mindlink.forum.repositories.UserRepository;
import com.mindlink.forum.services.CommentService;
import com.mindlink.forum.utils.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public CommentGetDto createComment(CommentCreateDto comment) {
        Comment commentEntity = new Comment();
        commentEntity.setContent(comment.getContent());
        commentEntity.setPost(postRepository.findById(comment.getPostId()).get());
        commentEntity.setUser(userRepository.findById(comment.getUserId()).get());
        commentEntity.setFechaCreacion(LocalDateTime.now());
        return commentMapper.commentToCommentGetDto(commentRepository.save(commentEntity));
    }

    @Override
    public CommentGetDto getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return commentMapper.commentToCommentGetDto(comment.get());
        }
        return null;
    }

    @Override
    public List<CommentGetDto> getAllComments() {
        return commentMapper.commentsToCommentGetDtos(commentRepository.findAll());
    }

    @Override
    public CommentGetDto updateComment(Long id,CommentUpdateDto comment) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Comment commentEntity = commentOptional.get();
            commentEntity.setContent(comment.getContent());
            return commentMapper.commentToCommentGetDto(commentRepository.save(commentEntity));
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
