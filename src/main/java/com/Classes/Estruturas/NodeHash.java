package com.Classes.Estruturas;
import com.Interfaces.Filme_IF;

public class NodeHash {
    private Node head;

    private NodeHash anterior;
    private NodeHash proximo;

    public NodeHash(){
        this.anterior = null;
        this.proximo = null;
        this.head = null;
    }
    
    public Node getFilmes() {
        return head;
    }

    public void setFilmes(Node no) {
        this.head = no;
    }

    public void insertFilme(Filme_IF filme) {
        if(head == null) {
            head = new Node(filme);
        }
        else {
            Node newNode = new Node(filme);
            newNode.setAnterior(head);
            head.setProximo(newNode);
            head = newNode;
        }
    }

    public NodeHash getAnterior() {
        return anterior;
    }

    public NodeHash getProximo() {
        return proximo;
    }

    public void setAnterior(NodeHash anterior) {
        this.anterior = anterior;
    }

    public void setProximo(NodeHash proximo) {
        this.proximo = proximo;
    }
}
