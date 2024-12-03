package com.Classes.Estruturas;
import com.Interfaces.Filme_IF;

public class Node {
    private Filme_IF valor;
    private Node anterior;
    private Node proximo;

    public Node(Filme_IF valor){
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }

    public Filme_IF getValor() {
        return valor;
    }

    public void setValor(Filme_IF valor) {
        this.valor = valor;
    }



    public Node getAnterior() {
        return anterior;
    }



    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }



    public Node getProximo() {
        return proximo;
    }



    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }



    public boolean isNil(){
        return this.valor == null;
    }
}
