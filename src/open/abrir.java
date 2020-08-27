package open;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;
import wysiwyg.vista;

/**
 *
 * @author manuel.vargas
 */
public class abrir {

    private String NombreArchivo;
    
    public String getNombreArchivo(){
    return NombreArchivo;
    }
    
    public void setNombreArchivo(String NombreArchivo){
    this.NombreArchivo = NombreArchivo;
    }
    
    public void openFile(vista vis, JTextPane jTextPane1) throws FileNotFoundException, IOException, BadLocationException {
        JFileChooser file = new JFileChooser();
        String fileName = "";

        if (file.showOpenDialog(vis) == JFileChooser.APPROVE_OPTION) {
            fileName = file.getSelectedFile().getAbsolutePath();
            setNombreArchivo(fileName);
        } else {
            return;
        }
        RTFEditorKit rtf = new RTFEditorKit();
        try {
            try (FileInputStream fi = new FileInputStream(fileName)) {
                jTextPane1.setText(null);
                rtf.read(fi, jTextPane1.getDocument(), 0);
            }
        } catch (IOException | BadLocationException e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
