package common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理类
 * 
 * @author eric
 * @version 1.0 2012-09-17
 * @since 1.0
 */
public final class DateUtil {
	/** 默认日期格式 */
	public static final String DEF_DATE_FORMAT = "yyyy-MM-dd";
	/** 默认时间格式 */
	public static final String DEF_TIME_FORMAT = "HH:mm:ss";
	/** 默认日期时间格式 */
	public static final String DEF_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** 精确到分钟时间格式 */
	public static final String MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

	/** 默认日期匹配格式 */
	public static final String DEF_DATE_PATTERN = "\\d{4}\\-\\d{1,2}-\\d{1,2}";
	/** 默认日期时间匹配格式 */
	public static final String DEF_DATETIME_PATTERN = "\\d{4}\\-\\d{1,2}-\\d{1,2}\\p{javaWhitespace}\\d{1,2}:\\d{1,2}:\\d{1,2}";
	/** 精确到分钟时间匹配格式 */
	public static final String MINUTE_PATTERN = "\\d{4}\\-\\d{1,2}-\\d{1,2}\\p{javaWhitespace}\\d{1,2}:\\d{1,2}";

	/**
	 * 构造函数(空)
	 */
	private DateUtil() {
	}

	private static final DateUtil instance = new DateUtil();

	public static final DateUtil getInstance() {
		return instance;
	}

	/**
	 * 日期比较
	 * 
	 * @return 1 0 -1
	 */
	public static int compareDate(Date date1, Date date2) {
		long date1time = getDate(formatDate(date1)).getTime();
		long date2time = getDate(formatDate(date2)).getTime();
		if (date1time > date2time)
			return 1;
		else if (date1time == date2time)
			return 0;
		else
			return -1;
	}

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDateTime(Date date1, Date date2) {
		long date1time = getDateTime(formatDateTime(date1)).getTime();
		long date2time = getDateTime(formatDateTime(date2)).getTime();
		if (date1time > date2time)
			return 1;
		else if (date1time == date2time)
			return 0;
		else
			return -1;
	}

	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareTimestamp(Timestamp date1, Timestamp date2) {
		if (date1 == null && date2 == null) {
			return 0;
		} else if (date1 == null) {
			return -1;
		} else if (date2 == null) {
			return 1;
		} else {
			long date1time = getDateTime(formatDateTime(date1)).getTime();
			long date2time = getDateTime(formatDateTime(date2)).getTime();
			if (date1time > date2time)
				return 1;
			else if (date1time == date2time)
				return 0;
			else
				return -1;
		}
	}

	/**
	 * 取得系统当前时间戳
	 * 
	 * @return 系统当前时间戳对象
	 */
	public static Timestamp getSysTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 将yyyy-MM-dd格式的字符串转换为日期对象
	 * 
	 * @param date
	 *            yyyy-MM-dd格式字符串
	 * @return 转换后的日期对象，无法转换时返回null
	 */
	public static Date getDate(String date) {
		if (!matchesPattern(date, DEF_DATE_PATTERN))
			return null;
		return parseDate(date, DEF_DATE_FORMAT);
	}

