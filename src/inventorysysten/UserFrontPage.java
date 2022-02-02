package inventorysysten;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
 
public class UserFrontPage extends JFrame implements ActionListener {

    Container container;
    JLabel imageLabel;
    ImageIcon icon;
    Font font1;

    JScrollPane ScrollPane;
    JTextField searchtxt;
    JButton searchBtn, viewDataBtn, orderBtn, backBtn;

    public UserFrontPage() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //this.setBounds(50, 10, 1150, 640);
        this.setSize(1150, 640);
        this.setLocationRelativeTo(null);
        
        this.setTitle("Front Page");
        this.setResizable(false);

        container = this.getContentPane();
        container.setLayout(null);

        icon = new ImageIcon(getClass().getResource("blank.png"));

        imageLabel = new JLabel(icon);
        imageLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        container.add(imageLabel);

        font1 = new Font("Time new Roman", Font.BOLD, 30);

        viewDataBtn = new JButton("View Products");
        viewDataBtn.setBounds(150, 315, 280, 75);
        viewDataBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        viewDataBtn.setFocusable(false);
        viewDataBtn.setBackground(Color.decode("#00A86B"));
        viewDataBtn.setFont(font1);
        imageLabel.add(viewDataBtn);

        orderBtn = new JButton("Purchase Item");
        orderBtn.setBounds(645, 315, 280, 75);
        orderBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        orderBtn.setFocusable(false);
        orderBtn.setBackground(Color.decode("#D7BFDC"));
        orderBtn.setFont(font1);
        imageLabel.add(orderBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(405, 435, 280, 75);
        backBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        backBtn.setFocusable(false);
        backBtn.setBackground(Color.decode("#34C3E7"));
        backBtn.setFont(font1);
        imageLabel.add(backBtn);

         
        viewDataBtn.addActionListener(this);
        orderBtn.addActionListener(this);
        backBtn.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserFrontPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewDataBtn) {
            dispose();
            new UserViewData();
        } else if (e.getSource() == orderBtn) {
            dispose();
            new PurchaseOrderUser();
        }else if (e.getSource() ==  backBtn) {
            dispose();
            new ADminUser();
        }
    }
}
