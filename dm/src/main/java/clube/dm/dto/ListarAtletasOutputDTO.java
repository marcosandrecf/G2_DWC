package clube.dm.dto;

import clube.dm.entity.Atleta;

public record ListarAtletasOutputDTO(
        String id,
        String nome,
        int numCamisa
) {

    public static ListarAtletasOutputDTO output(Atleta atleta) {
        return new ListarAtletasOutputDTO(
                atleta.getId(),
                atleta.getNome(),
                atleta.getNumCamisa()
        );
    }
}

