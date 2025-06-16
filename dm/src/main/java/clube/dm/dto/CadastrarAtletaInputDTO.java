package clube.dm.dto;

public record CadastrarAtletaInputDTO(
        String nome,
        String descricaoLesao,
        String situacao,
        int camisa
) {}
