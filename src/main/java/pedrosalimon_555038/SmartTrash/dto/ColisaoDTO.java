package pedrosalimon_555038.SmartTrash.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 5, max = 100, message = "O campo nome deve ter entre 5 e 100 caracteres")
    private String nome;
    @NotBlank(message = "O campo descrição é obrigatório")
    @Size(min = 5, max = 200, message = "O campo descrição deve ter entre 10 e 200 caracteres")
    private String descricao;
    @NotNull(message = "O campo data de Colisão é obrigatório")
    @PastOrPresent(message = "O campo de data de colisão deve ser passada ou presente")
    private LocalDate dataColisao;
    @NotNull(message = "O campo velocidade de impacto é obrigatório")
    @Positive(message = "Velocidade de impacto deve ser um valor positivo e maior que zero")
    private Long velocidadeImpacto;
    @NotNull(message = "O campo de quantidade de lixos gerados é obrigatório")
    @Positive(message = "Quantidade de lixos gerados deve ser um valor positivo e maior que zero")
    private Long qtdLixosGerados;
    @NotEmpty(message = "Colisão deve ter pelo menos um lixo espacial")
    private List<@Valid LixoEspacialDTO> lixos = new ArrayList<>();

    public ColisaoDTO(Colisao colisao) {
        id = colisao.getId();
        nome = colisao.getNome();
        descricao = colisao.getDescricao();
        dataColisao = colisao.getDataColisao();
        velocidadeImpacto = colisao.getVelocidadeImpacto();
        qtdLixosGerados = colisao.getQtdLixosGerados();

        for (LixoEspacial lixo: colisao.getLixos()) {
            LixoEspacialDTO lixoDTO = new LixoEspacialDTO(lixo);
            lixos.add(lixoDTO);
        }
    }
}
