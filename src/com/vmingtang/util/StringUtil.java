package com.vmingtang.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

public class StringUtil {
	public static final String EMPTY = "";

	public static boolean isEqual(String one, String another) {
		return isNotTrimBlank(one) && isNotTrimBlank(another) && one.equals(another);
	}
	
	public static boolean isNotBlank(String str) {
		return (str != null) && (str.length() != 0);
	}

	public static boolean isBlank(String str) {
		return (str == null) || (str.length() == 0);
	}

	public static boolean isNotTrimBlank(String str) {
		return (str != null) && (str.trim().length() != 0);
	}
	
	public static boolean isNotTrimBlanks(String... strs) {
		boolean result = true;
		for (String str : strs) {
			result = result && (str != null) && (str.trim().length() != 0);
		}
		return result;
	}

	public static boolean isTrimBlank(String str) {
		return (str == null) || (str.trim().length() == 0);
	}

	public static String capFirstUpperCase(String str) {
		if (isBlank(str)) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String capFirstLowerCase(String str) {
		if (isBlank(str)) {
			return str;
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static boolean isIdNo(String idNo) {
		if (isTrimBlank(idNo)) {
			return false;
		}
		Pattern p = Pattern.compile("^([1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3})|([1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[X,x]))$");
		Matcher matcher = p.matcher(idNo);
		return matcher.find();
	}

	public static boolean isMobile(String mobile) {
		if (isTrimBlank(mobile)) {
			return false;
		}
		Pattern p = Pattern.compile("^(?:13\\d|15\\d|18\\d)-?\\d{8}$");
		Matcher matcher = p.matcher(mobile);
		return matcher.find();
	}

	public static String num2String(Long no) {
		if (no.longValue() < 10L)
			return String.valueOf(no);
		if (no.longValue() < 36L)
			return String.valueOf((char) (int) (no.longValue() - 10L + 65L));
		if (no.longValue() < 62L) {
			return String.valueOf((char) (int) (no.longValue() - 36L + 97L));
		}
		return num2String(Long.valueOf(no.longValue() / 62L)) + num2String(Long.valueOf(no.longValue() % 62L));
	}
	/**
	 * 返回￥0.00格式的金额
	 * @param money
	 * @return
	 * @author yubin
	 * @date 2014-2-24
	 */
	public static String moneyFormat(Object money) {
		return String.format("￥%,.2f", money);
	}

	/**
	 * 验证日期字符串是否是YYYY-MM-DD格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDataFormat(String str) {
		boolean flag = false;
		// String
		// regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";
		String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern pattern1 = Pattern.compile(regxStr);
		Matcher isNo = pattern1.matcher(str);
		if (isNo.matches()) {
			flag = true;
		}
		return flag;
	}
	public static String replaceSpace(String info){
		String str=null;
		if (info!=null) {
			 Pattern p = Pattern.compile("\\s*|\t|\r|\n");  
             Matcher m = p.matcher(info); 
             str=m.replaceAll("");
		}
		return str;
	}
	/**
	 * 功能：判断字符串是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	// 以下生成一个随机的字符串
	private static long id = 0;
	private static String prefix = randomString(5) + "-";
	public static String getPacketID() {
		return prefix + Long.toString(id++);
	}
	public static String randomString(int length) {
		char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		if (length < 1) {
			return null;
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[new Random().nextInt(71)];
		}
		return new String(randBuffer);
	}
	
    /** 
     * 判断是否是json结构 
     */  
    public static boolean isJson(String value) {  
    	if(value == null) return false;
        try {  
            new JSONObject(value);  
        } catch (JSONException e) {  
            return false;  
        }  
        return true;  
    }  
}