package clube.dm.controller;

import clube.dm.dto.*;
import clube.dm.service.AtletaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atletas")
@Tag(name = "Atleta", description = "Gerencia os Atletas")
public class AtletaController {

    private final AtletaService atletaService;

    public AtletaController(AtletaService atletaService) {
        this.atletaService = atletaService;
    }

    //CRUD

    @PostMapping //ENDPOINT CADASTRO
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar Atleta")
    @ApiResponse(responseCode = "201", description = "Atleta Cadastrado")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<CadastrarAtletaOutputDTO> cadastrar(@RequestBody CadastrarAtletaInputDTO input) {
        CadastrarAtletaOutputDTO output = atletaService.cadastrar(input);
        return ResponseEntity.created(URI.create("/atletas/" + output.id())).body(output);
    }

    @PutMapping("/{id}") //ENDPOINT ATUALIZAÇÃO
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar Atleta")
    @ApiResponse(responseCode = "201", description = "Atleta Atualizado")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Atleta não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<AtualizarAtletaOutputDTO> atualizar(@PathVariable("id") String id, @RequestBody AtualizarAtletaInputDTO input) {
        AtualizarAtletaOutputDTO output = atletaService.atualizar(id, input);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/{id}") //ENDPOINT BUSCA/PESQUISA UNICA
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Pesquisar Atleta")
    @ApiResponse(responseCode = "201", description = "Atleta Consultado")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Atleta não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<PesquisarAtletaOutputDTO> pesquisar(@PathVariable("id") String id) {
        PesquisarAtletaOutputDTO output = atletaService.pesquisar(id);
        return ResponseEntity.ok(output);
    }

    @GetMapping //ENDPOINT BUSCA/PESQUISA GERAL
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar Atletas")
    @ApiResponse(responseCode = "201", description = "Atletas Listados")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Atleta não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<List<ListarAtletasOutputDTO>> listar() {
        List<ListarAtletasOutputDTO> output = atletaService.listar();
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}") //ENDPOINT DELEÇÃO
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Atleta")
    @ApiResponse(responseCode = "201", description = "Atleta Excluido")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Atleta não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        atletaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
