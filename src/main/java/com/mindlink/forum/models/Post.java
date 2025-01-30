package com.mindlink.forum.models;

import com.mindlink.forum.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "fecha_borrado")
    private LocalDateTime fechaBorrado;

    @Column(name = "categoria")
    private String categoria;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy="post", cascade = CascadeType.ALL)
    private List<Comment> comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*@Version
    @Column(name = "version")
    private Long version;*/
}
