package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.IOException;

import net.wimpi.modbus.ModbusIOException;
import net.wimpi.modbus.msg.ModbusMessage;

public interface UnityModbusTransport {

	public void close() throws IOException;
	
	public void writeMessage(ModbusMessage msg) throws ModbusIOException;
	
	public UnityModbusRequest readRequest() throws ModbusIOException;
	
	public UnityModbusResponse readRespnse() throws ModbusIOException;
}//class Modbustransport
