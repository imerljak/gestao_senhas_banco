package br.imerljak.paripassu_senhas.app.senhas;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class SenhaService {

    private final ApplicationEventPublisher eventPublisher;

    private AtomicInteger atomicInteger = new AtomicInteger();
    private List<Senha> senhas = new LinkedList<>();

    private static Predicate<Senha> senhaNaoChamada = s -> !s.isChamada();
    private static Comparator<Senha> ordenaPorTipoEDataCriacao =
            Comparator.comparing(Senha::getTipo).reversed()
                    .thenComparing(Senha::getDataCriacao);

    public Senha gerarSenha(TipoSenha tipoSenha) {
        final Senha novaSenha = new Senha(atomicInteger.incrementAndGet(), tipoSenha);
        senhas.add(novaSenha);

        return novaSenha;
    }

    public Senha proximaSenha() {
        final Senha proximaSenha = senhas.parallelStream()
                .filter(senhaNaoChamada)
                .min(ordenaPorTipoEDataCriacao)
                .orElse(null);

        if (proximaSenha != null) {
            proximaSenha.chamar();
            eventPublisher.publishEvent(new SenhaChamada(proximaSenha));
        }

        return proximaSenha;
    }

    public void reiniciarContagem() {
        atomicInteger.set(0);
    }

}
