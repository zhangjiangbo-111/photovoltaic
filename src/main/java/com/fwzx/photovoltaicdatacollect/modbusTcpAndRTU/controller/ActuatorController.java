package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.controller;

public class ActuatorController extends BaseController implements Runnable {

	public void showTest(){
		System.out.println(">>>>>>>>>>>ActuatorController");
	}
	
	
	public void run(){
		for(int i = 0;i < 50000;i++){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("BB运行       "+i);
		}
		
	}
}
