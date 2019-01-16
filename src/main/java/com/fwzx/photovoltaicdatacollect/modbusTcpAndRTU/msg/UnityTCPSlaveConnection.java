package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import net.wimpi.modbus.Modbus;

public class UnityTCPSlaveConnection {

	//instance attributes
	private Socket m_Socket;
	private int m_Timeout = Modbus.DEFAULT_TIMEOUT;
	private boolean m_Connected;
	private UnityModbusTCPTransport m_ModbusTransport;
	private UnityModbusCoupler m_umc;
	
	
	public UnityTCPSlaveConnection(Socket socket,UnityModbusCoupler umc) {
		m_umc = umc;
		try{
			setSocket(socket);
		}catch(IOException ex){
			if(Modbus.debug)System.out.println("TCPSlaveConnection::Socket invalid.");
			//@commentstart@
			throw new IllegalStateException("Socket invalid.");
			//@commentend@
		}
		
	}//constructor
	
	
	public void close(){
		if(m_Connected){
			try{
				m_ModbusTransport.close();
				m_Socket.close();
			}catch(IOException ex){
				if(Modbus.debug) ex.printStackTrace();
			}
			m_Connected = false;
		}
	}//close
	
	public UnityModbusTransport getModbusTransport(){
		return m_ModbusTransport;
	}//getIO
	
	private void setSocket(Socket socket)throws IOException{
		m_Socket = socket;
		if(m_ModbusTransport == null){
			m_ModbusTransport = new UnityModbusTCPTransport(m_Socket,m_umc);
		}else{
			m_ModbusTransport.setSocket(m_Socket);
		}
		m_Connected = true;
	}//prepareIO
	
	
	public int getTimeout(){
		return m_Timeout;
	}//getReceiveTimeout
	
	public void setTimeout(int timeout){
		m_Timeout = timeout;
		try{
			m_Socket.setSoTimeout(m_Timeout);
		}catch(IOException ex){
			//handle?
		}
	}//setReceiveTimeout
	
	
	public int getPort(){
		return m_Socket.getLocalPort();
	}
	
	public InetAddress getAddress(){
		return m_Socket.getLocalAddress();
	}
	
	public boolean isConnected(){
		return m_Connected;
	}//isConnected
}//class TCPSlaveConnection
