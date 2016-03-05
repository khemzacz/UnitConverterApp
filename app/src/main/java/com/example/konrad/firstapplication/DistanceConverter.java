package com.example.konrad.firstapplication;

import java.math.BigDecimal;

/**
 * Created by Konrad on 3/5/2016.
 */
public class DistanceConverter extends AbstractConverter {
    public DistanceConverter(){

    }

    private double result;
    private double value;
    private String unit;
    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b))
            result= value;
        else if(a.equals("Kilometers")&& b.equals("Miles")){
            result= kilometersToMiles();
        }
        else if(a.equals("Miles")&& b.equals("Kilometers"))
            result = milesToKilometers();
        else result= 0;
        Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return (td.toString()+unit);
    }

    private double kilometersToMiles(){
        unit = " mi";
        return (value/1.609344);
    }
    private double milesToKilometers(){
        unit = " km";
        return (value*1.609344);
    }

}
