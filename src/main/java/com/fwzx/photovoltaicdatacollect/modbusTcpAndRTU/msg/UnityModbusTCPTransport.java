package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.msg;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import net.wimpi.modbus.Modbus;
import net.wimpi.modbus.ModbusIOException;
import net.wimpi.modbus.io.BytesInputStream;
import net.wimpi.modbus.msg.ModbusMessage;
import net.wimpi.modbus.util.ModbusUtil;

public class UnityModbusTCPTransport implements UnityModbusTransport {

	//instance attributes
	private DataInputStream m_Input;
	private DataOutputStream m_Output;
	private BytesInputStream m_ByteIn;
	private UnityModbusCoupler m_umc;
	
	
	
	
	
	
	public UnityModbusTCPTransport(Socket socket,UnityModbusCoupler umc) {
		// TODO Auto-generated constructor stub
		m_umc = umc;
		try{
			setSocket(socket);
		}catch(IOException ex){
			if(Modbus.debug)
				System.out.println("ModbusTCPTransport::Socket invalid.");
			//@commentstart@
			throw new IllegalStateException("Socket invalid.");
			//@commentend@
		}	
	} //constructor
	
	public void setSocket(Socket socket) throws IOException{
		prepareStreams(socket);
	}//setSocket
	

	public void close() throws IOException {
		// TODO Auto-generated method stub
		m_Input.close();
		m_Output.close();
	}

	public void writeMessage(ModbusMessage msg) throws ModbusIOException {
		// TODO Auto-generated method stub
		try{
			msg.writeTo((DataOutput) m_Output);
		}catch(Exception ex){
			throw new ModbusIOException("I/O exception - failed to write.");
		}
	}//write

	public UnityModbusRequest readRequest() throws ModbusIOException {
		// TODO Auto-generated method stub
		
		try{
			UnityModbusRequest req = null;
			synchronized(m_ByteIn){
				//use same buffer
				byte[] buffer = m_ByteIn.getBuffer();
			//read to byte length of message
			if(m_Input.read(buffer,0,6) == -1){
				throw new EOFException("Premature end of stream (Header truncated). ");
			}
			//extract length of bytes following in message
			int bf = ModbusUtil.registerToShort(buffer,4);
			//read rest
			if(m_Input.read(buffer,6,bf) == -1){
				throw new ModbusIOException("Premature end of stream (Message truncated).");
			}
			m_ByteIn.reset(buffer,(6 + bf));
			m_ByteIn.skip(7);
			int functionCode = m_ByteIn.readUnsignedByte();
			m_ByteIn.reset();
			req = UnityModbusRequest.createModbusRequest(functionCode, m_umc);
			req.readFrom(m_ByteIn);
			
				}
			return req;
		}catch(EOFException eoex){
			throw new ModbusIOException(true);
		}catch(SocketException sockex){
			//connection reset by peer,also EOF
			throw new ModbusIOException(true);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ModbusIOException("I/O exception - failed to read.");
		}
		
	} //readRequest

	public UnityModbusResponse readRespnse() throws ModbusIOException {
		// TODO Auto-generated method stub
		
		try{
			UnityModbusResponse res = null;
			synchronized (m_ByteIn){
				//use same buffer
				byte[] buffer = m_ByteIn.getBuffer();
				
				//read to byte length of message
				if(m_Input.read(buffer,0,6)== -1){
					throw new ModbusIOException("Premature end of stream (Header truncated).");
				//throw new ModbusIOException("Premature end of stream (Message truncated).");

				}
				//extract length of bytes following in message
				int bf = ModbusUtil.registerToShort(buffer,4);
				
				//read rest
				if(m_Input.read(buffer,6,bf) == -1){
					throw new ModbusIOException("Premature end of stream (Message truncated).");
						
					}
				m_ByteIn.reset(buffer,(6 + bf));
				m_ByteIn.skip(7);
				int functionCode = m_ByteIn.readUnsignedByte();
				res = UnityModbusResponse.createModbusResponse(functionCode, m_umc);
				res.readFrom(m_ByteIn);
			}
			return res;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ModbusIOException("I/O exception - failed to read.");
		}	
	}//readResponse
	
	private void prepareStreams(Socket socket)throws IOException{
		
		m_Input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		m_Output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		m_ByteIn = new BytesInputStream(Modbus.MAX_MESSAGE_LENGTH);
	}//prepareStreams

}//class ModbusTCPTransport
