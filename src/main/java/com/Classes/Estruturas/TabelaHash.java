package com.Classes.Estruturas;

import com.Classes.Filme;
import com.Interfaces.Filme_IF;
import com.Interfaces.TabelaHash_IF;

public class TabelaHash implements TabelaHash_IF{
	private NodeHash head;
	private NodeHash tail;
	private int length;
	private int lengthItens;

	public TabelaHash() {
		head = new NodeHash();
		tail = head;
		length = 0;
	}

	public void crescer(long newMinLength) {
		while (length < newMinLength) {
			addNode();
			length++;
		}
	}

	public int hash(Filme_IF filme) {
		return((int) ((filme.getID()) % (lengthItens + 1)));
	}

	public int hash(long id) {
		return((int) ((id) % (lengthItens + 1)));
	}

	private Node procurarNoNode(NodeHash node, long id) {
		Node aux = node.getFilmes();
		if (aux.getValor().getID() == id) {
			return aux;
		}
		while (aux.getAnterior() != null) {
			if (aux.getAnterior().getValor().getID() == id) {
				return aux.getAnterior();
			}
			aux = aux.getAnterior();
		}
		return null;
	}

	public NodeHash procurarNode(long id) {
		NodeHash aux;
		int index = hash(id);
		if(index <= length/2) {
			aux = tail;
			for(int i = 0; aux.getProximo() != null && i < hash(id); i++) {
				aux = aux.getProximo();
			};
			return aux;
		}
		else {
			aux = head;
			for(int i = length - 1; aux.getAnterior() != null && i > hash(id); i--) {
				aux = aux.getAnterior();
			};
			return aux;
		}
	}

	@Override
	public Filme_IF remove(long id) throws Exception {
		NodeHash node = head;
		Node filmeEncontrado;

		if (id != 1) node = procurarNode(id);
		filmeEncontrado = procurarNoNode(node, id);

		if(filmeEncontrado == null) throw new Exception("Filme não encontrado");
		else {
			if (filmeEncontrado.getAnterior() != null)
				filmeEncontrado.getAnterior().setProximo(filmeEncontrado.getProximo());
			if (filmeEncontrado.getProximo() != null)
				filmeEncontrado.getProximo().setAnterior(filmeEncontrado.getAnterior());
			if (filmeEncontrado == head.getFilmes())
				head.setFilmes(filmeEncontrado.getAnterior());
				tail = head;
			lengthItens--;
			return filmeEncontrado.getValor();
		}
	}

	public void addNode() {
		NodeHash newNode = new NodeHash();
		newNode.setAnterior(head);
		length++;
		head.setProximo(newNode);
		head = newNode;
	}

	@Override
	public void insert(Filme_IF elemento) {
		NodeHash aux = new NodeHash();
		if (hash(elemento) > length) crescer(hash(elemento));
		if(hash(elemento) <= length/2) {
			aux = tail;
			for(int i = 0; aux.getProximo() != null && i < hash(elemento); i++) {
				aux = aux.getProximo();
			};
		}
		else {
			aux = head;
			for(int i = length - 1; aux.getAnterior() != null && i > hash(elemento); i--) {
				aux = aux.getAnterior();
			};
		}
		aux.insertFilme(elemento);
		lengthItens++;
	}

	@Override
	public boolean isEmpty() {
		return (lengthItens == 0);
	}

	@Override
	public Filme_IF search(long id) throws Exception {
		NodeHash node = head;
		Node filmeEncontrado;

		if (id != 1) node = procurarNode(id);
		filmeEncontrado = procurarNoNode(node, id);

		if(filmeEncontrado == null) throw new Exception("Filme não encontrado");
		else {
			return filmeEncontrado.getValor();
		}
	}

	private String printNode(Node node) {
		String linha;
		if (node == null) return "";
		linha = (node.getValor().getID() + ": [" + node.getValor().getNome().substring(0, Math.min(node.getValor().getNome().length(), 10)) + "... (" + node.getValor().getAno() + ")]");
		while (node.getAnterior() != null) {
			node = node.getAnterior();
			linha = linha + (";\n" + node.getValor().getID() + ": [" + node.getValor().getNome().substring(0, Math.min(node.getValor().getNome().length(), 10)) + "... (" + node.getValor().getAno() + ")]");
		};

		return linha;
	}

	@Override
	public String print() {

		if(head == null) return "Nenhum filme encontrado";
		NodeHash aux = head;
		String lista = printNode(aux.getFilmes());
		while (aux.getAnterior() != null) {
			aux = aux.getAnterior();
			if(aux.getFilmes() != null) lista = lista + "\n" + hash(aux.getFilmes().getValor()) + ": " + printNode(aux.getFilmes());
		}
		return lista;
	}

	public String printOrdenado() {
		Filme_IF[]  filmes = new Filme_IF[lengthItens];
		NodeHash aux = head;
		Node aux2 = head.getFilmes();
		int contador = 0;
		String lista = "";

		filmes[contador] = aux2.getValor();
		while (aux2.getAnterior() != null) {
			aux2 = aux2.getAnterior();
			if (aux2.getValor() != null) {
				contador++;
				filmes[contador] = aux2.getValor();
			}
		};		
		while (aux.getAnterior() != null) {
			aux = aux.getAnterior();
			aux2 = aux.getFilmes();
			while (aux2.getAnterior() != null) {
				aux2 = aux2.getAnterior();
				if (aux2.getValor() != null) {
					contador++;
					filmes[contador] = aux2.getValor();
				}
			};	
		}

		quickSort(filmes, 0, filmes.length - 1);
		int id=0;
		for (Filme_IF filme : filmes) {
			id ++;
			lista = lista + id + ": " + filme + "\n";
		}
		return lista;
	}

	public void quickSort(Filme_IF[] array, int comeco, int fim) {
        if (comeco < fim) {
            int pivot = part(array, comeco, fim);
            quickSort(array, comeco, pivot-1);
            quickSort(array, pivot+1, fim);
        }
	}

	private int part(Filme_IF[] array, int comeco, int fim) {
		Filme_IF pivot = array[comeco];
		int i = (comeco+1);
		int j = fim;

		while (i<=j) {
			if (array[i].compareTo(pivot) <= 0) i++;
			else if (array[j].compareTo(pivot) >= 0) j--;
			else swap(array,i,j);
		}
		swap(array,comeco,j);
		return j;
	}

	private void swap(Filme_IF[] array, int pos1, int pos2) {
		Filme_IF aux = new Filme();
		aux = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = aux;
	}
}
