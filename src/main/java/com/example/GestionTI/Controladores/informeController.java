package com.example.GestionTI.Controladores;

import com.example.GestionTI.Repositorio.InformesRepositorio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/informe")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class informeController {
    private final InformesRepositorio informesRepositorio;


}
