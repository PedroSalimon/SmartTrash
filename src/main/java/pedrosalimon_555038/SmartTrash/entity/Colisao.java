package pedrosalimon_555038.SmartTrash.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_colisao")
public class Colisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dataColisao", nullable = false)
    private LocalDate dataColisao;
    @Column(name = "velocidadeImpacto", nullable = false)
    private Double velocidadeImpacto;
    @Column(name = "qtdLixosGerados", nullable = false)
    private Long qtdLixosGerados;
    @OneToMany(mappedBy = "colisao",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LixoEspacial> lixos = new ArrayList<>();

}
