package com.lampp.hire.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "urls")
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String urlOriginal;
    private LocalDateTime reponseTime;

}
