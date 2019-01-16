package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;

public class UnityExceptionResponse extends UnityModbusResponse {

	//instance attributes
	private int m_ExceptionCode = -1;
	
	
	public UnityExceptionResponse(){
		setDataLength(1);
	}
	
	public UnityExceptionResponse(int fc){
		setDataLength(1);
		setFunctionCode(fc +Modbus.EXCEPTION_OFFSET);
	}
	
	public UnityExceptionResponse(int fc,int exc){
		setDataLength(1);
		setFunctionCode(fc + Modbus.EXCEPTION_OFFSET);
		m_ExceptionCode = exc;
	}
	
	public int getExceptionCode(){
		return m_ExceptionCode;
	}
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeByte(getExceptionCode());
	}

	@Override
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		m_ExceptionCode = din.readUnsignedByte();
	}

}
