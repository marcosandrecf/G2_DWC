package clube.dm.entity;

import clube.dm.util.IdUtil;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Preparador")
@Table(name = "preparador")
public class Preparador implements Serializable {
    private static final int serial = 10;

    @Getter
    @Id
    private String id;

    @Getter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter
    @Column(name = "area", nullable = false)
    private String area;

    @Getter
    @Column(name = "CREF", nullable = false)
    private Long CREF;

    @Getter
    @Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime dataCriacao;

    @Getter
    @OneToMany(mappedBy = "preparador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atleta> atletas;

    public Preparador() {
    }

    private Preparador(String id, String nome, String area, Long CREF, LocalDateTime dataCriacao, List<Atleta> atletas) {
        this.id = id;
        this.nome = nome;
        this.area = area;
        this.CREF = CREF;
        this.dataCriacao = dataCriacao;
        this.atletas = atletas;
    }

    public static Preparador novoPreparador(String nome, String area, Long CREF, List<Atleta> atletas) {
        String id = IdUtil.uuid();
        LocalDateTime dataCriacao = LocalDateTime.now();
        return new Preparador(id, nome, area, CREF, dataCriacao, atletas);
    }

    public void setArea(String area) {
        this.area = area;
    }
}
