package com.Classes;

import com.Interfaces.Filme_IF;

public class Filme implements Filme_IF{
    private long ID;
    private String nome;
    private int nota;
    private int ano;

    public Filme(){}

    public Filme(long ID, String nome, int nota, int ano){
        this.ID = ID;
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }

    public long getID(){
        return ID;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF filme2){

        // Decrescente
        if (this.nota != filme2.getNota())
            return Integer.compare(filme2.getNota(), this.nota);
        // Crescente
        else if (this.ano != filme2.getAno())
            return Integer.compare(this.ano, filme2.getAno());
        // Crescente
        return this.nome.compareTo(filme2.getNome());
    }

    @Override
    public String toString(){
        return nome + " (" +ano+ ") "+ "["+ nota + "]";
    }
}

