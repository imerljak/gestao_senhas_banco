package br.imerljak.paripassu_senhas.app.senhas;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TipoSenha {
    NORMAL("N"),
    PREFERENCIAL("P");

    private final String prefixo;

    String formataSenha(Senha senha) {
        String senhaFormatada = prefixo + String.format("%4s", senha.getDigito());
        return senhaFormatada.replaceAll("\\s", "0");
    }
}
