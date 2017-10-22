/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Filme;
import Modelo.Genero;
import Modelo.Ator;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jw
 */
public class ControladorFilmes {
    private ArrayList<Filme> filmesCadastrados = new ArrayList ();
    
    
    
    public Filme buscaFilme(int idFilme){
        for(Filme u: filmesCadastrados){
            if(u.getIdFilme()==idFilme)
                return u;
        }
        return null;
    }
    
    public boolean cadastrarFilme (int idFilme, String titulo, Date lancamento, int quantFitas){
        if(titulo.equals(""))
        {
            return false;
        }
        
        if(buscaFilme(idFilme) != null){
            System.out.println("Filme já existe!");
            return false;
        }
        Filme filme = new Filme(idFilme, titulo, lancamento, quantFitas, quantFitas);
        filmesCadastrados.add(filme);
        return true;
    }
    
    public boolean removeFilme(int idFilme){
        Filme u=buscaFilme(idFilme);
        if(u != null){
            System.out.println("Filme existe!");
            filmesCadastrados.remove(u);
            return true;
        }
        else
        {
            System.out.println("Filme não existe!");
            return false;
        }     
    }
    
}
