package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.msg.ModbusMessageImpl;

public abstract class UnityModbusRequest extends ModbusMessageImpl {

	public abstract UnityModbusResponse createResponse();
	
	
	public UnityModbusResponse createExceptionResponse(int EXCEPTION_CODE){
		UnityExceptionResponse response = new UnityExceptionResponse(this.getFunctionCode(),EXCEPTION_CODE);
		if(!isHeadless()){
			response.setTransactionID(this.getTransactionID());
			response.setProtocolID(this.getProtocolID());
			response.setUnitID(this.getUnitID());
		}else{
			response.setHeadless();
		}
		return response;
	}
	
	public static UnityModbusRequest createModbusRequest(int functionCode,UnityModbusCoupler umc){
		UnityModbusRequest request = null;
		switch(functionCode){
		case Modbus.READ_MULTIPLE_REGISTERS:
			request = new UnityReadMultipleRegistersRequest(umc);
			break;
		case Modbus.READ_INPUT_DISCRETES:
			request = new UnityReadInputDiscretesRequest(umc);
			break;
		case Modbus.READ_INPUT_REGISTERS:
			request = new UnityReadInputRegistersRequest(umc);
			break;
		case Modbus.READ_COILS:
			request = new UnityReadCoilsRequest(umc);
			break;
		case Modbus.WRITE_MULTIPLE_REGISTERS:
			request = new UnityWriteMultipleRegistersRequest(umc);
			break;
		case Modbus.WRITE_SINGLE_REGISTER:
			request = new UnityWriteSingleRegisterRequest(umc);
			break;
		case Modbus.WRITE_COIL:
			request = new UnityWriteCoilRequest(umc);
			break;
		case Modbus.WRITE_MULTIPLE_COILS:
			request = new UnityWriteMultipleCoilsRequest(umc);
			break;
		default:
			request = new UnityIllegalFunctionRequest(functionCode);
			break;
		
		}
		return request;
	} 
	
}
