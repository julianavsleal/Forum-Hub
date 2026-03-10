package com.example.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {

    public DadosListagemTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome()
        );
    }
}