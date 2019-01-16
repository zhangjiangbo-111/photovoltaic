package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test;

import java.util.Arrays;

import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;

public class TestModbusRTU {

	
	private static final int SLAVE_ADDRESS = 1;
	private static final int BAUD_RATE = 9600;


	public static void main(String[] args) {
        SerialParameters serialParameters = new SerialParameters();
        // 设定MODBUS通讯的串行口
        serialParameters.setCommPortId("com1");
        // 设定成无奇偶校验
        serialParameters.setParity(0);
        // 设定成数据位是8位
        serialParameters.setDataBits(8);
        // 设定为1个停止位
        serialParameters.setStopBits(1);
        // 设定端口名称
        serialParameters.setPortOwnerName("Numb nuts");
        // 设定端口波特率
        serialParameters.setBaudRate(BAUD_RATE);
 
        // 创建ModbusFactory工厂实例
        ModbusFactory modbusFactory = new ModbusFactory();
        // 创建ModbusMaster实例
        ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);
 
 
        // 初始化
        try {
            master.init();
            
            /**
             * 读的位置从零开始，长度4
             * 长度大小是采集器寄存器的数量，寄存器的数量是采集器可接入的电流输入的路数
             */
            readHoldingRegistersTest(master,SLAVE_ADDRESS,0,10);
 
 
        } catch (ModbusInitException e) {
            e.printStackTrace();
        } finally {
            master.destroy();
        }
        
    }


 private static void readHoldingRegistersTest(ModbusMaster master,
            int slaveId, int start, int len) {
        try {
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(
                    slaveId, start, len);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master
                    .send(request);
            if (response.isException()) {
                System.out.println("Exception response: message="
                        + response.getExceptionMessage());
            } else {
                System.out.println(Arrays.toString(response.getShortData()));
                short[] list = response.getShortData();
                for(int i = 0; i < list.length; i++){
                    System.out.print(list[i] + " ");
                }
                System.out.println();
                int hight = (list[3] - 4000) /160;
                if(hight <= 0){
                    System.out.println("水位高度为：0CM");
                }else{
                    System.out.println("水位高度为：" + (hight + 13.5) + "CM");
                }
                               
            }
        } catch (ModbusTransportException e) {
            e.printStackTrace();
        }
    }
}
