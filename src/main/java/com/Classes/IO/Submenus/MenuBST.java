package com.Classes.IO.Submenus;

import com.Classes.Filme;
import com.Classes.IO.IO;
import com.Interfaces.Filme_IF;
import com.Classes.Estruturas.BST;
import com.Classes.IO.Log;

public class MenuBST extends Submenu{
    BST bst;

    public MenuBST() {
        bst = new BST();
    }

    private void inserirFilmesGerados(Filme[] filmes) {
        for (Filme filme : filmes) {
            bst.insert(filme);
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
                    bst.imprimirOrdenado();
                    log.addToLog("print BST", fim());
                    IO.pausar();
                    break;
                case 3:
                    IO.banner();
                    System.out.println("[!] Digite o ID para remover (-1 para cancelar)");
                    id = IO.intInput();
                    if (id != -1) {
                        try {
                            inicio();
                            bst.remove(id);
                            log.addToLog("remove BST", fim());
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
                            Filme_IF filmeAchado = bst.search(id);
                            log.addToLog("search BST", fim());
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

                        bst.insert(novoFilme);
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
                    return;
            }
        }
    }
}
