package com.Classes.Estruturas;

import com.Interfaces.Filme_IF;

public class NodeBST {
    private Filme_IF valor;
    private NodeBST esquerda, direita;

    public NodeBST(Filme_IF valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public Filme_IF getValor() {
        return valor;
    }

    public void setValor(Filme_IF valor) {
        this.valor = valor;
    }

    public NodeBST getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NodeBST esquerda) {
        this.esquerda = esquerda;
    }

    public NodeBST getDireita() {
        return direita;
    }

    public void setDireita(NodeBST direita) {
        this.direita = direita;
    }

    public boolean isNil(){
        if (this.valor == null)
            return true;
        return false;
    }
}