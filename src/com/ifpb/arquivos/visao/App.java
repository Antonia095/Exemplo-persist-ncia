package com.ifpb.arquivos.visao;

import com.ifpb.arquivos.banco.ConFactory;
import com.ifpb.arquivos.dao.PessoaDaoArquivo;
import com.ifpb.arquivos.dao.PessoaDaoBanco;
import com.ifpb.arquivos.modelo.Pessoa;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        Pessoa p = new Pessoa("111.111.111-99", "João das Neves", LocalDate.now());

        PessoaDaoBanco dao = new PessoaDaoBanco();

        try {
            System.out.println(dao.atualizar(p));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        ConFactory factory = new ConFactory();
//        try {
//            Connection connection = factory.getConnection();
//            if(connection != null) System.out.println("OK");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        try {
//            PessoaDaoArquivo dao = new PessoaDaoArquivo();
//            Pessoa p = new Pessoa("111.111.111-01","João das Neves",
//                    LocalDate.now());
//            if(dao.atualizar(p)){
//                System.out.println("Atualizado");
//            }else{
//                System.out.println("Falha");
//            }
//            System.out.println(dao.buscarPorCpf("111.111.111-01"));
//            Pessoa p = new Pessoa("222.222.222-02","Maria", null);
//            if(dao.deletar(p)){
//                System.out.println("Removido com sucesso");
//            }else{
//                System.out.println("Falha ao deletar");
//            }
//            System.out.println(dao.salvar(new Pessoa("222.222.222-02",
//                    "Maria",LocalDate.now())));
//            System.out.println(dao.getPessoas());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

}
