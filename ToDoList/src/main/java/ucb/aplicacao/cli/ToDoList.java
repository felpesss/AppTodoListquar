/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucb.aplicacao.cli;


import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

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
                System.out.print("Titulo");
                String titulo = entrada.nextLine();
                System.out.print("Descrição: ");
                String descricao = entrada.nextLine();
                Tarefas nova = servico.criarTarefa(titulo, descricao);
                System.out.println("Tarefa criada: " + nova.getTitulo());        
                }
            }
       }       
    }

}
