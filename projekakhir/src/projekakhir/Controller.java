/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekakhir;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Radhiya & Syifa
 */

public class Controller {
    Model model;
    View view;
    
    public String data;
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        if (model.getBanyakData()!=0) {
            String data[][] = model.readContact(); // memanggil class model dengan sintax readcontact
            view.tabelData.setModel((new JTable(data, view.namaKolom)).getModel()); // data ditampilkan
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.tabelData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) { //fungsinya untuk mengklik data tabel dan ditampilkan di kolom-kolom
                String data[][] = model.readContact();
                int row = view.tabelData.getSelectedRow();
                view.textID.setEditable(true);
                view.baris = row;
                view.textID.setText(data[row][0]);                
                view.textBarang.setText(data[row][1]);
                view.textKasir.setText(data[row][2]);
                view.textQuantity.setText(data[row][3]);
                view.textHarga.setText(data[row][4]);
                view.textDiskon.setText(data[row][5]);
            }
        });
        
        view.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cari = view.getCari();//mengambil inputan dari data di kasir
                model.setCari(cari);//memanggil pencarian
                String data[][] = model.cari(model);
                view.tabelData.setModel((new JTable(data, view.namaKolom)).getModel());//tampilkan hasil
            }
        });
        
         view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ID = view.getID();
                String Barang = view.getBarang();
                String Kasir = view.getKasir();
                int Quantity = Integer.parseInt(view.getQuantity());
                double Harga = Double.parseDouble(view.getHarga());
                double Diskon = Double.parseDouble(view.getDiskon());
                double Total = Quantity*(Harga-(Harga*(Diskon/100)));
                model.insertData(ID, Barang, Kasir, Quantity, Harga, Diskon, Total);
         
                String data[][] = model.readContact();
                view.tabelData.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
         
          view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Baris = "+view.getBaris());
                if(view.getBaris()<0){
                    JOptionPane.showMessageDialog(null, "Pilih Data yang mau diupdate!");
                }
                else{ 
                    String ID = view.getID();
                    String Barang = view.getBarang();
                    String Kasir = view.getKasir();
                    int Quantity = Integer.parseInt(view.getQuantity());
                    double Harga = Double.parseDouble(view.getHarga());
                    double Diskon = Double.parseDouble(view.getDiskon());
                    double Total = Quantity*(Harga-(Harga*(Diskon/100)));
                    model.updateData(ID, Barang, Kasir, Quantity, Harga, Diskon, Total);
            
                    String data[][] = model.readContact();
                    view.tabelData.setModel((new JTable(data, view.namaKolom)).getModel());
                }
            }
        });
         
          view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                view.textID.setText("");
                view.textBarang.setText("");
                view.textKasir.setText("");
                view.textQuantity.setText("");
                view.textHarga.setText("");
                view.textDiskon.setText("");
            }
        });
        
          view.tabelData.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = view.tabelData.getSelectedRow();
                data = view.tabelData.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[7];
                dataUpdate[0] = view.tabelData.getValueAt(baris, 0).toString();
                dataUpdate[1] = view.tabelData.getValueAt(baris, 1).toString();
                dataUpdate[2] = view.tabelData.getValueAt(baris, 2).toString();
                dataUpdate[3] = view.tabelData.getValueAt(baris, 3).toString();
                dataUpdate[4] = view.tabelData.getValueAt(baris, 4).toString();
                dataUpdate[5] = view.tabelData.getValueAt(baris, 5).toString();
                dataUpdate[6] = view.tabelData.getValueAt(baris, 6).toString();
                System.out.println(data);
            }
           });
                  
        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            System.out.println("Baris = "+view.getBaris());
                if(view.getBaris()<0){
                JOptionPane.showMessageDialog(null, "Pilih Data yang mau dihapus!");
                } 
                else{
                    model.deleteContact(data);
                    String data[][] = model.readContact();
                    view.tabelData.setModel((new JTable(data, view.namaKolom)).getModel());
                }
            }
        });

    }
}