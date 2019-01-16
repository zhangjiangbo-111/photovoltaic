package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.DefaultProcessImageFactory;
import net.wimpi.modbus.procimg.ProcessImage;
import net.wimpi.modbus.procimg.ProcessImageFactory;

public class UnityModbusCoupler {

	//instance attributes
	private ProcessImage m_ProcessImage;
	private int m_UnitID = Modbus.DEFAULT_UNIT_ID;
	private boolean m_Master = true;
	private ProcessImageFactory m_PIFactory;
	
	public UnityModbusCoupler(){
		m_PIFactory = new DefaultProcessImageFactory();
		
	}//constructor
	
	
	public UnityModbusCoupler(ProcessImage procimg){
		setProcessImage(procimg);
	}
	
	public ProcessImageFactory getProcessImageFactory(){
		return m_PIFactory;
	}
	
	public void setProcessImageFactory(ProcessImageFactory factory){
		m_PIFactory = factory;
	}
	
	public synchronized ProcessImage getProcessImage(){
		return m_ProcessImage;
	}
	
	public synchronized void setProcessImage(ProcessImage procimg){
		m_ProcessImage = procimg;
	}
	
	public int getUnitID(){
		return m_UnitID;
	}
	
	public void setUnitID(int id){
		m_UnitID = id;
	}
	
	public boolean isMaster(){
		return m_Master;
	}
	
	public boolean isSlave(){
		return !m_Master;
	}
	
	public void setMaster(boolean master){
		m_Master = master;
	}
	

}

