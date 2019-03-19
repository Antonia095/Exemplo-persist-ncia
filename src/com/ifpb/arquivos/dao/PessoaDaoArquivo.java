package com.ifpb.arquivos.dao;

import com.ifpb.arquivos.modelo.Pessoa;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class PessoaDaoArquivo {

    private File arquivo;

    public PessoaDaoArquivo() throws IOException {
        arquivo = new File("Pessoas");

        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }

    public Set<Pessoa> getPessoas() throws IOException, ClassNotFoundException {
        if(arquivo.length()>0){
            try(ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo)
            )){
                return (HashSet) in.readObject();
            }
        }else{
            return new HashSet<>();
        }
    }

    public boolean salvar(Pessoa pessoa) throws IOException, ClassNotFoundException {
        Set<Pessoa> pessoas = getPessoas();
        if(pessoas.add(pessoa)){
            atualizarArquivo(pessoas);
            return true;
        }else{
            return false;
        }
    }

    private void atualizarArquivo(Set<Pessoa> pessoas) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(arquivo)
        )){
            out.writeObject(pessoas);
        }
    }

}