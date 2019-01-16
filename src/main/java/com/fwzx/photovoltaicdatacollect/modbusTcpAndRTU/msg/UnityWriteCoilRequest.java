package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.DigitalOut;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;

public class UnityWriteCoilRequest extends UnityModbusRequest {

	//instance attributes
	private int m_Reference;
	private boolean m_Coil;
	private UnityModbusCoupler m_umc;
	
	
	public UnityWriteCoilRequest(UnityModbusCoupler umc) {
		super();
		m_umc = umc;
		setFunctionCode(Modbus.WRITE_COIL);
		// 4 bytes (unit id and function code is excluded)
		setDataLength(4);
	}// constructor
	
	public UnityWriteCoilRequest(int ref,boolean b){
		super();
		setFunctionCode(Modbus.WRITE_COIL);
		setDataLength(4);
		setReference(ref);
		setCoil(b);
	}
	
	public UnityModbusResponse createResponse(){
		UnityWriteCoilResponse response = null;
		DigitalOut dout = null;
		
		
		//1. get process image
		ProcessImage procimg = m_umc.getProcessImage();
		
		//2. get coil
		try{
			dout = procimg.getDigitalOut(this.getReference());
			//3. set coil
			dout.set(this.getCoil());
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
			
		}
		response = new UnityWriteCoilResponse(this.getReference(),dout.isSet(),m_umc);
		
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
		}else{
			response.setHeadless();
		}
		response.setUnitID(this.getUnitID());
		response.setFunctionCode(this.getFunctionCode());	 
		return response;
	}//createRespnse
	


	public void setReference(int ref){
		m_Reference = ref;
	}
	
	public int getReference(){
		return m_Reference;
	}
	
	public void setCoil(boolean b){
		m_Coil = b;
	}
	
	public boolean getCoil(){
		return m_Coil;
	}
	
	
	
	@Override
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(m_Reference);
		if(m_Coil){
			dout.write(Modbus.COIL_ON_BYTES,0,2);
			
		}else{
			dout.write(Modbus.COIL_OFF_BYTES,0,2);
		}
	}
	@Override
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		m_Reference = din.readUnsignedShort();
		if(din.readByte() == Modbus.COIL_ON){
			m_Coil = true;
		}else{
			m_Coil = false;
		}
		din.readByte();
	}
	
	
	
	
	
}
