package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.DigitalOut;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;
import net.wimpi.modbus.util.BitVector;

public class UnityWriteMultipleCoilsRequest extends UnityModbusRequest {

	//instance attributes
	private int m_Reference;
	private BitVector m_Coils;
	private UnityModbusCoupler m_umc;
	
	public UnityWriteMultipleCoilsRequest(UnityModbusCoupler umc){
		super();
		m_umc = umc;
		setFunctionCode(Modbus.WRITE_MULTIPLE_COILS);
		setDataLength(5);
	}//constructor
	
	public UnityWriteMultipleCoilsRequest(int ref, int count){
		super();
		setFunctionCode(Modbus.WRITE_MULTIPLE_COILS);
		setReference(ref);
		m_Coils = new BitVector(count);
		setDataLength(m_Coils.byteSize() + 5);
		
	}//constructor
	
	public UnityWriteMultipleCoilsRequest(int ref, BitVector bv){
		super();
		setFunctionCode(Modbus.WRITE_MULTIPLE_COILS);
		setReference(ref);
		m_Coils = bv;
		setDataLength(m_Coils.byteSize() + 5);
	} //constructor
	
	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		UnityWriteMultipleCoilsResponse response = null;
		DigitalOut douts[] = null;
		
		//1. get process image
		ProcessImage procimg = m_umc.getProcessImage();
		
		try{
			douts = procimg.getDigitalOutRange(m_Reference, m_Coils.size());
			
			//3. set coils
			for(int i = 0; i < douts.length; i++){
				douts[i].set(m_Coils.getBit(i));
			}
		}catch(IllegalAddressException iaex){
			return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
		}
		
		response = new UnityWriteMultipleCoilsResponse(m_Reference,m_Coils.size(), m_umc);
		
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
		}else{
			response.setHeadless();
		}
		response.setUnitID(this.getUnitID());
		response.setFunctionCode(this.getFunctionCode());
		
		return response;
	}
	
	public void setReference(int ref){
		m_Reference = ref;
	}//setReference

	public int getReference(){
		return m_Reference;
	}//getReference
	
	public int  getBitCount(){
		if(m_Coils == null){
			return 0;
		}else{
			return m_Coils.size();
		}
	}//getBitCount
	
	public int getByteCount(){
		return m_Coils.byteSize();
	} // getByteCount
	
	public boolean getCoilsStatus(int index)throws IndexOutOfBoundsException{
		return m_Coils.getBit(index);
	}//getCoilsStatus
	
	public void setCoilStatus(int index,boolean b)throws IndexOutOfBoundsException{
		m_Coils.setBit(index, b);
	}//setCoilStatus
	
	public BitVector getCoils(){
		return m_Coils;
	}//getCoils
	
	public void setCoils(BitVector bv){
		m_Coils = bv;
	}
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(m_Reference);
		dout.writeShort(m_Coils.size());
		dout.writeByte(m_Coils.byteSize());
		dout.write(m_Coils.getBytes());

	}//writeData

	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		m_Reference = din.readUnsignedShort();
		int bitcount = din.readUnsignedShort();
		int count = din.readUnsignedByte();
		byte[] data = new byte[count];
		
		for(int k = 0; k < count; k++){
			data[k] = din.readByte();
		}
		
		m_Coils = BitVector.createBitVector(data,bitcount);
		
		//update data length
		setDataLength(count + 5);
		
	}//readData

}//class WriteMultipleCoilsRequest
