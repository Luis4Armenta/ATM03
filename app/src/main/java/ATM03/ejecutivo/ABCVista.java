/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ATM03.ejecutivo;

import ATM03.database.HashMapBinFileCuentasRepository;
import ATM03.database.ICuentasRepository;
import ATM03.models.Cuenta;
import javax.swing.JOptionPane;

/**
 *
 * @author luigi
 */
public class ABCVista extends javax.swing.JFrame {
    ICuentasRepository cuentasRepository  = HashMapBinFileCuentasRepository.obtenerInstancia("archivo.bin");
    Cuenta cuentaSeleccionada;
    
    public Cuenta[] cuentas;

    /**
     * Creates new form ABCVista
     */
    public ABCVista() {
        this.cuentas = this.cuentasRepository.obtenerCuentas();
        initComponents();
        
        this.cuentaSeleccionada = new Cuenta(000000000, 0000000, 0000000);
        this.setLocationRelativeTo(null);
        
        this.numCuentas.setText(String.valueOf(this.cuentas.length));
    }
    
    public void actualizarLista() {
        this.cuentas = this.cuentasRepository.obtenerCuentas();
        
        cuentasLista.setModel(new javax.swing.AbstractListModel<Cuenta>() {
            @Override
            public int getSize() {
                return cuentas.length;
            }

            @Override
            public Cuenta getElementAt(int i) {
                return cuentas[i];
            }
        });
        
        this.cuentaSeleccionada = new Cuenta(000000000, 0000000, 0000000);
        
        this.numCuentas.setText(String.valueOf(this.cuentas.length));
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerLabel = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuentasLista = new javax.swing.JList<>();
        regresarBtn = new javax.swing.JButton();
        nuevaCuentaBtn = new javax.swing.JButton();
        numCuentas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema ejecutivo de Altas Bajas y Cambios");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        headerLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        headerLabel.setText("ABC");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        getContentPane().add(headerLabel, gridBagConstraints);

        label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label.setText("Cuentas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        getContentPane().add(label, gridBagConstraints);

        cuentasLista.setModel(new javax.swing.AbstractListModel<Cuenta>() {
            public int getSize() {
                return cuentas.length;
            }

            public Cuenta getElementAt(int i) {
                return cuentas[i];
            }
        });
        cuentasLista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                cuentasListaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(cuentasLista);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 160;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        regresarBtn.setText("Regresar al menu principal");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(regresarBtn, gridBagConstraints);

        nuevaCuentaBtn.setText("Crear nueva cuenta");
        nuevaCuentaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaCuentaBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(nuevaCuentaBtn, gridBagConstraints);

        numCuentas.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 50;
        getContentPane().add(numCuentas, gridBagConstraints);

        jLabel2.setText("Numero de cuentas: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void nuevaCuentaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaCuentaBtnActionPerformed
        // TODO add your handling code here:
        CuentaFormulario formulario = new CuentaFormulario(this);
        formulario.setVisible(true);

//        JOptionPane.showMessageDialog(this, new nuevaCuentaForm(), "Nueva Cuenta", -1);

        
        
    }//GEN-LAST:event_nuevaCuentaBtnActionPerformed

    private void cuentasListaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_cuentasListaValueChanged
        // TODO add your handling code here:
        System.out.println("Valor seleccionado " + this.cuentasLista.getSelectedValue());
        if (!this.cuentaSeleccionada.equals(this.cuentasLista.getSelectedValue()) && null != this.cuentasLista.getSelectedValue()) {
            
            Cuenta konta = this.cuentasLista.getSelectedValue();

            this.cuentaSeleccionada = new Cuenta(
                    konta.obtenerNumeroCuenta(),
                    konta.ObtenerNIP(),
                    konta.obtenerSaldoDisponible()
            );

            EditorCuentas editor = new EditorCuentas(this,
                    new Cuenta(
                            this.cuentaSeleccionada.obtenerNumeroCuenta(),
                            this.cuentaSeleccionada.ObtenerNIP(), 
                            this.cuentaSeleccionada.obtenerSaldoDisponible()
                    ));
            
            editor.setVisible(true);
        }

    }//GEN-LAST:event_cuentasListaValueChanged

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
            java.util.logging.Logger.getLogger(ABCVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABCVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABCVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABCVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABCVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Cuenta> cuentasLista;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JButton nuevaCuentaBtn;
    private javax.swing.JTextField numCuentas;
    public javax.swing.JButton regresarBtn;
    // End of variables declaration//GEN-END:variables
}