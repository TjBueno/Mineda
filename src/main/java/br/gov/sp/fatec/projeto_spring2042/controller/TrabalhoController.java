package br.gov.sp.fatec.projeto_spring2042.controller;

import br.gov.sp.fatec.projeto_spring2042.entity.Trabalho;
import br.gov.sp.fatec.projeto_spring2042.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalho")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    // Rota para cadastrar um novo trabalho
    @PostMapping("/cadastrar")
    public Trabalho cadastrarTrabalho(@RequestBody Trabalho trabalho) {
        return trabalhoService.cadastrarTrabalho(trabalho);
    }

    // Rota para listar todos os trabalhos cadastrados
    @GetMapping("/listar")
    public List<Trabalho> listarTodos() {
        return trabalhoService.listarTodos();
    }

    // Rota para buscar trabalhos por título contendo uma palavra e nota superior a um valor
    @GetMapping("/buscar")
    public List<Trabalho> buscarTrabalhosPorTituloENota(
            @RequestParam("palavra") String palavra,
            @RequestParam("nota") Integer nota) {
        return trabalhoService.buscarTrabalhosPorTituloENota(palavra, nota);
    }
}