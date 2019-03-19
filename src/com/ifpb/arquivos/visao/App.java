package com.ifpb.arquivos.visao;

import com.ifpb.arquivos.dao.PessoaDaoArquivo;
import com.ifpb.arquivos.modelo.Pessoa;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        try {
            PessoaDaoArquivo dao = new PessoaDaoArquivo();
//            System.out.println(dao.salvar(new Pessoa("222.222.222-02",
//                    "Maria",LocalDate.now())));
            System.out.println(dao.getPessoas());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        File file = new File("teste.txt");
//        System.out.println("Tamanho: "+file.length()+" bytes");
//        System.out.println("Modificação: "+new Date(file.lastModified()));

//        JFileChooser chooser = new JFileChooser();
//
//        chooser.setDialogTitle("Escolha um arquivo");
//        //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        //chooser.setMultiSelectionEnabled(true);
//        switch (chooser.showDialog(null,"OK")){
//            case JFileChooser.APPROVE_OPTION:
//                File file = chooser.getSelectedFile();
//                System.out.println(file.getAbsolutePath());
//                break;
//            case JFileChooser.CANCEL_OPTION:
//                System.out.println("Não selecionou nada");
//                break;
//        }

    }

}
