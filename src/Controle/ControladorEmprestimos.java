/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controle;

import Modelo.Emprestimo;
import Persistencia.ConexaoBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adriele
 */
public class ControladorEmprestimos {
    private ArrayList<Emprestimo> listaEmprestimos;
    private ConexaoBanco conexaobanco;
    private ControladorFilmes controlafilmes;
    
    public ArrayList<Emprestimo> getListaEmprestimos(String nomeTabela) {
        try {
            return conexaobanco.getEmprestados();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmprestimos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
    public boolean realizarEmprestimos(int idFilme, String cpf, Date dataEmprestimo, Date dataDevolucao, float valor) throws SQLException{
        if(idFilme == 0 || cpf.equals("")|| dataEmprestimo.equals("") || dataDevolucao.equals("") || valor == 0)
        {
            return false;
        }
        
        if(!controlafilmes.verificaQtdeFitas(idFilme)){
            return false;
        }
        
        Emprestimo emprestimo = new Emprestimo(idFilme, cpf, dataEmprestimo, dataDevolucao, valor);
        listaEmprestimos.add(emprestimo);
        controlafilmes.diminuiQtdFilmes(idFilme);
        conexaobanco.realizarEmprestimo(idFilme, cpf, dataEmprestimo, dataDevolucao, valor);
        System.out.println("Emprestimo realizado com sucesso");
        return true;
    }
    
    public boolean realizarDevolucao(int idFilme, String cpf){
        Emprestimo e = buscaEmprestimo(idFilme, cpf);
        
        if(idFilme == 0 || cpf.equals(""))
        {
            return false;
        }
        
        if(buscaEmprestimo(idFilme, cpf) != null){
            return false;
        }
        
        listaEmprestimos.remove(e);
        //atualizar banco de dados
        System.out.println("Devolução realizado com sucesso");
        return true;
    }
    
    public Emprestimo buscaEmprestimo(int idFilme, String cpf){
        if(listaEmprestimos.isEmpty())
            return null;
        for(Emprestimo e: listaEmprestimos){
            if(e.getIdFilme() == idFilme && e.getCpf().equals(cpf))
                return e;
        }
        return null;
    }
}