	/**
	 * 将yyyy-MM-dd格式的字符串转换为时间戳对象
	 * 
	 * @param date
	 *            yyyy-MM-dd格式字符串
	 * @return 转换后的时间戳对象，无法转换时返回null
	 */
	public static Timestamp getTimestamp(String date) {
		if (!matchesPattern(date, DEF_DATE_PATTERN))
			return null;
		return new Timestamp(parseDate(date, DEF_DATE_FORMAT).getTime());
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的字符串转换为日期对象
	 * 
	 * @param datetime
	 *            yyyy-MM-dd HH:mm:ss格式字符串
	 * @return 转换后的日期对象，无法转换时返回null
	 */
	public static Date getDateTime(String datetime) {
		if (!matchesPattern(datetime, DEF_DATETIME_PATTERN))
			return null;
		return parseDate(datetime, DEF_DATETIME_FORMAT);
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的字符串转换为时间戳期对象
	 * 
	 * @param datetime
	 *            yyyy-MM-dd HH:mm:ss格式字符串
	 * @return 转换后的时间戳对象，无法转换时返回null
	 */
	public static Timestamp getDateTimeStamp(String datetime) {
		if (!matchesPattern(datetime, DEF_DATETIME_PATTERN))
			return null;
		return new Timestamp(parseDate(datetime, DEF_DATETIME_FORMAT).getTime());
	}

	/**
	 * 将指定格式的字符串对象转换为日期对象
	 * 
	 * @param date
	 *            字符串
	 * @param pattern
	 *            指定的格式
	 * @return 转换后的日期，无法转换时返回null
	 */
	public static Date getDate(String date, String pattern) {
		return getDate(date, pattern, null);
	}

	/**
	 * 将指定格式的字符串对象转换为日期对象
	 * 
	 * @param date
	 *            字符串
	 * @param pattern
	 *            指定的格式
	 * @param defVal
	 *            默认返回值
	 * @return 转换后的日期，无法转换时返回defVal指定值
	 */
	public static Date getDate(String date, String pattern, Date defVal) {
		if (date == null || pattern == null)
			return null;
		if (date.endsWith("-00") || date.endsWith("-0"))
			return null;
		Date ret = parseDate(date, pattern);
		return (ret == null) ? defVal : ret;
	}

	/**
	 * 根据指定的格式格式将传入字符串转化为日期对象
	 * 
	 * @param date
	 *            传入字符串
	 * @param format
	 *            指定格式
	 * @return 格式化后日期对象
	 */
	private static Date parseDate(String date, String format) {
		Date d;
		try {
			d = new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			d = null;
		}
		return d;
	}

	/**
	 * 检测输入字符串是否与指定格式匹配
	 * 
	 * @param input
	 *            待检测字符串
	 * @param pattern
	 *            检测格式
	 * @return
	 * 		<li>true：匹配</li>
	 *         <li>false：不匹配</li>
	 */
	public static boolean matchesPattern(String input, String pattern) {
		return (input != null) && (input.matches(pattern));
	}

	/**
	 * 将日期对象格式化成yyyy-mm-dd类型的字符串
	 * 
	 * @param date
	 *            日期对象
	 * @return 格式化后的字符串，无法格式化时，返回null
	 */
	public static String formatDate(Date date) {
		return formatDateToString(date, DEF_DATE_FORMAT);
	}

	public static String dateAdd(Date d, int addDays) {

		// *gc.add(1,-1)表示年份减一.
		// *gc.add(2,-1)表示月份减一.
		// *gc.add(3.-1)表示周减一.
		// *gc.add(5,-1)表示天减一.
		GregorianCalendar gc = new GregorianCalendar();

		gc.setTime(d);
		gc.add(5, addDays);
		gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));

		return formatDateTime(gc.getTime());
	}

	/**
	 * 将日期对象格式化成HH:mm:ss类型的字符串
	 * 
	 * @param date
	 *            日期对象
	 * @return 格式化后的字符串，无法格式化时，返回null
	 */
	public static String formatTime(Date date) {
		return formatDateToString(date, DEF_TIME_FORMAT);
	}

	/**
	 * 将日期对象格式化成yyyy-MM-dd HH:mm:ss类型的字符串
	 * 
	 * @param date
	 *            日期对象
	 * @return 格式化后的字符串，无法格式化时，返回null
	 */
	public static String formatDateTime(Date date) {
		return formatDateToString(date, DEF_DATETIME_FORMAT);
	}

	/**
	 * 将日期对象格式化成yyyy-MM-dd HH:mm类型的字符串
	 * 
	 * @param date
	 *            日期对象
	 * @return 格式化后的字符串，无法格式化时，返回null
	 */
	public static String formateMinuteDate(Date date) {
		return formatDateToString(date, MINUTE_FORMAT);
	}

