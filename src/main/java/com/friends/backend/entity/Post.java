package com.friends.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person user;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "num_players")
    private int numberOfPlayers;

    @Column(name = "full_court")
    private boolean fullCourt;

    @Column(name = "players_needed")
    private int playersNeeded;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

}

