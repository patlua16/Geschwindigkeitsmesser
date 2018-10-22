/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author lukas
 */
public class VelocityTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Measurment s = (Measurment) value;
        JLabel label = new JLabel();
    label.setOpaque(true);
    label.setBackground(Color.white);
    label.setForeground(Color.black);
   if (isSelected) {
          label.setBackground(Color.red);
           
   }
   if (column==5 && s.getÜberteten()>=30)
   {
       label.setBackground(Color.red);
   }
    if (column==5 && s.getÜberteten()<30&&s.getÜberteten()>=20)
   {
       label.setBackground(Color.orange);
   }
     if (column==5 && s.getÜberteten()<20&&s.getÜberteten()>=10)
   {
       label.setBackground(Color.yellow);
   }
      if (column==5 && s.getÜberteten()<10)
   {
       label.setBackground(Color.BLUE);
   }
   
      
    switch(column)
    {
        case 0: label.setText(s.getDatum()+"");
          break;
          case 1: label.setText(s.getUhrzeit()+"");
          break;
           case 2: label.setText(s.kennzeichen().toString());
          break;
           case 3: label.setText(s.getVgemessen()+" km/h");
          break;
           case 4: label.setText(s.getVerlaubt()+" km/h");
          break;
           case 5: label.setText(s.getÜberteten()+"");
    }
    return label;
    
    }
    
}
