package clube.dm.service;

import clube.dm.dto.*;
import clube.dm.entity.Atleta;
import clube.dm.repository.AtletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtletaService {

    private final AtletaRepository atletaRepository;

    public AtletaService(AtletaRepository atletaRepository){
        this.atletaRepository = atletaRepository;
    }

    public CadastrarAtletaOutputDTO cadastrar(CadastrarAtletaInputDTO input) {
        Atleta atleta = Atleta.novoAtleta(
                input.nome(),
                input.descricaoLesao(),
                input.situacao(),
                input.camisa()
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
}

