package com.example.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosTopicoAtualizado(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao
) {

    public DadosTopicoAtualizado(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }
}