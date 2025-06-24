package clube.dm.entity;

import clube.dm.util.IdUtil;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
@Entity(name = "Atleta")
@Table(name = "atleta")
public class Atleta {

    // Getters
    @Getter
    @Id
    private String id;

    @Getter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter
    @Column(name = "descricao_lesao", nullable = false)
    private String descricaoLesao;

    @Getter
    @Column(name = "situacao", nullable = false)
    private String situacao;

    @Getter
    @Column(name = "num_camisa", nullable = false)
    private int numCamisa;

    @Getter
    @Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @Getter
    @JoinColumn(name = "preparador_id")
    private Preparador preparador;

    public Atleta() {
    }

    private Atleta(String id, String nome, String descricaoLesao, String situacao, int numCamisa, LocalDateTime dataCriacao, Preparador preparador) {
        this.id = id;
        this.nome = nome;
        this.descricaoLesao = descricaoLesao;
        this.situacao = situacao;
        this.numCamisa = numCamisa;
        this.dataCriacao = dataCriacao;
        this.preparador = preparador;
    }

    public static Atleta novoAtleta(String nome, String descricaoLesao, String situacao, int numCamisa, Preparador preparador) {
        String id = IdUtil.uuid();
        LocalDateTime dataCriacao = LocalDateTime.now();
        return new Atleta(id, nome, descricaoLesao, situacao, numCamisa, dataCriacao, preparador);
    }

    public Atleta atualizar(String descricaoLesao, String situacao){
        this.descricaoLesao = descricaoLesao;
        this.situacao = situacao;
        return this;
    }

    public void setPreparador(Preparador preparador) {
    this.preparador = preparador;
    }


}
