//package aaInfrastructure;
//
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Font;
//import java.net.URL;
//import javax.swing.BorderFactory;
//import javax.swing.SwingConstants;
//import javax.swing.border.CompoundBorder;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
//
//public abstract class aaAppStyle {
//    
//    // Colores
//    public static final Color COLOR_FONT       = new Color(200, 100, 50); // (218, 8, 40) original comentado
//    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
//    public static final Color COLOR_CURSOR     = Color.black;
//    public static final Color COLOR_BORDER     = Color.lightGray;
//
//    // Fuentes
//    // Nota: En Font.BOLD | Font.PLAIN, el PLAIN es redundante, pero lo dejé como en tu imagen
//    public static final Font FONT       = new Font("JetBrains Mono", Font.PLAIN, 14);
//    public static final Font FONT_BOLD  = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
//    public static final Font FONT_SMALL = new Font("JetBrains Mono", Font.PLAIN | Font.PLAIN, 10);
//
//    // Alineaciones
//    public static final int ALIGNMENT_LEFT   = SwingConstants.LEFT;
//    public static final int ALIGNMENT_RIGHT  = SwingConstants.RIGHT;
//    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;
//
//    // Cursores
//    public static final Cursor CURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
//    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);
//
//    // URLs de Imágenes
//    public static final URL URL_MAIN   = aaAppStyle.class.getResource("/aaUserInterface/aaResourse/Img/IABot.png");
//    public static final URL URL_LOGO   = aaAppStyle.class.getResource("/aaUserInterface/aaResourse/Img/Logo.png");
//
//    // CORREGIDO: De "Splah.png" a "Splash.png" para evitar error NullPointerException
//    public static final URL URL_SPLASH = aaAppStyle.class.getResource("/aaUserInterface/aaResourse/Img/Splash.png");
//    // Método para bordes
//    public static final CompoundBorder createBorderRect(){
//        return BorderFactory.createCompoundBorder(
//            new LineBorder(Color.lightGray),
//            new EmptyBorder(5, 5, 5, 5)
//        );
//    }
//}
//