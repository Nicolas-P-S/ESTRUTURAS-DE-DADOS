package com.Classes;

import java.util.Random;

public class GeradorFilmes {
	public static Filme[] gerarFilmes(int qtd) {
		Filme[] filmes;
		Random random = new Random();
		filmes = new Filme[qtd];

		String[] comeco = {"Buscando ", "Procurando ", "O bom ", "The good ", "A odisséia de ", "Crônicas de ",  "A lista de ", "O silêncio do ", "The ", "Procurando ", "The Great ", "O Fabuloso Destino de ", "Dungeons e ", "O revólver de ", "Velozes e ", "Debi e ", "O psicopata ", "Dr. ", "A redenção de ", "O último ", "O bom, o mau e o ", "Meu nome é ", "Ao resgate do soldado ", "O poderoso " , "Turma do ", "Triste fim de ", "O drama de ", "A vida ordinária do ", "Todo mundo odeia o ", "Aventuras de ", "O grande ", "Missão Impossível: ", "", "O Sindicato do ", "A Bela e o ", "Bonnie e ", "O ", "50 tons de ", "Breaking ", "Esquadrão "};
		String[] meio = {"Fulano", "Estudante", "Batman", "Estranho", "Chaves", "Shrek", "Harry Potter", "Cicrano", "Deltrano", "Ben10", "Kayky", "Nicolas", "Gabriel", "Matheus", "Renan", "Fernando", "Pedro Henrique", "Augusto", "Janderson", "Pedro Henrique", "Oppenheimer", "Chris" , "James Bond", "Clyde", "Godfather", "Homem-Aranha", "Loid", "Janderson"};
		String[] fim = {" - Continuação.", ".",".",".",".",".",".",".",".",".",".", " - O Filme.", " - O retorno ", " Parte II", " 2", " 3", " - Ultimato.", " na aula de EDA. ", " em DVD", " Full HD", " - Um filme", " - Clássico", " 4k", " Remasterizado", " Remake"};

		for (int i=0; i<qtd; i++) {
			int id = i+1;
			String nome = comeco[random.nextInt(comeco.length)] + meio[random.nextInt(meio.length)] + fim[(random.nextInt(fim.length))];
			int ano = random.nextInt(2025 - 1950) + 1950;
			int nota = random.nextInt(5)  +1;
			//System.out.println(nome + ":" + ano + ", " + nota);
			filmes[i] = new Filme(id, nome, nota, ano);
		}

		return filmes;
	}
}
