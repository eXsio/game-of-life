/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 2011-06-30, 13:50:25
 */

package pl.exsio.gol.main;


import pl.exsio.gol.db.DbManager;
import pl.exsio.gol.model.Cell;
import pl.exsio.gol.ui.MyComboBoxRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Main extends javax.swing.JFrame {

    public Cell[][] Grid;
    private Play play;
    public DbManager db;

    /**
     * Creates new form NewJFrame
     */
    public Main() {

        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);

        FlowLayout layout = new FlowLayout();
        layout.setHgap(1);
        layout.setVgap(1);
        GridPanel.setLayout(layout);

        delay.setValue((Object) 100);
        size_cols.setValue((Object) 50);
        size_rows.setValue((Object) 90);

        this.setGrid(Integer.parseInt(size_cols.getValue().toString()), Integer.parseInt(size_rows.getValue().toString()));

        db = new DbManager(this);
        this.updateSchemasList();

        schemas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                db.openSchema(Grid);
            }
        });

    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GridPanel = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        delay = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        gen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        size_cols = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        size_rows = new javax.swing.JSpinner();
        save = new javax.swing.JButton();
        schemas = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        setResizable(false);

        GridPanel.setMaximumSize(new Dimension(350, 350));
        GridPanel.setMinimumSize(new Dimension(350, 350));
        GridPanel.setPreferredSize(new Dimension(350, 350));

        javax.swing.GroupLayout GridPanelLayout = new javax.swing.GroupLayout(GridPanel);
        GridPanel.setLayout(GridPanelLayout);
        GridPanelLayout.setHorizontalGroup(
                GridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1205, Short.MAX_VALUE)
        );
        GridPanelLayout.setVerticalGroup(
                GridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 540, Short.MAX_VALUE)
        );

        start.setText("Start");
        start.setToolTipText("Start the game");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel1.setText("Delay:");

        delay.setToolTipText("delay in ms (10 - 2000)");

        jLabel2.setText("generations:");

        gen.setText("0");
        gen.setToolTipText("");

        jLabel3.setText("size:");

        size_cols.setToolTipText("min 50, max 80");

        jLabel4.setText("x");

        size_rows.setToolTipText("min 90, max 140");
        size_rows.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                size_rowsInputMethodTextChanged(evt);
            }
        });

        save.setText("Save");
        save.setToolTipText("Create new schema");
        save.setPreferredSize(new Dimension(55, 29));
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        schemas.setToolTipText("Saved schemas list");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText("|");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText("|");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText("|");

        jButton1.setText("Set");
        jButton1.setToolTipText("Set grid size");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        stop.setText("Stop");
        stop.setToolTipText("Stop the game");
        stop.setEnabled(false);
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        del.setText("Delete");
        del.setToolTipText("Delete selected schema");
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(GridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(size_cols, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(size_rows, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(start)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stop)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(gen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel6))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel9)
                                                                .addGap(23, 23, 23)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(schemas, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(del)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel7)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(delay, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(295, 295, 295)
                                                                .addComponent(jLabel10)))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(size_cols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4)
                                                .addComponent(size_rows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel2)
                                                .addComponent(gen)
                                                .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addComponent(schemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                                .addComponent(del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel1)
                                                .addComponent(delay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(start, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                .addGap(7, 7, 7)
                                .addComponent(GridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        gen.setText("0");
        if (Integer.parseInt(delay.getValue().toString()) < 10) delay.setValue((Object) 10);
        if (Integer.parseInt(delay.getValue().toString()) > 2000) delay.setValue((Object) 2000);
        play = new Play(Grid, this);
        play.start();
        start.setEnabled(false);
        stop.setEnabled(true);

    }//GEN-LAST:event_startActionPerformed

    public void updateSchemasList() {

        schemas.setModel(db.getSchemas());
        schemas.setRenderer(new MyComboBoxRenderer(db.getTooltips()));

    }

    private void saveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        db.saveSchema(Grid);
    }//GEN-LAST:event_saveActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Integer.parseInt(size_rows.getValue().toString()) < 90) size_rows.setValue((Object) 90);
        if (Integer.parseInt(size_cols.getValue().toString()) < 50) size_cols.setValue((Object) 50);
        if (Integer.parseInt(size_rows.getValue().toString()) > 130) size_rows.setValue((Object) 140);
        if (Integer.parseInt(size_cols.getValue().toString()) > 90) size_cols.setValue((Object) 80);
        this.setGrid(Integer.parseInt(size_cols.getValue().toString()), Integer.parseInt(size_rows.getValue().toString()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void stopActionPerformed(ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        play.stopTheGame();
        start.setEnabled(true);
        stop.setEnabled(false);
    }//GEN-LAST:event_stopActionPerformed

    private void delActionPerformed(ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        db.deleteSchema();
    }//GEN-LAST:event_delActionPerformed

    private void size_rowsInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_size_rowsInputMethodTextChanged

    }//GEN-LAST:event_size_rowsInputMethodTextChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    public void setGrid(int cols, int rows) {

        GridPanel.removeAll();
        this.setSize(rows * 11 + 30, cols * 12 + 60);
        Grid = new Cell[cols][rows];
        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[i].length; j++) {
                Grid[i][j] = new Cell();
                Grid[i][j].setToolTipText("Cell " + Integer.toString(i) + "," + Integer.toString(j));
                GridPanel.add(Grid[i][j]);
            }
        }
    }


    public String getSelectedSchema() {

        return schemas.getSelectedItem().toString();

    }

    public int getSelectedSchemaIndex() {

        return schemas.getSelectedIndex();

    }

    public void clearGrid() {
        for (int i = 0; i < Grid.length; i++) {
            for (int j = 0; j < Grid[i].length; j++)
                Grid[i][j].setPopulated(false);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GridPanel;
    private javax.swing.JButton del;
    public javax.swing.JSpinner delay;
    public javax.swing.JLabel gen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton save;
    private javax.swing.JComboBox schemas;
    public javax.swing.JSpinner size_cols;
    public javax.swing.JSpinner size_rows;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables

}