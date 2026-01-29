package Infrastructure.Tools;

import java.util.Scanner;
//Refactorización

public class aaCMDInput {
    
    private static Scanner sc = new Scanner(System.in);

    public static String read(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
    
    public static String readString(String msg) {
        System.out.print(" ➤ " + msg + ": ");
        return sc.nextLine();
    }

    public static int readNumber(String msg) {
        int numero = 0;
        boolean entradaValida = false;
        
        do {
            System.out.print(" ➤ " + msg + ": ");
            try {
                String input = sc.nextLine();
                numero = Integer.parseInt(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                aaCMD.printError("¡Error! Debes ingresar un número válido.");
            }
        } while (!entradaValida);
        
        return numero;
    }

    public static boolean readBoolean(String msg) {
        System.out.print(" ➤ " + msg + " (S/N): ");
        String input = sc.nextLine().trim().toLowerCase();
        return input.equals("s") || input.equals("si") || input.equals("y");
    }
}