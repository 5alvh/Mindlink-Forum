package com.mindlink.forum.services.serviceImpl;

import com.mindlink.forum.models.DTO.PostDtos.PostCreateDto;
import com.mindlink.forum.models.DTO.PostDtos.PostGetDto;
import com.mindlink.forum.models.DTO.PostDtos.PostUpdateDto;
import com.mindlink.forum.models.Post;
import com.mindlink.forum.models.User;
import com.mindlink.forum.repositories.PostRepository;
import com.mindlink.forum.repositories.UserRepository;
import com.mindlink.forum.services.PostService;
import com.mindlink.forum.utils.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    UserRepository userRepository;
    @Autowired
    PostMapper postMapper;
    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostGetDto createPost(PostCreateDto post) {

        User user = userRepository.findById(post.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + post.getUserId()));

        Post pst = new Post();
        pst.setTitle(post.getTitle());
        pst.setContent(post.getContent());
        pst.setFechaCreacion(LocalDateTime.now());
        pst.setCategoria(post.getCategoria());
        try {
            pst.setImage(post.getImage().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pst.setUser(user);
        return postMapper.postToPostGetDto(postRepository.save(pst));
    }

    @Override
    public PostGetDto updatePost(Long postId, PostUpdateDto post) {
        Optional<Post> postToUpdateOpt = postRepository.findById(postId);
        if(postToUpdateOpt.isPresent()){
            Post postToUpdate = postToUpdateOpt.get();
            postToUpdate.setTitle(post.getTitle());
            postToUpdate.setFechaActualizacion(LocalDateTime.now());
            postToUpdate.setContent(post.getContent());
            postToUpdate.setCategoria(post.getCategoria());
            return postMapper.postToPostGetDto(postRepository.save(postToUpdate));
        }
        return null;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostGetDto> getAllPosts() {

        return postMapper.postsToPostsGetDto(postRepository.findAll());
    }

    @Override
    public PostGetDto getPostById(Long postId) {
        return postMapper.postToPostGetDto(postRepository.findById(postId).get());
    }
}
