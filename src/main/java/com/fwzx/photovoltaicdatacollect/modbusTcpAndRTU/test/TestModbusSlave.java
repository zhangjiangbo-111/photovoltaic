package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test;

import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.utils.ModbusUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestModbusSlave {



	public static void main(String[] args) {
		//ip地址、端口号、寄存器起始地址、主机id
	//*	Object mod = ModbusUtil.readInputRegister("127.0.0.1", 502, 100, 1);
		//Object mod1 = ModbusUtil.readInputRegister("127.0.0.1", 502, 5, 4);
		//System.out.println(mod);
		//System.out.println(mod1);
		//Object mod2 = ModbusUtil.readInputRegister("127.0.0.1", 502, 1, 1);

		//System.out.println(mod2);
	//	Object mod3 = ModbusUtil.readInputRegister("127.0.0.1", 502, 1, 1);

		//System.out.println(mod3);
		//for(int i=0; i<100;i++){
		int mod4 = ModbusUtil.readRegister("127.0.0.1", 502, 17, 1);
		//if(i%2 == 0){ //n%m==0
		//if(i == 3 ){
		System.out.println(mod4+" ");
		 //}
		int mod5 = ModbusUtil.readRegister("127.0.0.1", 502, 18, 1);
		System.out.print(mod5+" ");	
		
	/*	String mod = ModbusIntConvertFloat.decimalToHex(mod4)+ModbusIntConvertFloat.decimalToHex(mod5);
		System.out.println(mod);
		Double data = ModbusFloatTest.getDoubleByHexstr(mod);
		System.out.println("从Modbus中取出的数据："+data);
		//}*/
	}

	//@Scheduled(cron = "0/5 * * * * ?")
	public  void testModhod() {
		//ip地址、端口号、寄存器起始地址、主机id
	/*	Object mod = ModbusUtil.readInputRegister("127.0.0.1", 502, 100, 1);
		//Object mod1 = ModbusUtil.readInputRegister("127.0.0.1", 502, 5, 4);
		System.out.println(mod);
		//System.out.println(mod1);
		Object mod2 = ModbusUtil.readInputRegister("127.0.0.1", 502, 1, 1);

		System.out.println(mod2);
		Object mod3 = ModbusUtil.readInputRegister("127.0.0.1", 502, 1, 1);

		System.out.println(mod3);*/
		//for(int i=0; i<100;i++){
		int mod4 = ModbusUtil.readRegister("127.0.0.1", 502, 3, 1);
		//if(i%2 == 0){ //n%m==0
		//if(i == 3 ){
		System.out.print(mod4+" ");
		//}
		int mod5 = ModbusUtil.readRegister("127.0.0.1", 502, 2, 1);
		System.out.print(mod5+" ");

		String mod = ModbusIntConvertFloat.decimalToHex(mod4)+ModbusIntConvertFloat.decimalToHex(mod5);
		System.out.println(mod);
		Double data = ModbusFloatTest.getDoubleByHexstr(mod);
		System.out.println("从Modbus中取出的数据："+data);
		//}
	}




}
