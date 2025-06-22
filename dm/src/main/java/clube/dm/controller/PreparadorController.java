package clube.dm.controller;

import clube.dm.dto.*;
import clube.dm.service.PreparadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/preparadores")
@Tag(name = "Preparador", description = "Gerencia os Preparadores")
public class PreparadorController {

    private final PreparadorService preparadorService;

    public PreparadorController(PreparadorService preparadorService) {
        this.preparadorService = preparadorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar Preparador")
    @ApiResponse(responseCode = "201", description = "Preparador Cadastrado")
    @ApiResponse(responseCode = "201", description = "Preparador Cadastrado")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<CadastrarPreparadorOutputDTO> cadastrar(@RequestBody CadastrarPreparadorInputDTO input) {
        final var output = preparadorService.cadastrar(input);
        return ResponseEntity.created(URI.create("/preparadores/" + output.id())).body(output);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar Preparador")
    @ApiResponse(responseCode = "201", description = "Preparador Atualizado")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Preparador não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<AtualizarPreparadorOutputDTO> atualizar(@PathVariable("id") String id, @RequestBody AtualizarPreparadorInputDTO input) {
        final var output = preparadorService.atualizar(id, input);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Pesquisar Preparador")
    @ApiResponse(responseCode = "201", description = "Preparador Consultado")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Preparador não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<PesquisarPreparadorOutputDTO> pesquisar(@PathVariable("id") String id) {
        final var output = preparadorService.pesquisar(id);
        return ResponseEntity.ok(output);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar Preparadores")
    @ApiResponse(responseCode = "201", description = "Preparadores Listados")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Preparador não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<List<ListarPreparadoresOutputDTO>> listar() {
        final var output = preparadorService.listar();
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar Preparador")
    @ApiResponse(responseCode = "201", description = "Preparador Excluido")
    @ApiResponse(responseCode = "400", description = "Erro de Validação")
    @ApiResponse(responseCode = "404", description = "Preparador não Encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um Erro no Servidor")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        preparadorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
