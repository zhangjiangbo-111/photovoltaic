package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.DigitalOut;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;

public class UnityReadCoilsRequest extends UnityModbusRequest {

	//instance attributes
	private int m_Reference;
	private int m_BitCount;
	private UnityModbusCoupler m_umc;
	
	
	public UnityReadCoilsRequest(UnityModbusCoupler umc){
		super();
		m_umc = umc;
		setFunctionCode(Modbus.READ_COILS);
		setDataLength(4);
	}
	
	public UnityReadCoilsRequest(int ref, int count){
		super();
		setFunctionCode(Modbus.READ_COILS);
		setDataLength(4);
		setReference(ref);
		setBitCount(count);
	}

	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		UnityReadCoilsResponse response = null;
		DigitalOut[] douts = null;
		
		//1.get process image
		ProcessImage procimg = m_umc.getProcessImage();
		
		try{
			douts = procimg.getDigitalOutRange(this.getReference(), this.getBitCount());
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
		}
		response = new UnityReadCoilsResponse(douts.length,m_umc);
		
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
		}else{
			response.setHeadless();
		}
		response.setUnitID(this.getUnitID());
		response.setFunctionCode(this.getFunctionCode());
		
		for(int i = 0; i < douts.length; i++){
			response.setColisStatus(i, douts[i].isSet());
		}
		
		return response;
	}//createResponse

	private void setBitCount(int count) {
		// TODO Auto-generated method stub
		if(count > Modbus.MAX_BITS){
			throw new IllegalArgumentException("Maximum bitcount exceeded.");
		}else{
			m_BitCount = count;
		}
	}

	private void setReference(int ref) {
		// TODO Auto-generated method stub
		m_Reference = ref;
	}
	
	private int getBitCount() {
		// TODO Auto-generated method stub
		return m_BitCount;
	}

	private int getReference() {
		// TODO Auto-generated method stub
		return m_Reference;
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

}//class ReadCoilsRequest
