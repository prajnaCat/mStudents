package com.tool;

import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import sun.misc.BASE64Decoder;

public class ToolUtil {
	
	 /**
     * 10-20出现的概率为50%
     */
	 public static double rate0 = 0.50;
	 /**
     * 20-30出现的概率为25%
     */
	 public static double rate1 = 0.25;
	 /**
     * 30-40出现的概率为10%
     */
	 public static double rate2 = 0.10;
	 /**
     * 40-50出现的概率为7%
     */
	 public static double rate3 = 0.07;
	 /**
     * 50-60出现的概率为%4
     */
	 public static double rate4 = 0.03;
	 /**
     * 60-70出现的概率为2%
     */
 	public static double rate5 = 0.02;
 
 	/**
 	 * 70-80出现的概率为1.5%
 	 */
	public static double rate6 = 0.015;
	
	/**
	 * 80-90出现的概率为1%
	 */
	public static double rate7 = 0.010;
	
	/**
	 * 90-100出现的概率为0.5%
	 */
	public static double rate8 = 0.005;
	
	public final String STATUS_CARE = "1";
	
	public final String STATUS_YY = "2";

	private static String hexString="0123456789ABCDEF"; 
	
	public static String encode(String str) 
	{ 
		byte[] bytes=str.getBytes(); 
		StringBuilder sb=new StringBuilder(bytes.length*2); 
		for(int i=0;i<bytes.length;i++) 
		{ 
			sb.append(hexString.charAt((bytes[i]&0xf0)>>4)); 
			sb.append(hexString.charAt((bytes[i]&0x0f)>>0)); 
		} 
		return sb.toString(); 
	} 
	
	public static String decode(String bytes) 
	{ 
		ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2); 
		//将每2位16进制整数组装成一个字节 
		for(int i=0;i<bytes.length();i+=2) 
			baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1)))); 
		return new String(baos.toByteArray()); 
	}
	
	/**
     * 补齐不足长度
     * @param length 长度
     * @param number 数字
     * @return
     */
	public static String lpad(int length, int number) {
        String f = "%0" + length + "d";
        return String.format(f, number);
    }
	
	// 复制目录下的文件（不包括该目录）到指定目录，会连同子目录一起复制过去。  
	 public static void copyFileFromDir(String toPath, String fromPath) {  
		File file = new File(fromPath);  
		createFile(toPath, false);// true:创建文件 false创建目录  
		if (file.isDirectory()) {// 如果是目录  
		copyFileToDir(toPath, listFile(file));  
		}  
	 } 
	 
	 // 复制一组文件到指定目录。targetDir是目标目录，filePath是需要复制的文件路径  
     public static void copyFileToDir(String toDir, String[] filePath) {  
         if (toDir == null || "".equals(toDir)) {// 目录路径为空  
            System.out.println("参数错误，目标路径不能为空");  
             return;  
         }  
         File targetFile = new File(toDir);  
         if (!targetFile.exists()) {// 如果指定目录不存在  
             targetFile.mkdir();// 新建目录  
         } else {  
             if (!targetFile.isDirectory()) {// 如果不是目录  
                 System.out.println("参数错误，目标路径指向的不是一个目录！");  
                 return;  
             }  
         }  
         for (int i = 0; i < filePath.length; i++) {// 遍历需要复制的文件路径  
            File file = new File(filePath[i]);// 创建文件  
             if (file.isDirectory()) {// 判断是否是目录  
                 copyFileToDir(toDir + "/" + file.getName(), listFile(file));// 递归调用方法获得目录下的文件  
                 System.out.println("复制文件 " + file);  
             } else {  
                 copyFileToDir(toDir, file, "");// 复制文件到指定目录  
             }  
         }  
     } 
     
     public static void copyFileToDir(String toDir, File file, String newName) {// 复制文件到指定目录  
         String newFile = "";  
         if (newName != null && !"".equals(newName)) {  
             newFile = toDir + "/" + newName;  
         } else {  
             newFile = toDir + "/" + file.getName();  
         }  
         File tFile = new File(newFile);  
         copyFile(tFile, file);// 调用方法复制文件  
     }  
    	   
     public static void copyFile(File toFile, File fromFile) {// 复制文件  
         if (toFile.exists()) {// 判断目标目录中文件是否存在  
             System.out.println("文件" + toFile.getAbsolutePath() + "已经存在，跳过该文件！");  
             return;  
         } else {  
             createFile(toFile, true);// 创建文件  
         }  
         System.out.println("复制文件" + fromFile.getAbsolutePath() + "到"  
                 + toFile.getAbsolutePath());  
         try {  
             InputStream is = new FileInputStream(fromFile);// 创建文件输入流  
             FileOutputStream fos = new FileOutputStream(toFile);// 文件输出流  
             byte[] buffer = new byte[1024];// 字节数组  
             while (is.read(buffer) != -1) {// 将文件内容写到文件中  
                 fos.write(buffer);  
             }
             if (fromFile.exists()) {
            	 fromFile.delete();
             }
             is.close();// 输入流关闭  
             fos.close();// 输出流关闭  
         } catch (FileNotFoundException e) {// 捕获文件不存在异常  
             e.printStackTrace();  
         } catch (IOException e) {// 捕获异常  
             e.printStackTrace();  
         }  
     }  


	 
	 public static String[] listFile(File dir) {// 获取文件绝对路径  
         String absolutPath = dir.getAbsolutePath();// 声获字符串赋值为路传入文件的路径  
         String[] paths = dir.list();// 文件名数组  
         String[] files = new String[paths.length];// 声明字符串数组，长度为传入文件的个数  
         for (int i = 0; i < paths.length; i++) {// 遍历显示文件绝对路径  
             files[i] = absolutPath + "/" + paths[i];  
         }  
         return files;  
     } 

	 
	 public static void createFile(String path, boolean isFile) {// 创建文件或目录  
         createFile(new File(path), isFile);// 调用方法创建新文件或目录  
     } 


	 public static void createFile(File file, boolean isFile) {// 创建文件  
        if (!file.exists()) {// 如果文件不存在  
         if (!file.getParentFile().exists()) {// 如果文件父目录不存在  
                 createFile(file.getParentFile(), false);  
            } else {// 存在文件父目录  
                 if (isFile) {// 创建文件  
                     try {  
                         file.createNewFile();// 创建新文件  
                     } catch (IOException e) {  
                         e.printStackTrace();  
                     }  
                 } else {  
                     file.mkdir();// 创建目录  
                 }  
             }  
         }  
     } 
	 
