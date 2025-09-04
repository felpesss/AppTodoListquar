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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getDataAgora() {
        return dataAgora;
    }

    public void setDataAgora(LocalDateTime dataAgora) {
        this.dataAgora = dataAgora;
    }
    public Tarefas (String Titulo, String descricao){
        this();
        this.descricao = descricao;     
    }
    public Tarefas (Long id, String titulo, String descricao, boolean completa){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.descricao = descricao;
        this.completa = completa;
    }
    

    
}
