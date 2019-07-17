package br.imerljak.paripassu_senhas.app.senhas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerente/senhas")
@RequiredArgsConstructor
public class SenhaGerenteController {

    private final SenhaService senhaService;

    @GetMapping
    public Senha chamarProximaSenha() {
        return senhaService.proximaSenha();
    }

    @PostMapping
    public void reiniciarContagem() {
        senhaService.reiniciarContagem();
    }

}
