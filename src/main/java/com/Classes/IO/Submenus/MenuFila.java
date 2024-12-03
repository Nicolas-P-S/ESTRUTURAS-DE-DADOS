package com.Classes.IO.Submenus;

import com.Classes.Filme;
import com.Classes.IO.IO;
import com.Interfaces.Filme_IF;
import com.Classes.Estruturas.Fila;
import com.Classes.IO.Log;

public class MenuFila extends Submenu{
    Fila fila;

    public MenuFila() {
        fila = new Fila();
    }

    private void inserirFilmesGerados(Filme[] filmes) {
        for (Filme filme : filmes) {
            fila.enqueue(filme);
        }
    }

    public void menu() {
        boolean loop = true;
        while (loop) {
            IO.banner();
            System.out.println("""
                    \n[!] Escolha uma opção:
                    [1]: Gerar filmes
                    [2]: Ver lista completa de filmes
                    [3]: Remover primeiro filme
                    [4]: Ver lista ordenada de filmes
                    [5]: Adicionar filme
                    [6]: Ver histórico de operações
                    [7]: Limpar histórico de operações
                    [8]: Sair
                    """);
            switch (IO.intInput(1,9)) {
                case 1 :
                    Filme[] filmes = escolherModo();
                    if (filmes != null) {
                        inserirFilmesGerados(filmes);
                        IO.banner();
                        System.out.println("[!] Filmes gerados com sucesso!");
                    }
                    IO.pausar();
                    break;
                case 2:
                    IO.banner();
                    inicio();
                    try{
                    fila.imprimirOrdenado();
                    }catch (Exception e) {
                        System.err.println(e);
                    }
                    log.addToLog("print Fila", fim());
                    IO.pausar();
                    break;
                case 3:
                    IO.banner();
                    try {
                        inicio();
                        fila.dequeue();
                        log.addToLog("dequeue Fila", fim());
                        IO.banner();
                        System.out.println("[!] Removido com sucesso.");
                    } catch (Exception e) {
                        IO.banner();
                        System.err.println(e.getMessage());
                    }
                    IO.pausar();
                    break;
                case 4:
                    IO.banner();
                    try {
                        IO.banner();
                        fila.imprimirOrdenado();
                    } catch (Exception e) {
                        IO.banner();
                        System.err.println(e.getMessage());
                    }
                    IO.pausar();
                    break;
                case 5:
                    Filme_IF novoFilme = criarFilme();
                    if (novoFilme != null) {
                        inicio();
                        fila.enqueue(novoFilme);
                        log.addToLog("enqueue Fila", fim());
                        IO.banner();
                        System.out.println("[!] Filme adicionado com sucesso. ");
                    }
                    IO.pausar();
                    break;
                case 6:
                    IO.banner();
                    log.printLog();
                    IO.pausar();
                    break;
                case 7:
                    IO.banner();
                    log = new Log();
                    System.out.println("[!] Registros apagados com sucesso!");
                    IO.pausar();
                    break;
                default:
                    if (IO.confirmacao("[!] Deseja mesmo sair?")) return;
                    break;
            }
        }
    }
}
