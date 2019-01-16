package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test;

import java.util.HashMap;
import java.util.Map;

import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.controller.BaseController;
import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.utils.SimulationMode;
import net.wimpi.modbus.ModbusException;
import net.wimpi.modbus.ModbusIOException;
import net.wimpi.modbus.ModbusSlaveException;

public class Test {

	/**
	 * 
	 * @param args
	 * @throws ModbusIOException
	 * @throws ModbusSlaveException
	 * @throws ModbusException
	 */
	
	public static void main(String[] args)throws ModbusIOException,ModbusSlaveException,ModbusException {
		
		showTest();
	}
	
	
	
	static void showTest(){
		UnityModbus um = new UnityModbus();
		
		Map<Integer, BaseController> map = um.getControllers();
		
		for(int key : map.keySet()){
			System.out.println();
			
			for(int address : map.get(key).getCtorEntity().getRegisters().keySet()){
				System.out.println("key:" + key + " address: " + address
						+ " mode:" +map.get(key).getCtorEntity().getMode() + " value:"
						+map.get(key).getCtorEntity().getRegisters().get(address).getValue()
						+" type:"
						+map.get(key).getCtorEntity().getRegisters().get(address).getType()
						+" ip:"+ map.get(key).getCtorEntity().getIp()
						+" prot:"+map.get(key).getCtorEntity().getPort());
				
				map.get(key).showTest();
			}
			
		}
		
		System.out.println(">>>>>>>>开始设置，");
		um.setSimulationMode(3, SimulationMode.SimulateAndForwarding);
		
		System.out.println(">>>>>>>>设置结束，");
		
		map = um.getControllers();
		
		for(int key: map.keySet()){
			System.out.println();
			
			for(int address : map.get(key).getCtorEntity().getRegisters().keySet()){
				System.out.println("key:" + key + "address: "+address
						+" mode:" + map.get(key).getCtorEntity().getMode()+" value:"
						+map.get(key).getCtorEntity().getRegisters().get(address).getValue()
						+" type:"
						+map.get(key).getCtorEntity().getRegisters().get(address).getType()
						+" ip:"+map.get(key).getCtorEntity().getIp()
						+" port:"+map.get(key).getCtorEntity().getPort());
				
				map.get(key).showTest();
			}
		}
		System.out.println("\n>>>>>>>>>>>查询某个controller");
		
		Map<Integer,Integer> resl = um.getAllRegisterState(3);
		for(int key : resl.keySet()){
		System.out.println("key:"+ key + " value:" + resl.get(key));
			
		 }
		System.out.println("\n>>>>>>>>>>>3号控制器总共有多少个寄存器："+um.getTotalRegisters(3));
		
		System.out.println("\n>>>>>>>>>>>开始3号控制的值：");
		
		Map<Integer,Integer>templ = new HashMap<Integer,Integer>();
		templ.put(0, 1);
		templ.put(1, 1);
		templ.put(2, 101);
		templ.put(3, 221);
		
		um.setAllRegisterState(3, templ);
		
		Map<Integer,Integer> res2 = um.getAllRegisterState(3);
		for(int key : res2.keySet()){
			System.out.println("key:" + key +" value:" + res2.get(key));
		}
		
		System.out.println("\n>>>>>>>>>>>>3号控制器设置结束");
		
		System.out.println("\n>>>>>>>>>>>>>设置三号控制器的第四个寄存器的值");
		um.setRegisterState(3, 3, 169);
		
		System.out.println("\n>>>>>>>>>>>>>设置三号控制器的第四个寄存器的值完成之后：");
		Map<Integer,Integer> res3 = um.getAllRegisterState(3);
		for(int key : res3.keySet()){
			System.out.println("key:" + key + " value" + res3.get(key));
		}
		
	}
	
}
