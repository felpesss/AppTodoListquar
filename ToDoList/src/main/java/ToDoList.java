/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import ucb.aplicacao.model.Tarefas;
import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import ucb.aplicacao.service.TarefaService;

/**
 *
 * @author davi.campanaro
 */
public class ToDoList {
    
    public static void main (String[] args){
       System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
       Scanner entrada = new Scanner(System.in);
       TarefaService servico = new TarefaService();
       
       while (true){
            System.out.println("\n ==== GERENCIADOR DE TAREFAS ====");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = entrada.nextInt();
            entrada.nextLine();
            
            switch (opcao){
                case 1 -> {
                System.out.print("Titulo: ");
                String titulo = entrada.nextLine();
                System.out.print("Descrição: ");
                String descricao = entrada.nextLine();
                Tarefas nova = servico.criarTarefa(titulo, descricao);
                System.out.println("Tarefa criada: " + nova.getTitulo());        
                }
                case 2 -> {
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    List<Tarefas> tarefas = servico.listarTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (Tarefas t : tarefas) {
                            System.out.println("ID: " + t.getId() + ", Título: " + t.getTitulo() + ", Descrição: " + t.getDescricao() + ", Completa: " + (t.isCompleta() ? "Sim" : "Não") + ", Data: " + t.getDataAgora());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Digite o ID da tarefa para atualizar: ");
                    Long idAtualizar = entrada.nextLong();
                    entrada.nextLine();
                    Optional<Tarefas> tarefaParaAtualizar = servico.buscarTarefaPorId(idAtualizar);
                    if (tarefaParaAtualizar.isPresent()) {
                        System.out.print("Novo Título (deixe em branco para manter o atual): ");
                        String novoTitulo = entrada.nextLine();
                        if (novoTitulo.isEmpty()) {
                            novoTitulo = tarefaParaAtualizar.get().getTitulo();
                        }
                        System.out.print("Nova Descrição (deixe em branco para manter a atual): ");
                        String novaDescricao = entrada.nextLine();
                        if (novaDescricao.isEmpty()) {
                            novaDescricao = tarefaParaAtualizar.get().getDescricao();
                        }
                        System.out.print("Tarefa completa?: ");
                        String completaStr = entrada.nextLine();
                        boolean completa = completaStr.equalsIgnoreCase("sim");
                        if (servico.atualizarTarefa(idAtualizar, novoTitulo, novaDescricao, completa)) {
                            System.out.println("Tarefa atualizada com sucesso!");
                        } else {
                            System.out.println("Erro ao atualizar a tarefa.");
                        }
                    } else {
                        System.out.println("Tarefa com ID " + idAtualizar + " não encontrada.");
                    }
                }
                case 4 -> {
                    System.out.print("Digite o ID da tarefa para remover: ");
                    Long idRemover = entrada.nextLong();
                    entrada.nextLine();
                    if (servico.removerTarefa(idRemover)) {
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Tarefa com ID " + idRemover + " não encontrada.");
                    }
                }
                case 5 -> {
                    System.out.println("Saindo do gerenciador de tarefas. Até mais!");
                    entrada.close();
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
       }       
    }

}
