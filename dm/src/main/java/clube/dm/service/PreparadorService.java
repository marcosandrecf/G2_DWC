package clube.dm.service;

import clube.dm.dto.*;
import clube.dm.entity.Preparador;
import clube.dm.repository.PreparadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreparadorService {

    private final PreparadorRepository preparadorRepository;

    public PreparadorService(PreparadorRepository preparadorRepository) {
        this.preparadorRepository = preparadorRepository;
    }

    public CadastrarPreparadorOutputDTO cadastrar(CadastrarPreparadorInputDTO input) {
        final var preparador = Preparador.novoPreparador(
                input.nome(),
                input.area(),
                input.CREF(),
                List.of()
        );

        final var salvo = preparadorRepository.save(preparador);

        return CadastrarPreparadorOutputDTO.output(salvo.getId());
    }

    public AtualizarPreparadorOutputDTO atualizar(String id, AtualizarPreparadorInputDTO input) {
        final var preparador = preparadorRepository.findById(id).orElseThrow();

        preparador.setArea(input.area());

        final var atualizado = preparadorRepository.save(preparador);

        return AtualizarPreparadorOutputDTO.output(atualizado.getId());
    }

    public PesquisarPreparadorOutputDTO pesquisar(String id) {
        final var preparador = preparadorRepository.findById(id).orElseThrow();
        return PesquisarPreparadorOutputDTO.output(preparador);
    }

    public List<ListarPreparadoresOutputDTO> listar() {
        return preparadorRepository.findAll()
                .stream()
                .map(ListarPreparadoresOutputDTO::output)
                .toList();
    }

    public void deletar(String id) {
        var preparador = preparadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preparador não encontrado"));

        if (preparador.getAtletas() != null && !preparador.getAtletas().isEmpty()) {
            throw new IllegalStateException("Não é possível deletar um preparador com atletas vinculados.");
        }

        preparadorRepository.deleteById(id);
    }
}
