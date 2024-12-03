package com.Classes.IO;

import com.Classes.IO.Submenus.*;

public class Menu{
	boolean loop = true;
	Submenu submenu;
	public void menu() {
		while (loop) {
			IO.banner();
			System.out.println("""
                \n[!] Escolha uma estrutura:
                [1]: Arvore Binaria de Pesquisa
                [2]: Fila
                [3]: Lista Duplamente Encadeada
                [4]: Pilha
                [5]: Tabela hash
                [6]: Sair
                """);
			switch (IO.intInput(1,6)) {
				case 1:
					submenu = new MenuBST();
					submenu.menu();
					break;
				case 2:
					submenu = new MenuFila();
					submenu.menu();
					break;		
				case 3:
					submenu = new MenuLDE();
					submenu.menu();
					break;	
				case 4:
					submenu = new MenuPilha();
					submenu.menu();
					break;	
				case 5:
					submenu = new MenuTabelaHash();
					submenu.menu();
					break;	
				default:
				if (IO.confirmacao("[!] Deseja mesmo sair?")) return;
                	break;
			}
		}
	}
}