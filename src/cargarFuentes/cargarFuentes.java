package cargarFuentes;

import java.awt.GraphicsEnvironment;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author manuel.vargas
 */
public class cargarFuentes {
    
    public void loadFont(JComboBox jcbFont) {
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = gEnv.getAvailableFontFamilyNames();
        ComboBoxModel model = new DefaultComboBoxModel(fontNames);
        jcbFont.setModel(model);
    }
    
}
