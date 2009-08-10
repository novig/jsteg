package codeimage;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Frame extends javax.swing.JFrame {

    String name;
    ChangeImage ch;

    public Frame() {
        initComponents();
        ch = null;
        name = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImage = new javax.swing.JLabel();
        jLabelCode = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuGetCode = new javax.swing.JMenu();
        jMenuItemCode = new javax.swing.JMenuItem();
        jMenuItemGetCode = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItemOpen.setText("Open Image");
        jMenuItemOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemOpenMousePressed(evt);
            }
        });
        jMenu1.add(jMenuItemOpen);

        jMenuItemSave.setText("Save Image");
        jMenuItemSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemSaveMousePressed(evt);
            }
        });
        jMenu1.add(jMenuItemSave);

        jMenuItemExit.setText("Exit");
        jMenuItemExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemExitMousePressed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        jMenuGetCode.setText("Edit");

        jMenuItemCode.setText("Write Code");
        jMenuItemCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemCodeMousePressed(evt);
            }
        });
        jMenuGetCode.add(jMenuItemCode);

        jMenuItemGetCode.setText("Get Code");
        jMenuItemGetCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemGetCodeMousePressed(evt);
            }
        });
        jMenuGetCode.add(jMenuItemGetCode);

        jMenuBar1.add(jMenuGetCode);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelCode, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelCode, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItemOpenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemOpenMousePressed
        FileDialog fd = new FileDialog(this, "New Image");
        fd.setVisible(true);
        name = fd.getFile();
        String dir = fd.getDirectory();
        name = dir + name;
        if (name == null) {
            return;
        }
        Image img = null;
        try {
            img = ImageIO.read(new File(name));
        } catch (IOException e) {
        }
        try {
            ch = new ChangeImage(name);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(img);
        jLabelImage.setIcon(icon);
        jLabelCode.setText("");

}//GEN-LAST:event_jMenuItemOpenMousePressed

    private void jMenuItemExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExitMousePressed
        System.exit(0);
}//GEN-LAST:event_jMenuItemExitMousePressed

    private void jMenuItemCodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCodeMousePressed
        CodeDialog dlg = new CodeDialog(this, true);
        dlg.setVisible(true);
         if ((dlg.code==null)||(dlg.value == null))
                return;
        int c = Integer.parseInt(dlg.code);
        int value = Integer.parseInt(dlg.value);
        int size = ch.height*ch.width/15;
        int code[] = new int[size];
        for (int i = 0; i < size; i++) {
            code[i] = c;
        }
        try {
            ch.writeCodeToImage(code, value);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image img = null;
        int data[] = new int[ch.height * ch.width];
        int index = 0;
        for (int j = 0; j < ch.height; j++) {
            for (int i = 0; i < ch.width; i++) {
                data[ch.width * (ch.height - j - 1) + i] =
                        (255 & 0xff) << 24 | (((int) ch.rgb[index + 2] & 0xff) << 16) | (((int) ch.rgb[index + 1] & 0xff) << 8) | (int) ch.rgb[index] & 0xff;
                index += 3;
            }
            index += ch.pad;
        }
        img = createImage(new MemoryImageSource(ch.width, ch.height,data, 0, ch.width));
        ImageIcon icon = new ImageIcon(img);
        jLabelImage.setIcon(icon);
}//GEN-LAST:event_jMenuItemCodeMousePressed

    private void jMenuItemGetCodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemGetCodeMousePressed
        GetCodeDialog dlg = new GetCodeDialog(this, true);
        dlg.setVisible(true);
        int value = Integer.parseInt(dlg.val);
        GetCode gc = null;
        try {
            gc = new GetCode(name);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int[] code = null;
        try {
            code = gc.readCodeFromImage(100, value);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabelCode.setText("" + code[0]);

}//GEN-LAST:event_jMenuItemGetCodeMousePressed

    private void jMenuItemSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemSaveMousePressed
        FileDialog fd = new FileDialog(this, "Save Image", FileDialog.SAVE);
        fd.setVisible(true);
        String filename = fd.getFile();
        String dir = fd.getDirectory();
        filename = dir + filename;
        if (!filename.contains(".bmp"))
            filename += ".bmp";
        FileOutputStream codeimg = null;
        try {
            codeimg = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            codeimg.write(ch.head);
            codeimg.write(ch.infohead);
            codeimg.write(ch.rgb);
            codeimg.close();
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jMenuItemSaveMousePressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Frame().setVisible(true);
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCode;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuGetCode;
    private javax.swing.JMenuItem jMenuItemCode;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemGetCode;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    // End of variables declaration//GEN-END:variables
}
