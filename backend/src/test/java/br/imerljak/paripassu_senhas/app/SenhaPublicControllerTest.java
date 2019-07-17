package br.imerljak.paripassu_senhas.app;

import br.imerljak.paripassu_senhas.app.senhas.Senha;
import br.imerljak.paripassu_senhas.app.senhas.SenhaPublicController;
import br.imerljak.paripassu_senhas.app.senhas.SenhaService;
import br.imerljak.paripassu_senhas.app.senhas.TipoSenha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SenhaPublicController.class)
@RunWith(SpringRunner.class)
public class SenhaPublicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SenhaPublicController controller;

    @MockBean
    public SenhaService service;

    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    public void gerarSenhaNormal() throws Exception {
        final Senha senha = new Senha(1, TipoSenha.NORMAL);
        when(service.gerarSenha(TipoSenha.NORMAL)).thenReturn(senha);

        this.mockMvc.perform(post("/senhas/gerar-normal"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(senha.toString())));
    }

    @Test
    public void gerarSenhaPreferencial() throws Exception {
        final Senha senha = new Senha(1, TipoSenha.PREFERENCIAL);
        when(service.gerarSenha(TipoSenha.PREFERENCIAL)).thenReturn(senha);

        this.mockMvc.perform(post("/senhas/gerar-preferencial"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(senha.toString())));
    }
}