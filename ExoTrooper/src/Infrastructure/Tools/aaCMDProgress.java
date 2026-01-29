package Infrastructure.Tools;
//Refactorización


public class aaCMDProgress {

    private aaCMDProgress() {}
    
    public static void showSpinner() {
        String c = "|/-\\|"; 
        for (int x = 0; x <= 100; x++) {
            String srt = "\r " + c.charAt(x % c.length()) + " Cargando módulos... " + x + " % ";
            System.out.print(srt);
            try {
                Thread.sleep(30); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); 
    }

    public static void showBar(String caracter) throws InterruptedException {
        int sizeBar = 30; // Tamaño visual de la barra
        System.out.println("Iniciando secuencia de carga...");

        for (int i = 0; i <= 100; i++) {
            int nroChar = i * sizeBar / 100;  
            
            String bar = "\r[" 
                    + caracter.repeat(nroChar)      // Parte llena
                    + " ".repeat(sizeBar - nroChar) 
                    + "] " + i + " %";
            
            System.out.print(bar);
            Thread.sleep(20); 
        }
        System.out.println("\n¡Carga completa!");
    }

    public static String progressBar(int progressBarSize, long currentPosition, long startPosition, long finishPosition) {
        char charLleno = '█';
        char charVacio = '░';
        StringBuilder bar = new StringBuilder();
        
        int nPositions = progressBarSize;

        for (int p = 0; p < nPositions; p++)
            bar.append(charVacio);

        int status = (int) (100 * (currentPosition - startPosition) / (finishPosition - startPosition));
        int move = (nPositions * status) / 100;
        
        String visual = "[" 
            + bar.substring(0, move).replace(charVacio, charLleno) 
            + bar.substring(move, bar.length())                    
            + "] " + status + "%";
            
        return visual;
    }
}