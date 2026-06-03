package pedrosalimon_555038.SmartTrash.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pedrosalimon_555038.SmartTrash.entity.LixoEspacial;
import pedrosalimon_555038.SmartTrash.entity.Tipo;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LixoEspacialDTO {
    private Long id;
    @NotBlank(message = "O campo risco é obrigatório")
    @Size(max = 5, message = "O campo risco deve ter no máximo 5 caracteres")
    private String risco;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @NotNull(message = "O campo de data da última aparição é obrigatório")
    private LocalDate dataUltimaAparicao;
    @NotNull(message = "O campo de peso é obrigatório")
    @Positive(message = "Peso deve ser um valor positivo e maior que zero")
    private Double peso;

    public LixoEspacialDTO(LixoEspacial lixoEspacial){
        id = lixoEspacial.getId();
        risco = lixoEspacial.getRisco();
        tipo = lixoEspacial.getTipo();
        dataUltimaAparicao = lixoEspacial.getDataUltimaAparicao();
        peso = lixoEspacial.getPeso();
    }

}
