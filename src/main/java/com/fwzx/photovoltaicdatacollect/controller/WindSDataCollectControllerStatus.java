package com.fwzx.photovoltaicdatacollect.controller;

import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test.Modbus10Convert16;
import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test.ModbusFloatTest;
import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.test.ModbusIntConvertFloat;
import com.fwzx.photovoltaicdatacollect.modbusTcpAndRTU.utils.ModbusUtil;
import com.fwzx.photovoltaicdatacollect.pojo.WindActSData;
import com.fwzx.photovoltaicdatacollect.service.WindSDataCollectService;
import com.fwzx.photovoltaicdatacollect.util.PropertiesUtil;
import net.wimpi.modbus.Modbus;
import org.n3r.idworker.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class WindSDataCollectControllerStatus {



    @Autowired
    WindSDataCollectService WSDCService;

   public void InsertData(){
        IdWorker id =  new IdWorker(10);

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

    }




    //@Scheduled(cron ="0 0/1 * * * ?")
    @Scheduled(cron ="0 0,5,10,15,20,25,30,35,40,45,50,55 * * * ? ")
    public void ins(){

        IdWorker id = new IdWorker(10);
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
       // Date date = new Date();
        // 得到现在的时间
        Calendar calendar = Calendar.getInstance();
        System.out.println(id.nextId());

        String ip = PropertiesUtil.get(PropertiesUtil.IPADDRESS);
        String quantity = PropertiesUtil.get(PropertiesUtil.QUANTITY);
        String function = PropertiesUtil.get(PropertiesUtil.FUNCTION);
        String slaveId = PropertiesUtil.get(PropertiesUtil.SLAVEID);
        String port = PropertiesUtil.get(PropertiesUtil.PORT);
        //风机数量
        Integer fanQuantity = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.FANQUANTITY));

        //1风机变奖角度1
        Integer angle = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.ANGLE));
        //2风机电网电压1
        Integer voltage1 = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.VOLTAGE1));
        //3风机电网电压2
        Integer voltage2 = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.VOLTAGE2));
        //4风机电网电压3
        Integer voltage3 = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.VOLTAGE3));
        //5风机电网电流1
        Integer current1 = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.CURRENT1));
        //6风机电网电流2
        Integer current2 = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.CURRENT2));
        //7风机电网电流3
        Integer current3 = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.CURRENT3));
        //8风机环境温度
        Integer tempe = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.TEMPE));
        //9风机风速
        Integer wind = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.WIND));
        //10风机风向
        Integer direction = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.DIRECTION));
        //11风机有功
        Integer power = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.POWER));
        //12风机无功
        Integer nopower = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.NOPOWER));
        //13风机叶轮转速
        Integer windspeed = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.WINDSPEED));
        //14风机发电机转速
        Integer motorspeed = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.MOTORSPEED));
        //15风机频率
        Integer frequency = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.FREQUENCY));
        //16风机总发电量
        Integer electric = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.ELECTRIC));
        //17风机功率因数
        Integer factor = Integer.parseInt(PropertiesUtil.get(PropertiesUtil.FACTOR));
        System.out.println("ip: "+ip+" port:"+port+" slaveId:"+slaveId+" function:"+function+" quantity:"+quantity);
        Integer quan = Integer.parseInt(quantity);
        List mod12 = new ArrayList();
        for(int j=1; j<(fanQuantity+1); j++) {
            //fanQuantity是风机的数量
            int q = 34 * j;
            List mod13 = new ArrayList();
            // Thread.sleep(500);
            // System.out.println();
            for (int i = q - 34; i < q; i++) {
               // Thread.sleep(10);
                if (i % 2 == 0) {
                    int mod5 = ModbusUtil.readRegister(ip, Integer.parseInt(port), i, Integer.parseInt(slaveId));
                    int mod6 = ModbusUtil.readRegister(ip, Integer.parseInt(port), i + 1, Integer.parseInt(slaveId));

                     //*System.out.print("mod5 "+mod5 +" ");
                     // System.out.print("mod6 "+mod6+" ");
                    String mod10;
                    if(mod6 == 0){
                        mod10 = Modbus10Convert16.decimalToHex(mod6)+"0000"+ Modbus10Convert16.decimalToHex(mod5);
                    }else {

                        mod10 = Modbus10Convert16.decimalToHex(mod6) + Modbus10Convert16.decimalToHex(mod5);
                    }
                    //System.out.print(mod10);
                    //  System.out.print(" ");
                    //Double mod18 = Modbus10Convert16.getDoubleByHexstr(mod10);
                    // System.out.print(" "+mod18);
                    if (mod10.length() == 8) {
                        Double mod11 = Modbus10Convert16.getDoubleByHexstr(mod10);
                        // System.out.print(mod11 + " ");
                        // mod12.add(mod11);
                        mod13.add(mod11);
                    } else {
                        //System.out.print(0 + " ");
                        // mod12.add(0);
                        mod13.add(0);

                    }

                }//第二层循环


            }  //第一层循环

            System.out.println();
            WindActSData data = new WindActSData();
            data.setId(String.valueOf(id.nextId()));
            data.setGetTime( new Date(calendar.getTimeInMillis()));
            data.setAngle(Double.valueOf(mod13.get(angle).toString()));
            data.setVoltage1(Double.valueOf(mod13.get(voltage1).toString()));
            data.setVoltage2(Double.valueOf(mod13.get(voltage2).toString()));
            data.setVoltage3(Double.valueOf(mod13.get(voltage3).toString()));
            data.setCurrent1(Double.valueOf(mod13.get(current1).toString()));
            data.setCurrent2(Double.valueOf(mod13.get(current2).toString()));
            data.setCurrent3(Double.valueOf(mod13.get(current3).toString()));
            data.setTempe(Double.valueOf(mod13.get(tempe).toString()));
            data.setWind(Double.valueOf(mod13.get(wind).toString()));
            data.setDirection(Double.valueOf(mod13.get(direction).toString()));
            data.setPower(Double.valueOf(mod13.get(power).toString()));
            data.setNopower(Double.valueOf(mod13.get(nopower).toString()));
            data.setWindspeed(Double.valueOf(mod13.get(windspeed).toString()));
            data.setMotorspeed(Double.valueOf(mod13.get(motorspeed).toString()));
            data.setFrequency(Double.valueOf(mod13.get(frequency).toString()));
            data.setElectric(Double.valueOf(mod13.get(electric).toString()));
            data.setFactor(Double.valueOf(mod13.get(factor).toString()));

            WSDCService.insertData(data);


            System.out.println(mod13);
            System.out.println("风机变奖角度:"+ mod13.get(angle));
            System.out.println("风机电网电压1:"+ mod13.get(voltage1));
            System.out.println("风机电网电压2:"+ mod13.get(voltage2));
            System.out.println("风机电网电压3:"+ mod13.get(voltage3));
            System.out.println("风机电网电流1:"+ mod13.get(current1));
            System.out.println("风机电网电流2:"+ mod13.get(current2));
            System.out.println("风机电网电流3:"+ mod13.get(current3));
            System.out.println("风机环境温度:"+ mod13.get(tempe));
            System.out.println("风机风速:"+ mod13.get(wind));
            System.out.println("风机风向:"+ mod13.get(direction));
            System.out.println("风机有功:"+ mod13.get(power));
            System.out.println("风机无功:"+ mod13.get(nopower));
            System.out.println("风机叶轮转速:"+ mod13.get(windspeed));
            System.out.println("风机发电机转速:"+ mod13.get(motorspeed));
            System.out.println("风机频率:"+ mod13.get(frequency));
            System.out.println("风机总发电量:"+ mod13.get(electric));
            System.out.println("风机功率因数:"+ mod13.get(factor));


            System.out.println();
    /*    for(int i=0; i<quan;i++) {
            int mod = ModbusUtil.readRegister("127.0.0.1", 502, i, 1);
            System.out.print(mod + " ");
        }*/
            System.out.println();
            // System.out.println(mod12);
        }

    }

    public static void main(String[] args) throws InterruptedException {


        //int modStatus = ModbusUtil.readDigitalInput("127.0.0.1",502,0,2);
            List list = new ArrayList();
            List list2 = new ArrayList();
            int mub =1;
            for (int i=0;i<87;i++) {
                int modStatus1 = ModbusUtil.readDigitalOutput("127.0.0.1", 502, i, 2);

               // int modStatus2 = ModbusUtil.readDigitalOutput("127.0.0.1", 502, 1, 2);

                    list.add(modStatus1 );
                    if(i%3==0){
                        list2.add(mub++);
                    }

            }

            for(int x=0; x < list.size(); x++) {
                Integer s = Integer.parseInt(list.get(x).toString());
                if (s == 1) {
                    System.out.println(x);
                }
            }
        System.out.println(list2);

    }


}
