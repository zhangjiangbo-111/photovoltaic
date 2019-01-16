package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.procimg;

import net.wimpi.modbus.procimg.Register;

public class UnityRegister implements Register {

	protected byte[] m_Register = new byte[2];
	
	public UnityRegister(){
		m_Register = null;
	}
	
	public UnityRegister(byte b1,byte b2){
		m_Register[0] = b1;
		m_Register[1] = b2;
	}
	
	public UnityRegister(int value){
		setValue(value);
	}
	
	
	public int getValue() {
		return ((m_Register[0] & 0xff) << 8 | (m_Register[1] & 0xff));
	}

	
	public int toUnsignedShort() {
		return ((m_Register[0] & 0xff) << 8 | (m_Register[1] & 0xff));
	}

	
	public short toShort() {
		return (short) ((m_Register[0] << 8) | (m_Register[1] & 0xff));
	}

	
	public byte[] toBytes() {
		return m_Register;
	}

	
	public void setValue(int v) {
		setValue((short) v);
	}

	
	public void setValue(short s) {
		if (m_Register == null) {
			m_Register = new byte[2];
		}
		m_Register[0] = (byte) (0xff & (s >> 8));
		m_Register[1] = (byte) (0xff & s);
		
		onChanged();
	}

	
	public void setValue(byte[] bytes) {
		if (bytes.length < 2) {
			throw new IllegalArgumentException();
		} else {
			m_Register[0] = bytes[0];
			m_Register[1] = bytes[1];
		}
		
		onChanged();
	}
	
	
	public void onChanged(){
		System.out.println(">>>>>>>>>>>>UnityRegister:这里set了值：" + m_Register);
	}
}
