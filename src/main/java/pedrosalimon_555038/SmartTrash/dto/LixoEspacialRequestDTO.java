package pedrosalimon_555038.SmartTrash.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pedrosalimon_555038.SmartTrash.entity.LixoEspacial;
import pedrosalimon_555038.SmartTrash.entity.Tipo;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LixoEspacialRequestDTO {
    private Long id;
    @NotBlank(message = "O campo risco é obrigatório")
    @Size(max = 5, message = "O campo risco deve ter no máximo 5 caracteres")
    private String risco;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @NotNull(message = "O campo de data da aparição é obrigatório")
    @PastOrPresent(message = "O campo de data da aparição deve ser passada ou presente")
    private LocalDate dataAparicao;
    @NotNull(message = "O campo de peso é obrigatório")
    @Positive(message = "Peso deve ser um valor positivo e maior que zero")
    private Double peso;
    private Long id_colisao;

    public LixoEspacialRequestDTO(LixoEspacial lixoEspacial){
        id = lixoEspacial.getId();
        risco = lixoEspacial.getRisco();
        tipo = lixoEspacial.getTipo();
        dataAparicao = lixoEspacial.getDataAparicao();
        peso = lixoEspacial.getPeso();
        id_colisao = lixoEspacial.getColisao().getId();
    }

}
