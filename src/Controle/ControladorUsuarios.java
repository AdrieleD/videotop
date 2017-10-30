/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Endereco;
import Modelo.Funcionario;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import Persistencia.ConexaoBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jw
 */
public class ControladorUsuarios {
    private ArrayList<Usuario> usuariosCadastrados;
    
    private ConexaoBanco conexaoBanco;
            
    public ArrayList<Usuario> getUsuariosCadastrados(String nomeTabela) {
        try {
            return conexaoBanco.getCadastrados();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Funcionario> getFuncCadastrados() {
        try {
            return conexaoBanco.getFuncCadastrados();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ControladorUsuarios() throws SQLException{
        conexaoBanco = new ConexaoBanco();
        usuariosCadastrados = new ArrayList ();
   }
    
    public Usuario buscaUsuario(String cpf) throws SQLException{;
        Usuario u = conexaoBanco.consultarUsuario(cpf);
        return u;
    }
    
    public boolean cadastrarFuncionario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha, float salario) throws SQLException{
        cadastrarUsuario( nome,  cpf,  nascimento,  telefone,  tipoUsuario, endereco, senha);
        conexaoBanco.insertFuncionario(cpf, salario);
        return true;
    }
    
    public boolean cadastrarUsuario (String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) throws SQLException{
        if(nome.equals("")||cpf.equals("")|| telefone.equals("") || endereco.equals("") || senha.equals(""))
        {
            return false;
        }
        
        if(buscaUsuario(cpf) != null){
            System.out.println("Usuário já existe!");
            return false;
        }
        
        Usuario usuario = new Usuario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha);
        usuariosCadastrados.add(usuario);
        conexaoBanco.insertUsuario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha);
        System.out.println("Usuario Cadastrado com sucesso");        
        return true;
    }
    
    
    public boolean atualizarUsuario (String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) throws SQLException{
        if(nome.equals("")||cpf.equals("")|| telefone.equals("") || endereco.equals("") || senha.equals(""))
        {
            return false;
        }
        
        Usuario usuario = new Usuario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha);
        conexaoBanco.updateUsuario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha);
        System.out.println("Usuario Atualizado com sucesso");        
        return true;
    }
    
    
    public boolean atualizarFuncionario (String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha, float salario) throws SQLException{
        if(nome.equals("")||cpf.equals("")|| telefone.equals("") || endereco.equals("") || senha.equals(""))
        {
            return false;
        }
        
        Funcionario funcionario = new Funcionario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha,salario);
        conexaoBanco.updateFuncionario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha,salario);
        System.out.println("Usuario Atualizado com sucesso");        
        return true;
    }
    
    public boolean removeUsuario(String cpf) throws SQLException{
        Usuario u=buscaUsuario(cpf);
        if(u != null){
            System.out.println("Usuário existe!");
            conexaoBanco.removeUsuario(cpf);
            usuariosCadastrados.remove(u);
            return true;
        }
        else
        {
            System.out.println("Usuário não existe!");
            return false;
        }     
    }
    
    public Usuario realizarLogin(String cpf, String senha) throws SQLException{
        Usuario u = buscaUsuario(cpf);
       if(u.getSenha().equals(senha)){
                System.out.println("Login realizado com sucesso!");
                return u;
            }
       else
           return null;
        
    }
    
    public int getTamanhoTabela() throws SQLException{
        return conexaoBanco.getTamanhoTabela("usuario");
    }
        
}
