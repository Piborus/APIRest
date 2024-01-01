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
@Entity(name = "hire")
@Table(name = "hire")
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shortUrl")
    private String shortUrl;

    @Column(name = "originalUrl")
    private String originalUrl;

    @Column(name = "responseTime")
    private LocalDateTime reponseTime;

    @Column(name= "ativo")
    private Boolean ativo;

    public void excluir() {
        this.ativo = false;
    }
}