	/**
	 * 将日期对象格式化成指定的格式字符串
	 * 
	 * @param date
	 *            日期对象
	 * @param format
	 *            格式
	 * @return 格式化后的字符串，无法格式化时，返回null
	 */
	private static String formatDateToString(Date date, String format) {
		if (date == null)
			return null;
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 将日期对象格式化成指定格式的字符串
	 * 
	 * @param date
	 *            日期对象
	 * @param format
	 *            格式
	 * @return 格式化后的字符串，无法格式化时，返回null
	 */
	public static String formatDate(Date date, String format) {
		if (date == null || format == null)
			return null;
		String ret;
		try {
			ret = new SimpleDateFormat(format).format(date);
		} catch (RuntimeException e) {
			ret = null;
		}
		return ret;
	}

	/**
	 * 取得指定日期所在月的最后一天日期对象
	 * 
	 * @param d
	 *            指定日期
	 * @return 指定日期当月的最后一天日期对象，如指定日期为null时，返回当前月的最后一天日期对象
	 */
	public static Date getLastDayObjectInMonth(Date d) {
		Calendar cal = Calendar.getInstance();
		if (d != null)
			cal.setTime(d);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 取得指定日期所在月的最后一天日期值
	 * 
	 * @param d
	 *            指定日期
	 * @return 当月的最后一天日期值，如指定日期为null时，返回当前月的最后一天日期值
	 * @see #getLastDayObjectInMonth(Date)
	 */
	public static int getLastDayInMonth(Date d) {
		Date date = getLastDayObjectInMonth(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public static java.util.Date getCurrentDate() {
		java.util.Date date = new java.util.Date(System.currentTimeMillis());
		return date;
	}

	public static Timestamp getCurrentTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}

	public static String dateToStr(Date source) {
		return dateToStr(source, "yyyy-MM-dd HH:mm:ss");
	}

	public static String dateToStr(Date source, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (source == null) {
			return "";
		} else {
			return sdf.format(source);
		}
	}

	public static Calendar getCurrentCalendar() {
		Calendar calendar = Calendar.getInstance();
		return calendar;
	}

	public static Calendar getCurrentWeekBegin() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int warpnum = 2 - dayOfWeek;
		if (dayOfWeek == 1)
			warpnum = -6;
		calendar.add(Calendar.DATE, warpnum);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);
		calendar.set(year, month, day, 0, 0, 0);
		return calendar;
	}

	public static Calendar getNextWeekBegin() {
		Calendar calendar = getCurrentWeekBegin();
		calendar.add(Calendar.DATE, 7);
		return calendar;
	}

	public static Calendar getPreWeekBegin() {
		Calendar calendar = getCurrentWeekBegin();
		calendar.add(Calendar.DATE, -7);
		return calendar;
	}

	public static Calendar getCurrentMonthBegin() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(year, month, 1, 0, 0, 0);
		return calendar;
	}

	public static Calendar getNextMonthBegin() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(year, month + 1, 1, 0, 0, 0);
		return calendar;
	}

	public static Calendar getPreMonthBegin() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		calendar.set(year, month - 1, 1, 0, 0, 0);
		return calendar;
	}

	public static Calendar date2calendar(Date source) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		return calendar;
	}

	public static String formatFeedDate(Timestamp timestamp) {
		if (timestamp == null)
			return "";
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		String timestampStr = formatter.format(timestamp);
		String todayStr = formatter.format(today);
		if (todayStr.substring(0, 11).equals(timestampStr.substring(0, 11))) {
			return "今天" + timestampStr.substring(11, timestampStr.length());
		}
		return timestampStr;
	}

	public static void main(String args[]) {
		try {
			DateUtil.getCurrentWeekBegin();
			DateUtil.getNextWeekBegin();
			DateUtil.getCurrentMonthBegin();
			DateUtil.getNextMonthBegin();
			System.out.println(DateUtil.formatDate(DateUtil.getCurrentDate(), "HHmmss1992MMddyyHH"));
			System.out.println(DateUtil.formatDate(DateUtil.getCurrentDate(), "dd"));
			System.out.println(DateUtil.matchesPattern("2012-05-03 03:84:55", DEF_DATETIME_PATTERN));
			System.out.println(getDateTime(formatDateTime(DateUtil.getCurrentTime())).getTime());
		} catch (Exception e) {
		}
	}

	// 将以秒为单位的整数转换为×小时×分×秒 [TY insert 2007-03-22]
	public static String transferSec2Hms(int second) {
		int hour = second / 3600;
		int minute = (second % 3600) / 60;
		int sec = (second % 3600) % 60;

		StringBuffer buf = new StringBuffer();
		buf.append(hour).append("小时").append(minute).append("分").append(sec).append("秒");

		return buf.toString();
	}

	public static long getDateDiffNum(Date date1, Date date2) {
		long diff = date1.getTime() - date2.getTime();
		long days = diff / (24 * 60 * 60 * 1000);
		return days;
	}

}
