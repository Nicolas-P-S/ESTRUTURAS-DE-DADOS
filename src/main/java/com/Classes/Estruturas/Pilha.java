package com.Classes.Estruturas;
import com.Interfaces.Filme_IF;
import com.Interfaces.Pilha_IF;

public class Pilha implements Pilha_IF{
    public ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
    public Node topo;

    public int size(){
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public Filme_IF pop() throws Exception {
        if (isEmpty())
            System.err.println("ERRO: A fila esta vazia!");
        topo = lista.tail.getAnterior();
        return lista.remove(lista.tail().getID());
    }

    @Override
    public void push(Filme_IF elemento) {
        lista.insert(elemento);
        topo = lista.tail;
    }

    @Override
    public Filme_IF top() throws Exception {    
        return this.topo.getValor();
    }

    public void print() {
        if (!isEmpty()){ 
            Node aux = topo;

            while (!aux.isNil()){
                System.out.printf("ID: %d, Nome: %s, Ano: %d, Nota: %d\n",
                aux.getValor().getID(), aux.getValor().getNome(), aux.getValor().getAno(), aux.getValor().getNota());
                aux = aux.getAnterior();
            }
        }
        else{
            System.out.println("ERRO: A fila esta vazia!");
        }
    }
}
