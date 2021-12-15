package fr.uge.psw.ifcars;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CleintCarGraph {
    private JPanel carsPanel = new JPanel();
    private JButton add = new JButton();
    private JTextField marque;
    private JTextField model;
    private JTextField id;
    private JTextField prix;
    private JTextField nb_location;
    private JButton del = new JButton();
    private JTable tableCars = new JTable();
    DefaultTableModel modelTab;

    public void createTable(){
        tableCars.setModel(new DefaultTableModel(
                null, new String[] {"ID","Marque","Model","Prix","Note"}
        ));
        modelTab = (DefaultTableModel) tableCars.getModel();
    }
    private long deleteSelectedRow(){
        List<Vector> selectedRows = new ArrayList();
        Vector rowData = modelTab.getDataVector();

        for (int row : tableCars.getSelectedRows()) {
            int modelRow = tableCars.convertRowIndexToModel(row);
            Vector rowValue = (Vector) rowData.get(modelRow);
            selectedRows.add(rowValue);
        }
        long rowDel = -1;
        for (Vector rowValue : selectedRows) {
            int rowIndex = rowData.indexOf(rowValue);
            modelTab.removeRow(rowIndex);
            rowDel = (long) rowValue.get(0);
        }
        return rowDel;
    }

    public CleintCarGraph() {
        createTable();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ISellCar v = (ISellCar) Naming.lookup("SellCarServer");
                    boolean result = v.add(marque.getText(),model.getText(),Integer.parseInt(id.getText()),
                            Integer.parseInt(prix.getText()),Integer.parseInt(nb_location.getText()));

                    if (result){
                        Car car = new Car(marque.getText(),model.getText(),Integer.parseInt(id.getText()),
                                Integer.parseInt(prix.getText()),Integer.parseInt(nb_location.getText()));
                        try {
                            modelTab.addRow(new Object[] {car.getID(),car.getMarque(),car.getModel(),car.getPrix(),car.getNote()});
                        } catch (RemoteException remoteException) {
                            remoteException.printStackTrace();
                        }
                    }
                    v.listCars().forEach(c-> {

                        try {
                            System.out.println(c.getInformation());
                        } catch (RemoteException remoteException) {
                            remoteException.printStackTrace();
                        }
                    });
                }catch (Exception exception){
                    System.out.println("Exception " + exception);
                }
            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ISellCar v = (ISellCar) Naming.lookup("SellCarServer");
                    ICar car = v.del(deleteSelectedRow());
                    v.listCars().forEach(c-> {
                        try {
                            System.out.println(c.getInformation());
                        } catch (RemoteException remoteException) {
                            remoteException.printStackTrace();
                        }
                    });
                }catch (Exception ex){
                    System.out.println("Exception " + ex);
                }
            }
        });

        try {
            ISellCar v = (ISellCar) Naming.lookup("SellCarServer");
            v.listCars().forEach(c-> {
                try {
                    modelTab.addRow(new Object[] {c.getID(),c.getMarque(),c.getModel(),c.getPrix(),c.getNote()});
                    System.out.println(c.getInformation());
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            });
        }catch (Exception exception){
            System.out.println("Exception " + exception);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicule List");
        frame.setContentPane(new CleintCarGraph().carsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
