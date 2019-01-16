package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test;

public class ModbusIntConvertFloat {

	

	    public static void main(String[] args){ 
	        int decimal = 16691;
	        int decimal1 = 24576;
	        System.out.println("十进制数 " + decimal1 +"的十六进制数为: " + decimalToHex(decimal1)); 
	      
	    } 
	    
	    public static String decimalToHex(int decimal) { 
	        String hex = ""; 
	        while(decimal != 0) { 
	            int hexValue = decimal % 16; 
	            hex = toHexChar(hexValue) + hex; 
	            decimal = decimal / 16; 
	        } 
	        return  hex; 
	    } 
	    //将0~15的十进制数转换成0~F的十六进制数 
	    public static char toHexChar(int hexValue) { 
	        if(hexValue <= 9 && hexValue >= 0) 
	            return (char)(hexValue + '0'); 
	        else 
	            return (char)(hexValue - 10 + 'A'); 
	    } 
	} 

