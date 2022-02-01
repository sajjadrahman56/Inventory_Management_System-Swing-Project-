package inventorysysten;

//package TableDeno;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPasswordField;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
////import project_swing.DatabaseConnect;
//
//public class purchaseItem extends JFrame {
//
//    Container container;
//    JLabel imageLabel;
//    ImageIcon icon;
//    JTextField idField, nameField, qantitiField, priceField, totalCostTf, PaymentTf, BalanceTf;
//    JPasswordField pf1, pass;
//    JButton addbtn;
//    Font f1, f2;
//    JTable table;
//
//    DefaultTableModel model, df;
//
//    JLabel pId, pName, pPrice, pQuantity, pCategory, totalCost, Payment, Balance;
//    JScrollPane sp;
//    Connection con;
//    PreparedStatement pst;
//
//    purchaseItem() {
//        initComponent();
//    }
//
//    public void initComponent() {
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(null);
//        this.setBounds(200, 100, 1200, 700);
//        // this.setBounds(200, 100, 800, 550);
//        this.setTitle("Purchase Form");
//        //  this.setResizable(false);
//
//        container = this.getContentPane();
//        container.setLayout(null);
//
//        f1 = new Font("Time new Roman", Font.BOLD, 16);
//        f2 = new Font("Arial", Font.BOLD + Font.ITALIC, 25);
//
//        icon = new ImageIcon(getClass().getResource("purchaseFrom.png"));
//
//        imageLabel = new JLabel(icon);
//        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//        container.add(imageLabel);
//
//        idField = new JTextField();
//        idField.setBounds(10, 200, 175, 40);
//        idField.setFont(f1);
//        imageLabel.add(idField);
//
//        nameField = new JTextField();
//        nameField.setBounds(250, 200, 175, 40);
//        nameField.setFont(f1);
//        imageLabel.add(nameField);
//
//        priceField = new JTextField();
//        priceField.setBounds(480, 200, 175, 40);
//        priceField.setFont(f1);
//        imageLabel.add(priceField);
//
//        qantitiField = new JTextField();
//        qantitiField.setBounds(730, 200, 170, 40);
//        qantitiField.setFont(f1);
//        imageLabel.add(qantitiField);
//
//        addbtn = new JButton("Add");
//        addbtn.setBounds(960, 170, 100, 60);
//        addbtn.setFont(f1);
//        addbtn.setFocusable(false);
//        imageLabel.add(addbtn);
//
//        Object data[][] = {};
//        String columnNames[] = {"Product Id", "Product Name", "Price", "Quantity", "Total"};
//        model = new DefaultTableModel(data, columnNames);
//        table = new JTable(model);
//        table.setRowHeight(24);
//        table.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
//        sp = new JScrollPane(table);
//
//        sp.setBounds(20, 300, 600, 300);
//        imageLabel.add(sp);
//
//        totalCost = new JLabel("Total Cost");
//        totalCost.setBounds(750, 300, 200, 60);
//        totalCost.setFont(f2);
//        imageLabel.add(totalCost);
//
//        totalCostTf = new JTextField();
//        totalCostTf.setBounds(750, 360, 200, 40);
//        totalCostTf.setFont(f1);
//        imageLabel.add(totalCostTf);
//
//        Payment = new JLabel("Payment ");
//        Payment.setBounds(750, 400, 200, 60);
//        Payment.setFont(f2);
//        
//        imageLabel.add(Payment);
//        
//        PaymentTf = new JTextField();
//        PaymentTf.setBounds(750, 460, 200, 40);
//        PaymentTf.setFont(f1);
//        imageLabel.add(PaymentTf);
//
//         Balance = new JLabel("Payment ");
//        Balance.setBounds(750, 500, 200, 60);
//        Balance.setFont(f2);
//        
//        imageLabel.add(Balance);
//        
//        BalanceTf = new JTextField();
//        BalanceTf.setBounds(750, 560, 200, 40);
//       BalanceTf.setFont(f1);
//        imageLabel.add(BalanceTf);
//        this.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new purchaseItem();
//    }
//}
