/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author lukas
 */
public class Measurment implements Serializable{
    private final LocalDate datum;
    private final LocalTime uhrzeit;
    private final String kennzeichen;
    private final int vgemessen, verlaubt, übertreten;
    
    

    public Measurment(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int vgemessen, int verlaubt, int übertreten) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.vgemessen = vgemessen;
        this.verlaubt = verlaubt;
        this.übertreten=übertreten;
    }

    public int getÜberteten() {
        return übertreten;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public String kennzeichen() {
        return kennzeichen;
    }

    public int getVgemessen() {
        return vgemessen;
    }

    public int getVerlaubt() {
        return verlaubt;
    }

    @Override
    public String toString() {
        return datum +" - " +uhrzeit + " "+kennzeichen+" "+
        vgemessen+" "+verlaubt+" "+übertreten;
   }

    
    
    
    
}
