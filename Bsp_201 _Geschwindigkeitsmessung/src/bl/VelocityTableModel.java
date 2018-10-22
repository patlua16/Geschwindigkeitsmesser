/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import graphic.VelocityDlg;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lukas
 */
public class VelocityTableModel extends AbstractTableModel{
     private java.util.List<Measurment> liste = new ArrayList<>();
     public static final String[] colNames = {"Datum", "Uhrzeit", "Kennzeichen","Gemessen", 
     "Erlaubt", "Übertretung"};
    private JFileChooser chooser = new JFileChooser(new File("."));
     @Override
    public int getRowCount() {
        return liste.size();
    }
    public void save(File f)throws Exception
    {
         OutputStream fos = null;
        try{
           fos = new FileOutputStream(f);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Measurment s: liste) {
                oos.writeObject(s);
            }
        }catch(IOException ex)
        {
            //Log
            System.err.println("Save: "+ex.getMessage());
            throw ex; //Weiterleiten des Exception/des Exception-Objekts
            
        }finally{
            fos.close();
            
        }  
    }
    public void load(File f)throws Exception
    {
       InputStream fis = null;
        liste = new LinkedList<>(); //ODER schuelerListe.clear();   //leere Liste
        try{
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Einlesen
            while(true) //Einlesen bis EOF (End of FILE) Exception geworfen wird
            {
                Measurment s = (Measurment) ois.readObject();
                liste.add(s);
            }
        }catch(EOFException ex)
        {
            System.err.println("LOAD:EOF erkannt!");
            
            //do nix, weil EOF erkannt!!!!
        }catch(IOException ex)
        {
            System.err.println("Load:" +ex.getMessage());
            throw ex;
        }finally{
            fis.close();
        }  
        
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Geschwindigkeitsmessung!\n");
        for (Measurment s : liste) {
           sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public int getColumnCount() {
       return colNames.length;
    }
   
     @Override
    public String getColumnName(int column) {
        return colNames[column];
        
    }
     public void delete(int index) {
        this.liste.remove(index);
        super.fireTableDataChanged();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //da passt was nd
        Measurment s = liste.get(rowIndex);
        return s;   
    }
    public void addElement(Measurment element)
    {
        this.liste.add(element);
        super.fireTableDataChanged();
    }
    public void clear()
    {
        liste.clear();
    }
    
    
}
