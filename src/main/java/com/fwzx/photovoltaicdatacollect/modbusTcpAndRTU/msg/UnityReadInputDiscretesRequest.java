package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.DigitalIn;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;

public class UnityReadInputDiscretesRequest extends UnityModbusRequest {

	//instance attribues
	private int m_Reference;
	private int m_BitCount;
	private UnityModbusCoupler m_umc;
	
	
	public UnityReadInputDiscretesRequest(UnityModbusCoupler umc){
		super();
		m_umc = umc;
		setFunctionCode(Modbus.READ_INPUT_DISCRETES);
		setDataLength(4);
	}//constructor
	
	
	
	
	public UnityReadInputDiscretesRequest(int ref, int count) {
		super();
		setFunctionCode(Modbus.READ_INPUT_DISCRETES);
		setDataLength(4);
		setReference(ref);
		setBitCount(count);
	}//constructor




	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		UnityReadInputDiscretesResponse response = null;
		DigitalIn[] dins = null;
		
		ProcessImage procimg = m_umc.getProcessImage();
		
		try{
			dins = procimg .getDigitalInRange(this.getReference(), this.getBitCount());
			
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
		}
		
		response = new UnityReadInputDiscretesResponse(dins.length,m_umc);
		//transfer header data
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
		}else{
			response.setHeadless();
		}
		response.setUnitID(this.getUnitID());
		response.setFunctionCode(this.getFunctionCode());
		for(int i = 0; i < dins.length; i++){
			response.setDiscreteStatus(i, dins[i].isSet());
		}
		return response;
	}//createResponse

	public void setReference(int ref){
		m_Reference = ref;
	}//setreference
	
	public int getReference(){
		return m_Reference;
	}
	
	public void setBitCount(int count){
		m_BitCount = count;
	}
	
	public int getBitCount(){
		return m_BitCount;
	}
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		
		dout.writeShort(m_Reference);
		dout.writeShort(m_BitCount);
	}//writeData

	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		m_Reference = din.readUnsignedShort();
		m_BitCount = din.readUnsignedShort();
	}//readData

}//class ReadInputDiscreteRequest
