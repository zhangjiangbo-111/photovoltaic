package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusIOException;

public class UnityTCPSlaveConnectionHandler implements Runnable {

	private UnityTCPSlaveConnection m_Connection;
	private UnityModbusTransport m_Transport;
	private UnityModbusCoupler m_umc;
	
	
	
	public UnityTCPSlaveConnectionHandler(UnityTCPSlaveConnection con, UnityModbusCoupler umc) {
		m_umc = umc;
		setConnection(con);
		
	}
	
	public void setConnection(UnityTCPSlaveConnection con){
		m_Connection = con;
		m_Transport = m_Connection.getModbusTransport();
		
	}//setConnection
	
	



	public void run() {
	// TODO Auto-generated method stub
		
		try{
			do{
				//1.read the request
				UnityModbusRequest request = m_Transport.readRequest();
				//System.out.println("Request:"+request.getHexMessage());
				UnityModbusResponse response = null;
				
				//test if Process image exists
				if(m_umc.getProcessImage()==null){
					response = request.createExceptionResponse(Modbus.ILLEGAL_FUNCTION_EXCEPTION);
				}else{
					response = request.createResponse();
				}
				/*DEBUG*/
				if(Modbus.debug) System.out.println("Request:"+request.getHexMessage());
				if(Modbus.debug) System.out.println("Response:"+response.getHexMessage());
				
				//System.out.println("Response:" + response.getHexMessage());
				
			} while(true);
		}catch(ModbusIOException ex){
			if(!ex.isEOF()){
				ex.printStackTrace();
			}
		}finally{
			try{
				m_Connection.close();
			}catch(Exception ex){
				//ignore
			}
		}
		
	}//run

}//TCPConnectionHandler
