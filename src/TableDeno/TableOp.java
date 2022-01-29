///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package TableDeno;
//
// 
// 
//import java.awt.*;
//import java.awt.event.*;
//
//import javax.swing.*;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class TableOp  extends JFrame{
//	
//	JTable table;
//	JPanel tablePanel, OperationPanel;
//	JTextField serialText, nameText, idText;
//	JButton addBtn, updateBtn, deleteBtn;
//	String serial, name,id;
//	DefaultTableModel model;
//	
//	public TableOp() {
//		
//		setSize(500,450);
//		setDefaultCloseOperation(3);
//		//setResizable(false);
//		setLayout(null);
//		setLocationRelativeTo(null);
//		
//		tablePanel = new JPanel();
//		tablePanel.setBounds(0,0,500,200);
//		tablePanel.setBackground(Color.GRAY);
//		tablePanel.setLayout(null);
//		add(tablePanel);
//		
//		OperationPanel = new JPanel();
//		OperationPanel.setBounds(0,200,500,250);
//		OperationPanel.setLayout(null);
//		OperationPanel.setBackground(Color.GRAY);
//		add(OperationPanel);
//		
//		Object data[][]= {{"1","Abir","112233"},{"1","Hasan","112233"},{"1","Wasim","112233"}};
//		String columnNames[]= {"Serial","Name","id"};
//		//Creating table model
//		model = new DefaultTableModel(data,columnNames);
//		//Adding
//		table = new JTable(model);
//		JScrollPane sp = new JScrollPane(table);
//		sp.setBounds(10,10,465,280);
//		tablePanel.add(sp);
//		
//		
//		serialText.setBounds(150,10,200,30);
//		OperationPanel.add(serialText);
//		
//		nameText = new JTextField("Name");
//		nameText.setBounds(150,50,200,30);
//		OperationPanel.add(nameText);
//		
//		idText = new JTextField("ID");
//		idText.setBounds(150,90,200,30);
//		OperationPanel.add(idText);
//	
//		addBtn = new JButton("Add");
//		addBtn.setBounds(100,140,70,30);
//		OperationPanel.add(addBtn);
//		
//		updateBtn = new JButton("Update");
//		updateBtn.setBounds(195,140,80,30);
//		OperationPanel.add(updateBtn);
//		
//		deleteBtn = new JButton("Delete");
//		deleteBtn.setBounds(295,140,80,30);
//		OperationPanel.add(deleteBtn);
//		
//		addBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				 serial = serialText.getText();
//				 name = nameText.getText();
//				 id = idText.getText();
//				
//				Object newRow[]= {serial,name,id};
//				model.addRow(newRow);
//				
//			}
//		});
//		
//		//Update
//		//Mouse Adapter Class
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int rowIndex = table.getSelectedRow();
//				//System.out.println(rowIndex);
//				serial = (String) model.getValueAt(rowIndex, 0);//row, column
//				name = (String) model.getValueAt(rowIndex, 1);
//				id = (String) model.getValueAt(rowIndex, 2);
//				
//				serialText.setText(serial);
//				nameText.setText(name);
//				idText.setText(id);
//			}
//		});
//		
//		 
//		
//		updateBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				 serial = serialText.getText();
//				 name = nameText.getText();
//				 id = idText.getText();
//				
//				 int row = table.getSelectedRow();
//				
//				model.setValueAt(serial, row, 0);
//				model.setValueAt(name, row, 1);
//				model.setValueAt(id, row, 2);
//				
//			}
//		});
//		
//		deleteBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				model.removeRow(table.getSelectedRow());
//				
//			}
//		});
//		setVisible(true);
//	
//		
//		
//	}
//        public static void main(String[] args) {
//        new TableOp();
//    }
//}