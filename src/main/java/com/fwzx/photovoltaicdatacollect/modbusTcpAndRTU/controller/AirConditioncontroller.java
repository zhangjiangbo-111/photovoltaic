package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.controller;

public class AirConditioncontroller extends BaseController implements Runnable {

	
	public void run(){
		for(int i =0; i < 50000; i++){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("AA运行    "+i);
		}
	}
}
