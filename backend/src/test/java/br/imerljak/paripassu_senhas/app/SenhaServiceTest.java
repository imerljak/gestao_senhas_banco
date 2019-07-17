package br.imerljak.paripassu_senhas.app;

import br.imerljak.paripassu_senhas.app.senhas.Senha;
import br.imerljak.paripassu_senhas.app.senhas.SenhaService;
import br.imerljak.paripassu_senhas.app.senhas.TipoSenha;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class SenhaServiceTest {

    @Mock
    private SenhaService service;

    @Test
    public void gerarSenha() {
        final Senha senhaNormal = service.gerarSenha(TipoSenha.NORMAL);
        final Senha senhaPrefefencial = service.gerarSenha(TipoSenha.NORMAL);

        assertNotNull(senhaNormal);
        assertNotNull(senhaPrefefencial);

        assertEquals((Integer) 1, senhaNormal.getDigito());
        assertEquals((Integer) 2, senhaPrefefencial.getDigito());
    }

    @Test
    public void proximaSenha() {
        final Senha primeiraSenha = service.gerarSenha(TipoSenha.NORMAL);
        final Senha segundaSenha = service.gerarSenha(TipoSenha.NORMAL);
        final Senha terceiraSenha = service.gerarSenha(TipoSenha.NORMAL);

        assertSame(primeiraSenha, service.proximaSenha());
        assertSame(segundaSenha, service.proximaSenha());
        assertSame(terceiraSenha, service.proximaSenha());
    }

    @Test
    public void proximaSenhaPreferencial() {
        final Senha primeiraSenha = service.gerarSenha(TipoSenha.NORMAL);
        final Senha segundaSenha = service.gerarSenha(TipoSenha.NORMAL);
        final Senha senhaPreferencial = service.gerarSenha(TipoSenha.PREFERENCIAL);

        assertSame(senhaPreferencial, service.proximaSenha());
        assertSame(primeiraSenha, service.proximaSenha());
        assertSame(segundaSenha, service.proximaSenha());
    }

    @Test
    public void reiniciarContagem() {
        final Senha senhaPreferencial = service.gerarSenha(TipoSenha.PREFERENCIAL);
        final Senha senhaNormal = service.gerarSenha(TipoSenha.NORMAL);
        service.reiniciarContagem();
        final Senha senhaNormalReiniciada = service.gerarSenha(TipoSenha.NORMAL);

        assertEquals((Integer) 1, senhaPreferencial.getDigito());
        assertEquals((Integer) 2, senhaNormal.getDigito());
        assertEquals((Integer) 1, senhaNormalReiniciada.getDigito());
    }


    @Test
    public void proximaSenhaMantemOrdemAposReiniciarContagem() {
        final Senha senhaNormal = service.gerarSenha(TipoSenha.NORMAL);
        final Senha senhaPreferencial = service.gerarSenha(TipoSenha.PREFERENCIAL);
        service.reiniciarContagem();
        final Senha novaSenhaNormal = service.gerarSenha(TipoSenha.NORMAL);
        final Senha novaSenhaPreferencial = service.gerarSenha(TipoSenha.PREFERENCIAL);

        assertSame(senhaPreferencial, service.proximaSenha());
        assertSame(novaSenhaPreferencial, service.proximaSenha());
        assertSame(senhaNormal, service.proximaSenha());
        assertSame(novaSenhaNormal, service.proximaSenha());
    }
}