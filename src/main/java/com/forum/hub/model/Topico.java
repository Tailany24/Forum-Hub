package com.forum.hub.model;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String mensagem;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacao;

    @NotNull
    private String estado;

    @NotNull
    private String autor;

    @NotNull
    private String curso;

    // Getters e Setters
}

