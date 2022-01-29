/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableDeno;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Inventory extends JFrame {

    JPanel panel1, panel2;
    Container container;
    JButton upbtn, delbtn, addbtn, ex;

    JTable table;
    JTextField serialText, nameText, idText, uptext, deltext;
    String name, serial, id;
    DefaultTableModel model;

    JLabel serialLabel, nameLabel, idJLabel;

    public Inventory() {

        container = this.getContentPane();
        container.setLayout(null);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setBounds(5, 0, 445, 600);
        panel1.setLayout(null);
        panel1.setBackground(Color.red);
        container.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(450, 0, 430, 600);
        panel2.setLayout(null);
        panel2.setBackground(Color.BLACK);
        container.add(panel2);

        
        
        String data[][] = {{"1", "Abir", "112233", ""}, {"1", "Hasan", "112233", ""}, {"1", "Wasim", "112233", ""}};
        String columnNames[] = {"Serial", "Name", "id", "Age"};
        //Creating table model
        model = new DefaultTableModel(data, columnNames);
        //Adding
        table = new JTable(model);
        table.setRowHeight(24);
        table.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 10, 410, 580);
        panel2.add(sp);
        //panel1.add(new JScrollPane(table));

       

        serialLabel = new JLabel("  SERIAL : ");
        serialLabel.setBounds(10, 80, 100, 40);
        serialLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
        panel1.add(serialLabel);
        
        

        serialText = new JTextField();
        serialText.setBounds(150, 80, 150, 40);
        panel1.add(serialText);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Inventory();
    }
}
