package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;
import net.wimpi.modbus.procimg.Register;

public class UnityReadMultipleRegistersRequest extends UnityModbusRequest {

	//instance attributes
	private int m_Reference;
	private int m_WordCount;
	private UnityModbusCoupler m_umc;
	
	
	
	public UnityReadMultipleRegistersRequest(UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		setFunctionCode(Modbus.READ_MULTIPLE_REGISTERS);
		setDataLength(4);
		
	}//constructor
	
	public UnityReadMultipleRegistersRequest(int ref, int count){
		super();
		setFunctionCode(Modbus.READ_MULTIPLE_REGISTERS);
		setDataLength(4);
		setReference(ref);
		setWordCount(count);
	}
	
	
	public UnityModbusResponse createResponse(){
		UnityReadMultipleRegistersResponse response = null;
		Register[] regs = null;
		
		//1. get process image
		ProcessImage procimg = m_umc.getProcessImage();
		try{
			regs = procimg.getRegisterRange(this.getReference(), this.getWordCount());
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);	
		}
		response = new UnityReadMultipleRegistersResponse(regs,m_umc);
		//transfer header data
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
		}else{
			response.setHeadless();
		}
		return response;
		
	}//createResponse
	
	public void setReference(int ref){
		m_Reference = ref;
	}//setReference
	
	public int getReference(){
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
		m_Reference = din.readUnsignedShort();
		m_WordCount = din.readUnsignedShort();

	}//readData

}//class ReadMultipleRegistersRequest
