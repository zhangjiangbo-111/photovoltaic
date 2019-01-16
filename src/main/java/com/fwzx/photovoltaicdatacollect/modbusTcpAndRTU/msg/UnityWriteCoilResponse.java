package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;

public class UnityWriteCoilResponse extends UnityModbusResponse {

	//instance attributes
	private boolean m_Coil = false;
	private int m_Reference;
	private int m_FunctionCode;
	
	public UnityWriteCoilResponse(UnityModbusCoupler umc){
		super();
		setFunctionCode(Modbus.WRITE_COIL);
		setDataLength(4);
	}
	
	public UnityWriteCoilResponse(int reference,boolean b,UnityModbusCoupler umc){
		super();
		setFunctionCode(Modbus.WRITE_COIL);
		setDataLength(4);
		setReference(reference);
		setCoil(b);
	}
	
	private void setCoil(boolean b){
		m_Coil = b;
	}
	
	public boolean getCoil(){
		return m_Coil;
	}
	
	public int getReference(){
		return m_Reference;
	}
	
	private void setReference(int ref){
		m_Reference = ref;
	}
	
	 public void setFunctionCode(int code) {
		    m_FunctionCode = code;
		    //setChanged(true);
    }
	 public int getFunctionCode(){
		 return m_FunctionCode;
	 }
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(getReference());
		if(getCoil()){
			dout.write(Modbus.COIL_ON_BYTES,0,2);
		}else{
			dout.write(Modbus.COIL_OFF_BYTES,0,2);
		}
	}

	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		setReference(din.readUnsignedShort());
		
		byte[] data = new byte[2];
		for(int k = 0; k <2; k++){
			data[k] = din.readByte();
		}
		
		if(data[0] == Modbus.COIL_ON){
			setCoil(true);
		}else{
			setCoil(false);
		}
		
		//update data length
		setDataLength(4);
	}//readData

}//class WriteCoilResponse
