package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;

public class UnityIllegalFunctionRequest extends UnityModbusRequest {

	public UnityIllegalFunctionRequest(int fc){
		setFunctionCode(fc);
	}//constructor
	
	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		return this.createExceptionResponse(Modbus.ILLEGAL_FUNCTION_EXCEPTION);
		
	}

	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		throw new RuntimeException();

	}//writeData

	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		int length = getDataLength();
		for(int i = 0; i < length; i++){
			din.readByte();
		}

	}//readData

}//class IllegalFunctionRequest
