package inventorysysten;

import com.mysql.cj.xdevapi.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class PurchaseOrderUser extends JFrame implements ActionListener {

    Container container;
    JLabel imageLabel;
    ImageIcon icon;
    Font font1;
    JTable orderInsertTable;
    JTextField productIDtext, productNametext, productpricetext,
            quantitytext, paymentText, totalCostText, balanceText;
    JButton addBtn, addBtnLast,  backBtn;
    DefaultTableModel model;
    JScrollPane ScrollPane;

    String cols[] = {"Product ID", "Product Name", "Price", "Quantity", "Total"};

    String[][] row = {};
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    JComboBox combox;
    ResultSet rs;
    Vector v2 = new Vector();

    PurchaseOrderUser() {
        initComponent();
        connect();
        combox();
    }

    public void initComponent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
       // this.setBounds(0, 0, 1243, 900);
        this.setSize(1243, 900);
        this.setLocationRelativeTo(null);

        this.setTitle("Puchase ");
        //this.setResizable(false);

        container = this.getContentPane();
        container.setLayout(null);

        font1 = new Font("Time new Roman", Font.BOLD, 16);

        icon = new ImageIcon(getClass().getResource("Purchase.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        container.add(imageLabel);

        productIDtext = new JTextField();
        productIDtext.setBounds(75, 200, 170, 40);
        productIDtext.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        productIDtext.setFont(font1);
        imageLabel.add(productIDtext);

        productNametext = new JTextField();
        productNametext.setBounds(290, 200, 170, 40);
        productNametext.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        productNametext.setFont(font1);
        imageLabel.add(productNametext);

        productpricetext = new JTextField();
        productpricetext.setBounds(510, 200, 140, 40);
        productpricetext.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        productpricetext.setFont(font1);
        imageLabel.add(productpricetext);

        quantitytext = new JTextField();
        quantitytext.setBounds(700, 200, 150, 40);
        quantitytext.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        quantitytext.setFont(font1);
        imageLabel.add(quantitytext);

        model = new DefaultTableModel(row, cols);

        orderInsertTable = new JTable(model);
        orderInsertTable.setSelectionBackground(Color.decode("#D7BFDC"));
        orderInsertTable.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));

        ScrollPane = new JScrollPane(orderInsertTable);
        ScrollPane.setBounds(75, 280, 820, 300);
        ScrollPane.setFont(font1);
        imageLabel.add(ScrollPane);

        totalCostText = new JTextField();
        totalCostText.setBounds(160, 630, 160, 60);
        totalCostText.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        totalCostText.setFont(font1);
        imageLabel.add(totalCostText);

        paymentText = new JTextField();
        paymentText.setBounds(400, 630, 160, 60);
        paymentText.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        paymentText.setFont(font1);
        imageLabel.add(paymentText);

        balanceText = new JTextField();
        balanceText.setBounds(640, 630, 160, 60);
        balanceText.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        balanceText.setFont(font1);
        imageLabel.add(balanceText);

        JLabel userNameDb = new JLabel("User Name");
        userNameDb.setBounds(950, 130, 150, 50);
        userNameDb.setFont(font1);
         imageLabel.add(userNameDb);
        
        combox = new JComboBox();
        combox.setBounds(950, 190, 150, 50);
        imageLabel.add(combox);

//Jbutton
        addBtn = new JButton("Add Table");
        addBtn.setBounds(950, 270, 120, 70);
        addBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        addBtn.setBackground(Color.decode("#98FB98"));
        addBtn.setFocusable(false);
        addBtn.setFont(font1);
        imageLabel.add(addBtn);

        addBtnLast = new JButton("Save Database");
        addBtnLast.setBounds(880, 650, 200, 90);
        addBtnLast.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        addBtnLast.setBackground(Color.decode("#98FB98"));
        addBtnLast.setFocusable(false);
        addBtnLast.setFont(font1);
        imageLabel.add(addBtnLast);

        backBtn = new JButton("Back");
        backBtn.setBounds(500, 780, 150, 60);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        backBtn.setBackground(Color.decode("#34C3E7"));
        backBtn.setFocusable(false);
        backBtn.setFont(font1);
        imageLabel.add(backBtn);

        //  productNametext.addKeyListener(l);
        productIDtext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    productIdFound();
                }
            }

        });
        paymentText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int pay = Integer.parseInt(paymentText.getText());
            
            int total = Integer.parseInt(totalCostText.getText());

            int restamount = pay - total;
         

            balanceText.setText( String.valueOf(restamount));
                }
            }

        });

        addBtn.addActionListener(this);
        addBtnLast.addActionListener(this);
         backBtn.addActionListener(this);

        this.setVisible(true);

    }

    public void productIdFound() {

        try {
            String prodcutCode = productIDtext.getText();

            pst = con.prepareStatement("select * from products where id = ?");
            pst.setString(1, prodcutCode);
            rs = pst.executeQuery();

            if (rs.next() == false) {
                JOptionPane.showMessageDialog(null, "product id missing");
            } else {
                String productNameDb = rs.getString("Name");
                String productPriceDb = rs.getString("Price");

                productNametext.setText(productNameDb);
                productpricetext.setText(productPriceDb);
                quantitytext.requestFocus();

            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrderUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void combox() {
        try {
            pst = con.prepareStatement("select Distinct userName from userinformation");

            rs = pst.executeQuery();
            combox.removeAllItems();

            while (rs.next()) {
                combox.addItem(rs.getString("userName"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrderUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void orderInsetIntoTalble() {

        int price = Integer.parseInt(productpricetext.getText());
        int quantity = Integer.parseInt(quantitytext.getText());

        int totalCostOrder = price * quantity;

        model = (DefaultTableModel) orderInsertTable.getModel();

        model.addRow(new Object[]{
            productIDtext.getText(), productNametext.getText(), productpricetext.getText(),
            quantitytext.getText(), totalCostOrder
        }
        );

        // calcultate ammount after data insert into table and set total cost text field 
        int totalCostAfterOrder = 0;
        for (int i = 0; i < orderInsertTable.getRowCount(); i++) {
            totalCostAfterOrder += Integer.parseInt(orderInsertTable.getValueAt(i, 4).toString());
        }

        totalCostText.setText(String.valueOf(totalCostAfterOrder));

        productIDtext.setText("");
        productNametext.setText("");
        productpricetext.setText("");
        quantitytext.setText("");

    }

    
    // here i can make it big at a time so cool boss 
    
    
    public void dataInsrtInDbAfterOrder() {
        try {
            DateTimeFormatter dfSet = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime nowTime = LocalDateTime.now();

            String username = combox.getSelectedItem().toString();
            String date = dfSet.format(nowTime);
            String totalcost = totalCostText.getText();
            String payment = paymentText.getText();
            String balance = balanceText.getText();

            int lastId = 0;

            String query1 = "insert into purchasehistory(username,date,totalcost,payment,balance)values(?,?,?,?,?)";
            pst1 = con.prepareStatement(query1);

            pst1.setString(1, username);
            pst1.setString(2, date);
            pst1.setString(3, totalcost);
            pst1.setString(4, payment);
            pst1.setString(5, balance);

            pst1.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrderUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new PurchaseOrderUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBtn) {

            orderInsetIntoTalble();

        } else if (e.getSource() == addBtnLast) {

            
            dataInsrtInDbAfterOrder();

        }else if (e.getSource() ==  backBtn) {

            
            dispose();
            new UserFrontPage();

        }
        

    }

}
