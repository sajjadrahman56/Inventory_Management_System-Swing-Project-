package inventorysysten;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AllUserNameWithDb extends JFrame implements ActionListener {

    JPanel panel1, panel2;
    Container container;
    JButton cancel, upbtn, delbtn, addbtn, ex, vendor, product, purchase, logOut, refresh;

    JTable table;
    JTextField serialText, nameText, idText, uptext, deltext, userName, userPhone, userEmail, userAdress;
    String name, serial, id, dbName, dbPhone, dbEmail, dbAddress;
    DefaultTableModel model, df;

    JLabel serialLabel, nameLabel, idJLabel, vendorName, phone, email, address;
    JScrollPane sp;
    Connection con;
    PreparedStatement pst;

    public AllUserNameWithDb() {

        initComponet();
        connect();
        load();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // con = DriverManager.getConnection("jdbc:mysql://localhost/sajjad","root","");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sajjad", "root", "");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load() {
        int a;
        try {
            pst = con.prepareStatement("select * from vendor");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd = rs.getMetaData();
            a = rd.getColumnCount();
            df = (DefaultTableModel) table.getModel();
            df.setRowCount(0);
            //table = (DefaultTableModel)table.getModel();

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= a; i++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("Name"));
                    v2.add(rs.getString("Phone"));
                    v2.add(rs.getString("Email"));
                    v2.add(rs.getString("Adress"));
                }
//                Object newRow[]= {Name,,id};
//				model.addRow(newRow);
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initComponet() {
        container = this.getContentPane();
        container.setLayout(null);
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        upbtn = new JButton("Edit");
        upbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
        upbtn.setBackground(Color.red);
        upbtn.setBounds(20, 320, 90, 60);
        add(upbtn);

        delbtn = new JButton("Delete");
        delbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
        delbtn.setBackground(Color.red);
        delbtn.setBounds(120, 320, 90, 60);
        add(delbtn);

        addbtn = new JButton("Add");
        addbtn.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
        addbtn.setBackground(Color.red);
        addbtn.setBounds(220, 320, 90, 60);
        add(addbtn);
        cancel = new JButton("Cancel");

        cancel.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
        cancel.setBackground(Color.red);
        cancel.setBounds(320, 320, 90, 60);
        add(cancel);

        refresh = new JButton("Refresh");
        refresh.setFont((new Font("Arial", Font.CENTER_BASELINE, 16)));
        refresh.setBackground(Color.red);
        refresh.setBounds(320, 420, 100, 60);
        add(refresh);

        vendorName = new JLabel("Name : ");
        vendorName.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
        phone = new JLabel("Phone : ");
        phone.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
        email = new JLabel("Email : ");
        email.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));
        address = new JLabel("Address : ");
        address.setFont((new Font("Arial", Font.CENTER_BASELINE, 18)));

        vendorName.setBounds(20, 20, 100, 50);
        phone.setBounds(20, 100, 100, 50);
        email.setBounds(20, 180, 100, 50);
        address.setBounds(20, 260, 100, 50);

        add(vendorName);
        add(phone);
        add(email);
        add(address);

        userName = new JTextField();
        userName.setBounds(150, 20, 150, 50);
        userPhone = new JTextField();
        userPhone.setBounds(150, 100, 150, 50);
        userEmail = new JTextField();
        userEmail.setBounds(150, 180, 150, 50);
        userAdress = new JTextField();
        userAdress.setBounds(150, 260, 150, 50);

        add(userName);
        add(userPhone);
        add(userAdress);
        add(userEmail);

        Object data[][] = {};
        String columnNames[] = {"Id", "Name", "Phone", "Email", "Adress"};
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setRowHeight(24);
        table.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        sp = new JScrollPane(table);

        sp.setBounds(520, 10, 465, 380);
        add(sp);

       
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                df = (DefaultTableModel) table.getModel();
                int selected = table.getSelectedRow();
                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));

                dbName = (String) model.getValueAt(selected, 1);//row, column
                dbPhone = (String) model.getValueAt(selected, 2);
                dbEmail = (String) model.getValueAt(selected, 3);
                dbAddress = (String) model.getValueAt(selected, 4);

                userName.setText(dbName);
                userPhone.setText(dbPhone);
                userEmail.setText(dbEmail);
                userAdress.setText(dbAddress);

                upbtn.setEnabled(false);
            }

        });

        upbtn.addActionListener(this);
        refresh.addActionListener(this);
        addbtn.addActionListener(this);
        delbtn.addActionListener(this);
        cancel.addActionListener(this);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AllUserNameWithDb();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == upbtn) {
            try {

                String userNameRecive = userName.getText();
                String userPhoneRecive = userPhone.getText();
                String userEmailRecive = userEmail.getText();
                String userAdressRecive = userAdress.getText();

                pst = con.prepareStatement("insert into vendor(Name,Phone,Email,Adress)values(?,?,?,?)");
                pst.setString(1, userNameRecive);
                pst.setString(2, userPhoneRecive);
                pst.setString(3, userEmailRecive);
                pst.setString(4, userAdressRecive);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "This is vender Added ");

                userName.setText("");
                userPhone.setText("");
                userEmail.setText("");
                userAdress.setText("");
                userName.requestFocus();
                load();

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == refresh) {
            table.setModel(new DefaultTableModel(null, new String[]{"Id", "Name", "Phone", "Email", "Adress"}));
            load();
        } else if (e.getSource() == addbtn) {
            try {
                df = (DefaultTableModel) table.getModel();
                int selected = table.getSelectedRow();
                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));

                String userNameRecive = userName.getText();
                String userPhoneRecive = userPhone.getText();
                String userEmailRecive = userEmail.getText();
                String userAdressRecive = userAdress.getText();
                pst = con.prepareStatement("update vendor set Name =?,Phone =? ,Email =?,Adress=? where id =?");
                pst.setString(1, userNameRecive);
                pst.setString(2, userPhoneRecive);
                pst.setString(3, userEmailRecive);
                pst.setString(4, userAdressRecive);
                pst.setInt(5, id);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "This is vender Updated ");

                userName.setText("");
                userPhone.setText("");
                userEmail.setText("");
                userAdress.setText("");
                userName.requestFocus();
                load();
               
                upbtn.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == delbtn) {
            try {
                df = (DefaultTableModel) table.getModel();
                int selected = table.getSelectedRow();
                int id = Integer.parseInt((df.getValueAt(selected, 0).toString()));

                pst = con.prepareStatement("delete from vendor where id =?");

                pst.setInt(1, id);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "This is vender Deleted ");

                userName.setText("");
                userPhone.setText("");
                userEmail.setText("");
                userAdress.setText("");
                userName.requestFocus();
                load();
                //that means my update is done so edit is onpen 
                upbtn.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(AllUserNameWithDb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == cancel) {
            userName.setText("");
            userPhone.setText("");
            userEmail.setText("");
            userAdress.setText("");
            userName.requestFocus();
            load();
            //that means my update is done so edit is onpen 
            upbtn.setEnabled(true);
        }
    }
}
