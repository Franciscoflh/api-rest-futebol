package service;

import exception.ResourceNotFoundException;
import model.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.JogadorRepository;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> getAllJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador getJogadorById(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador not found with id: " + id));
    }

    public Jogador saveJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Jogador updateJogador(Long id, Jogador updatedJogador) {
        Jogador jogador = getJogadorById(id);
        jogador.setNome(updatedJogador.getNome());
        jogador.setDataNascimento(updatedJogador.getDataNascimento());
        jogador.setAltura(updatedJogador.getAltura());
        return jogadorRepository.save(jogador);
    }

    public void deleteJogador(Long id) {
        Jogador jogador = getJogadorById(id);
        jogadorRepository.delete(jogador);
    }

    public Page<Jogador> searchJogadores(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return jogadorRepository.findAll(pageable);
    }
}

