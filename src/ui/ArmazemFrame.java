package ui;
import business.ArmazemFacade;
import business.Gestor;
import business.Robot;

import java.lang.String;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class ArmazemFrame extends javax.swing.JFrame {
    ArmazemFacade af;
    Gestor g;
    Robot r;

    private void sair_btnActionPerformed (ActionEvent e){
        this.dispose();
        new LoginFrame().setVisible(true);
    }

    private void paletes_btnActionPerformed (ActionEvent e) throws Exception{
        new TabelaPaletes(this.af).setVisible(true);
    }

    private void descargas_btnActionPerformed (ActionEvent e) throws Exception {
        new RegistaDescargaFrame (this.af).setVisible(true);
    }

    private void requisicoes_btnActionPerformed (ActionEvent e) throws Exception {
        new RegistaPedidoFrame (this.af).setVisible(true);
    }

    /**
     * Creates new from ArmazemFrame
     */

    public void armazemFrame(ArmazemFacade af, Gestor g, Robot r){
        initComponents();
        this.af = af;
        this.g = g;
        this.r = r;
        this.login_lbl.setText ("Logged in as " + g.getUserName());
        this.login_lbl.setText ("Logged in as " + r.getId());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do not modify this code. The content of thi method is always regenerated
     * by the Form Editor.
     */

    @SuppressWarnings("unchecked")

    private void initComponents(){
        jLabel1 = new JLabel();
        descargas_btn = new JButton();
        requisicoes_btn = new JButton();
        paletes_btn = new JButton();
        sair_btn = new JButton();
        login_lbl = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ARMAZÉM");
        Container contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel1.setIcon(new ImageIcon(getClass().getResource("logo.png")));
        jLabel1.setText("- ARMAZÉM");

        //---- descargas_btn ----
        descargas_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        descargas_btn.setText("Visualizar Descargas");
        descargas_btn.addActionListener(e -> {
            try {
                descargas_btnActionPerformed(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //---- requisicoes_btn ----
        requisicoes_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        requisicoes_btn.setText("Visualizar Requisicões");
        requisicoes_btn.addActionListener(e -> {
            try {
                requisicoes_btnActionPerformed(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //---- paletes_btn ----
        paletes_btn.setFont(new Font("Tahoma", Font.PLAIN, 12));
        paletes_btn.setText("Atualizar Stock de Paletes");
        paletes_btn.addActionListener(e -> {
            try {
                paletes_btnActionPerformed(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //---- sair_btn ----
        sair_btn.setText("Sair");
        sair_btn.addActionListener(e -> sair_btnActionPerformed(e));

        //---- login_lbl ----
        login_lbl.setFont(new Font("Tahoma", Font.PLAIN, 8));
        login_lbl.setText("Logged in as");
        login_lbl.setHorizontalAlignment(SwingConstants.RIGHT);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(descargas_btn, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(requisicoes_btn, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paletes_btn, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(76, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sair_btn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addComponent(login_lbl, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(descargas_btn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(requisicoes_btn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(paletes_btn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(sair_btn)
                                                .addGap(7, 7, 7))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(login_lbl)
                                                .addGap(2, 2, 2))))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license
    private JLabel jLabel1;
    private JButton descargas_btn;
    private JButton requisicoes_btn;
    private JButton paletes_btn;
    private JButton sair_btn;
    private JLabel login_lbl;
    // End of variables declaration//GEN-END:variables

}
