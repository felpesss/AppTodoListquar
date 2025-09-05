/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ucb.aplicacao.service;

import ucb.aplicacao.model.Tarefas;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author davi.campanaro
 */
public class TarefaService {
    private List<Tarefas> tarefas;
    private Long proximoId;

    public TarefaService() {
        this.tarefas = new ArrayList<>();
        this.proximoId = 1L;
    }

    public Tarefas criarTarefa(String titulo, String descricao) {
        Tarefas novaTarefa = new Tarefas(proximoId++, titulo, descricao, false);
        this.tarefas.add(novaTarefa);
        return novaTarefa;
    }

    public List<Tarefas> listarTarefas() {
        return new ArrayList<>(this.tarefas);
    }

    public Optional<Tarefas> buscarTarefaPorId(Long id) {
        return this.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public boolean atualizarTarefa(Long id, String novoTitulo, String novaDescricao, boolean completa) {
        Optional<Tarefas> tarefaExistente = buscarTarefaPorId(id);
        if (tarefaExistente.isPresent()) {
            Tarefas tarefa = tarefaExistente.get();
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setCompleta(completa);
            return true;
        }
        return false;
    }

    public boolean removerTarefa(Long id) {
        return this.tarefas.removeIf(t -> t.getId().equals(id));
    }
}