package br.imerljak.paripassu_senhas.app;

import br.imerljak.paripassu_senhas.app.senhas.Senha;
import br.imerljak.paripassu_senhas.app.senhas.SenhaGerenteController;
import br.imerljak.paripassu_senhas.app.senhas.SenhaService;
import br.imerljak.paripassu_senhas.app.senhas.TipoSenha;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SenhaGerenteController.class)
@RunWith(SpringRunner.class)
public class SenhaGerenteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SenhaGerenteController controller;

    @MockBean
    private SenhaService service;

    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    public void chamarProximaSenha() throws Exception {
        final Senha senha = new Senha(1, TipoSenha.NORMAL);
        when(service.proximaSenha()).thenReturn(senha);
        mockMvc.perform(get("/gerente/senhas"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.containsString(senha.toString())));
    }

    @Test
    public void reiniciarContagem() throws Exception {
        mockMvc.perform(post("/gerente/senhas"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}