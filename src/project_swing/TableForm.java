package project_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class TableForm extends JFrame {

    Container c;
    JLabel imageLabel;
    ImageIcon icon;
    Font font1, font2;
    JTable table1;
    JComboBox comboBox;
    JTextField searchtxt, nametxt, pricetxt, quantitytxt;

    JPanel panel1, Panel2;
    JScrollPane ScrollPane;
    JButton searchBtn, addCategoryBtn, removeCategoryBtn, addBtn, updateBtn, deleteBtn, refreshBtn, viewBtn, orderBtn;

    DefaultTableModel model;

    String productName, productprice, quantity;

    String cols[] = {"Product Name", "Product Price", "Quantity"};

    String[][] row = {{" ", " ", " "}, {" ", " ", " "}};

    TableForm() {
        initComponent();
    }

    public void initComponent() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(50, 10, 1105, 668);

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
        searchtxt.setBounds(635, 135, 300, 35);
        searchtxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
//        searchtxt.setBorder(BorderFactory.createLineBorder(Color.blue));
        searchtxt.setFont(font1);
        imageLabel.add(searchtxt);
        
        
        ///comboBox 
        
        String [] category = {"SELECT", "Electronics", "Mobile", "Grocery"}; 
        comboBox = new JComboBox(category);
        comboBox.setBounds(190, 150, 190, 40);
        comboBox.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        comboBox.setFont(font1);
        comboBox.setEditable(true);
        imageLabel.add(comboBox);

        nametxt = new JTextField();
        nametxt.setBounds(190, 208, 190, 40);
        nametxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        nametxt.setFont(font1);
        imageLabel.add(nametxt);

        pricetxt = new JTextField();
        pricetxt.setBounds(190, 265, 190, 40);
        pricetxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        pricetxt.setFont(font1);
        imageLabel.add(pricetxt);

        quantitytxt = new JTextField();
        quantitytxt.setBounds(190, 322, 190, 40);
        quantitytxt.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        quantitytxt.setFont(font1);
        imageLabel.add(quantitytxt);

        //JButton
        searchBtn = new JButton("Search");
        searchBtn.setBounds(965, 135, 95, 35);
        searchBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        searchBtn.setFocusable(false);
        searchBtn.setBackground(Color.decode("#00A86B"));
        searchBtn.setFont(font2);
        imageLabel.add(searchBtn);

        removeCategoryBtn = new JButton("DELETE CATEGORY");
        removeCategoryBtn.setBounds(210, 115, 170, 30);
        removeCategoryBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        removeCategoryBtn.setBackground(Color.decode("#8A9A5B"));
        removeCategoryBtn.setFocusable(false);
        removeCategoryBtn.setFont(font2);
        imageLabel.add(removeCategoryBtn);

        addCategoryBtn = new JButton("ADD CATEGORY");
        addCategoryBtn.setBounds(390, 115, 150, 30);
        addCategoryBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        addCategoryBtn.setBackground(Color.decode("#E3B778"));
        addCategoryBtn.setFocusable(false);
        addCategoryBtn.setFont(font2);
        imageLabel.add(addCategoryBtn);

        deleteBtn = new JButton("DELETE");
        deleteBtn.setBounds(390, 155, 150, 30);
        deleteBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        deleteBtn.setBackground(Color.decode("#FA8072"));
        deleteBtn.setFocusable(false);
        deleteBtn.setFont(font2);
        imageLabel.add(deleteBtn);

        addBtn = new JButton("INSERT");
        addBtn.setBounds(390, 195, 150, 30);
        addBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        addBtn.setBackground(Color.decode("#73C2FB"));
        addBtn.setFocusable(false);
        addBtn.setFont(font2);
        imageLabel.add(addBtn);

        updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(390, 235, 150, 30);
        updateBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        updateBtn.setBackground(Color.decode("#98FB98"));
        updateBtn.setFocusable(false);
        updateBtn.setFont(font2);
        imageLabel.add(updateBtn);

        orderBtn = new JButton("ORDER");
        orderBtn.setBounds(390, 275, 150, 30);
        orderBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        orderBtn.setBackground(Color.decode("#F19CBB"));
        orderBtn.setFocusable(false);
        orderBtn.setFont(font2);
        imageLabel.add(orderBtn);

        viewBtn = new JButton("View");
        viewBtn.setBounds(390, 315, 150, 30);
        viewBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        viewBtn.setBackground(Color.decode("#29AB87"));
        viewBtn.setFocusable(false);
        viewBtn.setFont(font2);
        imageLabel.add(viewBtn);

        refreshBtn = new JButton("REFRESH");
        refreshBtn.setBounds(390, 355, 150, 30);
        refreshBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));
        refreshBtn.setBackground(Color.decode("#EB9605"));
        refreshBtn.setFocusable(false);
        refreshBtn.setFont(font2);
        imageLabel.add(refreshBtn);

        model = new DefaultTableModel(row, cols);

        table1 = new JTable(model);
        table1.setSelectionBackground(Color.decode("#D7BFDC"));
        table1.setBorder(BorderFactory.createLineBorder(Color.decode("#222021")));

        ScrollPane = new JScrollPane(table1);
        ScrollPane.setBounds(568, 190, 513, 270);
        ScrollPane.setFont(font2);
        imageLabel.add(ScrollPane);

        ///Data insert
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productName = nametxt.getText();
                productprice = pricetxt.getText();
                quantity = quantitytxt.getText();

                Object newRow[] = {productName, productprice, quantity};
                model.addRow(newRow);

            }
        });

        //Update
        //Mouse Adapter Class
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIndex = table1.getSelectedRow();
                //System.out.println(rowIndex);
                productName = (String) model.getValueAt(rowIndex, 0);//row, column
                productprice = (String) model.getValueAt(rowIndex, 1);
                quantity = (String) model.getValueAt(rowIndex, 2);

                nametxt.setText(productName);
                pricetxt.setText(productprice);
                quantitytxt.setText(quantity);
            }
        });

        updateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                productName = nametxt.getText();
                productprice = pricetxt.getText();
                quantity = quantitytxt.getText();

                int row = table1.getSelectedRow();

                model.setValueAt(productName, row, 0);
                model.setValueAt(productprice, row, 1);
                model.setValueAt(quantity, row, 2);

            }
        });
        
        deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeRow(table1.getSelectedRow());
				
			}
		});
        

        setVisible(true);
    }

    public static void main(String[] args) {
        new TableForm();
    }
}
