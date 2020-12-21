package ui;
import business.ArmazemFacade;
import business.Gestor;
import business.Robot;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class GestorFrame extends javax.swing.JFrame {
    ArmazemFacade af;
    List<Gestor> gestores;

    public void updateTable (Collection<Gestor> gestor){
        DefaultTableModel model =(DefaultTableModel) display_tbl.getModel();
        Object row_data[] = new Object[3];

        //Remove todos
        model.setRowCount(0);

        //Adiciona novos

        for (Gestor g : gestores){
            row_data[0] = g.getUserName();
            row_data[1] = g.getNome();
            row_data[2] = g.getEmail();
            model.addRow(row_data);
        }
    }
    private void novo_gestor_btnActionPerformed(ActionEvent e) {
        new NovoGestorFrame(this.af, this).setVisible(true);

    }
    private void display_tblMouseClicked (MouseEvent e) throws Exception{
        if(e.getClickCount()==2){
            int row = this.display_tbl.getSelectedRow();
            int id = (int) this.display_tbl.getModel().getValueAt(row, 0);

            Gestor selected = this.af.getGestores(userName);

            new AlteraGestorFrame (selected, af, this).setVisible(true);
        }
    }
    private void gestor_txtKeyReleased(KeyEvent e){
        String to_search = gestor_txt.getText();

        Collection<Gestor> gestores = this.gestores.stream().filter(g->g.getNome().contains(to_search)).collect(Collectors.toList());
        updateTable(gestores);
    }
    private void sair_btnActionPerformed(ActionEvent e) {
        this.dispose();
    }
    public void updateList (List<Gestor> list){
        this.gestores = list;
    }
    /**
     * Creates new form GestorFrame
     */
    public GestorFrame(ArmazemFacade af) throws Exception {
        initComponents();
        this.af = af;
        this.gestores = af.getGestores();
        updateTable(this.gestores);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Pedro Moreira
    private void initComponents() {
        sair_btn = new JButton();
        novo_gestor_btn = new JButton();
        gestor_txt = new JTextField();
        jScrollPane1 = new JScrollPane();
        display_tbl = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestores");
        Container contentPane = getContentPane();

        //---- sair_btn ----
        sair_btn.setText("Sair");
        sair_btn.addActionListener(e -> sair_btnActionPerformed(e));

        //---- novo_cliente_btn ----
        novo_gestor_btn.setText("Adicionar Gestor");
        novo_gestor_btn.addActionListener(e -> {
            novo_gestor_btnActionPerformed(e);
        });

        //---- gestor_txt ----
        gestor_txt.setToolTipText("Procurar Gestor");
        gestor_txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                gestor_txtKeyReleased(e);
            }
        });
        //======== jScrollPane1 ========
        {

            //---- display_tbl ----
            display_tbl.setModel(new DefaultTableModel(
                    new Object[][] {
                            {null, null, null},
                    },
                    new String[] {
                            "UserName", "Nome", "Email"
                    }
            ) {
                boolean[] columnEditable = new boolean[] {
                        false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = display_tbl.getColumnModel();
                cm.getColumn(0).setPreferredWidth(10);
                cm.getColumn(2).setPreferredWidth(40);
            }
            display_tbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        display_tblMouseClicked(e);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            jScrollPane1.setViewportView(display_tbl);
        }
        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sair_btn, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(novo_gestor_btn)
                                .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gestor_txt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gestor_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sair_btn)
                                        .addComponent(novo_gestor_btn))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license
    private JButton sair_btn;
    private JButton novo_gestor_btn;
    private JTextField gestor_txt;
    private JScrollPane jScrollPane1;
    private JTable display_tbl;
    // End of variables declaration//GEN-END:variables


    }
