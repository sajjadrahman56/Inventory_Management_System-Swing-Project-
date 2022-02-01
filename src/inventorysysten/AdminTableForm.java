package inventorysysten;

import inventorysysten.AllUserNameWithDb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class AdminTableForm extends JFrame implements ActionListener {

    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    Font font1, font2;
    JTable table;
    JComboBox comboBox;
    JTextField searchtxt, idtxt, nametxt, pricetxt, quantitytxt, categorytxt;

    JPanel panel1, Panel2;
    JScrollPane ScrollPane;
    JButton searchBtn, clearBtn, addBtn, updateBtn, deleteBtn, refreshBtn, insertBtn ,backBtn;

    String productName, productprice, quantity;
    String name, serial, id, dbId, dbName, dbPhone, dbEmail, dbAddress, dbPrice, dbCategory, dbQuantity;

    String cols[] = {"ID", "Name", "Price", "Quantity", "Category"};

    String[][] row = {{" ", " ", " ", " ", " "}};
    Connection con;
    PreparedStatement pst;
    DefaultTableModel model, df;

    AdminTableForm() {
        initComponent();
        connect();
        load();

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

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(50, 10, 1150, 668);

        this.setTitle("Front Page");
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);

        icon = new ImageIcon(getClass().getResource("MaintableFrame.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(imageLabel);

        font1 = new Font("Time new Roman", Font.BOLD, 16);
        font2 = new Font("Time new Roman", Font.BOLD, 14);

        searchtxt = new JTextField();
        searchtxt.setBounds(565, 136, 377, 35);
        searchtxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
//        searchtxt.setBorder(BorderFactory.createLineBorder(Color.blue));
        searchtxt.setFont(font1);
        imageLabel.add(searchtxt);
//        
//        
//        ///comboBox 
//        
//        String [] category = {"SELECT", "Electronics", "Mobile", "Grocery"}; 
//        comboBox = new JComboBox(category);
//        comboBox.setBounds(190, 150, 190, 40);
//        comboBox.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
//        comboBox.setFont(font1);
//        comboBox.setEditable(true);
//        imageLabel.add(comboBox);
//

        idtxt = new JTextField();
        idtxt.setBounds(190, 170, 190, 40);
        idtxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        idtxt.setFont(font1);
        imageLabel.add(idtxt);

        nametxt = new JTextField();
        nametxt.setBounds(190, 225, 190, 40);
        nametxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        nametxt.setFont(font1);
        imageLabel.add(nametxt);

        pricetxt = new JTextField();
        pricetxt.setBounds(190, 285, 190, 40);
        pricetxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        pricetxt.setFont(font1);
        imageLabel.add(pricetxt);

        quantitytxt = new JTextField();
        quantitytxt.setBounds(190, 340, 190, 40);
        quantitytxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        quantitytxt.setFont(font1);
        imageLabel.add(quantitytxt);

        categorytxt = new JTextField();
        categorytxt.setBounds(190, 390, 190, 40);
        categorytxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        categorytxt.setFont(font1);
        imageLabel.add(categorytxt);

        //JButton
        searchBtn = new JButton("Search");
        searchBtn.setBounds(965, 135, 110, 35);
        searchBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        searchBtn.setFocusable(false);
        searchBtn.setBackground(Color.decode("#00A86B"));
        searchBtn.setFont(font2);
        imageLabel.add(searchBtn);

        insertBtn = new JButton("INSERT");
        insertBtn.setBounds(60, 470, 90, 40);
        insertBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        insertBtn.setBackground(Color.decode("#8A9A5B"));
        insertBtn.setFocusable(false);
        insertBtn.setFont(font2);
        imageLabel.add(insertBtn);

        updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(170, 470, 90, 40);
        updateBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        updateBtn.setBackground(Color.decode("#98FB98"));
        updateBtn.setFocusable(false);
        updateBtn.setFont(font2);
        imageLabel.add(updateBtn);

        deleteBtn = new JButton("DELETE");
        deleteBtn.setBounds(280, 470, 90, 40);
        deleteBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        deleteBtn.setBackground(Color.decode("#73C2FB"));
        deleteBtn.setFocusable(false);
        deleteBtn.setFont(font2);
        imageLabel.add(deleteBtn);

        clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(115, 525, 90, 40);
        clearBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        clearBtn.setBackground(Color.decode("#F19CBB"));
        clearBtn.setFocusable(false);
        clearBtn.setFont(font2);
        imageLabel.add(clearBtn);

        refreshBtn = new JButton("REFRESH");
        refreshBtn.setBounds(225, 525, 90, 40);
        refreshBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        refreshBtn.setBackground(Color.decode("#EB9605"));
        refreshBtn.setFocusable(false);
        refreshBtn.setFont(font2);
        imageLabel.add(refreshBtn);
        
        
        backBtn = new JButton("Back");
        backBtn.setBounds(175, 580, 90, 40);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        backBtn.setBackground(Color.decode("#60F8F8"));
        backBtn.setFocusable(false);
        backBtn.setFont(font2);
        imageLabel.add(backBtn);
        
        model = new DefaultTableModel(row, cols);

        table = new JTable(model);
        table.setSelectionBackground(Color.decode("#D7BFDC"));
        table.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));

        table.setRowHeight(24);
        table.setFont(new Font("Time new Roman", Font.CENTER_BASELINE, 17));

        ScrollPane = new JScrollPane(table);
        ScrollPane.setBounds(520, 195, 595, 390);
        ScrollPane.setFont(font2);
        imageLabel.add(ScrollPane);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                df = (DefaultTableModel) table.getModel();
                int selected = table.getSelectedRow();
                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));

                dbId = (String) model.getValueAt(selected, 0);//row, column
                dbName = (String) model.getValueAt(selected, 1);//row, column
                dbPrice = (String) model.getValueAt(selected, 2);
                dbQuantity = (String) model.getValueAt(selected, 3);
                dbCategory = (String) model.getValueAt(selected, 4);

                idtxt.setText(dbId);
                nametxt.setText(dbName);
                pricetxt.setText(dbPrice);
                quantitytxt.setText(dbQuantity);
                categorytxt.setText(dbCategory);

                insertBtn.setEnabled(false);
            }

        });

        insertBtn.addActionListener(this);   
        refreshBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        backBtn.addActionListener(this);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminTableForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertBtn) {
            try {

                String userIdRecive = idtxt.getText();
                String userNameRecive = nametxt.getText();
                String userPriceRecive = pricetxt.getText();
                String userQuantityRecive = quantitytxt.getText();
                String userCategoryRecive = categorytxt.getText();

                pst = con.prepareStatement("insert into products(Id, Name, Price, Quantity, Category)values(?,?,?,?,?)");
                pst.setString(1, userIdRecive);
                pst.setString(2, userNameRecive);
                pst.setString(3, userPriceRecive);
                pst.setString(4, userQuantityRecive);
                pst.setString(5, userCategoryRecive);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "This is  Products Added ");

                idtxt.setText("");
                nametxt.setText("");
                pricetxt.setText("");
                quantitytxt.setText("");
                categorytxt.setText("");

                idtxt.requestFocus();
                load();

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == refreshBtn) {
            table.setModel(new DefaultTableModel(null, new String[]{"Id", "Name", "Price", "Quantity", "Category"}));
            load();
        } else if (e.getSource() == updateBtn) {
            try {
                df = (DefaultTableModel) table.getModel();
                int selected = table.getSelectedRow();

                int userIdRecive = Integer.parseInt((df.getValueAt(selected, 0).toString()));

                int userPriceRecive = Integer.parseInt((df.getValueAt(selected, 2).toString()));
                int userQuantityRecive = Integer.parseInt((df.getValueAt(selected, 3).toString()));

                String userNameRecive = nametxt.getText();

                String userCategoryRecive = categorytxt.getText();

                pst = con.prepareStatement("update products set Id =? ,Name =?,Price =? ,Quantity =?,Category=? where id =?");

                pst.setInt(1, userIdRecive);
                pst.setString(2, userNameRecive);
                //pst.setString(3, userNameRecive);
                pst.setInt(3, userPriceRecive);
                pst.setInt(4, userQuantityRecive);
                pst.setString(5, userCategoryRecive);
                pst.setInt(6, userIdRecive);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "This is  products Updated ");

                idtxt.setText("");
                nametxt.setText("");
                pricetxt.setText("");
                quantitytxt.setText("");
                categorytxt.setText("");
                searchtxt.setText("");

                idtxt.requestFocus();
                load();
                //that means my update is done so edit is onpen  
                insertBtn.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == deleteBtn) {
            try {
                df = (DefaultTableModel) table.getModel();
                int selected = table.getSelectedRow();
                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));

                pst = con.prepareStatement("delete from products where id =?");

                pst.setInt(1, id);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "This is products Deleted ");

                idtxt.setText("");
                nametxt.setText("");
                pricetxt.setText("");
                quantitytxt.setText("");
                categorytxt.setText("");
                searchtxt.setText("");

                idtxt.requestFocus();

                load();
                //that means my update is done so edit is onpen 
                insertBtn.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == clearBtn) { //searchBtn, , , updateBtn, deleteBtn,  ,insertBtn;
            idtxt.setText("");
            nametxt.setText("");
            pricetxt.setText("");
            quantitytxt.setText("");
            categorytxt.setText("");
            searchtxt.setText("");

            idtxt.requestFocus();

            load();
            //that means my update is done so edit is onpen 
            insertBtn.setEnabled(true);
        } else if (e.getSource() == searchBtn) {

            int a;
            //    serachTf.getText();
            try {
                if (searchtxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, " Search Box Empty !!");
                } else {
                    pst = con.prepareStatement("select * from products WHERE Category = '" + searchtxt.getText() + "' ");

                    ResultSet rs = pst.executeQuery();
                    ResultSetMetaData rd = rs.getMetaData();

                    a = rd.getColumnCount();
                    df = (DefaultTableModel) table.getModel();
                    df.setRowCount(0);
                    //table = (DefaultTableModel)table.getModel();

                    while (rs.next()) {
                        Vector dataStore = new Vector();
                        for (int i = 1; i <= a; i++) {
                            
                           dataStore.add(rs.getString("Id"));
                            dataStore.add(rs.getString("Name"));
                            dataStore.add(rs.getString("Price"));
                            dataStore.add(rs.getString("Quantity"));
                            dataStore.add(rs.getString("Category"));
                        }

                        df.addRow(dataStore);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource() ==  backBtn)
        {
            dispose();      
            new ADminUser();
        }
        
    }
}
