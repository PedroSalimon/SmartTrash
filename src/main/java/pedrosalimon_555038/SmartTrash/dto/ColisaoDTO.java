package pedrosalimon_555038.SmartTrash.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pedrosalimon_555038.SmartTrash.entity.Colisao;
import pedrosalimon_555038.SmartTrash.entity.LixoEspacial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ColisaoDTO {
    private Long id;
    @NotNull(message = "O campo data de Colisão é obrigatório")
    private LocalDate dataColisao;
    @NotNull(message = "O campo velocidade de impacto é obrigatório")
    @Positive(message = "Velocidade de impacto deve ser um valor positivo e maior que zero")
    private Double velocidadeImpacto;
    @NotNull(message = "O campo de quantidade de lixos gerados é obrigatório")
    @Positive(message = "Quantidade de lixos gerados deve ser um valor positivo e maior que zero")
    private Long qtdLixosGerados;
    @NotEmpty(message = "Colisão deve ter pelo menos um lixo espacial")
    private List<@Valid LixoEspacialDTO> lixos = new ArrayList<>();

    public ColisaoDTO(Colisao colisao) {
        id = colisao.getId();
        dataColisao = colisao.getDataColisao();
        velocidadeImpacto = colisao.getVelocidadeImpacto();
        qtdLixosGerados = colisao.getQtdLixosGerados();

        for (LixoEspacial lixo: colisao.getLixos()) {
            LixoEspacialDTO lixoDTO = new LixoEspacialDTO(lixo);
            lixos.add(lixoDTO);
        }
    }
}
