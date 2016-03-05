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
        else if(a.equals("Kilograms")&& b.equals("Pounds")){
            result= kilogramsToPounds();
        }
        else if(a.equals("Pounds")&& b.equals("Kilograms"))
            result = poundsToKilograms();
        else result= 0;
        Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return (td.toString()+unit);
    }

    private double kilogramsToPounds(){
        unit = " lb";
        return (value*2.2046);
    }
    private double poundsToKilograms(){
        unit = " kg";
        return (value/2.2046);
    }

}
