//package inventorysysten;
//
//import java.awt.*;
//
//import java.awt.event.*;
//
//import java.sql.*;
//
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.*;
//
//import javax.swing.table.DefaultTableModel;
//
///**
// *
// * @author Talha Bin Rais
// */
//public class MultipleCategoryTest extends JFrame implements ActionListener {
//
//    JPanel panel1, panel2;
//    Container container;
//    JButton searchbtn, cancel, insertbtn, upbtn, delbtn, addbtn, ex, vendor, product, purchase, logOut, refresh;
//
//    JTable table;
//    JTextField serachTf, serialText, nameText, idText, uptext, deltext, userName, userPhone, userEmail, userAdress, pIdTf, pNameTf, pPriceTf, pQuantityTf, pCategoryTf;
//    String name, serial, id, dbId, dbName, dbPhone, dbEmail, dbAddress, dbPrice, dbCategory, dbQuantity;
//    DefaultTableModel model, df;
//
//    JLabel pId, pName, pPrice, pQuantity, pCategory;
//    JScrollPane sp;
//    Connection con;
//    PreparedStatement pst;
//
//    public MultipleCategoryTest() {
//
//        initComponet();
//        connect();
//        load();
//    }
//
//    public void connect() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // con = DriverManager.getConnection("jdbc:mysql://localhost/sajjad","root","");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ourswingproject", "root", "");
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void load() {
//        int a;
//        try {
//            pst = con.prepareStatement("select * from products");
//
//            ResultSet rs = pst.executeQuery();
//            ResultSetMetaData rd = rs.getMetaData();
//
//            a = rd.getColumnCount();
//            df = (DefaultTableModel) table.getModel();
//            df.setRowCount(0);
//            //table = (DefaultTableModel)table.getModel();
//
//            while (rs.next()) {
//                Vector v2 = new Vector();
//                for (int i = 1; i <= a; i++) {
//                    v2.add(rs.getString("Id"));
//                    v2.add(rs.getString("Name"));
//                    v2.add(rs.getString("Price"));
//                    v2.add(rs.getString("Quantity"));
//                    v2.add(rs.getString("Category"));
//                }
////                Object newRow[]= {Name,,id};
////				model.addRow(newRow);
//                df.addRow(v2);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public void initComponet() {
//        container = this.getContentPane();
//        container.setLayout(null);
//        this.setSize(1200, 800);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//
//        pId = new JLabel("Product Id : ");
//        pId.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        pId.setBounds(20, 20, 250, 50);
//
//        pName = new JLabel("Product Name : ");
//        pName.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        pName.setBounds(20, 100, 250, 50);
//
//        pPrice = new JLabel("Product Price : ");
//        pPrice.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        pPrice.setBounds(20, 180, 250, 50);
//
//        pQuantity = new JLabel("Product Qantity : ");
//        pQuantity.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        pQuantity.setBounds(20, 260, 250, 50);
//
//        pCategory = new JLabel("Product Category : ");
//        pCategory.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        pCategory.setBounds(20, 340, 250, 50);
//
//        pIdTf = new JTextField();
//        pIdTf.setBounds(190, 20, 200, 50);
//
//        pNameTf = new JTextField();
//        pNameTf.setBounds(190, 100, 200, 50);
//
//        pPriceTf = new JTextField();
//        pPriceTf.setBounds(190, 180, 200, 50);
//
//        pQuantityTf = new JTextField();
//        pQuantityTf.setBounds(190, 260, 200, 50);
//
//        pCategoryTf = new JTextField();
//        pCategoryTf.setBounds(190, 340, 200, 50);
//
//        add(pId);
//        add(pName);
//        add(pPrice);
//        add(pQuantity);
//        add(pCategory);
//
//        add(pIdTf);
//        add(pNameTf);
//        add(pPriceTf);
//        add(pQuantityTf);
//        add(pCategoryTf);
//
//        insertbtn = new JButton("Insert");
//        insertbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        insertbtn.setBackground(Color.red);
//        insertbtn.setBounds(20, 400, 90, 60);
//        add(insertbtn);
//
//        delbtn = new JButton("Delete");
//        delbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        delbtn.setBackground(Color.red);
//        delbtn.setBounds(120, 400, 90, 60);
//        add(delbtn);
//
//        addbtn = new JButton("Add");
//        addbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        addbtn.setBackground(Color.red);
//        addbtn.setBounds(220, 400, 90, 60);
//        add(addbtn);
//        cancel = new JButton("Cancel");
//
//        cancel.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        cancel.setBackground(Color.red);
//        cancel.setBounds(320, 400, 90, 60);
//        add(cancel);
//
//        refresh = new JButton("Refresh");
//        refresh.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        refresh.setBackground(Color.red);
//        refresh.setBounds(320, 470, 100, 60);
//        add(refresh);
//
//        //search btn work 
//        serachTf = new JTextField();
//        serachTf.setBounds(190, 550, 190, 60);
//        add(serachTf);
//        searchbtn = new JButton("serach ");
//        searchbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        searchbtn.setBackground(Color.red);
//        searchbtn.setBounds(10, 550, 120, 60);
//        add(searchbtn);
//
//        Object data[][] = {};
//        String columnNames[] = {"Id", "Name", "Price", "Quantity", "Category"};
//        model = new DefaultTableModel(data, columnNames);
//        table = new JTable(model);
//        table.setRowHeight(24);
//        table.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
//        sp = new JScrollPane(table);
//
//        sp.setBounds(560, 10, 485, 480);
//        add(sp);
//
//        //////////////////////////////////
//        // DB
////        table.addMouseListener(new MouseAdapter() {
////            @Override
////            public void mouseClicked(MouseEvent e) {
////                int rowIndex = table.getSelectedRow();
////                //System.out.println(rowIndex);
////                dbName = (String) model.getValueAt(rowIndex, 1);//row, column
////                dbPhone = (String) model.getValueAt(rowIndex, 2);
////                dbEmail = (String) model.getValueAt(rowIndex, 3);
////                dbAddress = (String) model.getValueAt(rowIndex, 4);
////
////                userName.setText(dbName);
////                userPhone.setText(dbPhone);
////                userEmail.setText(dbEmail);
////                userAdress.setText(dbAddress);
////            }
////        });
//// data mouse event to textfield
//        table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                df = (DefaultTableModel) table.getModel();
//                int selected = table.getSelectedRow();
//                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));
//
//                dbId = (String) model.getValueAt(selected, 0);//row, column
//                dbName = (String) model.getValueAt(selected, 1);//row, column
//                dbPrice = (String) model.getValueAt(selected, 2);
//                dbQuantity = (String) model.getValueAt(selected, 3);
//                dbCategory = (String) model.getValueAt(selected, 4);
//
//                pIdTf.setText(dbId);
//                pNameTf.setText(dbName);
//                pPriceTf.setText(dbPrice);
//                pQuantityTf.setText(dbQuantity);
//                pCategoryTf.setText(dbCategory);
//
//                insertbtn.setEnabled(false);
//            }
//
//        });
//
//        insertbtn.addActionListener(this);
//        refresh.addActionListener(this);
//        addbtn.addActionListener(this);
//        delbtn.addActionListener(this);
//        cancel.addActionListener(this);
//        searchbtn.addActionListener(this);
//
//        this.setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == insertbtn) {
//            try {
//
//                String userIdRecive = pIdTf.getText();
//                String userNameRecive = pNameTf.getText();
//                String userPriceRecive = pPriceTf.getText();
//                String userQuantityRecive = pQuantityTf.getText();
//                String userCategoryRecive = pCategoryTf.getText();
//
//                pst = con.prepareStatement("insert into products(Id, Name, Price, Quantity, Category)values(?,?,?,?,?)");
//                pst.setString(1, userIdRecive);
//                pst.setString(2, userNameRecive);
//                pst.setString(3, userPriceRecive);
//                pst.setString(4, userQuantityRecive);
//                pst.setString(5, userCategoryRecive);
//
//                pst.executeUpdate();
//                JOptionPane.showMessageDialog(this, "This is  Products Added ");
//
//                pIdTf.setText("");
//                pNameTf.setText("");
//                pPriceTf.setText("");
//                pQuantityTf.setText("");
//                pCategoryTf.setText("");
//                pIdTf.requestFocus();
//                load();
//
//            } catch (SQLException ex) {
//                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (e.getSource() == refresh) {
//            table.setModel(new DefaultTableModel(null, new String[]{"Id", "Name", "Price", "Quantity", "Category"}));
//            load();
//        } else if (e.getSource() == addbtn) {
//            try {
//                df = (DefaultTableModel) table.getModel();
//                int selected = table.getSelectedRow();
//
//                int userIdRecive = Integer.parseInt((df.getValueAt(selected, 0).toString()));
//
//                int userPriceRecive = Integer.parseInt((df.getValueAt(selected, 2).toString()));
//                int userQuantityRecive = Integer.parseInt((df.getValueAt(selected, 3).toString()));
//
//                String userNameRecive = pNameTf.getText();
//
//                String userCategoryRecive = pCategoryTf.getText();
//
//                pst = con.prepareStatement("update products set Id =? ,Name =?,Price =? ,Quantity =?,Category=? where id =?");
//
//                pst.setInt(1, userIdRecive);
//                pst.setString(2, userNameRecive);
//                //pst.setString(3, userNameRecive);
//                pst.setInt(3, userPriceRecive);
//                pst.setInt(4, userQuantityRecive);
//                pst.setString(5, userCategoryRecive);
//                pst.setInt(6, userIdRecive);
//
//                pst.executeUpdate();
//
//                JOptionPane.showMessageDialog(this, "This is  products Updated ");
//
//                pIdTf.setText("");
//                pNameTf.setText("");
//                pPriceTf.setText("");
//                pQuantityTf.setText("");
//                pCategoryTf.setText("");
//                pIdTf.requestFocus();
//                load();
//                //that means my update is done so edit is onpen 
//                insertbtn.setEnabled(true);
//
//            } catch (SQLException ex) {
//                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (e.getSource() == delbtn) {
//            try {
//                df = (DefaultTableModel) table.getModel();
//                int selected = table.getSelectedRow();
//                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));
//
//                pst = con.prepareStatement("delete from vendor where id =?");
//
//                pst.setInt(1, id);
//
//                pst.executeUpdate();
//
//                JOptionPane.showMessageDialog(this, "This is vender Deleted ");
//
//                pIdTf.setText("");
//                pNameTf.setText("");
//                pPriceTf.setText("");
//                pQuantityTf.setText("");
//                pCategoryTf.setText("");
//                pIdTf.requestFocus();
//                load();
//                //that means my update is done so edit is onpen 
//                insertbtn.setEnabled(true);
//
//            } catch (SQLException ex) {
//                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (e.getSource() == cancel) {
//            pIdTf.setText("");
//            pNameTf.setText("");
//            pPriceTf.setText("");
//            pQuantityTf.setText("");
//            pCategoryTf.setText("");
//            pIdTf.requestFocus();
//            load();
//            //that means my update is done so edit is onpen 
//            insertbtn.setEnabled(true);
//        } else if (e.getSource() == searchbtn) {
//            JOptionPane.showMessageDialog(null, " I am From Search Box Here ");
//
//            int a;
//       //    serachTf.getText();
//            try {
//                pst = con.prepareStatement("select * from products WHERE Category = '"+serachTf.getText()+"' ");
//
//                ResultSet rs = pst.executeQuery();
//                ResultSetMetaData rd = rs.getMetaData();
//
//                a = rd.getColumnCount();
//                df = (DefaultTableModel) table.getModel();
//                df.setRowCount(0);
//                //table = (DefaultTableModel)table.getModel();
//
//                while (rs.next()) {
//                    Vector v2 = new Vector();
//                    for (int i = 1; i <= a; i++) {
//                        v2.add(rs.getString("Id"));
//                        v2.add(rs.getString("Name"));
//                        v2.add(rs.getString("Price"));
//                        v2.add(rs.getString("Quantity"));
//                        v2.add(rs.getString("Category"));
//                    }
////                Object newRow[]= {Name,,id};
////				model.addRow(newRow);
//                    df.addRow(v2);
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new MultipleCategoryTest();
//    }
//}
