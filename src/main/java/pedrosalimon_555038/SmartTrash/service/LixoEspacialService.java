package pedrosalimon_555038.SmartTrash.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedrosalimon_555038.SmartTrash.dto.LixoEspacialRequestDTO;
import pedrosalimon_555038.SmartTrash.entity.LixoEspacial;
import pedrosalimon_555038.SmartTrash.exceptions.ResourceNotFoundException;
import pedrosalimon_555038.SmartTrash.repositories.LixoEspacialRepository;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class LixoEspacialService {
    @Autowired
    private LixoEspacialRepository lixoEspacialRepository;

    @Transactional
    public List<LixoEspacialRequestDTO> findAllLixos () {
        return lixoEspacialRepository.findAll().stream().map(LixoEspacialRequestDTO:: new).toList();
    }

    @Transactional
    public LixoEspacialRequestDTO findLixoById (Long id) {
        LixoEspacial lixoEspacial = lixoEspacialRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Recurso não encontrado. ID: " + id)
        );
        return new LixoEspacialRequestDTO(lixoEspacial);
    }

    @Transactional
    public LixoEspacialRequestDTO updateLixo (Long id, LixoEspacialRequestDTO lixoEspacialRequestDTO) {
        try {
            LixoEspacial lixoEspacial = lixoEspacialRepository.getReferenceById(id);
            mapDtoToLixoEspacial(lixoEspacialRequestDTO, lixoEspacial);
            lixoEspacial = lixoEspacialRepository.save(lixoEspacial);
            return new LixoEspacialRequestDTO(lixoEspacial);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: "+ id);
        }
    }

    private void mapDtoToLixoEspacial (LixoEspacialRequestDTO lixoEspacialRequestDTO, LixoEspacial lixoEspacial) {
        lixoEspacial.setDataAparicao(lixoEspacialRequestDTO.getDataAparicao());
        lixoEspacial.setRisco(lixoEspacialRequestDTO.getRisco());
        lixoEspacial.setTipo(lixoEspacialRequestDTO.getTipo());
        lixoEspacial.setPeso(lixoEspacialRequestDTO.getPeso());
    }
}
