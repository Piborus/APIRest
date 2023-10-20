package com.lampp.hire.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UrlDto(

        @NotEmpty
        @NotNull
        String alias,

        @NotEmpty
        @NotNull
        String urlOriginal,

        @NotEmpty
        @NotNull
        LocalDateTime responseTime


) {
}
