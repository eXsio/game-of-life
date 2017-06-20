package pl.exsio.gol.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class MyComboBoxRenderer extends BasicComboBoxRenderer {

    private String[] tooltips;

    public MyComboBoxRenderer(String[] tooltips) {
        this.tooltips = tooltips;
    }


    @Override
    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            if (-1 < index) {
                list.setToolTipText(tooltips[index]);
            }
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
