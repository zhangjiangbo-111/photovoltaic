package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test;

import java.util.Arrays;

import com.serotonin.io.serial.SerialParameters;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.msg.ReadDiscreteInputsRequest;
import com.serotonin.modbus4j.msg.ReadDiscreteInputsResponse;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.msg.WriteRegistersRequest;
import com.serotonin.modbus4j.msg.WriteRegistersResponse;


public class TestModbusDemo {
        
        private final static int SLAVE_ADDRESS = 1;
        private final static int SLAVE_ADDRESS2 = 2;
        private final static int BAUD_RATE = 9600;
        
       public static void main(String[] args) {
               
        	SerialParameters serialParameters = new SerialParameters();
                
                serialParameters.setCommPortId("COM1");
                
                serialParameters.setParity(0);
                
                serialParameters.setDataBits(8);
                
                serialParameters.setStopBits(1);
               
                serialParameters.setPortOwnerName("Numb nuts");
                
                serialParameters.setBaudRate(BAUD_RATE);

               
                ModbusFactory modbusFactory = new ModbusFactory();
                
                ModbusMaster master = modbusFactory.createRtuMaster(serialParameters);

                
                try {
                        master.init();
                        readHoldingRegistersTest(master,SLAVE_ADDRESS,0,124);
                        //readDiscreteInputTest(master,SLAVE_ADDRESS2,0,10);
                        //writeRegistersTest(master,SLAVE_ADDRESS,3,10);
                    
                } catch (ModbusInitException e) {
                        e.printStackTrace();
                } finally {
                        master.destroy();
                }
                
        }
       
        
        private static void readDiscreteInputTest(ModbusMaster master, int slaveId, int start, int len) {
        try {
                ReadDiscreteInputsRequest request = new ReadDiscreteInputsRequest(slaveId, start, len);
                ReadDiscreteInputsResponse response = (ReadDiscreteInputsResponse) master.send(request);
                if (response.isException()){
                        System.out.println("Exception response: message=" + response.getExceptionMessage());
                		
                }else{
                        System.out.println(Arrays.toString(response.getBooleanData()));
               //  System.out.println("这是什么数据 ： "+response.getData());
                }
        }
                catch (ModbusTransportException e) {
                        e.printStackTrace();
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
                                //System.out.println(Arrays.toString(response.getShortData()));
                                short[] list = response.getShortData();
                                for(int i = 0; i < list.length; i++){
                                        System.out.print(list[i] + " ");
                                }
                        }
                } catch (ModbusTransportException e) {
                        e.printStackTrace();
                }
        }
        
        
                 
    public static void writeRegistersTest(ModbusMaster master, int slaveId, int start, short[] values) {
        try {
            WriteRegistersRequest request = new WriteRegistersRequest(slaveId, start, values);
            WriteRegistersResponse response = (WriteRegistersResponse) master.send(request);
            if (response.isException()){
                System.out.println("Exception response: message=" + response.getExceptionMessage());
            }
            else {
                System.out.println("Success");
            }
        }
        catch (ModbusTransportException e) {
            e.printStackTrace();
        }
    }
}