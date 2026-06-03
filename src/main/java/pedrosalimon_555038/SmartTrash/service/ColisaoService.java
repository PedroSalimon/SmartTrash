package pedrosalimon_555038.SmartTrash.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedrosalimon_555038.SmartTrash.dto.ColisaoDTO;
import pedrosalimon_555038.SmartTrash.entity.Colisao;
import pedrosalimon_555038.SmartTrash.repositories.ColisaoRepository;
import pedrosalimon_555038.SmartTrash.repositories.LixoEspacialRepository;

import java.beans.Transient;
import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class ColisaoService {

    @Autowired
    private ColisaoRepository colisaoRepository;
    @Autowired
    private LixoEspacialRepository lixoEspacialRepository;

    @Transactional
    public List<ColisaoDTO> findAllColisoes () {
        return colisaoRepository.findAll().stream().map(ColisaoDTO::new).toList();
    }

    @Transactional
    public ColisaoDTO findColisaoById(Long id) {
        Colisao colisao = colisaoRepository.findById(id).orElseThrow(
                () -> new ResolutionException("Recurso não encontrado. ID: " + id)
        );
        return new ColisaoDTO(colisao);
    }

}
