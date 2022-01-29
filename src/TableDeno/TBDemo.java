/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableDeno;

import javax.swing.*;
import javax.swing.event.*;

public class TBDemo extends JFrame{

    TBDemo() {
        
   String data[][] = {{"", "", "",""}};
//        String data[][] = {{"101", "Amit", "670000","0"},
//        {"102", "Jai", "780000","0"},
//        {"101", "Sachin", "700000","0"}};
        String column[] = {"ID", "NAME", "SALARY","Quantity"};
        final JTable jt = new JTable(data, column);
        jt.setCellSelectionEnabled(true);
        ListSelectionModel select = jt.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = jt.getSelectedRows();
                int[] columns = jt.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) jt.getValueAt(row[i], columns[j]);
                    }
                }
                System.out.println("Table element selected is: " + Data);
            }
        });
        JScrollPane sp = new JScrollPane(jt);
         add(sp);
        setSize(500, 400);
        setLocationRelativeTo(null);
         setVisible(true);
    }

    public static void main(String[] a) {

        new TBDemo();
    }
}
