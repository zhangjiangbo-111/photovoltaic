package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.io.NonWordDataHandler;
import net.wimpi.modbus.procimg.IllegalAddressException;
import net.wimpi.modbus.procimg.ProcessImage;
import net.wimpi.modbus.procimg.ProcessImageFactory;
import net.wimpi.modbus.procimg.Register;

public class UnityWriteMultipleRegistersRequest extends UnityModbusRequest {

	private int m_Reference;
	private Register[] m_Registers;
	private NonWordDataHandler m_NonWordDataHandler = null;
	private UnityModbusCoupler m_umc;
	
	public UnityWriteMultipleRegistersRequest(UnityModbusCoupler umc){
		super();
		m_umc = umc;
		setFunctionCode(Modbus.WRITE_MULTIPLE_REGISTERS);
		
	}//constructor
	
	
	public UnityWriteMultipleRegistersRequest(int ref,Register[] registers){
		super();
		setFunctionCode(Modbus.WRITE_MULTIPLE_REGISTERS);
		setReference(ref);
		setRegisters(registers);
	}
	



	public UnityModbusResponse createResponse() {
		// TODO Auto-generated method stub
		UnityWriteMultipleRegistersResponse response = null;
		
		if(m_NonWordDataHandler == null){
			Register[] regs = null;
			//1. get process image
			ProcessImage procimg = m_umc.getProcessImage();
			//2. get registers
			try{
				//TODO: realize a setRegisterRange()?
				regs = procimg.getRegisterRange(this.getReference(), this.getWordCount());
			
				//3. set Register values
				for(int i = 0; i < regs.length; i++){
					regs[i].setValue(this.getRegister(i).toBytes());
				}
				
			}catch(IllegalAddressException iaex){
				return createExceptionResponse(Modbus.ILLEGAL_ADDRESS_EXCEPTION);
			}
			response = new UnityWriteMultipleRegistersResponse(this.getReference(),regs.length,m_umc);
		}else{
			int result = m_NonWordDataHandler.commitUpdate();
			if(result > 0){
				return createExceptionResponse(result);
			}
			response = new UnityWriteMultipleRegistersResponse(this.getReference(),m_NonWordDataHandler.getWordCount(),m_umc);
		}
		
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

	
	


	private int getWordCount() {
		// TODO Auto-generated method stub
		return m_Registers.length;
	}


	private int getReference() {
		// TODO Auto-generated method stub
		return m_Reference;
	}
	private void setReference(int ref) {
		// TODO Auto-generated method stub
		m_Reference = ref;
	}
	
	private Register[] getRegister() {
		// TODO Auto-generated method stub
		
		return m_Registers;
	}


	public Register getRegister(int index)throws IndexOutOfBoundsException{
		if(index >= getWordCount()){
			throw new IndexOutOfBoundsException();
		}else{
			return m_Registers[index];
		}
	}
	
	private void setRegisters(Register[] registers) {
		// TODO Auto-generated method stub
		m_Registers = registers;
		setDataLength(5 + getByteCount());//update message length in header
	}

	public int getRegisterValue(int index)throws IndexOutOfBoundsException{
		return m_Registers[index].toUnsignedShort();
	}
	
	public int getByteCount(){
		return getWordCount() * 2;
	}
	
	
	public void setNonWordDataHandler(NonWordDataHandler dhandler){
		m_NonWordDataHandler = dhandler;
		setDataLength(5 +(m_NonWordDataHandler.getWordCount() * 2));
	}//setNonWordDataHandler
	
	public NonWordDataHandler getNonWordDataHandler(){
		return m_NonWordDataHandler;
	} //getNonWordDataHandler
	
	
	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		//1.the reference
		dout.writeShort(m_Reference);
		dout.writeShort(getWordCount());
		dout.writeByte(getByteCount());
		
		if(m_NonWordDataHandler == null){
			for(int n = 0; n < m_Registers.length; n++){
				dout.write(m_Registers[n].toBytes());
			}
		}else{
			m_NonWordDataHandler.prepareData(getReference(), getWordCount());
			dout.write(m_NonWordDataHandler.getData());
		}//writeData
		
	}

	
	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub

		m_Reference = din.readShort();
		//read lengths
		int wc = din.readUnsignedShort();
		
		//read values
		if(m_NonWordDataHandler ==null){
			m_Registers = new Register[wc];
			ProcessImageFactory pimf = m_umc.getProcessImageFactory();
			for(int i = 0; i < wc; i++){
				m_Registers[i] = pimf.createRegister(din.readByte(), din.readByte());
			}
		}else{
			m_NonWordDataHandler.readData(din, m_Reference, wc);
		} // readData
		
	}//class WriteMultipleRegistersRequest

}
