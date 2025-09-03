/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicacao.service;
import java.util.List;

/**
 *
 * @author davi.campanaro
 */
public class TarefasService {
    private List<Tarefas> tarefas = new ArrayList<>;
    private Long contadorId = IL;
    
    public Tarefas criarTarefa(String titulo, String descricao) {
        
        Tarefas tarefa = new Tarefas (contadorId++, titulo, descricao, false);
        tarefas.add(tarefa);
        return tarefa;
    }
    
}
