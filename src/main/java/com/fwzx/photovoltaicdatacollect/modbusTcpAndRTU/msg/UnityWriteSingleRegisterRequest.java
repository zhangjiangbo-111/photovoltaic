package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusCoupler;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;
import net.wimpi.modbus.procimg.Register;

public class UnityWriteSingleRegisterRequest extends UnityModbusRequest {

	//instance attributes
	private int m_Reference;
	private Register m_Register;
	private UnityModbusCoupler m_umc;
	
	public UnityWriteSingleRegisterRequest(UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		m_umc = umc;
		setFunctionCode(Modbus.WRITE_MULTIPLE_REGISTERS);
		setDataLength(4);
	}//constructor
	

	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		UnityWriteSingleRegisterResponse response = null;
		Register reg = null;
		
		//1. get process image
		ProcessImage procimg = m_umc.getProcessImage();
		//2. get register
		try{
			reg = procimg.getRegister(m_Reference);
			//3. set Register
			reg.setValue(m_Register.toBytes());
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
		}
		response = new UnityWriteSingleRegisterResponse(this.getReference(),reg.getValue(),m_umc);
		//transfer header data
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
		}else{
			response.setHeadless();
		}
		response.setUnitID(this.getUnitID());
		response.setFunctionCode(this.getFunctionCode());
		
		return response;
	}//createResonse

	
	public void setReference(int ref){
		m_Reference = ref;
	}
	
	
	public int getReference() {
		// TODO Auto-generated method stub
		return m_Reference;
	}

	public void setRegister(Register reg){
		
		m_Register = reg;
	}
	
	public Register getRegister(){
		return m_Register;
	}
	
	

	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(m_Reference);
		dout.write(m_Register.toBytes(), 0, 2);
		
	} //reData
	
	

	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		m_Reference = din.readUnsignedShort();
		m_Register = ModbusCoupler.getReference().getProcessImageFactory().createRegister(din.readByte(),din.readByte());
		

	}//readData

}//calss WriteSingleRegisterRequest

