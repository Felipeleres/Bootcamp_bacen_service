package com.bootcamp.bacen_service.controller;

import com.bootcamp.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.bacen_service.service.ChaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(CREATED).body(chaveservice.buscarChave(chave));
    }

}
