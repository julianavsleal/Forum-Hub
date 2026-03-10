package com.example.forumhub.controller;

import com.example.forumhub.domain.usuario.DadosAutenticacao;
import com.example.forumhub.domain.usuario.DadosCadastroUsuario;
import com.example.forumhub.domain.usuario.Usuario;
import com.example.forumhub.domain.usuario.UsuarioRepository;
import com.example.forumhub.infra.security.DadosTokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.forumhub.infra.security.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        // Verificar se o email já existe
        var usuarioExistente = usuarioRepository.findByLogin(dados.email());
        if (usuarioExistente != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado");
        }

        // Criptografar a senha
        var senhaCriptografada = passwordEncoder.encode(dados.senha());

        // Criar novo usuário
        var novoUsuario = new Usuario();
        novoUsuario.setNome(dados.nome());
        novoUsuario.setLogin(dados.email());
        novoUsuario.setSenha(senhaCriptografada);

        usuarioRepository.save(novoUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso");
    }
}