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
@Table(name = "tb_lixoEspacial")
public class LixoEspacial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "risco", nullable = false, length = 5)
    private String risco;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(name = "dataUltimaAparicao", nullable = false)
    private LocalDate dataUltimaAparicao;
    @Column(name = "peso", nullable = false)
    private Double peso;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_colisao")
    private Colisao colisao;



}
