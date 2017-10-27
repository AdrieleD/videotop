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
    private ArrayList<Genero> generos = new ArrayList<>();
    private ArrayList<Estudio> estudios = new ArrayList<>();
    private Date lancamento;
    public ArrayList<Ator> ListaAtores = new ArrayList<>();
    private int quantFitas;
    private int quantFitasDisp;

    public Filme(int idFilme, String titulo, Date lancamento, int quantFitas, int quantFitasDisp) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.lancamento = lancamento;
        this.quantFitas = quantFitas;
        this.quantFitasDisp = quantFitasDisp;
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

    public ArrayList<Genero> getGenero() {
        return generos;
    }

    public void setListaGeneros(ArrayList<Genero> ListaGeneros) {
        this.generos = ListaGeneros;
    }

    public ArrayList<Estudio> getEstudio() {
        return estudios;
    }

    public void setListaEstudios(ArrayList<Estudio> ListaEstudios) {
        this.estudios = ListaEstudios;
    }

    public ArrayList<Ator> getListaAtores() {
        return ListaAtores;
    }

    public void setListaAtores(ArrayList<Ator> ListaAtores) {
        this.ListaAtores = ListaAtores;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public ArrayList<Estudio> getEstudios() {
        return estudios;
    }

    public void setEstudios(ArrayList<Estudio> estudios) {
        this.estudios = estudios;
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
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

    public void setQuantFitasDisp() {
        this.quantFitasDisp = quantFitasDisp - 1;
    }
    
    
}
