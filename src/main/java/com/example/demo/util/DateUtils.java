/**
 * @author:liucs(liucs518@126.com)
 * @DATE:2016年2月16日  下午3:41:00
 *
 */
package com.example.demo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Comments: Company: 郑州商鼎科技有限公司 Created by liucs(liucs518@126.com)
 * @DATE:2016年2月16日
 * @TIME: 下午3:41:00
 */
public class DateUtils {
	public static final String formatPattern = "yyyy-MM-dd";

	public static final String formatPattern_all = "yyyy-MM-dd HH:mm:ss";
	
	public static final String format_all = "yyyy/MM/dd HH:mm:ss";
	
	public static final String formatPattern_Short = "yyyyMMdd";

	public static final String formatPattern_sml = "yyMMdd";

	// mysql 常用的日期转换
	public static final String formatMysqlByDay = "%Y-%c-%d"; // 按天
	public static final String formatMysqlByHonour = "%Y-%c-%d %H"; // 按小时
	public static final String formatMySqlByMonth = "%Y-%c"; // 按月

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat format = new SimpleDateFormat(formatPattern);
		return format.format(new Date());
	}

	/**
	 * 获取当前日期 时间
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat format = new SimpleDateFormat(formatPattern_all);
		return format.format(new Date());
	}
	/**
	 * 获取当前日期 时间
	 * 
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat(format_all);
		return format.format(new Date());
	}
	/**
	 * 获取制定毫秒数之前的日期
	 * 
	 * @param timeDiff
	 * @return
	 */
	public static String getDesignatedDate(long timeDiff) {
		SimpleDateFormat format = new SimpleDateFormat(formatPattern);
		long nowTime = System.currentTimeMillis();
		long designTime = nowTime - timeDiff;
		return format.format(designTime);
	}
	/**
	 * YYYYMMDDHHSS
	 * @return
	 */
	public static String getNOWDate(){
		 Calendar now = Calendar.getInstance();  
	     String year= String.valueOf(now.get(Calendar.YEAR));//获取当前的年
	     String mouth=String.valueOf(now.get(Calendar.MONTH) + 1);  
	     String day= String.valueOf(now.get(Calendar.DAY_OF_MONTH));
	     String hour= String.valueOf(now.get(Calendar.HOUR_OF_DAY));  
	     String minute= String.valueOf(now.get(Calendar.MINUTE));  
	     String second= String.valueOf(now.get(Calendar.SECOND));
	     String nowDate=year+mouth+day+hour+minute+second;
	     return nowDate;
	}
	/**
	 * 
	 * 获取前几天的日期
	 */
	public static String getPrefixDate(String count) {
		Calendar cal = Calendar.getInstance();
		int day = 0 - Integer.parseInt(count);
		cal.add(Calendar.DATE, day); // int amount 代表天数
		Date datNew = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat(formatPattern);
		return format.format(datNew);
	}

	/**
	 * 日期转换成字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(formatPattern);
		return format.format(date);
	}

	/**
	 * 日期转换字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 日期时间转换成字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String datetimeToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(formatPattern_all);
		return format.format(date);
	}

	/**
	 * 字符串转换日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str) {
		// str = " 2008-07-10 19:20:00 " 格式
		SimpleDateFormat format = new SimpleDateFormat(formatPattern);
		if (!str.equals("") && str != null) {
			try {
				return format.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 字符串转换日期时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date stringToDateTime(String str) {
		return stringToDateTime(str, null);
	}

	/**
	 * 字符串转换日期时间
	 * 
	 * @param str
	 * @return
	 */
	public static Date stringToDateTime(String str, String formatText) {

		if (formatText == null) {
			formatText = formatPattern_all;
		}

		SimpleDateFormat format = new SimpleDateFormat(formatText);
		if (!str.equals("") && str != null) {
			try {
				return format.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 获取当前的年份
	 * @return
	 */
	public static int getNowYear(){
		Calendar a=Calendar.getInstance();
		int  year=a.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 计算时间之间的天数
	 * @param starttime
	 * @param endtime
	 * @return
	 */
public static Integer getDayCount(Date starttime,Date endtime){
	SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date begin = null;
	Date end   = null;
	try {
		begin = dfs.parse(DateUtils.dateToString(starttime,formatPattern_all));
		end = dfs.parse(DateUtils.dateToString(endtime,formatPattern_all));
	} catch (ParseException e) {
		e.printStackTrace();
	}

	long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

	long day1 = between / (24 * 3600);  //天
//	long hour1 = between % (24 * 3600) / 3600;//小时
//	long minute1 = between % 3600 / 60; //分钟
//	long second1 = between % 60;   //秒
	String days=String.valueOf(day1);
   return Integer.valueOf(days);
}
	// java中怎样计算两个时间如：“21:57”和“08:20”相差的分钟数、小时数 java计算两个时间差小时 分钟 秒 .
	public void timeSubtract() {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = null;
		Date end   = null;
		try {
			begin = dfs.parse("2004-01-02 11:30:24");
			end = dfs.parse("2004-03-26 13:31:40");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

		long day1 = between / (24 * 3600);  //天
		long hour1 = between % (24 * 3600) / 3600;//小时
		long minute1 = between % 3600 / 60; //分钟
		long second1 = between % 60;   //秒
		System.out.println("" + day1 + "天" + hour1 + "小时" + minute1 + "分"
				+ second1 + "秒");
	}
	

	
	
	/**
	 * 获取默认的时间
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}

	public static Timestamp getTimeStatmpByString(String format,
			String dateString) {
		Date date = stringToDateTime(dateString,format);
		return new Timestamp(date.getTime());
	}


	/**
	 * 获取当前日期再过x天的日期
	 * @param x 向后推迟的天数
	 * @return
	 */
	public static String getPastDate(Date date,Integer x){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(x==null)
			return format.format(new Date());
		 Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
         calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + x);
         Date today = calendar.getTime();
         
         String result = format.format(today);
         return result;
	}
	public static String addXDay(Date date,Integer x){
		return DateUtils.getPastDate(date,x);
	}
	public static Date getTargetTime(int hour,int minute,int second){
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR)
				,calendar.get(Calendar.MONTH)
				,calendar.get(Calendar.DAY_OF_MONTH)
				,hour,minute,second);
		return calendar.getTime();
	}

	public static int yearOfWeek(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR)+1;
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.getYesterdayMaxTime());
	}
	
	public static Date getYesterdayMaxTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date time = calendar.getTime();
		String day = DateUtils.dateToString(time);
		String maxTimeStr = day+" 23:59:59";
		return DateUtils.stringToDateTime(maxTimeStr, null);
	}
}
