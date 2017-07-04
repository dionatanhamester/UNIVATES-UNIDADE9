/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dionatan
 */
public class Convert {
    
    /**
     * Busca Data/Hora Atual
     * @return String data/hora
     */
    public static String getCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date); //2016/11/16 12:08:43
    }
    
    /**
     * Realiza a Conversão de String para Date
     * @param d Data
     * @param format Formato da Data 
     * @return Date Data Formatadada
     * @throws ParseException Exception
     */
    public static Date stringToDate(String d, String format) throws ParseException{
        DateFormat formatter = new SimpleDateFormat(format);//"dd/MM/yyyy"
        Date date = (Date)formatter.parse(d);
        
        return date;
    }    
    
    /**
     * Realiza a conversão de Date para  String
     * @param date Data
     * @param format Formato da Data
     * @return String Data Formatada
     */
    public static String dateToString(Date date, String format){
       SimpleDateFormat FORMAT = new SimpleDateFormat(format);
       
        return FORMAT.format(date);
    }

}
