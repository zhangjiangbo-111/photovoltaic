package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.InputRegister;
import net.wimpi.modbus.procimg.ProcessImage;

public class UnityReadInputRegistersRequest extends UnityModbusRequest {

	//instance attributes
	private int m_Reference;
	private int m_WordCount;
	private UnityModbusCoupler m_umc;
	
	public UnityReadInputRegistersRequest(UnityModbusCoupler umc){
		super();
		m_umc = umc;
		setFunctionCode(Modbus.READ_INPUT_DISCRETES);
		setDataLength(4);
	}//constructor
	
	public UnityReadInputRegistersRequest(int ref,int count){
		super();
		setFunctionCode(Modbus.READ_INPUT_REGISTERS);
		setDataLength(4);
		setReference(ref);
		setWordCount(count);
	}//constructor
	
	
	
	
	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		UnityReadInputRegistersResponse response = null;
		InputRegister[] inpregs = null;
		ProcessImage procimg = m_umc.getProcessImage();
		
		try{
			inpregs = procimg.getInputRegisterRange(this.getReference(), this.getWordCount());
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
		}
		response = new UnityReadInputRegistersResponse(inpregs,m_umc);
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
			
		}else{
			response.setHeadless();
		}
		response.setUnitID(this.getUnitID());
		response.setFunctionCode(this.getFunctionCode());
		return response;
	}//createResponse
	
	public void setReference(int ref){
		m_Reference = ref;
	}//setReference

	public  int getReference(){
		return m_Reference;
	}
	
	public void setWordCount(int count){
		m_WordCount = count;
	}
	
	public int getWordCount(){
		return m_WordCount;
	}
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(m_Reference);
		dout.writeShort(m_WordCount);
	}

	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		m_Reference =  din.readUnsignedShort();
		m_WordCount = din.readUnsignedShort();
	}//readData

}//class ReadInputRegistersRequest
