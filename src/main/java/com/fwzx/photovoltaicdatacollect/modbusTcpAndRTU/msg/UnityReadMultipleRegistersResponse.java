package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.procimg.InputRegister;
import net.wimpi.modbus.procimg.ProcessImageFactory;

public class UnityReadMultipleRegistersResponse extends UnityModbusResponse {

	//instance attributes
	private int m_ByteCount;
	//private int[] m_RegisterValues;
	private InputRegister[] m_Registers;
	private UnityModbusCoupler m_umc;
	
	
	
	public UnityReadMultipleRegistersResponse(UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		m_umc = umc;
		setFunctionCode(Modbus.READ_INPUT_REGISTERS);
	}
	
	
	

	public UnityReadMultipleRegistersResponse(InputRegister[] registers,UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
		m_umc = umc;
		setFunctionCode(Modbus.READ_INPUT_REGISTERS);
		m_ByteCount = registers.length * 2;
		m_Registers = registers;
		//set correct data length excluding unit id and fc
		setDataLength(m_ByteCount + 1);
	}

	public  int getByteCount(){
		return m_ByteCount;
	}
	
	public int getWordCount(){
		return m_ByteCount / 2;
	}//getWordCount
	
	private void setByteCount(int count){
		m_ByteCount = count;
	}//setByteCount

	public InputRegister getRegister(int index)throws IndexOutOfBoundsException{
			if(index >= getWordCount()){
				throw new IndexOutOfBoundsException();
			}else{
				return m_Registers[index];
			}
		}//getRegister
	
	public InputRegister[] getRegisters(){
		return m_Registers;
	}
	
	public int getRegisterValue(int index)throws IndexOutOfBoundsException{
		if(index >= getWordCount()){
			throw new IndexOutOfBoundsException();
		}else{
			return m_Registers[index].toUnsignedShort();
		}
		
	}

	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeByte(m_ByteCount);
		for(int k = 0; k < getWordCount();k++){
			dout.write(m_Registers[k].toBytes());
		}
	}//writeData

	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		setByteCount(din.readUnsignedByte());
		InputRegister[] registers = new InputRegister[getWordCount()];
		ProcessImageFactory pimf = m_umc.getProcessImageFactory();
		for(int k = 0; k < getWordCount(); k++){
			registers[k] = pimf.createInputRegister(din.readByte(),din.readByte());
		}
		m_Registers = registers;
		
		setDataLength(getByteCount() + 1);
	}//readData

}// class ReadInputRegistersResponse

