package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;

public class UnityWriteMultipleCoilsResponse extends UnityModbusResponse {

	//instance attributes
	private int m_Reference;
	private int m_BitCount;
	
	
	public UnityWriteMultipleCoilsResponse(UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		setFunctionCode(Modbus.WRITE_MULTIPLE_COILS);
		setDataLength(4);
	} //constructor(int)
	
	public UnityWriteMultipleCoilsResponse(int ref, int count, UnityModbusCoupler umc) {
		super();
		setFunctionCode(Modbus.WRITE_MULTIPLE_COILS);
		setDataLength(4);
		m_Reference = ref;
		m_BitCount = count;
	} // constructor(int)

	public int getReference(){
		return m_Reference;
	}//getReference
	
	public int getBitCount(){
		return m_BitCount;
	}//getBitCount

	public void setBitCount(int count){
		m_BitCount = count;
	}//setBitCount


	@Override
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

}//class ReadCoilsResponse

