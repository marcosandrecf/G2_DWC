package clube.dm.dto;

import clube.dm.entity.Preparador;

public record ListarPreparadoresOutputDTO(
        String id,
        String nome,
        Long CREF,
        String area
) {
    public static ListarPreparadoresOutputDTO output(Preparador preparador) {
        return new ListarPreparadoresOutputDTO(
                preparador.getId(),
                preparador.getNome(),
                preparador.getCREF(),
                preparador.getArea()
        );
    }
}
