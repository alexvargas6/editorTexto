package save;

import java.awt.HeadlessException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import wysiwyg.vista;

/**
 *
 * @author manuel.vargas
 */
public class guardar {

    public String saveAs(JTextPane jTextPane1, vista vis) {

        JFileChooser file = new JFileChooser();

        String fileName = "";

        if (file.showSaveDialog(vis) == JFileChooser.APPROVE_OPTION) {

            fileName = file.getSelectedFile().getAbsolutePath();

            StyledDocument doc = (StyledDocument) jTextPane1.getDocument();

            RTFEditorKit kit = new RTFEditorKit();
            BufferedOutputStream out;
            try {
                out = new BufferedOutputStream(new FileOutputStream(fileName + ".doc"));

                kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
                out.flush();
                out.close();
                JOptionPane.showMessageDialog(jTextPane1, "Archivo guardado", "OPERACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | BadLocationException | HeadlessException e) {
                System.out.println("Err:" + e.toString());
            }

        }
    return fileName;}

    public void save(JTextPane jTextPane1, String fileName) {

        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();

        RTFEditorKit kit = new RTFEditorKit();
        BufferedOutputStream out;
        try {
            out = new BufferedOutputStream(new FileOutputStream(fileName));

            kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
            out.flush();
            out.close();
            JOptionPane.showMessageDialog(jTextPane1, "Archivo guardado", "OPERACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | BadLocationException | HeadlessException e) {
            System.out.println("Err:" + e.toString());
        }
    }

}
