package com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test;

import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.utils.ModbusUtil;
import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.BatchResults;
import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;

import java.util.List;


public class BatchModbusSlave {



    static ModbusFactory modbusFactory;
    static {
        if (modbusFactory == null) {
            modbusFactory = new ModbusFactory();
        }
    }

    /*
     * 获取master
     * @param host  IP地址
     * @param port  端口号
     * @return
     * @throws ModbusInitException
     */
    public static ModbusMaster getMaster(String host,int port) throws ModbusInitException {
        try {
            IpParameters params = new IpParameters();
            params.setHost(host);
            params.setPort(port);
            ModbusMaster master = modbusFactory.createTcpMaster(params, false);// TCP 协议
            master.init();  //master初始化
            return master;
        } catch (Exception e) {
          //  logger.error("获取master出现异常"+e);
            System.out.println("获取master出现异常"+e);
            e.printStackTrace();
        }
        return null;
    }




    public static void main(String[] args){

        List<Integer> mod4 = ModbusUtil.readRegister1("127.0.0.1", 502, 918, 1);
       // List<Integer> mod4 = ModbusUtil.readRegister1("127.0.0.1", 502, 124, 1);
        System.out.println(mod4);
        //System.out.println(mod4);
    }




    /*
     * 读取[03 Holding Register类型 2x]模拟量数据
     * @param master ModbusMaster对象
     * @param slaveId
     *            slave Id  设备ID
     * @param offset
     *            偏移截止位置
     * @param dataType
     *            数据类型,来自com.serotonin.modbus4j.code.DataType
     * @return
     * @throws ModbusTransportException
     *             异常
     * @throws ErrorResponseException
     *             异常
     * @throws ModbusInitException
     *             异常
     */
/*    public static Number readHoldingRegister(ModbusMaster master,int slaveId, int offset, int dataType)
            throws ModbusTransportException, ErrorResponseException, ModbusInitException {
        // 03 Holding Register类型数据读取
        BaseLocator<Number> loc = BaseLocator.holdingRegister(slaveId, offset, dataType);
        System.out.println("loc:"+loc);
        Number value =master.getValue(loc);
        System.out.println();
        return value;
    }*/


    /*
     * 批量读取使用寄存器数据
     * @param  master ModbusMaster对象
     * @param batchRead   批量读取集合
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     * @throws ModbusInitException
     */
    public static BatchResults<Integer> batchRead(ModbusMaster master,BatchRead<Integer> batchRead)throws Exception {
        try {
            batchRead.setContiguousRequests(false);
            BatchResults<Integer> results = master.send(batchRead);
            return results;
        } catch (Exception e) {
            //logger.error("批量读取使用寄存器数据出现异常"+e);
            System.out.println("批量读取使用寄存器数据出现异常"+e);
            e.printStackTrace();
        }
        return null;

    }


/*    public static void main(String[] arg){

        try {
            ModbusMaster master= getMaster("127.0.0.1",502);
            BatchRead<Integer> batch = new BatchRead<Integer>();

            batch.addLocator(0, BaseLocator.holdingRegister(1,1002, DataType.FOUR_BYTE_FLOAT_SWAPPED));
            batch.addLocator(1, BaseLocator.holdingRegister(1,1004, DataType.FOUR_BYTE_FLOAT_SWAPPED));
            batch.addLocator(2, BaseLocator.holdingRegister(1,1006, DataType.FOUR_BYTE_FLOAT_SWAPPED));
            batch.addLocator(3, BaseLocator.holdingRegister(1,1008, DataType.FOUR_BYTE_FLOAT_SWAPPED));

            BatchResults<Integer> batchRead = batchRead(master,batch);
            System.out.println(batchRead.getValue(0));
            System.out.println(batchRead.getValue(1));
            System.out.println(batchRead.getValue(2));
            System.out.println(batchRead.getValue(3));
            //DataType.FOUR_BYTE_FLOAT_SWAPPED  float高低位数据处理
            Number v031 = readHoldingRegister(master,1,1010, DataType.FOUR_BYTE_FLOAT_SWAPPED);// 注意,float
            System.out.println("v031："+v031);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }*/

}
