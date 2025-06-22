package clube.dm.dto;

import clube.dm.entity.Preparador;

public record PesquisarPreparadorOutputDTO(
        String id,
        String nome,
        String area,
        Long CREF
) {
    public static PesquisarPreparadorOutputDTO output(Preparador preparador) {
        return new PesquisarPreparadorOutputDTO(
                preparador.getId(),
                preparador.getNome(),
                preparador.getArea(),
                preparador.getCREF()
        );
    }
}
