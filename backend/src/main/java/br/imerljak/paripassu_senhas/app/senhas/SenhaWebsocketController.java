package br.imerljak.paripassu_senhas.app.senhas;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SenhaWebsocketController {

    private final SimpMessagingTemplate template;

    @SendTo("/topic/senhaAtual")
    @EventListener(SenhaChamada.class)
    public void senhaAtualTopic(SenhaChamada evento) {
        System.out.println("evento = " + evento);
        template.convertAndSend("/topic/senhaAtual", evento.getSenha().toString());
    }

}
