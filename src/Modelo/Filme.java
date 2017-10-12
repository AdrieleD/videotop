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
    private String titulo;
    private Genero genero;
    private String estudio;
    private Date lancamento;
    public ArrayList<Ator> ListaAtores = new ArrayList<>();

    public Filme(String titulo, Genero genero, String estudio, Date lancamento, Ator ator) {
        this.titulo = titulo;
        this.genero = genero;
        this.estudio = estudio;
        this.lancamento = lancamento;
        this.ListaAtores.add(ator);
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

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public ArrayList<Ator> getListaAtores() {
        return ListaAtores;
    }

    public void setListaAtores(ArrayList<Ator> ListaAtores) {
        this.ListaAtores = ListaAtores;
    }
}
