/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package apresentacao;
import Modelo.Estaticos;
import Modelo.Pessoa;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Denipoti
 */
public class frmPesquisaNome extends javax.swing.JDialog
{

    /**
     * Creates new form frmPesquisaNome
     */
    public frmPesquisaNome(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        preencherTabela();
    }

    public void preencherTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tblPessoas.getModel();
        modelo.setNumRows(0);
        modelo.setColumnIdentifiers(new Object[]{
            "ID", "NOME", "RG", "CPF"
        });
        for(Pessoa pessoa : Estaticos.listaPessoas){
            modelo.addRow(new Object[]{
                pessoa.idPessoa, pessoa.nome, pessoa.rg, pessoa.cpf
            });
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoas = new javax.swing.JTable();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPessoas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPessoas.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tblPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPessoas);

        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOk)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOk)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOkActionPerformed
    {//GEN-HEADEREND:event_btnOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void tblPessoasMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblPessoasMouseClicked
    {//GEN-HEADEREND:event_tblPessoasMouseClicked
        int linha = tblPessoas.getSelectedRow();
        Estaticos.pessoaResultado.idPessoa = (int) tblPessoas.getValueAt(linha, 0);
        Estaticos.pessoaResultado.nome = (String) tblPessoas.getValueAt(linha, 1);
        Estaticos.pessoaResultado.rg = (String) tblPessoas.getValueAt(linha, 2);
        Estaticos.pessoaResultado.cpf = (String) tblPessoas.getValueAt(linha, 3);
    }//GEN-LAST:event_tblPessoasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(frmPesquisaNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(frmPesquisaNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(frmPesquisaNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(frmPesquisaNome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                frmPesquisaNome dialog = new frmPesquisaNome(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPessoas;
    // End of variables declaration//GEN-END:variables
}
