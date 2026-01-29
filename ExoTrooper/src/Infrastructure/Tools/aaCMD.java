package Infrastructure.Tools;

import Infrastructure.aaExoTracer;

public class aaCMD {

    public static void printGood(String msg) {
        String mensaje = "GOOD : " + msg;
        System.out.println(mensaje);
        aaExoTracer.write(mensaje);
    }

    public static void printError(String msg) {
        String mensaje = "ERROR: " + msg;
        System.out.println(mensaje);
        aaExoTracer.write(mensaje);
    }
    
    public static void print(String msg) {
        System.out.println(msg);
        aaExoTracer.write(msg);
    }
}