package com.Classes.IO.Submenus;

import java.util.Scanner;

import com.Classes.Filme;
import com.Classes.GeradorFilmes;
import com.Classes.IO.IO;
import com.Classes.IO.Log;
import com.Interfaces.Submenu_IF;

public abstract class Submenu implements Submenu_IF{
	private final int QTD_MAX_FILMES = 1000000;
    Log log;
	double inicio;
	double fim;

	public Submenu() {
		log = new Log();
	}

	protected Filme criarFilme() {
        String nome;
        long id;
        int nota;
        int ano;

        IO.banner();
        System.out.println("[1/4] Digite um nome (-1 para cancelar)");
        nome = IO.strInput(30);
        if (nome == "-1") return null;

        System.out.println("[2/4] Digite um id (-1 para cancelar)");
        id = IO.intInput();
        if (id == -1) return null;

        System.out.println("[3/4] Digite uma nota (-1 para cancelar)");
        nota = IO.intInput(0,5);
        if (nota == -1) return null;

        System.out.println("[3/4] Digite um ano (-1 para cancelar)");
        ano = IO.intInput(0, 2024);
        if (ano == -1) return null;

        return new Filme(id, nome, nota, ano);
    }

    protected Filme[] escolherModo() {
        IO.banner();
        System.out.println("[1/2] Escolha um modo (0 para cancelar)");
        System.out.println("[1]: Gerar filmes automaticamente");
        System.out.println("[2]: Criar filmes manualmente");

        int opcao = IO.intInput(0,2);
        if (opcao == 1) {
            return gerarArrayFilmes();
        }
        else if (opcao == 2) {
            return criarArrayFilmes();
        }
        return null;
    }

    private Filme[] gerarArrayFilmes() {
        IO.banner();
        System.out.println("\n[2/2] Quantos filmes quer gerar?");
        int qtd = IO.intInput(1, QTD_MAX_FILMES);
		inicio();
        Filme[] filmes = GeradorFilmes.gerarFilmes(qtd);
		log.addToLog("gerar", fim());
        return filmes;
    }

    private Filme[] criarArrayFilmes() {
        Scanner sc = new Scanner(System.in);
        IO.banner();
        System.out.println("\n[2/2] Quantos filmes quer criar?");
        int qtd = IO.intInput(1,20);
        Filme[] filmes = new Filme[qtd];
        for (int i = 0; i < qtd; i++) {
            IO.limpar();
            System.out.println("Filme " + (i + 1) + "/" + qtd + ":");
            filmes[i] = new Filme();
            System.out.println("[1/3] Digite o nome do filme:");
            filmes[i].setNome(sc.nextLine());
            System.out.println("[2/3] Digite a nota do filme:");
            filmes[i].setNota(IO.intInput(1,5));
            System.out.println("[3/3] Digite o ano do filme:");
            filmes[i].setAno(IO.intInput(0,2024));
            sc.close();
        }
        return filmes;
    }

	protected void inicio() {
		inicio = System.nanoTime();
	}
	protected double fim() {
		fim = System.nanoTime();
		return fim - inicio;
	}
}
