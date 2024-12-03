package com.Classes.IO;

public class Log {
	private static final int MAX_LOG = 5;
	private int length = 0;
	private String[][] log = new String[MAX_LOG + 1][];

    public void addToLog(String operacao, double qtd) {
        int counter = 0;
        if(length < MAX_LOG) {
            for (int i = 0; i < MAX_LOG; i++) {
                if(log[i] == null) {
                    log[i] = new String[2];
                    log[i][0] = operacao;
                    log[i][1] = ("" + qtd);
                    length++;
                    return;
                }
            }
        }
        else {
            for (int i = 0; i < MAX_LOG - 1; i++) {
                log[i] = log[i+1];
                counter = i;
            }
            log[counter + 1] =  new String[2];
            log[counter + 1][0] = operacao;
            log[counter + 1][1] = ("" + qtd);
            length++;
        }
    }


	public void printLog() {
        if(length > 0) {
            System.out.println("[!] " + length + " resultados encontrados.");
            if (length > MAX_LOG) System.out.println("[!] Mostrando os últimos " + (MAX_LOG) + " resultados.");
            for (int i = 0; i <= MAX_LOG; i++) {
                if(log[i] == null) return;
                else System.out.println((i + 1) + ": " + log[i][0] + " - nanotime: " + log[i][1]+ ".");
            }
        }
        else {
            System.out.println("[!] Nenhuma operação encontrada.");
        }
    }
}
