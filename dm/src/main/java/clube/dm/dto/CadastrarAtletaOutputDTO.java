package clube.dm.dto;

public record CadastrarAtletaOutputDTO(
        String id
) {
    public static CadastrarAtletaOutputDTO output(String id){
        return new CadastrarAtletaOutputDTO(id);
    }
}
