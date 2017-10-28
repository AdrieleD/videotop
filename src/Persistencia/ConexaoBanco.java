/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Endereco;
import Modelo.TipoUsuario;
import Modelo.Usuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jw
 */
public class ConexaoBanco  {

    String sql;
    PreparedStatement stmt;
    ResultSet rs;
    java.sql.Connection conexao;
    Statement st;
    
    public ConexaoBanco() throws SQLException {
        this.sql = null;
        this.stmt = null;
        this.rs = null;
        this.st = null;
        this.conexao = DriverManager.getConnection("jdbc:mysql://localhost/videotopdb", "root", "foiprotpdetopicos");
    }
    
    public boolean  insertUsuario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) throws SQLException{
        DateFormat df= new SimpleDateFormat("yyyy-mm-dd");
        try {
            nascimento=df.parse("1996-02-14");
        } catch (ParseException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "INSERT INTO usuario (cpf,senha,nome,dataNascimento,logradouro,numero,bairro,cep,telefone, idtipoUsuario)VALUES(?,?,?,?,?,?,?,?,?,?)";
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, cpf);
                    stmt.setString(2, senha);
                    stmt.setString(3, nome);
                    stmt.setString(4, "1996-02-14");
                    stmt.setString(5, endereco.getLogradouro());
                    stmt.setString(6, Integer.toString( endereco.getNumero()));
                    stmt.setString(7, endereco.getBairro());
                    stmt.setString(8,endereco.getCep());
                    stmt.setString(9,telefone);
                    stmt.setInt(10, tipoUsuario.getTiposUsuario());
                    System.out.println("tipo usuario "+ tipoUsuario.getTiposUsuario());
                    stmt.execute();
                    stmt.close();
                
                return  true;
    } 
    
    public Usuario consultarUsuario(String cpf) throws SQLException{
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        Usuario u = null;
        Endereco e  = null;
        TipoUsuario tu = null;
        sql = "SELECT cpf,senha,nome,dataNascimento,logradouro,numero,bairro,cep,telefone, idtipoUsuario FROM usuario WHERE cpf='"+cpf+"'";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            e = new Endereco(rs.getString("logradouro"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cep"));
            tu = TipoUsuario.getTipoUsuario(rs.getInt("idtipoUsuario"));
            u = new Usuario(rs.getString("nome"), rs.getString("cpf"), rs.getDate("dataNascimento"), rs.getString("telefone"), tu, e, rs.getString("senha"));
        }
        st.close();
        return u;
    }
    
    public boolean realizarEmprestimo(int idFilme, String cpf, Date dataEmprestimo, Date dataDevolucao, float valor){
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        
        
        return true;
    }
    
    public boolean removeUsuario(String cpf) throws SQLException{
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql="DELETE FROM usuario WHERE cpf='"+cpf+"'";
        st = conexao.createStatement();
        st.executeUpdate(sql);
        st.close();
        return true;
    }
    
    public int getTamanhoTabela(String nomeTabela) throws SQLException{
        sql = "SELECT COUNT(*) AS totaltuplas from '"+nomeTabela+"'";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        st.close();
            return rs.getInt("totaltuplas");
    }
    
    public ArrayList<Usuario> getCadastrados(String nomeTabela) throws SQLException{
        ArrayList<Usuario> usuariosCadastrados = new ArrayList();
        Usuario u = null;
        Endereco e  = null;
        TipoUsuario tu = null;
        sql = "SELECT * from "+nomeTabela;
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            e = new Endereco(rs.getString("logradouro"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cep"));
            tu = TipoUsuario.getTipoUsuario(rs.getInt("idtipoUsuario"));
            u = new Usuario(rs.getString("nome"), rs.getString("cpf"), rs.getDate("dataNascimento"), rs.getString("telefone"), tu, e, rs.getString("senha"));
            usuariosCadastrados.add(u);
        }
        st.close();
        return usuariosCadastrados;        
    }
    //criar método para atualizar banco de dados
}
