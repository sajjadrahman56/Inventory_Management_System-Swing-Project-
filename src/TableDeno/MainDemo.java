/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableDeno;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Talha Bin Rais
 */
public class MainDemo extends JFrame {

    JPanel panel1, panel2;
    Container container;
    JButton upbtn, delbtn, addbtn, ex;

    JTable table;
    JTextField serialText, nameText, idText, uptext, deltext;
    String name, serial, id;
    DefaultTableModel model;

    JLabel serialLabel, nameLabel, idJLabel;

    public MainDemo() {
        container = this.getContentPane();
        container.setLayout(null);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        upbtn = new JButton("Update ");
        upbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 26)));
        upbtn.setBackground(Color.red);
        upbtn.setBounds(90, 150, 150, 90);
        add(upbtn);

        delbtn = new JButton(" Delete ");
        delbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 26)));
        delbtn.setBackground(Color.red);
        delbtn.setBounds(300, 100, 150, 90);
        add(delbtn);

        addbtn = new JButton("  Add ");
        addbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 26)));
        addbtn.setBackground(Color.red);
        addbtn.setBounds(500, 160, 150, 90);
        add(addbtn);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainDemo();
    }
}
