package clube.dm.dto;

public record CadastrarPreparadorOutputDTO(
        String id
) {
    public static CadastrarPreparadorOutputDTO output(String id) {
        return new CadastrarPreparadorOutputDTO(id);
    }
}
