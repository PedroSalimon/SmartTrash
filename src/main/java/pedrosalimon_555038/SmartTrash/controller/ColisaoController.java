package pedrosalimon_555038.SmartTrash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedrosalimon_555038.SmartTrash.dto.ColisaoDTO;
import pedrosalimon_555038.SmartTrash.service.ColisaoService;

import java.util.List;

@RestController
@RequestMapping("/colisao")
public class ColisaoController {

    @Autowired
    private ColisaoService colisaoService;

    @GetMapping
    public ResponseEntity<List<ColisaoDTO>> getAll() {
        List<ColisaoDTO> list = colisaoService.findAllColisoes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColisaoDTO> getColisao (@PathVariable Long id) {
        ColisaoDTO colisaoDTO = colisaoService.findColisaoById(id);
        return ResponseEntity.ok(colisaoDTO);
    }

}
