package br.imerljak.paripassu_senhas.app.senhas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/senhas")
@RequiredArgsConstructor
public class SenhaPublicController {

    private final SenhaService senhaService;

    @PostMapping("/gerar-normal")
    public Senha gerarSenhaNormal() {
        return senhaService.gerarSenha(TipoSenha.NORMAL);
    }

    @PostMapping("/gerar-preferencial")
    public Senha gerarSenhaPreferencial() {
        return senhaService.gerarSenha(TipoSenha.PREFERENCIAL);
    }

}
