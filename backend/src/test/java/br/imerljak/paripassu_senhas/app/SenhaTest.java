package br.imerljak.paripassu_senhas.app;

import br.imerljak.paripassu_senhas.app.senhas.Senha;
import br.imerljak.paripassu_senhas.app.senhas.TipoSenha;
import org.junit.Test;

import static org.junit.Assert.*;

public class SenhaTest {

    @Test
    public void test_toString() {
        final Senha senhaNormal = new Senha(1, TipoSenha.NORMAL);
        final Senha senhaPreferencial = new Senha(1, TipoSenha.PREFERENCIAL);

        assertEquals("N0001", senhaNormal.toString());
        assertEquals("P0001", senhaPreferencial.toString());
    }

    @Test
    public void test_chamar() {
        final Senha senha = new Senha(0, TipoSenha.NORMAL);

        assertFalse(senha.isChamada());
        senha.chamar();
        assertTrue(senha.isChamada());
        assertNotNull(senha.getDataChamada());
    }
}