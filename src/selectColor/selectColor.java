package selectColor;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JTextPane;
import wysiwyg.vista;

/**
 *
 * @author manuel.vargas
 */
public class selectColor {

    public void seleccionarColor(Color selectColor, vista vis, JTextPane jTextPane1) {
        Color jColor = selectColor;
        if ((jColor = JColorChooser.showDialog(vis, "Selecciona el color de la fuente", jColor)) != null) {
            selectColor = jColor;
            jTextPane1.setForeground(selectColor);
        }

    }

}
