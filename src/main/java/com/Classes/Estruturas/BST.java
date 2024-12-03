package com.Classes.Estruturas;
import com.Interfaces.BST_IF;
import com.Interfaces.Filme_IF;

public class BST implements BST_IF{
    private NodeBST raiz = new NodeBST(null);

    @Override
    public int height() {
        if (isEmpty())
            return -1;
        return height(raiz);
    }
    
    private int height(NodeBST no) {
        if (no.isNil()) {
            return 0;
        }
    
        int alturaEsquerda = height(no.getEsquerda());
        int alturaDireita = height(no.getDireita());
    
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
    
    @Override
    public void insert(Filme_IF elemento) {
        NodeBST parent = null;
        NodeBST aux = raiz;
    
        while (!aux.isNil()) {
            parent = aux;
            if (elemento.getID() < aux.getValor().getID())
                aux = aux.getEsquerda();
            else 
                aux = aux.getDireita();
        }

        NodeBST novoNo = new NodeBST(elemento);
        NodeBST nilE = new NodeBST(null);
        NodeBST nilD = new NodeBST(null);

        novoNo.setEsquerda(nilE);
        novoNo.setDireita(nilD);
    
        if (this.isEmpty())
            this.raiz = novoNo;
        else if (elemento.getID() < parent.getValor().getID())
            parent.setEsquerda(novoNo);
        else
            parent.setDireita(novoNo);
    }
    
    @Override
    public boolean isComplete() {
        int totalNos = countNos(raiz);
        return isComplete(raiz, 0, totalNos);
    }
    
    private int countNos(NodeBST no) {
        if (no.isNil()) {
            return 0;
        }
        return 1 + countNos(no.getEsquerda()) + countNos(no.getDireita());
    }
    
    private boolean isComplete(NodeBST no, int indice, int totalNos) {
        if (no.isNil()) {
            return true;
        }

        if (indice >= totalNos) {
            return false;
        }

        return isComplete(no.getEsquerda(), 2 * indice + 1, totalNos) && isComplete(no.getDireita(), 2 * indice + 2, totalNos);
    }   

    @Override
    public boolean isEmpty() {
        return raiz.isNil();
    }

    @Override
    public Filme_IF[] order() {
        Filme_IF[] resultado = new Filme_IF[size()];
        int indice = 0;
        order(raiz, resultado, indice);
        return resultado;
    }
    
    private int order(NodeBST no, Filme_IF[] resultado, int indice) {
        if (no.isNil()) {
            return indice;
        }
        indice = order(no.getEsquerda(), resultado, indice);
        resultado[indice++] = no.getValor();
        indice = order(no.getDireita(), resultado, indice);
        return indice;
    }
    
    @Override
    public Filme_IF[] postOrder() {
        Filme_IF[] resultado = new Filme_IF[size()];
        int indice = 0;
        postOrder(raiz, resultado, indice);
        return resultado;
    }
    
    private int postOrder(NodeBST no, Filme_IF[] resultado, int indice) {
        if (no.isNil()) {
            return indice;
        }
        indice = postOrder(no.getEsquerda(), resultado, indice);
        indice = postOrder(no.getDireita(), resultado, indice);
        resultado[indice++] = no.getValor();
        return indice;
    }
    
    @Override
    public Filme_IF[] preOrder() {
        Filme_IF[] resultado = new Filme_IF[size()];
        int indice = 0;
        preOrder(raiz, resultado, indice);
        return resultado;
    }
    
    private int preOrder(NodeBST no, Filme_IF[] resultado, int indice) {
        if (no.isNil()) {
            return indice;
        }
        resultado[indice++] = no.getValor();
        indice = preOrder(no.getEsquerda(), resultado, indice);
        indice = preOrder(no.getDireita(), resultado, indice);
        return indice;
    }
    
    @Override
    public Filme_IF remove(long id) throws Exception {
        NodeBST parent = null;
        NodeBST aux = raiz;
    
        if (isEmpty()){
            throw new Exception();
        }

        while (aux != null && !aux.isNil() && aux.getValor().getID() != id) {
            parent = aux;
            if (id < aux.getValor().getID()) { 
                aux = aux.getEsquerda();
            } else {
                aux = aux.getDireita();
            }
        }
    
        if (aux.isNil()) {
            System.err.println("Nó não encontrado");
            return null;
        }
    
        Filme_IF filmeRemovido = aux.getValor();
    
        // Caso 1: Nó é uma folha
        if (aux.getEsquerda().isNil() && aux.getDireita().isNil()) {
            if (aux == raiz)
                raiz = new NodeBST(null);
            else if (parent.getEsquerda() == aux)
                parent.setEsquerda(new NodeBST(null));
            else
                parent.setDireita(new NodeBST(null));
        }
        // Caso 2: Nó com apenas um filho a direita
        else if (aux.getEsquerda().isNil()) {
            if (aux == raiz)
                raiz = aux.getDireita();
            else if (parent.getEsquerda() == aux)
                parent.setEsquerda(aux.getDireita());
            else
                parent.setDireita(aux.getDireita());
        }
        // Caso 3: Nó com apenas um filho a esquerda
        else if (aux.getDireita().isNil()) {
            if (aux == raiz)
                raiz = aux.getEsquerda();
            else if (parent.getEsquerda() == aux)
                parent.setEsquerda(aux.getEsquerda());
            else
                parent.setDireita(aux.getEsquerda());
        }
        // Caso 4: Nó com dois filhos
        else {
            NodeBST sucessorParent = aux;
            NodeBST sucessor = aux.getDireita();
    
            while (!sucessor.getEsquerda().isNil()) {
                sucessorParent = sucessor;
                sucessor = sucessor.getEsquerda();
            }
    
            aux.setValor(sucessor.getValor());
    
            if (sucessorParent.getEsquerda() == sucessor)
                sucessorParent.setEsquerda(sucessor.getDireita());
            else
                sucessorParent.setDireita(sucessor.getDireita());
        }
        return filmeRemovido;
    }
    
    @Override
    public Filme_IF root() throws Exception {
        if (isEmpty()){
            throw new Exception();
        }
        return raiz.getValor();
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (this.isEmpty()){
            throw new Exception();
        }

        NodeBST aux = raiz;

        while (!aux.isNil()){
            if (aux.getValor().getID() == id)
                return aux.getValor();

            else if(aux.getValor().getID() < id)
                aux = aux.getDireita();

            else if(aux.getValor().getID() > id)
                aux = aux.getEsquerda();
        }
        throw new Exception("id não encontrado!");
    }

    @Override
    public int size() {
        if (raiz.isNil()) {
            return 0;
        }
        return size(raiz);
    }
    
    private int size(NodeBST no) {
        if (no.isNil()) {
            return 0;
        }
        return 1 + size(no.getEsquerda()) + size(no.getDireita());
    }

    public void imprimirOrdenado() {
        if (raiz == null) {
            System.out.println("A árvore está vazia!");
        } else {
            imprimirEmOrdem(raiz);
        }
    }

    private void imprimirEmOrdem(NodeBST no) {
        if (!no.isNil()) {
            imprimirEmOrdem(no.getEsquerda());
            
            Filme_IF filme = no.getValor();
            System.out.printf("ID: %d, Nome: %s, Ano: %d, Nota: %d\n",
                    filme.getID(), filme.getNome(), filme.getAno(), filme.getNota());
            
            imprimirEmOrdem(no.getDireita());
        }
    }
}