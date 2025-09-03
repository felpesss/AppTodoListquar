/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ucb.aplicacao.cli;

/**
 *
 * @author davi.campanaro
 */
public class ToDoList {
    
    public static void main (String[] args){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        
       Scanner entrada = new scanner(System.in);
       TarefaService servico = new TarefaService();
       
       while (true)(
       System.out.println("\n ==== GERENCIADOR DE TAREFAS ===="));
        
    }

   
}
