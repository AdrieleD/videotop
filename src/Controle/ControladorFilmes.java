/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Ator;
import Modelo.Estudio;
import Modelo.Filme;
import Modelo.Genero;
import Persistencia.ConexaoBanco;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jw
 */
public class ControladorFilmes {
    private ArrayList<Filme> filmesCadastrados = new ArrayList ();
    private ConexaoBanco conexaoBanco;
    
    public ControladorFilmes() throws SQLException{
        conexaoBanco = new ConexaoBanco();
        filmesCadastrados = new ArrayList ();
   }
    
    public ArrayList<Filme> getFilmesCadastrados() throws ParseException {
        try {
            return conexaoBanco.getFilmesCadastrados();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Filme buscaFilme(int idFilme){
        for(Filme u: filmesCadastrados){
            if(u.getIdFilme()==idFilme)
                return u;
        }
        return null;
    }
    
    public boolean cadastrarFilme (int idFilme, String titulo, Genero genero, Estudio estudio, Date lancamento, Ator atorPrincipal, int quantFitas, int quantFitasDisp, String classe) throws SQLException{
        if(titulo.equals(""))
        {
            return false;
        }
        
        if(buscaFilme(idFilme) != null){
            System.out.println("Filme já existe!");
            return false;
        }
        Filme filme = new Filme(idFilme, titulo,  genero, estudio,  lancamento, atorPrincipal,  quantFitas, quantFitasDisp, classe);
        filmesCadastrados.add(filme);
        conexaoBanco.insertFilme(titulo, Integer.toString(lancamento.getYear()+1900), classe,quantFitas);
        System.out.println("Usuario Cadastrado com sucesso");  
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
    
    public boolean removeFilmeBanco(int idFilme) throws SQLException{
        conexaoBanco.removeFilme(idFilme);
        return false;
    }
    
    public boolean diminuiQtdFilmes(int idFilme){
        Filme u=buscaFilme(idFilme);
        if(u != null){
            //u.setQuantFitasDisp();
            return true;
        }
        else
        {
            System.out.println("Filme não existe!");
            return false;
        }
    }
    
    public boolean verificaQtdeFitas(int idFilme){
        Filme u=buscaFilme(idFilme);
        if(u != null){
            if(u.getQuantFitas()<= 0){
                return false; //não pode realizar impréstimo
            }
            else{
                return true;
            }
        }
        else
        {
            System.out.println("Filme não existe!");
            return false;
        }
    }
    
    public ArrayList<Ator> getAtores() throws SQLException{
        return conexaoBanco.getAtores();
    }
    
    public ArrayList<Genero> getGeneros() throws SQLException{
        return conexaoBanco.getGeneros();
    }
    
    public ArrayList<Estudio> getEstudios() throws SQLException{
        return conexaoBanco.getEstudios();
    }
}
