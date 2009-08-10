package codeimage;


public class CodeDialog extends javax.swing.JDialog {

    String code, value;
    public CodeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        code = null;
        value = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jTextField = new javax.swing.JTextField();
        jTextFieldCode = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextFieldValue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jButtonOK.setText("OK");
        jButtonOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonOKMousePressed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonCancelMousePressed(evt);
            }
        });

        jTextField.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextField.setEditable(false);
        jTextField.setText("Enter code:");
        jTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField.setFocusable(false);

        jTextField1.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextField1.setEditable(false);
        jTextField1.setText("Enter count of bits:");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldValue, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jButtonOK)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextFieldCode, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOK))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOKMousePressed
       code = jTextFieldCode.getText();
       value = jTextFieldValue.getText();
       dispose();
    }//GEN-LAST:event_jButtonOKMousePressed

    private void jButtonCancelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelMousePressed
      dispose();
    }//GEN-LAST:event_jButtonCancelMousePressed

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                CodeDialog dialog = new CodeDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JTextField jTextField;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldValue;
    // End of variables declaration//GEN-END:variables

}
