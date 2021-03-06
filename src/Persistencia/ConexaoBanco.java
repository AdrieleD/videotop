/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Ator;
import Modelo.Emprestimo;
import Modelo.Endereco;
import Modelo.Estudio;
import Modelo.Filme;
import Modelo.Funcionario;
import Modelo.Genero;
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
        this.conexao = DriverManager.getConnection("jdbc:mysql://localhost/videotopdb", "root", "344037");
    }
    
    public boolean insertFuncionario(String cpf, float salario) throws SQLException{
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "INSERT INTO funcionario (cpf,salario)VALUES(?,?)";
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, cpf);
                    stmt.setFloat(2, salario);
                    stmt.execute();
                    stmt.close();
            
                    return true;
    }
    
    public boolean  insertUsuario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) throws SQLException{
        java.sql.Date data = new java.sql.Date(nascimento.getTime());
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "INSERT INTO usuario (cpf,senha,nome,dataNascimento,logradouro,numero,bairro,cep,telefone, idtipoUsuario)VALUES(?,?,?,?,?,?,?,?,?,?)";
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, cpf);
                    stmt.setString(2, senha);
                    stmt.setString(3, nome);
                    stmt.setDate(4, data);
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
    
    public boolean  updateUsuario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha) throws SQLException{
        java.sql.Date data = new java.sql.Date(nascimento.getTime());
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "UPDATE usuario "
                +" SET cpf = ?,senha = ?,nome = ?,dataNascimento = ?,logradouro= ?,numero= ?,bairro= ?,cep = ?,telefone = ?, idtipoUsuario = ?"
                + "  WHERE cpf = ? ";
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, cpf);
                    stmt.setString(2, senha);
                    stmt.setString(3, nome);
                    stmt.setDate(4, data);
                    stmt.setString(5, endereco.getLogradouro());
                    stmt.setString(6, Integer.toString( endereco.getNumero()));
                    stmt.setString(7, endereco.getBairro());
                    stmt.setString(8,endereco.getCep());
                    stmt.setString(9,telefone);
                    stmt.setInt(10, tipoUsuario.getTiposUsuario());
                    stmt.setString(11, cpf);          
                    System.out.println("tipo usuario "+ tipoUsuario.getTiposUsuario());
                    stmt.execute();
                    stmt.close();
                
                return  true;
    } 
    
     public boolean  updateFuncionario(String nome, String cpf, Date nascimento, String telefone, TipoUsuario tipoUsuario, Endereco endereco, String senha, float salario) throws SQLException{
        java.sql.Date data = new java.sql.Date(nascimento.getTime());
        
        updateUsuario(nome, cpf, nascimento, telefone, tipoUsuario, endereco, senha);
        
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "UPDATE funcionario "
                +" SET cpf = ?,salario = ?"
                + "  WHERE cpf = ?";
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, cpf);
                    stmt.setFloat(2, salario);
                    stmt.setString(3, cpf);
                  
                    stmt.execute();
                    stmt.close();
                
                 
                return  true;
    } 
    
    
    public boolean insertFilme(String titulo, String ano, String classe, int qtdFitas) throws SQLException{
        int id; 
        String addFitas = " ";
        
        System.out.println(ano);
        sql = "INSERT INTO filme (titulo,ano,filmeTC)VALUES(?,?,?)";
        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, ano);
        stmt.setString(3, classe);
        stmt.execute();
        stmt.close();
        
        
        sql="SELECT idFilme FROM filme WHERE titulo = '"+titulo+"' AND filmeTC = '"+classe+"'";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        rs.next();
        id = rs.getInt("idFilme");
        st.close();
        
        System.out.println("------- id "+id);
        
        addFitas = addFitas.concat("("+Integer.toString(id)+")");
        for(int i = 1; i<= qtdFitas-1; i++){
            addFitas = addFitas.concat(",("+Integer.toString(id)+")");
        }
        
        sql = "INSERT INTO fita (idfilme) VALUES "+addFitas;
        stmt = conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();
        
        return false;
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
    
    public int consultarFilme(int idFilme) throws SQLException{
        sql = "SELECT idFilme FROM filme WHERE idfilme="+idFilme;
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            return rs.getInt("idfilme");
        }
        return 0;
    }
    
    public boolean realizarEmprestimo(int idFilme, String cpf, Date dataEmprestimo, Date dataDevolucao, float valor) throws SQLException{
        cpf=cpf.replace(".", "");
        cpf=cpf.replace("-", "");
        sql = "INSERT INTO usuario (idFilme,cpf,dataEmprestimo,dataDevolucao, valor)VALUES(?,?,?,?,?)";
        stmt = conexao.prepareStatement(sql);
                    stmt.setInt(1, idFilme);
                    stmt.setString(2, cpf);
                    stmt.setDate(3, (java.sql.Date) dataEmprestimo);
                    stmt.setDate(4, (java.sql.Date) dataDevolucao);
                    stmt.setFloat(5, valor);
                    stmt.execute();
                    stmt.close();
        
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
    
     public boolean removeFilme(int  idFilme) throws SQLException{
        sql="DELETE FROM filme WHERE idfilme="+idFilme;
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
    
    public ArrayList<Usuario> getCadastrados() throws SQLException{
        ArrayList<Usuario> usuariosCadastrados = new ArrayList();
        Usuario u = null;
        Endereco e  = null;
        TipoUsuario tu = null;
        sql = "SELECT * from usuario";
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
    
     public ArrayList<Funcionario> getFuncCadastrados() throws SQLException{
        ArrayList<Funcionario> funcionariosCadastrados = new ArrayList();
        Funcionario f = null;
        Endereco e  = null;
        TipoUsuario tu = null;
        sql = "SELECT * FROM videotopdb.funcionario NATURAL JOIN videotopdb.usuario";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            e = new Endereco(rs.getString("logradouro"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cep"));
            tu = TipoUsuario.getTipoUsuario(rs.getInt("idtipoUsuario"));
            System.out.println("tu = " +tu);
            f = new Funcionario(rs.getString("nome"), rs.getString("cpf"), rs.getDate("dataNascimento"), rs.getString("telefone"), tu, e, rs.getString("senha"), rs.getFloat("salario"));
            funcionariosCadastrados.add(f);
            System.out.println(rs.getInt("idtipoUsuario"));
            System.out.println("no banco "+ f.getTipoUsuario());
        }
        st.close();
        return funcionariosCadastrados;        
    }
    //criar método para atualizar banco de dados
    
    public ArrayList<Ator> getAtores() throws SQLException{
        ArrayList<Ator> atoresCadastrados = new ArrayList();
        Ator a =null;
        sql = "SELECT * from ator";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            a = new Ator(rs.getString("nome"), rs.getDate("dataNascimento"));
            atoresCadastrados.add(a);
        }
        st.close();
        return atoresCadastrados;
    }
    
    public ArrayList<Genero> getGeneros() throws SQLException{
        ArrayList<Genero> generosCadastrados = new ArrayList();
        Genero g =null;
        sql = "SELECT * from genero";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            g = new Genero(rs.getString("nome"), rs.getString("descricao"));
            generosCadastrados.add(g);
        }
        st.close();
        return generosCadastrados;
    }
    
    public ArrayList<Estudio> getEstudios() throws SQLException{
        ArrayList<Estudio> estudiosCadastrados = new ArrayList();
        Estudio e =null;
        sql = "SELECT * from estudio";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            e = new Estudio(rs.getString("nome"), rs.getString("sede"));
            estudiosCadastrados.add(e);
        }
        st.close();
        return estudiosCadastrados;
    }
    
    public ArrayList<Filme> getFilmesCadastrados()throws SQLException, ParseException{
        ArrayList<Filme> filmesCadastrados = new ArrayList();
        Filme f = null;
        //sql = "SELECT * from filme JOIN fita ON filme.idfilme=fita.idfilme";
        //sql="SELECT idFilme, titulo, ano, filmeTC FROM filme";
        sql="select filme.idfilme, filme.titulo,filme.ano, filme.filmeTC,COUNT(*) AS qtdFita "
                + "from filme natural join fita AS f1 "
                + "WHERE NOT EXISTS (select f2.idfita from fita f2 natural join emprestimo e where f1.idfita = f2.idfita) "
                + "GROUP BY filme.idfilme,filme.titulo,filme.ano, filme.filmeTC ";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        Genero g = null;
        Estudio e = null;
        Ator a = null;
        DateFormat df = new SimpleDateFormat("yyyy");
        Date d = new Date();
        while(rs.next()){
            d = df.parse(rs.getString("ano"));
            f = new Filme(rs.getInt("idFilme"), rs.getString("titulo"), g, e, d, a,0,rs.getInt("qtdFita"), rs.getString("filmeTC") );
            filmesCadastrados.add(f);
        }
        st.close();
        return filmesCadastrados;
    }
    
        public ArrayList<Emprestimo> getEmprestados() throws SQLException{
        ArrayList<Emprestimo> filmesEmprestados = new ArrayList();
        Emprestimo e  = null;

        sql = "SELECT titulo,  from emprestimo";
        st = conexao.createStatement();
        rs = st.executeQuery(sql);
        while(rs.next()){
            e = new Emprestimo(rs.getInt("idFita"), rs.getString("cpf"), rs.getDate("dataEmprestimo"), rs.getDate("dataDevolucao"), rs.getFloat("valor"));
            filmesEmprestados.add(e);
        }
        st.close();
        return filmesEmprestados;        
    }
    
}
