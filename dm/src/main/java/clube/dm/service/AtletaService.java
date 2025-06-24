package clube.dm.service;

import clube.dm.dto.*;
import clube.dm.entity.Atleta;
import clube.dm.entity.Preparador;
import clube.dm.repository.AtletaRepository;
import clube.dm.repository.PreparadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtletaService {

    private final AtletaRepository atletaRepository;
    private final PreparadorRepository preparadorRepository;

    public AtletaService(AtletaRepository atletaRepository, PreparadorRepository preparadorRepository) {
        this.atletaRepository = atletaRepository;
        this.preparadorRepository = preparadorRepository;
    }

    public CadastrarAtletaOutputDTO cadastrar(CadastrarAtletaInputDTO input) {
        Preparador preparador = preparadorRepository.findById(input.idPreparador())
                .orElseThrow(() -> new RuntimeException("Preparador não encontrado"));

        Atleta atleta = Atleta.novoAtleta(
                input.nome(),
                input.descricaoLesao(),
                input.situacao(),
                input.camisa(),
                preparador
        );

        final var atletaSalvo = atletaRepository.save(atleta);

        return CadastrarAtletaOutputDTO.output(atletaSalvo.getId());
    }

    public AtualizarAtletaOutputDTO atualizar(String id, AtualizarAtletaInputDTO input) {
        final var atleta = atletaRepository.findById(id).orElseThrow();

        atleta.atualizar(
                input.descricaoLesao(),
                input.situacao()
        );

        final var atletaAtualizado = atletaRepository.save(atleta);

        return AtualizarAtletaOutputDTO.output(atletaAtualizado.getId());
    }

    public PesquisarAtletaOutputDTO pesquisar(String id) {
        final var atleta = atletaRepository.findById(id).orElseThrow();

        return PesquisarAtletaOutputDTO.output(atleta);
    }

    public List<ListarAtletasOutputDTO> listar() {
        final var atletas = atletaRepository.findAll();

        return atletas.stream()
                .map(ListarAtletasOutputDTO::output)
                .toList();
    }

    public void deletar(String id) {
        atletaRepository.deleteById(id);
    }

    public void trocarPreparador(String idAtleta, TrocarPreparadorDTO dto) {
        Atleta atleta = atletaRepository.findById(idAtleta)
                .orElseThrow(() -> new RuntimeException("Atleta não encontrado"));

        Preparador novoPreparador = preparadorRepository.findById(dto.idPreparador())
                .orElseThrow(() -> new RuntimeException("Preparador não encontrado"));

        atleta.setPreparador(novoPreparador);
        atletaRepository.save(atleta);
    }
}

