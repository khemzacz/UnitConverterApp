package com.example.konrad.firstapplication;

import java.math.BigDecimal;

/**
 * Created by Konrad on 3/5/2016.
 */
public class TemperatureConverter extends AbstractConverter{

    public TemperatureConverter(){

    }

    private double result;
    private double value;

    public String convert(String val,String a, String b){
        value = Double.parseDouble(val);
        if(a.equals(b))
            result= value;
        else if(a.equals("Celsius")&& b.equals("Fahrenheit")){
            result= CelsiusToFahrenheit(value);
        }
        else if(a.equals("Celsius")&& b.equals("Kelwin")){
            result= CelsiusToKelwin(value);
        }
        else if(a.equals("Fahrenheit")&& b.equals("Celsius")){
            result= FahrenheitToCelsius(value);
        }
        else if(a.equals("Fahrenheit")&& b.equals("Kelwin")){
            result= FahrenheitToKelwin(value);
        }
        else if(a.equals("Kelwin")&& b.equals("Fahrenheit")){
            result= KelwinToFahrenheit(value);
        }
        else if(a.equals("Kelwin")&& b.equals("Celsius")){
            result= KelwinToCelsius(value);
        }
        else result= 0;
        Double td = new BigDecimal(result).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        return (td.toString());
    }


    private double CelsiusToFahrenheit(double value){
        return (value*1.8+32);
    }
    private double CelsiusToKelwin(double value){
        return (value+273.15);
    }

    private double FahrenheitToCelsius(double value){
        return ((value-32)/1.8);
    }
    private double FahrenheitToKelwin(double value){
        return ((value+459.67)/1.8);
    }

    private double KelwinToCelsius(double value){
        return (value-273.15);
    }
    private double KelwinToFahrenheit(double value){
        return (value*1.8-459.67);
    }
}
