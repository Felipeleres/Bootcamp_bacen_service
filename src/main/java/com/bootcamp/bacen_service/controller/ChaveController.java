package com.bootcamp.bacen_service.controller;

import com.bootcamp.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.bacen_service.model.Chave;
import com.bootcamp.bacen_service.service.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/api/bacen/chaves")
@RestController
@RequiredArgsConstructor
public class ChaveController {

    private final ChaveService chaveservice;

    @PostMapping
    public ResponseEntity<ChaveResponseDTO> criarChave(@RequestBody ChaveRequestDTO chaveRequestDTO){
        return ResponseEntity.status(CREATED).body(chaveservice.criarChave(chaveRequestDTO));
    }
    @GetMapping("/{chave}")
    public ResponseEntity<ChaveResponseDTO> buscarChave(@PathVariable String chave){
        return ResponseEntity.ok().body(chaveservice.buscarChave(chave));
    }
    @DeleteMapping("/{chave}")
    public ResponseEntity<Void> deletarChave(@PathVariable String chave){
        chaveservice.deletarChave(chave);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{chaveAtual}")
    public ResponseEntity<ChaveResponseDTO> updateChave(@PathVariable String chaveAtual, @RequestBody  ChaveRequestDTO chaveRequestDTO){

        ChaveResponseDTO chaveResponseDTO = chaveservice.updateChave(chaveAtual,chaveRequestDTO);

        return ResponseEntity.status(CREATED).body(chaveResponseDTO);
    }

}
