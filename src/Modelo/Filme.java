/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author adriele
 */
public class Filme {
    private int idFilme;
    private String titulo;
    private Genero genero;
    private Estudio estudio;
    private Date lancamento;
    public Ator atorPrincipal;
    private int quantFitas;
    private int quantFitasDisp;
    private String classe;

    public Filme(int idFilme, String titulo, Genero genero, Estudio estudio, Date lancamento, Ator atorPrincipal, int quantFitas, int quantFitasDisp, String classe) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.genero = genero;
        this.estudio = estudio;
        this.lancamento = lancamento;
        this.atorPrincipal = atorPrincipal;
        this.quantFitas = quantFitas;
        this.quantFitasDisp = quantFitasDisp;
        this.classe = classe;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public int getQuantFitas() {
        return quantFitas;
    }

    public void setQuantFitas(int quantFitas) {
        this.quantFitas = quantFitas;
    }

    public int getQuantFitasDisp() {
        return quantFitasDisp;
    }

    public void setQuantFitasDisp(int quantFitasDisp) {
        this.quantFitasDisp = quantFitasDisp;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    

   
    
    
}
