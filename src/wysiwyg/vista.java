package wysiwyg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author manuel.vargas
 */
public class vista extends javax.swing.JFrame {

    Color selectColor = null;

    /**
     * Creates new form vista
     */
    public vista() {
        initComponents();
        cerrar();
        loadFont();
    }

    private void loadFont() {
        GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // get all font name&amp;amp;amp;amp;nbsp;
        String[] fontNames = gEnv.getAvailableFontFamilyNames();
        // load to combobox
        ComboBoxModel model = new DefaultComboBoxModel(fontNames);
        jcbFont.setModel(model);
    }

    public void cerrar() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                validarCierre();
            }
        });
    }

    public void validarCierre() {

        if (jTextPane1.getText().length() > 0) {
            int resp;

            resp = JOptionPane.showConfirmDialog(rootPane, "¿DESEA GUARDAR EL ARCHIVO?", "NO SE HA GUARDADO EL ARCHIVO", JOptionPane.INFORMATION_MESSAGE);

            if (resp == JOptionPane.YES_OPTION) {
                guardar();
            }
        }
    }

    private void guardar() {
        JFileChooser file = new JFileChooser();
        String fileName = "";
        // show save file dialog
        if (file.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            // get full path of selected file
            fileName = file.getSelectedFile().getAbsolutePath();
            // get meta of text
            StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
            // convert to richtext format
            RTFEditorKit kit = new RTFEditorKit();
            BufferedOutputStream out;
            try {
                out = new BufferedOutputStream(new FileOutputStream(fileName + ".doc"));
                // save content to file
                kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
                out.flush();
                out.close();
            } catch (Exception e) {
                System.out.println("Err:" + e.toString());
            }

        } else {
            return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbFont = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcbSelectSize = new javax.swing.JComboBox<>();
        btnColor = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnOpen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FUENTE");

        jcbFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFontActionPerformed(evt);
            }
        });

        jLabel2.setText("TAMAÑO");

        jcbSelectSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56", "58" }));
        jcbSelectSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSelectSizeActionPerformed(evt);
            }
        });

        btnColor.setIcon(new javax.swing.ImageIcon("C:\\Users\\manuel.vargas\\Documents\\WYSIWYG\\img\\color.png")); // NOI18N
        btnColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnColorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnColorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnColorMouseExited(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon("C:\\Users\\manuel.vargas\\Documents\\WYSIWYG\\img\\SAVE.png")); // NOI18N
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });

        btnOpen.setIcon(new javax.swing.ImageIcon("C:\\Users\\manuel.vargas\\Documents\\WYSIWYG\\img\\OPEN.png")); // NOI18N
        btnOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOpenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOpenMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnColor)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jcbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbSelectSize, 0, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOpen)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSave)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcbSelectSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jcbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(btnColor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbSelectSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSelectSizeActionPerformed
        // Select size of text
        String getSize = jcbSelectSize.getSelectedItem().toString();
        Font f = jTextPane1.getFont();
// setting new size
        jTextPane1.setFont(new Font(f.getFontName(),
                f.getStyle(), Integer.parseInt(getSize)));
    }//GEN-LAST:event_jcbSelectSizeActionPerformed

    private void jcbFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFontActionPerformed
        // Change font of text
        jTextPane1.setFont(new Font(jcbFont.getSelectedItem().toString(),
                Font.PLAIN, Integer.parseInt(jcbSelectSize.getSelectedItem().toString())));
    }//GEN-LAST:event_jcbFontActionPerformed

    private void btnColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnColorMouseClicked
        Color jColor = selectColor;
        // open color dialog and select Color
        if ((jColor = JColorChooser.showDialog(this, "Select color", jColor)) != null) {
            selectColor = jColor;
            // set text color
            jTextPane1.setForeground(selectColor);
        }
    }//GEN-LAST:event_btnColorMouseClicked

    private void btnColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnColorMouseEntered
        btnColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 116, 143)));
    }//GEN-LAST:event_btnColorMouseEntered

    private void btnColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnColorMouseExited
        btnColor.setBorder(null);
    }//GEN-LAST:event_btnColorMouseExited

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        guardar();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseClicked
        JFileChooser file = new JFileChooser();
        String fileName = "";
// show open file dialog
        if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            fileName = file.getSelectedFile().getAbsolutePath();
        } else {
            return;
        }
// using richtext format
        RTFEditorKit rtf = new RTFEditorKit();
        try {
// load file into jTextPane
            FileInputStream fi = new FileInputStream(fileName);
            rtf.read(fi, jTextPane1.getDocument(), 0);
            fi.close();
        } catch (Exception e) {
            System.out.println("err:" + e.toString());
        }
    }//GEN-LAST:event_btnOpenMouseClicked

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered

        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 116, 143)));

    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnOpenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseEntered
        btnOpen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(66, 116, 143)));
    }//GEN-LAST:event_btnOpenMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        btnSave.setBorder(null);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnOpenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseExited
        btnOpen.setBorder(null);
    }//GEN-LAST:event_btnOpenMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnColor;
    private javax.swing.JLabel btnOpen;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JComboBox<String> jcbFont;
    private javax.swing.JComboBox<String> jcbSelectSize;
    // End of variables declaration//GEN-END:variables
}
