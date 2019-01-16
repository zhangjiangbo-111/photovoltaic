package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
public class UnityWriteMultipleRegistersResponse extends UnityModbusResponse {

	//instance attributes
	private int m_WordCount;
	private int m_Reference;
	
	
	
	public UnityWriteMultipleRegistersResponse(UnityModbusCoupler umc) {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public UnityWriteMultipleRegistersResponse(int reference, int wordCount, UnityModbusCoupler umc) {
		super();
		m_Reference = reference;
		m_WordCount = wordCount;
		setDataLength(4);
	}


	private void setReference(int ref){
		m_Reference = ref;
	}
	
	public int getReference(){
		return m_Reference;
	}
	

	
	public int getWordCount(){
		return m_WordCount;
	}//getWordCount
	
	public int getByteCount(){
		return m_WordCount * 2;
	}//getByteCount
	
	private void setWordCount(int count){
		m_WordCount = count;
	}

	public void writeData(DataOutput dout) throws IOException {
		// TODO Auto-generated method stub
		dout.writeShort(m_Reference);
		dout.writeShort(getWordCount());

	}

	public void readData(DataInput din) throws IOException {
		// TODO Auto-generated method stub
		setReference(din.readUnsignedByte());
		setWordCount(din.readUnsignedShort());
		//update data length
		setDataLength(4);
	}//readData

}//class WriteMultipleRegistersResponse
