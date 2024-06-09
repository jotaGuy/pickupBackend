package com.friends.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationName;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @OneToOne(mappedBy = "location")
    private Post currentLocation;

}

