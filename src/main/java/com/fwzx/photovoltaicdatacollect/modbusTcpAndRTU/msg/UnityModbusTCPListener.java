/**
 * 
 */
package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.util.ThreadPool;

/**
 * @author zhang
 *
 */
public class UnityModbusTCPListener implements Runnable {

	private static int c_RequestCounter = 0;
	private ServerSocket m_ServerSocket = null;
	private ThreadPool m_ThreadPool;
	private Thread m_Listener;
	private int m_Port = Modbus.DEFAULT_PORT;
	private int m_FloodProtection = 5;
	private boolean m_Listening;
	private InetAddress m_Address;
	private UnityModbusCoupler m_umc;
	
	public UnityModbusTCPListener(int poolsize){
		m_ThreadPool = new ThreadPool(poolsize);
		try{
			m_Address = InetAddress.getLocalHost();
		}catch(UnknownHostException ex){
			
		}
	}//constructor
	
	
	public UnityModbusTCPListener(int poolsize, InetAddress addr){
		m_ThreadPool = new ThreadPool(poolsize);
		m_Address = addr;
	}//constructor
	
	public void setPort(int port){
		m_Port = port;
	}
	
	public void setUmc(UnityModbusCoupler umc){
		m_umc = umc;
	}
	
	public void setAddress(InetAddress addr){
		m_Address = addr;
	}
	
	public void start(){
		m_Listener = new Thread(this);
		m_Listener.start();
		m_Listening = true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		try{
			m_ServerSocket = new ServerSocket(m_Port,m_FloodProtection,m_Address);
			if(Modbus.debug)System.out.println("Listenening to"+m_ServerSocket.toString() + "(Port" +m_Port+")");
			
			do{
				Socket incoming = m_ServerSocket.accept();
				if(Modbus.debug)
					System.out.println("Making new connection"+incoming.toString());
				if(m_Listening){
					//FIXME: Replace with object pool due to resource issues
					m_ThreadPool.execute(new UnityTCPSlaveConnectionHandler(new UnityTCPSlaveConnection(incoming,m_umc),m_umc));
					count();
				}else{
					//just close the socket
					incoming.close();
				}
			}while(m_Listening);
		
		}catch(SocketException iex){
			if(!m_Listening)
			{
				return;
			}else{
				iex.printStackTrace();
				}	
			}catch(IOException e){
				//FIXME: this is a major failure, how do we handle this
			}
	}//run

	
	public boolean isListening(){
		return m_Listening;
	}
	

	private void count() {
		// TODO Auto-generated method stub
		c_RequestCounter++;
		if(c_RequestCounter == REQUESTS_TOGC){
			System.gc();
			c_RequestCounter = 0;
		}
	}//count

	private static final int REQUESTS_TOGC = 10;
	
}
