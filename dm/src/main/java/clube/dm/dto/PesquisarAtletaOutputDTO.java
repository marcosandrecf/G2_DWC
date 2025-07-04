package clube.dm.dto;

import clube.dm.entity.Atleta;

public record PesquisarAtletaOutputDTO(
   String id,
   String nome,
   String descricaoLesao,
   String situacao,
   int numCamisa,
   String nomePreparador
) {

    public static PesquisarAtletaOutputDTO output(Atleta atleta) {
        return new PesquisarAtletaOutputDTO(
                atleta.getId(),
                atleta.getNome(),
                atleta.getDescricaoLesao(),
                atleta.getSituacao(),
                atleta.getNumCamisa(),
                atleta.getPreparador() != null ? atleta.getPreparador().getNome() : null
        );
    }
}
