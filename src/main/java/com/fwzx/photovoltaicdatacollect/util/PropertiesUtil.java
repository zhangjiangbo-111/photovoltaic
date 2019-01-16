package com.fwzx.photovoltaicdatacollect.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


public enum PropertiesUtil {

	/*#风机数量
			fanQuantity=2

#1风机变奖角度1
			angle=1
#2风机电网电压1
			voltage1=2
#3风机电网电压2
			voltage2=3
#4风机电网电压3
			voltage3=4
#5风机电网电流1
			current1=5
#6风机电网电流2
			current2=6
#7风机电网电流3
			current3=7
#8风机环境温度
			tempe=8
#9风机风速
			wind=9
#10风机风向
			direction=10
#11风机有功
			power=11
#12风机无功
			nopower=12
#13风机叶轮转速
			windspeed=13
#14风机发电机转速
			motorspeed=14
#15风机频率
			frequency=15
#16风机总发电量
			electric=16
#17风机功率因数
			factor=17*/
	
		ENTRYO("entryo"),
	    ENTRYT("entryt"),
	    ENTRYTH("entryth"),
	    SXO("sxo"),
	    SXT("sxt"),
		FANQUANTITY("fanQuantity"),
		ANGLE("angle"),
	    VOLTAGE1("voltage1"),
	    VOLTAGE2("voltage2"),
		VOLTAGE3("voltage3"),
	    CURRENT1("current1"),
		CURRENT2("current2"),
		CURRENT3("current3"),
		TEMPE("tempe"),
		WIND("wind"),
		DIRECTION("direction"),
		POWER("power"),
		NOPOWER("nopower"),
		WINDSPEED("windspeed"),
		MOTORSPEED("motorspeed"),
		FREQUENCY("frequency"),
		ELECTRIC("electric"),
		FACTOR("factor"),

		SLAVEID("slaveId"),
		PORT("port"),
		QUANTITY("quantity"),
		FUNCTION("function"),
		IPADDRESS("ipAddress");
	
	
	    private String title;
	    private static Properties props;
	    private PropertiesUtil(String title){
	        this.title = title;
	    }

	    private static final String PROPERTIES = "jTask.properties";
	    
	    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
	    
	    static{
	        try {
	            props = new Properties();
	            InputStream ins = PropertiesUtil.class.getClassLoader().getResourceAsStream(PROPERTIES);    
	            props.load(ins);
	            ins.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private String getTitle() {
	        return title;
	    }

	    public static String getTranslate(PropertiesUtil prop, Map<String, String> params){
	        String path = get(prop);
	        if(path==null||path.equals("")){
	            return "";
	        }
	        if(params!=null && !params.keySet().isEmpty()){
	            //需要替换的字段均放入map中，包括需要替换的日期
	            for(String key : params.keySet()){
	                path = path.replace("{"+key+"}", params.get(key));
	            }
	        }
	        
	        //如不指定日期，则替换为当前日期
	        Calendar cal = Calendar.getInstance();
	        path = path.replace("{year}", cal.get(Calendar.YEAR)+"")
	                .replace("{month}", cal.get(Calendar.MONTH)+1>9?cal.get(Calendar.MONTH)+1+"":"0"+(cal.get(Calendar.MONTH)+1))
	                .replace("{date}", cal.get(Calendar.DATE)>9?cal.get(Calendar.DATE)+"":"0"+cal.get(Calendar.DATE));
	        
	        return path;
	    }
	    
	    public static String get(PropertiesUtil prop){
	        String value = props.getProperty(prop.getTitle());
	        return value==null?null:loop(value);
	    }
	    
	    @SuppressWarnings("static-access")
	    private static String loop(String key){
	        //定义matcher匹配其中的路径变量
	        Matcher matcher = PATTERN.matcher(key);
	        StringBuffer buffer = new StringBuffer();
	        boolean flag = false;
	        while (matcher.find()) {
	            String matcherKey = matcher.group(1);//依次替换匹配到的路径变量
	            String matchervalue = props.getProperty(matcherKey);
	            if (matchervalue != null) {
	                matcher.appendReplacement(buffer, matcher.quoteReplacement(matchervalue));//quoteReplacement方法对字符串中特殊字符进行转化
	                flag = true;
	            }
	        }
	        matcher.appendTail(buffer);
	        //flag为false时说明已经匹配不到路径变量，则不需要再递归查找
	        return flag?loop(buffer.toString()):key;
	    }

}
