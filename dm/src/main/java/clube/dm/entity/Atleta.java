package clube.dm.entity;

import clube.dm.util.IdUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity(name = "Atleta")
@Table(name = "atleta")
public class Atleta {

    @Id
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao_lesao", nullable = false)
    private String descricaoLesao;

    @Column(name = "situacao", nullable = false)
    private String situacao;

    @Column(name = "num_camisa", nullable = false)
    private int numCamisa;

    @Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime dataCriacao;

    public Atleta() {
    }

    private Atleta(String id, String nome, String descricaoLesao, String situacao, int numCamisa, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricaoLesao = descricaoLesao;
        this.situacao = situacao;
        this.numCamisa = numCamisa;
        this.dataCriacao = dataCriacao;
    }

    public static Atleta novoAtleta(String nome, String descricaoLesao, String situacao, int numCamisa) {
        String id = IdUtil.uuid();
        LocalDateTime dataCriacao = LocalDateTime.now();
        return new Atleta(id, nome, descricaoLesao, situacao, numCamisa, dataCriacao);
    }

    public Atleta atualizar(String descricaoLesao, String situacao){
        this.descricaoLesao = descricaoLesao;
        this.situacao = situacao;
        return this;
    }

    // Getters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricaoLesao() { return descricaoLesao; }
    public String getSituacao() { return situacao; }
    public int getNumCamisa() { return numCamisa; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
