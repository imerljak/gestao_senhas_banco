package br.imerljak.paripassu_senhas.app.senhas;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@RequiredArgsConstructor
public class Senha {

    @NonNull
    private Integer digito;

    @NonNull
    private TipoSenha tipo;

    private boolean chamada = false;

    private Date dataChamada;

    private Date dataCriacao = new Date();

    @JsonValue
    @Override
    public String toString() {
        return tipo.formataSenha(this);
    }

    public void chamar() {
        this.chamada = true;
        this.dataChamada = new Date();
    }
}
