package com.Classes.Estruturas;

import com.Interfaces.Fila_IF;
import com.Interfaces.Filme_IF;

public class Fila implements Fila_IF{
    Pilha pilha1 = new Pilha();
    Pilha pilha2 = new Pilha();

    @Override
    public Filme_IF dequeue() throws Exception {
        if (pilha1.isEmpty()){
            throw new Exception("ERRO: A fila esta vazia!");
        }
        
        else{
            Node aux = pilha1.topo;

            while(!aux.isNil()){
                pilha2.push(aux.getValor());
                pilha1.pop();
                aux = aux.getAnterior();
            }
            Filme_IF retorno = pilha2.pop();

            if (!pilha2.isEmpty()){
                aux = pilha2.lista.tail;

                while (!aux.isNil()){
                    pilha1.push(aux.getValor());
                    pilha2.pop();
                    aux = aux.getAnterior();
                }
            }
            return retorno;
        }
    }

    @Override
    public void enqueue(Filme_IF elemento) {
        pilha1.push(elemento);
    }

    @Override
    public Filme_IF head() throws Exception {
        if (pilha1.isEmpty()){
            throw new Exception("ERRO: A fila esta vazia!");
        }
        else{
            return pilha1.lista.head();
        }
    }

    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty();
    }

    public void imprimir() {
        if (!pilha1.isEmpty()){
            Node aux = pilha1.topo;

            while(!aux.getAnterior().isNil()){
                System.out.printf(" %s -",aux.getValor().getNome());
                aux = aux.getAnterior();
            }
            System.out.printf(" %s.\n",aux.getValor().getNome());
        }
        else{
            System.out.println("ERRO: A fila esta vazia!");
        }
    }

    public void imprimirOrdenado() throws Exception {
        if (isEmpty()) {
            System.out.println("ERRO: A fila está vazia!");
            return;
        }

        Pilha pilhaAuxiliar = new Pilha();
        Node aux = pilha1.topo;

        while (!aux.isNil()) {
            pilhaAuxiliar.push(aux.getValor());
            aux = aux.getAnterior();
        }

        Filme_IF[] filmes = new Filme_IF[pilhaAuxiliar.size()];
        int index = 0;
    
        while (!pilhaAuxiliar.isEmpty()) {
            filmes[index++] = pilhaAuxiliar.pop();
        }
    
        for (int i = 0; i < filmes.length - 1; i++) {
            for (int j = 0; j < filmes.length - 1 - i; j++) {
                if (filmes[j].getID() > filmes[j + 1].getID()) {
                    Filme_IF temp = filmes[j];
                    filmes[j] = filmes[j + 1];
                    filmes[j + 1] = temp;
                }
            }
        }
    
        for (Filme_IF filme : filmes) {
            System.out.printf("ID: %d, Nome: %s, Ano: %d, Nota: %d\n",
                    filme.getID(), filme.getNome(), filme.getAno(), filme.getNota());
        }
        System.out.println();
    }
    
}
