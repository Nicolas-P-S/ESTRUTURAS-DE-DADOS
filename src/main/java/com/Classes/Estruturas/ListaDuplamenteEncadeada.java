package com.Classes.Estruturas;

import com.Interfaces.Filme_IF;
import com.Interfaces.Lista_IF;

public class ListaDuplamenteEncadeada implements Lista_IF {
    protected Node head = new Node(null);
    protected Node tail = new Node(null);

    @Override
    public Filme_IF remove(long id) throws Exception {
        if (isEmpty()) {
            System.err.println("ERRO: A fila esta vazia");
            return null;
        }

        Node aux = head;
        while (!aux.isNil()) {
            if (aux.getValor().getID() == id) {
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
                if (aux == head) {
                    head = aux.getProximo();
                }
                if (aux == tail) {
                    tail = aux.getAnterior();
                }
                return aux.getValor();
            }
            aux = aux.getProximo();
        }
        throw new Exception("ERRO: ID nao encontrado");
    }

    @Override
    public void insert(Filme_IF elemento) {
        Node novoNo = new Node(elemento);
        if (isEmpty()){
            novoNo.setAnterior(head);
            novoNo.setProximo(tail);
            head.setProximo(novoNo);
            tail.setAnterior(novoNo);
            head = novoNo;
        }
        else{
            novoNo.setAnterior(tail);
            novoNo.setProximo(tail.getProximo());
            tail.setProximo(novoNo);
        }
        tail = novoNo;
    }

    @Override
    public boolean isEmpty() {
        return head.isNil();
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (head.isNil()) {
            throw new Exception("ERRO: ID não encontrado");
        }

        Node aux = head;
        while (!aux.isNil()) {
            if (aux.getValor().getID() == id) {
                return aux.getValor();
            }
            aux = aux.getProximo();
        }
        throw new Exception("ERRO: ID não encontrado");
    }

    @Override
    public Filme_IF head() throws Exception {
        return head.getValor();
    }

    @Override
    public Filme_IF tail() throws Exception {
        return tail.getValor();
    }

    @Override
    public int size() {
        int count = 0;
        Node aux = head;
    
        while (aux != null && !aux.isNil()) {
            count++;
            aux = aux.getProximo();
        }
    
        return count;
    }

    public void print() {
        if (!isEmpty()){
            Node aux = head;

            while (!aux.isNil()){
                System.out.printf("ID: %d, Nome: %s, Ano: %d, Nota: %d\n",
                aux.getValor().getID(), aux.getValor().getNome(), aux.getValor().getAno(), aux.getValor().getNota());
                aux = aux.getProximo();
            }
        }
        else{
            System.out.println("ERRO: A fila esta vazia!");
        }
    }
}
