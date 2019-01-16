package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.util.BitVector;

public class UnityReadCoilsResponse extends UnityModbusResponse {

	//instance attrbutes
	private BitVector m_Coils;
	
	
	
	public UnityReadCoilsResponse(UnityModbusCoupler umc) {
		super();
		setFunctionCode(Modbus.READ_COILS);
	}//constructor(int)
	
	
	public UnityReadCoilsResponse(int count,UnityModbusCoupler umc) {
		super();
		m_Coils = new BitVector(count);
		setFunctionCode(Modbus.READ_COILS);
		setDataLength(m_Coils.byteSize() + 1);
		
	}//constructor(int)

	public int getBitCount(){
		if(m_Coils == null){
			return 0;
		}else{
			return m_Coils.size();
		}
	}
	
	public BitVector getCoils(){
		return m_Coils;
	}
	
	public boolean getCoilStatus(int index)throws IndexOutOfBoundsException{
		
		return m_Coils.getBit(index);
	}
	
	public void setColisStatus(int index, boolean b){
		m_Coils.setBit(index,b);
	}
	
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeByte(m_Coils.byteSize());
		dout.write(m_Coils.getBytes(), 0, m_Coils.byteSize());

	}//writeData

	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		int count = din.readUnsignedByte();
		byte[] data = new byte[count];
		for(int k = 0; k <count; k++){
			data[k] = din.readByte();
 		}
		
		m_Coils = BitVector.createBitVector(data);
		setDataLength(count + 1);
	}//readData

}//class ReadCoilsResponse
