package clube.dm.dto;

public record AtualizarPreparadorOutputDTO(
        String id
) {
    public static AtualizarPreparadorOutputDTO output(String id) {
        return new AtualizarPreparadorOutputDTO(id);
    }
}
