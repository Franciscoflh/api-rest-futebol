package com.francisco.apirestfutebol.service;

import com.francisco.apirestfutebol.dto.JogadorDTO;
import com.francisco.apirestfutebol.exception.ResourceNotFoundException;
import com.francisco.apirestfutebol.model.Jogador;
import com.francisco.apirestfutebol.repository.JogadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .orElseThrow(() -> new ResourceNotFoundException("Jogador não encontrado com o id: " + id));
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

    public Page<JogadorDTO> searchJogadores(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Jogador> jogadores = jogadorRepository.findAll(pageable);
        List<JogadorDTO> jogadorDTOs = jogadores.map(JogadorDTO::fromJogador).getContent();
        return new PageImpl<>(jogadorDTOs, pageable, jogadores.getTotalElements());
    }
}

