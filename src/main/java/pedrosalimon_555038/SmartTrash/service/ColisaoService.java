package pedrosalimon_555038.SmartTrash.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedrosalimon_555038.SmartTrash.dto.ColisaoDTO;
import pedrosalimon_555038.SmartTrash.dto.LixoEspacialDTO;
import pedrosalimon_555038.SmartTrash.entity.Colisao;
import pedrosalimon_555038.SmartTrash.entity.LixoEspacial;
import pedrosalimon_555038.SmartTrash.exceptions.ResourceNotFoundException;
import pedrosalimon_555038.SmartTrash.repositories.ColisaoRepository;
import pedrosalimon_555038.SmartTrash.repositories.LixoEspacialRepository;

import java.beans.Transient;
import java.lang.module.ResolutionException;
import java.time.LocalDate;
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

    @Transactional
    public ColisaoDTO saveColisao(ColisaoDTO colisaoDTO) {
        Colisao colisao = new Colisao();
        mapDtoToColisao(colisaoDTO, colisao);
        colisao = colisaoRepository.save(colisao);
        return new ColisaoDTO(colisao);
    }

    @Transactional
    public ColisaoDTO updateColisao (Long id, ColisaoDTO colisaoDTO) {
        try {
            Colisao colisao = colisaoRepository.getReferenceById(id);
            colisao.getLixos().clear();
            mapDtoToColisao(colisaoDTO, colisao);
            colisao = colisaoRepository.save(colisao);
            return new ColisaoDTO(colisao);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional
    public void deleteColisaoById (Long id) {
        if (!colisaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        colisaoRepository.deleteById(id);
    }

    private void mapDtoToColisao (ColisaoDTO colisaoDTO, Colisao colisao) {
        colisao.setNome(colisaoDTO.getNome());
        colisao.setDescricao(colisaoDTO.getDescricao());
        colisao.setQtdLixosGerados(colisaoDTO.getQtdLixosGerados());
        colisao.setDataColisao(colisaoDTO.getDataColisao());
        colisao.setVelocidadeImpacto(colisaoDTO.getVelocidadeImpacto());
        for (LixoEspacialDTO lixoDto: colisaoDTO.getLixos()) {
            LixoEspacial lixoEspacial = new LixoEspacial();
            lixoEspacial.setTipo(lixoDto.getTipo());
            lixoEspacial.setPeso(lixoDto.getPeso());
            lixoEspacial.setRisco(lixoDto.getRisco());
            lixoEspacial.setDataAparicao(lixoDto.getDataAparicao());
            lixoEspacial.setColisao(colisao);
            colisao.getLixos().add(lixoEspacial);
        }
    }

}
