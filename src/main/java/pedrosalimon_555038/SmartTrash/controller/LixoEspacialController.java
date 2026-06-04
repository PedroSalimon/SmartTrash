package pedrosalimon_555038.SmartTrash.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pedrosalimon_555038.SmartTrash.dto.ColisaoDTO;
import pedrosalimon_555038.SmartTrash.dto.LixoEspacialDTO;
import pedrosalimon_555038.SmartTrash.dto.LixoEspacialRequestDTO;
import pedrosalimon_555038.SmartTrash.repositories.LixoEspacialRepository;
import pedrosalimon_555038.SmartTrash.service.LixoEspacialService;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/lixos")
public class LixoEspacialController {
    @Autowired
    private LixoEspacialService lixoEspacialService;
    @GetMapping
    public ResponseEntity<List<LixoEspacialRequestDTO>> getAll() {
        List<LixoEspacialRequestDTO> list = lixoEspacialService.findAllLixos();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LixoEspacialRequestDTO> getLixoById(@PathVariable Long id) {
        LixoEspacialRequestDTO lixoEspacialRequestDTO = lixoEspacialService.findLixoById(id);
        return ResponseEntity.ok(lixoEspacialRequestDTO);
    }
    @PostMapping
    public ResponseEntity<LixoEspacialRequestDTO> createLixo (@RequestBody
                                                              @Valid LixoEspacialRequestDTO lixoEspacialRequestDTO) {
        lixoEspacialRequestDTO =lixoEspacialService.createLixoEspacial(lixoEspacialRequestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(lixoEspacialRequestDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(lixoEspacialRequestDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LixoEspacialRequestDTO> updateLixo(@PathVariable Long id,
                                                             @Valid @RequestBody LixoEspacialRequestDTO lixoEspacialRequestDTO){
        lixoEspacialRequestDTO = lixoEspacialService.updateLixo(id, lixoEspacialRequestDTO);
        return ResponseEntity.ok(lixoEspacialRequestDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColisao (@PathVariable Long id) {
        lixoEspacialService.deleteLixoById(id);
        return ResponseEntity.noContent().build();
    }

}
