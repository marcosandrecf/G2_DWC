package clube.dm.dto;

public record AtualizarAtletaOutputDTO(
        String id
) {

    public static AtualizarAtletaOutputDTO output(String id) {
        return new AtualizarAtletaOutputDTO(id);
    }
}