//	 public static void main(String[] args) {
//		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		 try {
//			 Calendar cal = Calendar.getInstance();
//			 cal.setTime(format.parse("1990-01-09"));
//			 System.out.println(getAge(cal.getTime()));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	 }

	 /** 计算年龄 */ 
	 public static int getAge(Date birthDay) throws Exception { 
	         Calendar cal = Calendar.getInstance(); 

	         if (cal.before(birthDay)) { 
	             throw new IllegalArgumentException( 
	                 "The birthDay is before Now.It's unbelievable!"); 
	         } 

	         int yearNow = cal.get(Calendar.YEAR); 
	         int monthNow = cal.get(Calendar.MONTH)+1; 
	         int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); 
	         
	         cal.setTime(birthDay); 
	         int yearBirth = cal.get(Calendar.YEAR); 
	         int monthBirth = cal.get(Calendar.MONTH); 
	         int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH); 

	         int age = yearNow - yearBirth; 

	         if (monthNow <= monthBirth) { 
	             if (monthNow == monthBirth) { 
	                 //monthNow==monthBirth 
	                 if (dayOfMonthNow < dayOfMonthBirth) { 
	                     age--; 
	                 } 
	             } else { 
	                 //monthNow>monthBirth 
	                 age--; 
	             } 
	         } 

	         return age; 
	     } 

	
	/**
     * 月第一天
     * @return
     */
	public static String getFirstDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date theDate = calendar.getTime();
        
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        return day_first;

    }
    
    /**
     * 月最后一天
     * @return
     */
	public static String getLasttDay(Date date) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);  
        calendar.add(Calendar.DATE, -1);
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        return s;

    }
	
	/**
	 * 根据开始时间和结束时间返回时间段内的时间集合
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return List
	 */
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(beginDate);// 把开始时间加入集合
		Calendar cal = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		cal.setTime(beginDate);
		boolean bContinue = true;
		while (bContinue) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			cal.add(Calendar.MONTH, 1);
			// 测试此日期是否在指定日期之后
			if (endDate.after(cal.getTime())) {
				lDate.add(cal.getTime());
			} else {
				break;
			}
		}
		lDate.add(endDate);// 把结束时间加入集合
		return lDate;
	}
	
	/**
	 * 获取两日期之间的月份
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getMonth(Date start, Date end) {
        if (start.after(end)) {
            Date t = start;
            start = end;
            end = t;
        }
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        Calendar temp = Calendar.getInstance();
        temp.setTime(end);
        temp.add(Calendar.DATE, 1);

        int year = endCalendar.get(Calendar.YEAR)
                - startCalendar.get(Calendar.YEAR);
        int month = endCalendar.get(Calendar.MONTH)
                - startCalendar.get(Calendar.MONTH);

        if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month + 1;
        } else if ((startCalendar.get(Calendar.DATE) != 1)
                && (temp.get(Calendar.DATE) == 1)) {
            return year * 12 + month;
        } else if ((startCalendar.get(Calendar.DATE) == 1)
                && (temp.get(Calendar.DATE) != 1)) {
            return year * 12 + month;
        } else {
            return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }
    }
	
	public static int compare_date(Date DATE1, Date DATE2) {
        try {
            if (DATE1.getTime() > DATE2.getTime()) {
                return 1;
            } else if (DATE1.getTime() < DATE2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
	}	
	/**
	 * MD5加密 大写
	 * @param s
	 * @return
	 */
	public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	/**
	 * MD5加密 小写
	 * @param s
	 * @return
	 */
	public final static String MD5Small(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};       

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	
	/**
	 * 咱的MD5加密
	 * @param s
	 * @return
	 */
	public final static String psdMD5(String s){
		String res = MD5(s);
		res = "SYJG_5102!" + res;
		res = MD5(res);
		return res;
	}
	
	public static boolean isEmpty(String value) {
		boolean flg = false;
		if (value==null || value.equals("") || value.equals("null")) {
			flg = true;
		}
		return flg;
	}
	
	public static String isNotEmpty(String value) {
		String result = "";
		if (value!=null && !value.equals("")) {
			result = value;
		}
		return result;
	}
	
	// 解密   
    public static String getFromBase64(String s) {  
        byte[] b = null;  
        String result = null;  
       if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  

	
	public static int daysBetween(Date smdate,Date bdate) throws Exception     
	{     
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");   
        smdate=sdf.parse(sdf.format(smdate));   
        bdate=sdf.parse(sdf.format(bdate));   
        Calendar cal = Calendar.getInstance();     
        cal.setTime(smdate);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(bdate);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24)+1;   
        return Integer.parseInt(String.valueOf(between_days));            
    } 
	
	 /**
     * 将json格式的字符串解析成Map对象 <li>
     * json格式：{"name":"admin","retries":"3fff","testname"
     * :"ddd","testretries":"fffffffff"}
     */
    public static HashMap<String, String> toHashMap(Object object)
    {
        HashMap<String, String> data = new HashMap<String, String>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext())
        {
            String key = String.valueOf(it.next());
            String value = (String) jsonObject.get(key);
            data.put(key, value);
        }
        return data;
    }
	
	public static String getBodyString(BufferedReader br) {
	     String inputLine;
        String str = "";
	     try {
	       while ((inputLine = br.readLine()) != null) {
	    	   str += inputLine;
	       }
	       br.close();
	     } catch (IOException e) {
	       System.out.println("IOException: " + e);
	     }
	     return str;
   }
	
	/**
	 * 字符转码
	 */
	public static String getUTFByIso(String value) {
		String result = "";
		try {
			if (!isEmpty(value)) {
				if (value.equals(new String(value.getBytes("ISO-8859-1"),"ISO-8859-1"))) {
					result = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				} else {
					result = value; 
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	/**
	  * Math.random()产生一个double型的随机数，判断一下
	  * 例如0出现的概率为%50，则介于0到0.50中间的返回0
	     * @return int
	     *
	     */
	 	public static int PercentageRandom()
	 	{
	 		double randomNumber;
	 		randomNumber = Math.random();
	 		if (randomNumber >= 0 && randomNumber <= rate0)
	 		{
	 			return (int)(randomNumber*10)+10;
	 		}
	 		else if (randomNumber >= rate0 && randomNumber <= rate0 + rate1)
	 		{
	 			return (int)(randomNumber*20)+10;
	 		}
	 		else if (randomNumber >= rate0 + rate1
	 				&& randomNumber <= rate0 + rate1 + rate2)
	 		{
	 			return (int)(randomNumber*30)+10;
	 		}
	 		else if (randomNumber >= rate0 + rate1 + rate2
	 				&& randomNumber <= rate0 + rate1 + rate2 + rate3)
	 		{
	 			return (int)(randomNumber*40)+10;
	 		}
	 		else if (randomNumber >= rate0 + rate1 + rate2 + rate3
	 				&& randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4)
	 		{
	 			return (int)(randomNumber*50)+10;
	 		}
	 		else if (randomNumber >= rate0 + rate1 + rate2 + rate3 + rate4
	 				&& randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4
	 				+ rate5)
	 		{
	 			return (int)(randomNumber*60)+10;
	 		}
	 		else if (randomNumber >= rate0 + rate1 + rate2 + rate3 + rate4 + rate5
			    && randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4 + rate5 + rate6)
			{
			   return (int)(randomNumber*70)+10;
		    }
	 		else if (randomNumber >= rate0 + rate1 + rate2 + rate3 + rate4 + rate5 + rate6
			    && randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7)
			{
			   return (int)(randomNumber*80)+10;
			}
	 		else if (randomNumber >= rate0 + rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7
			    && randomNumber <= rate0 + rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + rate8)
			{
			   return (int)(randomNumber*90)+10;
			} 
	 		return 10;
	 	}
	 	
	 	/**
	 	 * 姓名隐藏方法
	 	 */
	 	public static String xmHide(String xm) {
	 		String result = "";
	 		if (!isEmpty(xm)) {
	 			String str1=xm.substring(1,2);
	 			if (xm.length() == 3) {
	 				result = xm.substring(0,1) + "**" + xm.substring(2,3);
	 			} else if (xm.length() == 2) {
	 				result = xm.replace(str1, "**");
	 			} else {
	 				str1 = xm.substring(1,xm.length());
	 				result = xm.replace(str1, "**");
	 			}
	 		}
	 		return result;
	 	}
	 	
	 	/**
	 	 * 身份证隐藏方法
	 	 */
	 	public static String sfzHide(String sfz) {
	 		String result = "";
	 		if (!isEmpty(sfz)) {
	 			String str1=sfz.substring(6,14);
	 			if (sfz.length() == 18) {
	 				result = sfz.replace(str1, "********");
	 			} else {
	 				result = sfz;
	 			}
	 		}
	 		return result;
	 	}
	 	
	 	/**
	 	 * 银行卡隐藏方法
	 	 */
	 	public static String yhkHide(String yhk) {
	 		String result = "";
	 		if (!isEmpty(yhk)) {
	 			for (int i = 0; i < yhk.length()-4; i++) {
	 				result += "*";
	 			}
	 			result = result + yhk.substring(yhk.length()-4,yhk.length());
	 		}
	 		return result;
	 	}
	 	
//	 	public static void main(String[] args) {
//	 		getOrderNo();
////			for (int i = 0; i < 1000; i++) {
////				System.out.println(getOrderNo());
////			}
//		}
	 	
	 	/**
	 	 * 生成时间戳主键
	 	 * @return
	 	 */
	 	public static String getId(String value) {
	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	 		String math = (int)(Math.random()*10000) + "";
			return value + sdf.format(new Date())+getRandomFor(math,5);
	 	}
	 	
	 	
	 	/**
	 	 * 18位生成时间戳主键
	 	 * @return
	 	 */
	 	public static String getNewId(String value) {
	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHSSS");
	 		String math = (int)(Math.random()*10000) + "";
			return value + sdf.format(new Date())+getRandomFor(math,5);
	 	}
	 	
	 	
//	 	public static void main(String[] args) {
//	 		System.out.println(getOrderNo());
//		}
	 	/**
	 	 * 生成支付订单编号
	 	 * @return
	 	 */
//	 	public static String getOrderNo() {
//	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
//	 		String math = (int)(Math.random()*100000) + "";
//			return ToolConstants.ORDER_NO + sdf.format(new Date())+getRandomFor(math,6);
//	 	}
	 	
	 	public static String getRandomFor(String value,int num) {
	 		String result = value;
	 		if (value.length() < num) {
	 			String f = "";
	 			for (int i = value.length(); i < num; i++)  {
	 				f += "0";
	 			}
	 			result = f + result;
	 		}
	 		return result;
	 	}
	 	
	 	
	 	
	 	public static Map<String, BigDecimal> getLatAndLngByAddress(String addr){
	        String address = "";
	        String lat = "";
	        String lng = "";
	        try {  
	            address = java.net.URLEncoder.encode(addr,"UTF-8");  
	        } catch (UnsupportedEncodingException e1) {  
	            e1.printStackTrace();  
	        } 
	        String url = String.format("http://api.map.baidu.com/geocoder/v2/?"
	        +"ak=nx2eSm1qIyGpMGHGKcpZS7xh&output=json&address=%s",address);
	        URL myURL = null;
	        URLConnection httpsConn = null;  
	        //进行转码
	        try {
	            myURL = new URL(url);
	        } catch (MalformedURLException e) {

	        }
	        try {
	            httpsConn = (URLConnection) myURL.openConnection();
	            if (httpsConn != null) {
	                InputStreamReader insr = new InputStreamReader(
	                        httpsConn.getInputStream(), "UTF-8");
	                BufferedReader br = new BufferedReader(insr);
	                String data = null;
	                if ((data = br.readLine()) != null) {
	                	if (data.indexOf("\"lat\":") != -1) {
	                		lat = data.substring(data.indexOf("\"lat\":") 
	        	                    + ("\"lat\":").length(), data.indexOf("},\"precise\""));
	                	} 
	                	if (data.indexOf("\"lng\":") != -1) {
	                		lng = data.substring(data.indexOf("\"lng\":") 
	        	                    + ("\"lng\":").length(), data.indexOf(",\"lat\""));
	                	}
	                }
	                insr.close();
	            }
	        } catch (IOException e) {

	        }
	        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
	        map.put("lat", lat==""?new BigDecimal("0"):new BigDecimal(lat));
	        map.put("lng", lng==""?new BigDecimal("0"):new BigDecimal(lng));
	        return map;
		}
	 	
	 	/** 
		 * 计算地球上任意两点(经纬度)距离 
		 *  
		 * @param long1 
		 *            第一点经度 
		 * @param lat1 
		 *            第一点纬度 
		 * @param long2 
		 *            第二点经度 
		 * @param lat2 
		 *            第二点纬度 
		 * @return 返回距离 单位：米 
		 */  
		public static double Distance(double long1, double lat1, double long2,  
		        double lat2) {  
		    double a, b, R;  
		    R = 6378137; // 地球半径  
		    lat1 = lat1 * Math.PI / 180.0;  
		    lat2 = lat2 * Math.PI / 180.0;  
		    a = lat1 - lat2;  
		    b = (long1 - long2) * Math.PI / 180.0;  
		    double d;  
		    double sa2, sb2;  
		    sa2 = Math.sin(a / 2.0);  
		    sb2 = Math.sin(b / 2.0);  
		    d = 2  
		            * R  
		            * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)  
		                    * Math.cos(lat2) * sb2 * sb2));  
		    return d;  
		}
		
		
		
		private static final String APPLICATION_JSON = "application/json";
	    
	    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

	    public static String httpPostWithJSON(String url, String json) throws Exception {
	        HttpClient   httpClient = new HttpClient  ();
	        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60*1000);
	        // 设置读取超时时间(单位毫秒)
	        httpClient.getHttpConnectionManager().getParams().setSoTimeout(60*1000);
	        PostMethod method = new PostMethod(url);
			String info = null;
			try {
				RequestEntity entity = new StringRequestEntity(json, APPLICATION_JSON, "UTF-8");
				method.setRequestEntity(entity);
				httpClient.executeMethod(method);
				int code = method.getStatusCode();
				if (code == HttpStatus.SC_OK) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
					StringBuffer stringBuffer = new StringBuffer();
					String str = "";
					while ((str = reader.readLine()) != null) {
						stringBuffer.append(str);
					}
					info = stringBuffer.toString();
				}else{
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (method != null) {
					method.releaseConnection();
				}
			}
			return info;
//	        HttpPost httpPost = new HttpPost(url);
//	        httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
//	        
//	        StringEntity se = new StringEntity(encoderJson);
//	        se.setContentType(CONTENT_TYPE_TEXT_JSON);
//	        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON));
//	        httpPost.setEntity(se);
//	        HttpResponse  response = httpClient.execute(httpPost);
//	        HttpEntity entity = response.getEntity(); 
//	        System.out.println(response.getStatusLine()); 
//	        
//	        if (entity != null) {     
//	            System.out.println("Response content length: " + entity.getContentLength());  //得到返回数据的长度    
//	          }     
//	          // 显示结果     
//	          BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));   
//	            
//	          String line = null;     
//	         while ((line = reader.readLine()) != null) {     
//	              System.out.println(line);     
//	          }     
//	         if (entity != null) {     
//	               entity.consumeContent();     
//	          }     
	    }
	    public static Date getDate19() throws ParseException {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(new Date());
			Date nowtime = sdf.parse(time);
			return nowtime;
	    }
	    
	    public static Date formatNewDate(Date date){
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        try{
	            String dateStr = simpleDateFormat.format(date);
	            Date resDate = simpleDateFormat.parse(dateStr);
	            return resDate;
	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        }
	    }

    /**
     * 获取某月的最后一天
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     * @throws
     */
    public static String getLastDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }
	    
    /**
	 * 获得当前时分秒
	 */
	public static Date getCurrentTime() {
		SimpleDateFormat dateformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date parse = null;
		try {
			parse = dateformat.parse(dateformat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parse;
	}
	
    /**
	 * 获取指定格式的当前时间
	 * @param simpleDateFormat
	 * @return
	 */
	public static Date getCurrentTime(SimpleDateFormat simpleDateFormat){
		if(simpleDateFormat == null){
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
		Date parse = null;
		try {
			parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}

	/**
	 * 获取指定格式的当前时间(String)
	 * @param simpleDateFormat
	 * @return
	 */
	public static String getCurrentTimeStr(SimpleDateFormat simpleDateFormat){
		if(simpleDateFormat == null){
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
		Date date = new Date();
		String rq = simpleDateFormat.format(date);
		return rq;
	}
    
	/**日期格式化
	 * @param date
	 * @param simpleDateFormat
	 * @return
	 */
	public static Date formatDate(Date date,SimpleDateFormat simpleDateFormat){
		if(simpleDateFormat == null){
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		try {
			date = simpleDateFormat.parse(simpleDateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

    public static Integer calDaysBetweenTwoDays(Date sDate,Date eDate){
        long intervalMilli = eDate.getTime() - sDate.getTime();
        return (int)intervalMilli / (24 * 60 * 60 * 1000);
    }

  

    public static void copyDirectly(File src, File dst)throws FileNotFoundException{
        int BUFFER_SIZE = 500 * 1024;
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                while (in.read(buffer) > 0) {
                    out.write(buffer);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用文件通道复制文件
     * @param src
     * @param dst
     * @throws FileNotFoundException
     */
    public static void copy(File src,File dst)throws FileNotFoundException{
        boolean bReturn = true;
        try {
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dst);
            FileChannel in = fi.getChannel();//得到对应的文件通道
            FileChannel out = fo.getChannel();//得到对应的文件通道
            try {
                in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
            }catch (IOException e) {
                e.printStackTrace();
                bReturn = false;
            }finally {

                try{
                    fi.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

                try{
                    fo.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

                try{
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

                try{
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
//        return bReturn;
    }
    public  static String toDate(String date,String hqlFormat) {  
        StringBuffer bf = new StringBuffer();  
        bf.append("str_to_date('");  
        bf.append(date);  
        bf.append("','");  
        bf.append(hqlFormat);  
        bf.append("')");  
        return bf.toString();  
    }
}
