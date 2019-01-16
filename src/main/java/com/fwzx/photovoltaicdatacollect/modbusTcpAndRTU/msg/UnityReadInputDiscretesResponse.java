package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.util.BitVector;

public class UnityReadInputDiscretesResponse extends UnityModbusResponse {

	// instance attrbutes
	private int m_BitCount;
	private BitVector m_Discretes;
			
	
	
	
	
	public UnityReadInputDiscretesResponse(UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		setFunctionCode(Modbus.READ_INPUT_DISCRETES);
	}

	public UnityReadInputDiscretesResponse(int count, UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		setBitCount(count);
		
		
	}//constructor
	
	public int getBitCount(){
		return m_BitCount;
	}
	
	public void setBitCount(int count){
		m_BitCount = count;
		m_Discretes = new BitVector(count);
		//set correct length, without counting unitid and fc
		setDataLength(m_Discretes.byteSize() +  1);
	}//setBitCount
	
	public BitVector getDiscretes(){
		return m_Discretes;
	}// getDiscretes
	
	public boolean getDiscreteStatus(int index)throws IndexOutOfBoundsException{
		return m_Discretes.getBit(index);
	}
	
	public void setDiscreteStatus(int index,boolean b)throws IndexOutOfBoundsException{
		m_Discretes.setBit(index, b);
	}
	

	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeByte(m_Discretes.byteSize());
		dout.write(m_Discretes.getBytes(), 0, m_Discretes.byteSize());

	}//writeData
	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		int count = din.readUnsignedByte();
		byte[] data = new byte[count];
		for(int k = 0; k <count; k++){
			data[k] = din.readByte();
		}
		//decode bytes into bitvector
		m_Discretes = BitVector.createBitVector(data);
		setDataLength(count + 1);
	}

}
