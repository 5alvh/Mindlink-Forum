package com.mindlink.forum.services.serviceImpl;

import com.mindlink.forum.models.DTO.LikesDtos.LikeCreateDto;
import com.mindlink.forum.models.DTO.LikesDtos.LikeGetDto;
import com.mindlink.forum.models.Like;
import com.mindlink.forum.repositories.LikeRepository;
import com.mindlink.forum.repositories.PostRepository;
import com.mindlink.forum.repositories.UserRepository;
import com.mindlink.forum.services.LikeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, PostRepository postRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @Override
    public LikeGetDto createLike(LikeCreateDto likeCreateDto) {
        return null;
    }

    @Override
    public LikeGetDto likePost(LikeCreateDto likeCreateDto) {
        if (!postRepository.existsById(likeCreateDto.getPostId())) {
            throw new IllegalArgumentException("Post not found");

        }
        if (!userRepository.existsById(likeCreateDto.getUserId())) {
            throw new IllegalArgumentException("User not found");
        }
        if (likeRepository.existsByPostIdAndUserId(likeCreateDto.getPostId(), likeCreateDto.getUserId())) {
            throw new IllegalArgumentException("Post already liked by this user");
        }

        Like like = new Like();
        like.setPost(postRepository.findById(likeCreateDto.getPostId()).get());
        like.setUser(userRepository.findById(likeCreateDto.getUserId()).get());
        like.setLikedAt(LocalDateTime.now());
        System.out.println("HOLAAAAAAAAX");
        Like savedLike = likeRepository.save(like);
        return new LikeGetDto(
                savedLike.getId(),
                savedLike.getLikedAt(),
                savedLike.getPost().getId(),
                savedLike.getUser().getId()
        );
    }

    @Transactional
    @Override
    public void unlikePost(Long postId, Long userId) {
        System.out.println("Attempting to unlike postId: " + postId + ", userId: " + userId);
        if (!likeRepository.existsByPostIdAndUserId(postId, userId)) {
            System.out.println("Like does not exist for postId: " + postId + ", userId: " + userId);
            throw new IllegalArgumentException("Like does not exist");
        }
        likeRepository.deleteByPostIdAndUserId(postId, userId);
        System.out.println("Successfully unliked postId: " + postId + ", userId: " + userId);
    }

    @Override
    public List<LikeGetDto> getLikesForPost(Long postId) {
        return likeRepository.findAll().stream()
                .filter(like -> like.getPost().getId().equals(postId))
                .map(like -> new LikeGetDto(
                        like.getId(),
                        like.getLikedAt(),
                        like.getPost().getId(),
                        like.getUser().getId()
                ))
                .collect(Collectors.toList());
    }
}

    
