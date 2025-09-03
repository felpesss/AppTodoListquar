/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicacao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author davi.campanaro
 */
public class Tarefas {
    
    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDateTime dataAgora;
    
    public Tarefas(){
        this.dataAgora = LocalDateTime.now();
        this.completa = false;
    }
    public Tarefas(String titulo){
        this();
        this.titulo = titulo;
    }
    public Tarefas (String Titulo, String descricao){
        this();
        this.descricao = descricao;     
    }

    
}
