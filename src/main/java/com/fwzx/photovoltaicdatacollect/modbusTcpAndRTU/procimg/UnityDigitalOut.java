package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.procimg;

import net.wimpi.modbus.procimg.DigitalIn;

public class UnityDigitalOut implements DigitalIn {

	protected boolean m_Set;
	
	public UnityDigitalOut(){
		
	}
	
	public UnityDigitalOut(boolean b){
		set(b);
	}
	public boolean isSet() {
		// TODO Auto-generated method stub
		return m_Set;
	}
	
	public synchronized void set(boolean b){
		m_Set = b;
		onChanged();
	}

	public void onChanged(){
		System.out.println(">>>>>>>>>>>>>UnityDigitalOut:这里set了值:"+ m_Set);
	}
}
