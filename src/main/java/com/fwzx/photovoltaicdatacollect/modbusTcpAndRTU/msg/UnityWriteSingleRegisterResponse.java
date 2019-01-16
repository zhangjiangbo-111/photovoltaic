package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class UnityWriteSingleRegisterResponse extends UnityModbusResponse {

	//instance attributes
	private int m_Reference;
	private int m_RegisterValue;
	
	public UnityWriteSingleRegisterResponse(UnityModbusCoupler umc){
		super();
		setDataLength(4);
	}//constructor
	
	public UnityWriteSingleRegisterResponse(int reference,int value,UnityModbusCoupler umc){
		super();
		setReference(reference);
		setRegisterValue(value);
		setDataLength(4);
	}//constructor
	
	public int getRegisterValue(){
		return m_RegisterValue;
	} //getRegisterValue
	
	private void setRegisterValue(int value){
		m_RegisterValue = value;
	} //setRegisterValue
	
	public int getReference(){
		return m_Reference;
	}// getReference
	
	private void setReference(int ref){
		m_Reference = ref;
	}//setReference
	
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(getReference());
		dout.writeShort(getRegisterValue());
	}


	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		setReference(din.readUnsignedShort());
		setRegisterValue(din.readUnsignedShort());
		setDataLength(4);

	}

}
