/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir;

/**
 *
 * @author Radhiya & Syifa
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame{
    JLabel judul = new JLabel("KASIR MINIMARKET BAROKAH");
    JLabel labelID = new JLabel("ID");
    JLabel labelBarang = new JLabel("Barang");
    JLabel labelKasir = new JLabel("Kasir");
    JLabel labelQuantity = new JLabel("Quantity");
    JLabel labelHarga = new JLabel("Harga");
    JLabel labelDiskon = new JLabel("Diskon (%)");
    JLabel labelTotal = new JLabel("Total");
    
    public JTextField textCari =  new JTextField();
    public JTextField textID = new JTextField();
    public JTextField textBarang = new JTextField();
    public JTextField textKasir = new JTextField();
    public JTextField textQuantity = new JTextField();
    public JTextField textHarga = new JTextField();
    public JTextField textDiskon = new JTextField();
    public JTextField textTotal = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Reset");
    public JButton btnCari = new JButton("Cari");
    
    public JTable tabelData;
    DefaultTableModel TableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID", "Barang", "Kasir", "Quantity", "Harga", "Diskon (%)", "Total"};
    int baris = -1;

    public View() {
        TableModel = new DefaultTableModel(namaKolom, 0);
        tabelData = new JTable(TableModel);
        scrollPane = new JScrollPane(tabelData);
        
        setTitle("Data Catatan Transaksi");
        setVisible(true);
        setSize(850, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(judul);
        add(textCari);
        add(labelID);
        add(labelBarang); 
        add(labelKasir); 
        add(labelQuantity); 
        add(labelHarga); 
        add(labelDiskon); 
        add(textID); 
        add(textBarang); 
        add(textKasir); 
        add(textQuantity); 
        add(textHarga); 
        add(textDiskon); 
        add(btnTambah); 
        add(btnUpdate); 
        add(btnDelete); 
        add(btnReset);
        add(btnCari);
        add(scrollPane); 
        scrollPane.setBounds(40,250,425,400);
        scrollPane.setSize(770, 325);
        
        judul.setBounds(350, 30, 200, 20);
        textCari.setBounds(590, 60, 150, 20);
        
        labelID.setBounds(60,100,50,20);
        labelBarang.setBounds(60,130,50,20);
        labelKasir.setBounds(60,160,50,20);
        labelQuantity.setBounds(400,100,50,20);
        labelHarga.setBounds(400,130,50,20);
        labelDiskon.setBounds(400,160,75,20);
        
        textID.setBounds(180,100,140,20);
        textBarang.setBounds(180,130,140,20);
        textKasir.setBounds(180,160,140,20);
        textQuantity.setBounds(550,100,140,20);
        textHarga.setBounds(550,130,140,20);
        textDiskon.setBounds(550,160,140,20);
        
        btnTambah.setBounds(200, 210, 90, 20);
        btnTambah.setBackground(Color.black);
        btnTambah.setForeground(Color.white);
        
        btnUpdate.setBounds(310, 210, 90, 20);
        btnUpdate.setBackground(Color.black);
        btnUpdate.setForeground(Color.white);
        
        btnDelete.setBounds(420, 210, 90, 20);
        btnDelete.setBackground(Color.black);
        btnDelete.setForeground(Color.white);
        
        btnReset.setBounds(530, 210, 90, 20);
        btnReset.setBackground(Color.black);
        btnReset.setForeground(Color.white);
        
        btnCari.setBounds(750, 60, 70, 20);
        btnCari.setBackground(Color.black);
        btnCari.setForeground(Color.white);
        
        scrollPane.setBounds(40,260,425,400);
        scrollPane.setSize(770, 335);
        
    }
    
    public int getBaris(){
        return baris;
    }

    public String getCari(){
        return textCari.getText();
    }
    
    public String getID(){
        return textID.getText();
    }
    
    public String getBarang(){
        return textBarang.getText();
    }
    
    public String getKasir(){
        return textKasir.getText();
    }
    
    public String getQuantity(){
        return textQuantity.getText();
    }

    public String getHarga(){
        return textHarga.getText();
    }

    public String getDiskon(){
        return textDiskon.getText();
    }

}