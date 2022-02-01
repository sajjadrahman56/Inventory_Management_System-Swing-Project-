package inventorysysten;

//package TableDeno;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//
//
//public class CatTestDb extends JFrame implements ActionListener {
//
//    JPanel panel1, panel2;
//    Container container;
//    JButton cancel, upbtn, delbtn, addbtn, ex, vendor, product, purchase, logOut ,refresh;
//
//    JTable table;
//    JTextField serialText, nameText, idText, uptext, deltext, userName, userPhone, userEmail, userAdress;
//    String name, serial, id;
//    DefaultTableModel model,df;
//
//    JLabel serialLabel, nameLabel, idJLabel, vendorName, phone, email, address;
//     JScrollPane sp ;
//    Connection con;
//    PreparedStatement pst;
//
//    public CatTestDb() {
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
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sajjad", "root", "");
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(CategoryClass.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void load()
//    {
//        int a;
//        try {
//            pst = con.prepareStatement("select * from userinfo");
//            ResultSet rs = pst.executeQuery();
//            ResultSetMetaData rd = rs.getMetaData();
//            a = rd.getColumnCount();
//            df = (DefaultTableModel)table.getModel();
//            //table = (DefaultTableModel)table.getModel();
//            
//            while(rs.next())
//            {
//                Vector v2 = new Vector();
//                for(int i = 0 ; i <= a ; i++)
//                {
//                    v2.add(rs.getString("name"));
//                    v2.add(rs.getString("email"));
//                    v2.add(rs.getString("phone"));
//                    
//                    v2.add(rs.getString("address"));
//                }
////                Object newRow[]= {Name,,id};
////				model.addRow(newRow);
//                df.addRow(v2);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//
//    public void initComponet() {
//        container = this.getContentPane();
//        container.setLayout(null);
//        this.setSize(1200, 700);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//
//        upbtn = new JButton("Edit");
//        upbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        upbtn.setBackground(Color.red);
//        upbtn.setBounds(20, 320, 90, 60);
//        add(upbtn);
//
//        delbtn = new JButton("Delete");
//        delbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        delbtn.setBackground(Color.red);
//        delbtn.setBounds(120, 320, 90, 60);
//        add(delbtn);
//
//        addbtn = new JButton("Add");
//        addbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        addbtn.setBackground(Color.red);
//        addbtn.setBounds(220, 320, 90, 60);
//        add(addbtn);
//        cancel = new JButton("Cancel");
//
//        cancel.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        cancel.setBackground(Color.red);
//        cancel.setBounds(320, 320, 90, 60);
//        add(cancel);
//        
//        refresh = new JButton("Refresh");
//        refresh.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
//        refresh.setBackground(Color.red);
//        refresh.setBounds(320, 420, 100, 60);
//        add( refresh);
//        
//        vendorName = new JLabel("Name : ");
//        vendorName.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        phone = new JLabel("Phone : ");
//        phone.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        email = new JLabel("Email : ");
//        email.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//        address = new JLabel("Address : ");
//        address.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
//
//        vendorName.setBounds(20, 20, 100, 50);
//        phone.setBounds(20, 100, 100, 50);
//        email.setBounds(20, 180, 100, 50);
//        address.setBounds(20, 260, 100, 50);
//
//        add(vendorName);
//        add(phone);
//        add(email);
//        add(address);
//
//        userName = new JTextField();
//        userName.setBounds(150, 20, 150, 50);
//        userPhone = new JTextField();
//        userPhone.setBounds(150, 100, 150, 50);
//        userEmail = new JTextField();
//        userEmail.setBounds(150, 180, 150, 50);
//        userAdress = new JTextField();
//        userAdress.setBounds(150, 260, 150, 50);
//
//        add(userName);
//        add(userPhone);
//        add(userAdress);
//        add(userEmail);
//
//        Object data[][] = {};
//        String columnNames[] = {"id","name", "email", "phone", "address"};
//        model = new DefaultTableModel(data, columnNames);
//        table = new JTable(model);
//        table.setRowHeight(24);
//        table.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
//         sp = new JScrollPane(table);
//
//        sp.setBounds(520, 10, 465, 380);
//        add(sp);
//
//        //////////////////////////////////
//        // DB
//        upbtn.addActionListener(this);
//        refresh.addActionListener(this);
//        this.setVisible(true);
//    }
//
//    
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == upbtn) {
//            try {
//
//                String userNameRecive = userName.getText();
//                String userEmailRecive = userEmail.getText();
//                String userPhoneRecive = userPhone.getText();
//                String userAdressRecive = userAdress.getText();
//
//                pst = con.prepareStatement("insert into userinfo(name,email,phone,address)values(?,?,?,?)");
//                pst.setString(2, userNameRecive);
//                pst.setString(3, userEmailRecive);
//                pst.setString(4, userPhoneRecive);               
//                pst.setString(5, userAdressRecive);
//
//                pst.executeUpdate();
//                JOptionPane.showMessageDialog(this, "This is userinfo Added ");
//
//                userName.setText("");
//                userPhone.setText("");
//                userEmail.setText("");
//                userAdress.setText("");
//                userName.requestFocus();
//                // load();
//
//            } catch (SQLException ex) {
//                Logger.getLogger(CategoryClass.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        else if(e.getSource()==refresh)
//        {
//            load();
//        }
//    }
//    
//    public static void main(String[] args) {
//        new CatTestDb();
//    }
//}
