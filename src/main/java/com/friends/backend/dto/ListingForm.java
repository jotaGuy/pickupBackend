package com.friends.backend.dto;


import com.friends.backend.entity.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
@Getter
@Setter
public class ListingForm {

    @NotBlank(message = "Time is required")
    @NotNull
    private Location location;

    @NotBlank(message = "Time is required")
    @NotNull
    private int playersConfirmed;

    @NotBlank(message = "Time is required")
    @NotNull
    private boolean fullCourt;

    @NotBlank(message = "Time is required")
    @NotNull
    private int playersNeeded;

    @NotBlank(message = "Time is required")
    @NotNull
    private LocalDateTime createdTime;

    @NotBlank(message = "Time is required")
    @NotNull
    private LocalDateTime updatedTime;

}
