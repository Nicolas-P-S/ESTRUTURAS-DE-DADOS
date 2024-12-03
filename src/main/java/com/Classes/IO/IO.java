package com.Classes.IO;

import java.util.Scanner;

public class IO {
	public static String strInput(int maxChar) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String str = "";
        while(loop) {
            System.out.print("=> ");
            str = sc.nextLine();
            System.out.println();
            if(str.length() > maxChar) System.err.println("[!] Precisa ter mais de " + maxChar + " caracteres.");
            else return str;
        }
        return str;
    }

	public static int intInput() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("[!] Precisa ser um número");
            }
            sc.nextLine();
        } while (true);
    }
	
    public static int intInput(int min, int max) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("=> ");
                int input = sc.nextInt();
                System.out.println();
                if ((input < min) || (input > max)) System.err.println("[!] Precisa ter entre " + min + " e " + max + ".");
                else return input;
            } catch (Exception e) {
                System.out.println("[!] Precisa ser um número");
            }
            sc.nextLine();
        } while (true);
    }

	public static boolean confirmacao(String message) {
        System.out.println(message +" (S/N)");
        String input = strInput(10);
        try {
            return (input.toLowerCase().charAt(0) == 's');
        } catch (IndexOutOfBoundsException e) {
            return true;
        } catch (Exception exception) {
            System.out.println("[X]: " + exception.getMessage());
            return false;
        } 
    }

	public static void pausar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPressione enter para continuar...");
        try {
            sc.nextLine();
        } catch (Exception e) {
            limpar();
        }
        limpar();
    }
	public static void limpar() {
		try {	
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception E) {
			System.out.println("\033[H\033[2J");
		}
    }

    public static void banner() {
        limpar();
        System.out.println("""         
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█▄▄░█░█▄▄░█░░░█░█▀█░█▀▀░█░█░░░█▀▄▀█░█▀▀ █▀░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█▄█░█░█▄█░█▄▄░█░█▄█░█▀░░█░█▄▄░█░▀░█░██▄░▄█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                """);
    }
}
