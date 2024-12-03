package com.Classes.IO.Submenus;

import com.Classes.Filme;
import com.Classes.IO.IO;
import com.Interfaces.Filme_IF;
import com.Classes.Estruturas.ListaDuplamenteEncadeada;
import com.Classes.IO.Log;

public class MenuLDE extends Submenu{
    ListaDuplamenteEncadeada LDE;

    public MenuLDE() {
        LDE = new ListaDuplamenteEncadeada();
    }

    private void inserirFilmesGerados(Filme[] filmes) {
        for (Filme filme : filmes) {
            LDE.insert(filme);
        }
    }

    public void menu() {
        boolean loop = true;
        int id;
        while (loop) {
            IO.banner();
            System.out.println("""
                    \n[!] Escolha uma opção:
                    [1]: Gerar filmes
                    [2]: Ver lista completa de filmes
                    [3]: Remover filme
                    [4]: Procurar filme
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
                    LDE.print();
                    log.addToLog("print LDE", fim());
                    IO.pausar();
                    break;
                case 3:
                    IO.banner();
                    System.out.println("[!] Digite o ID para remover (-1 para cancelar)");
                    id = IO.intInput();
                    if (id != -1) {
                        try {
                            inicio();
                            LDE.remove(id);
                            log.addToLog("remove LDE", fim());
                            IO.banner();
                            System.out.println("[!] Removido com sucesso.");
                        } catch (Exception e) {
                            IO.banner();
                            System.err.println(e.getMessage());
                        }
                    }
                    IO.pausar();
                    break;
                case 4:
                    IO.banner();
                    System.out.println("[!] Digite o ID para procurar (-1 para cancelar)");
                    id = IO.intInput();
                    if (id != -1) {
                        try {
                            inicio();
                            Filme_IF filmeAchado = LDE.search(id);
                            log.addToLog("search LDE", fim());
                            IO.banner();
                            System.out.println("[-] " + filmeAchado.toString());
                        } catch (Exception e) {
                            IO.banner();
                            System.err.println(e.getMessage());
                        }
                    }
                    IO.pausar();
                    break;
                case 5:
                    Filme_IF novoFilme = criarFilme();
                    if (novoFilme != null) {
                        inicio();
                        LDE.insert(novoFilme);
                        log.addToLog("insert LDE", fim());
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
