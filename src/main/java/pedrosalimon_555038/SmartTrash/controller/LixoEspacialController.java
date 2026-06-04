package pedrosalimon_555038.SmartTrash.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrosalimon_555038.SmartTrash.dto.ColisaoDTO;
import pedrosalimon_555038.SmartTrash.dto.LixoEspacialDTO;
import pedrosalimon_555038.SmartTrash.dto.LixoEspacialRequestDTO;
import pedrosalimon_555038.SmartTrash.repositories.LixoEspacialRepository;
import pedrosalimon_555038.SmartTrash.service.LixoEspacialService;

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
    @PutMapping("/{id}")
    public ResponseEntity<LixoEspacialRequestDTO> updateLixo(@PathVariable Long id,
                                                             @Valid @RequestBody LixoEspacialRequestDTO lixoEspacialRequestDTO){
        lixoEspacialRequestDTO = lixoEspacialService.updateLixo(id, lixoEspacialRequestDTO);
        return ResponseEntity.ok(lixoEspacialRequestDTO);
    }

}
