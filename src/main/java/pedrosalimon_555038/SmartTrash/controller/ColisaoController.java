package pedrosalimon_555038.SmartTrash.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedrosalimon_555038.SmartTrash.dto.ColisaoDTO;
import pedrosalimon_555038.SmartTrash.service.ColisaoService;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<ColisaoDTO> createColisao (@RequestBody
                                                     @Valid ColisaoDTO colisaoDTO){
        colisaoDTO =colisaoService.saveColisao(colisaoDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(colisaoDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(colisaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ColisaoDTO> updateColisao(@PathVariable Long id,
                                                    @Valid @RequestBody ColisaoDTO colisaoDTO) {
        colisaoDTO = colisaoService.updateColisao(id, colisaoDTO);
        return ResponseEntity.ok(colisaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColisao (@PathVariable Long id) {
    colisaoService.deleteColisaoById(id);
    return ResponseEntity.noContent().build();
    }


}
