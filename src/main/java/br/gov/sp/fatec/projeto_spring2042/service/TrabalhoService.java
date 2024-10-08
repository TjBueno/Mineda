package br.gov.sp.fatec.projeto_spring2042.service;

import br.gov.sp.fatec.projeto_spring2042.entity.Trabalho;
import br.gov.sp.fatec.projeto_spring2042.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
//import java.util.Optional;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    // Método para cadastrar um novo trabalho
    public Trabalho cadastrarTrabalho(Trabalho trabalho) throws IllegalArgumentException {
        // Validação: título e grupo devem estar preenchidos
        if (trabalho.getTitulo() == null || trabalho.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título do trabalho deve ser preenchido.");
        }
        if (trabalho.getGrupo() == null || trabalho.getGrupo().trim().isEmpty()) {
            throw new IllegalArgumentException("O grupo do trabalho deve ser preenchido.");
        }

        // Se a data/hora de entrega não for fornecida, preenche com a data/hora atual
        if (trabalho.getDataHoraEntrega() == null) {
            trabalho.setDataHoraEntrega(LocalDateTime.now());
        }

        // Salva o trabalho no banco de dados
        return trabalhoRepository.save(trabalho);
    }

    // Método para listar todos os trabalhos cadastrados
    public List<Trabalho> listarTodos() {
        return trabalhoRepository.findAll();
    }

    // Método para buscar trabalhos com título contendo uma palavra e nota superior a um valor
    public List<Trabalho> buscarTrabalhosPorTituloENota(String palavra, Integer nota) {
        return trabalhoRepository.findByTituloContainingAndNotaGreaterThan(palavra, nota);
    }
}
