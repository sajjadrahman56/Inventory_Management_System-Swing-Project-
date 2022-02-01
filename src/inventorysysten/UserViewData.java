package inventorysysten;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserViewData extends JFrame implements ActionListener {

    Container container;
    JLabel imageLabel;
    ImageIcon icon;
    Font font1;
    JTable table;
    JScrollPane ScrollPane;
    JTextField searchtxt;
    JButton searchBtn, backBtn;
    DefaultTableModel model, df;
    Connection con;
    PreparedStatement pst;

    String cols[] = {"ID", "Name", "Price", "Category"};

    String[][] row = {{" ", " ", " ", " "}, {" ", " ", " ", " "}};

    public UserViewData() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1150, 660);
        this.setLocationRelativeTo(null);

        this.setTitle("Front Page");
        this.setResizable(false);

        container = this.getContentPane();
        container.setLayout(null);

        icon = new ImageIcon(getClass().getResource("userViewData.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        container.add(imageLabel);

        font1 = new Font("Time new Roman", Font.BOLD, 16);

        searchtxt = new JTextField();
        searchtxt.setBounds(47, 136, 290, 35);
        searchtxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        searchtxt.setFont(font1);
        imageLabel.add(searchtxt);

        //JButton
        searchBtn = new JButton("Search");
        searchBtn.setBounds(347, 135, 110, 35);
        searchBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        searchBtn.setFocusable(false);
        searchBtn.setBackground(Color.decode("#00A86B"));
        searchBtn.setFont(font1);
        imageLabel.add(searchBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(120, 500, 110, 55);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        backBtn.setFocusable(false);
        backBtn.setBackground(Color.decode("#00A86B"));
        backBtn.setFont(font1);
        imageLabel.add(backBtn);

        model = new DefaultTableModel(row, cols);

        table = new JTable(model);
        table.setSelectionBackground(Color.decode("#D7BFDC"));
        table.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));

        ScrollPane = new JScrollPane(table);
        ScrollPane.setBounds(520, 140, 595, 430);
        ScrollPane.setFont(font1);
        imageLabel.add(ScrollPane);

        connect();
        load();
        searchBtn.addActionListener(this);
        backBtn.addActionListener(this);

        setVisible(true);
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // con = DriverManager.getConnection("jdbc:mysql://localhost/sajjad","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourswingproject", "root", "");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {
        int a;
        try {
            pst = con.prepareStatement("select * from products");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();

            a = rd.getColumnCount();
            df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);
            //table = (DefaultTableModel)table.getModel();

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int i = 1; i <= a; i++) {
                    v2.add(rs.getString("Id"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Price"));
                    v2.add(rs.getString("Category"));
                }

                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new UserViewData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchBtn) {
            JOptionPane.showMessageDialog(null, " I am From Search Box Here ");

            int a;
            //    serachTf.getText();
            try {
                pst = con.prepareStatement("select * from products WHERE Category = '" + searchtxt.getText() + "' ");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rd = rs.getMetaData();

                a = rd.getColumnCount();
                df = (DefaultTableModel) table.getModel();
                df.setRowCount(0);
                //table = (DefaultTableModel)table.getModel();

                while (rs.next()) {
                    Vector v2 = new Vector();
                    for (int i = 1; i <= a; i++) {
                        v2.add(rs.getString("Id"));
                        v2.add(rs.getString("Name"));
                        v2.add(rs.getString("Price"));
                        v2.add(rs.getString("Quantity"));
                        v2.add(rs.getString("Category"));
                    }
//                Object newRow[]= {Name,,id};
//				model.addRow(newRow);
                    df.addRow(v2);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if( e.getSource() ==  backBtn)
        {
            dispose();
            new UserFrontPage();
        }
    }

}
