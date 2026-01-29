package Infrastructure;

import javax.swing.JOptionPane;

public class aaAppMSG {
    public static final void show(String msg){
        JOptionPane.showMessageDialog(null, msg, "🤖 ExoTrooper :: Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static final void showError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 ExoTrooper :: Error", JOptionPane.ERROR_MESSAGE);
    }

    public static final boolean showConfirmYesNo(String msg){
        int respuesta = JOptionPane.showConfirmDialog(null, msg, "🤖 ExoTrooper :: Confirmar", JOptionPane.YES_NO_OPTION);
        return (respuesta == JOptionPane.YES_OPTION);
    }
}