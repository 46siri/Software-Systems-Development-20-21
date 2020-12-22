package ui;
import business.RobotManager;
import business.ArmazemFacade;

import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class RobotFrame extends javax.swing.JFrame {
    ArmazemFacade af;
    List<RobotManager> robots;

    /**
     * Método que atualiza a tabela dos robots
     * @param robots nova lista de robots a exibir
     */
    public void updateTable (Collection<RobotManager> robots){
        DefaultTableModel model = (DefaultTableModel) display_tbl.getModel();
        Object row_data[] = new Object[1];

        //Remove todos
        model.setRowCount(0);

        //Adiciona novos
        for(RobotManager r : robots){
            row_data[0] = r.getId();
            model.addRow(row_data);
        }
    }
    private void novo_robot_btnActionPerformed(ActionEvent e) {
        new NovoRobotFrame(this.af,this,null).setVisible(true);
    }
    private void display_tblMouseClicked(MouseEvent e) throws Exception {
        if(e.getClickCount()==2){
            int row = this.display_tbl.getSelectedRow();
            int id = (int) this.display_tbl.getModel().getValueAt(row, 0);

            RobotManager selected = (RobotManager) this.af.getRobots(id);

            new AlterarRobotFrame(selected,af,this).setVisible(true);
        }
    }
    private void robot_txtKeyReleased(KeyEvent e) {
        String to_search = robot_txt.getText();

        Collection<RobotManager> robots = this.robots.stream().filter(r -> r.getId().contains(to_search))
                .collect(Collectors.toList());

        updateTable(robots);
    }

    private void sair_btnActionPerformed(ActionEvent e) {
        this.dispose();
    }

    public void updateList(List<RobotManager> list) {
        this.robots = list;
    }

    /**
     * Creates new form RobotsFrame
     */
    public RobotFrame(ArmazemFacade af) throws Exception {
        initComponents();
        this.af = af;
        this.robots = (List<RobotManager>) af.getRobots();
        updateTable(this.robots);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license

    private void initComponents() {
        sair_btn = new JButton();
        novo_robot_btn = new JButton();
        robot_txt = new JTextField();
        jScrollPane1 = new JScrollPane();
        display_tbl = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Robots");
        Container contentPane = getContentPane();

        //---- sair_btn ----
        sair_btn.setText("Sair");
        sair_btn.addActionListener(e -> sair_btnActionPerformed(e));

        //---- novo_robot_btn ----
        novo_robot_btn.setText("Adicionar Robot");
        novo_robot_btn.addActionListener(e -> {
            novo_robot_btnActionPerformed(e);
        });

        //---- robot_txt ----
        robot_txt.setToolTipText("Procurar Robot");
        robot_txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                robot_txtKeyReleased(e);
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
                            "ID"
                    }
            ) {
                boolean[] columnEditable = new boolean[] {
                        false
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
                                .addComponent(novo_robot_btn)
                                .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(robot_txt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(robot_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sair_btn)
                                        .addComponent(novo_robot_btn))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license 
    private JButton sair_btn;
    private JButton novo_robot_btn;
    private JTextField robot_txt;
    private JScrollPane jScrollPane1;
    private JTable display_tbl;
    // End of variables declaration//GEN-END:variables



}
