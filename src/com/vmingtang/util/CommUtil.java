package com.vmingtang.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.vmingtang.data.InfoFile_;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * 通用工具类
 * @date 2013-4-23
 * @author Goven
 * @email gxl3999@gmail.com
 */
public class CommUtil {
	private static final boolean DEBUG = true;

	/**
	 * 更改权限
	 * @param permission 权限
	 * @param path 文件路径
	 * @author Goven
	 * @date 2013-4-23
	 */
	public static void chmod(String permission, String path) {
		try {
			String command = "chmod " + permission + " " + path;
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(command);
		} catch (IOException e) {
			logE("CommUtil (chmod) --> ", e.toString());
		}
	}
	/**
	 * 打印默认verbose级别的日志
	 * @param tag 标签
	 * @param info 信息
	 * @author Goven
	 * @date 2013-4-23
	 */
	public static void logV(String tag,String info){
		if (DEBUG)
			Log.v(tag, info);
	}
	
	/**
	 * 打印默认info级别的日志
	 * @param tag 标签
	 * @param info 信息
	 * @author Goven
	 * @date 2013-4-23
	 */
	public static void logI(String tag, String info) {
		if (DEBUG)
			Log.i(tag, info);
	}

	/**
	 * 打印debug级别的日志
	 * @param tag 标签
	 * @param info 信息
	 * @author Goven
	 * @date 2013-4-23
	 */
	public static void logD(String tag, String info) {
		if (DEBUG)
			Log.d(tag, info);
	}
	
	/**
	 * 打印warnning级别的日志
	 * @param tag 标签
	 * @param info 信息
	 * @author Goven
	 * @date 2013-4-23
	 */
	public static void logW(String tag, String info) {
		if (DEBUG)
			Log.w(tag, info);
	}
	
	/**
	 * 打印error级别的日志
	 * @param tag 标签
	 * @param info 信息
	 * @author Goven
	 * @date 2013-4-23
	 */
	public static void logE(String tag, String info) {
		if (DEBUG)
			Log.e(tag, info);
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	// /**
	// * 字符串转json对象
	// */
	// public static JSONObject string2JSON(String str, String split) {
	// JSONObject json = new JSONObject();
	// try {
	// String[] arrStr = str.split(split);
	// for (int i = 0; i < arrStr.length; i++) {
	// String[] arrKeyValue = arrStr[i].split("=");
	// json.put(arrKeyValue[0], arrStr[i].substring(arrKeyValue[0].length() +
	// 1));
	// }
	// } catch (Exception e) {
	// logE("CommUtil(string2JSON)", e.toString());
	// }
	// return json;
	// }
	// /**
	// * 创建并显示进度对话框
	// * @param context 上下文
	// * @param title 标题
	// * @param message 信息
	// * @param indeterminate 是否确定
	// * @param cancelable 是否可撤销
	// * @return 进度对话框
	// * @author Goven
	// * @date 2013-4-22
	// */
	// public static ProgressDialog createProgress(Context context, CharSequence
	// title, CharSequence message, boolean indeterminate, boolean cancelable) {
	// ProgressDialog dialog = new ProgressDialog(context);
	// if (title != null) {
	// dialog.setTitle(title);
	// }
	// dialog.setMessage(message);
	// dialog.setIndeterminate(indeterminate);
	// dialog.setCancelable(cancelable);
	// dialog.show();
	// return dialog;
	// }

	public static boolean isNetworkOk(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeInfo = connectivityManager.getActiveNetworkInfo();
		if (activeInfo == null) {
			return false;
		} else {
			return activeInfo.isConnected();
		}
	}

	/**
	 * 保存用户信息
	 * @param context
	 * @param token
	 * @author yubin
	 * @date 2014-9-13
	 */
	public static void saveTokenInfo(Context context, String token) {
		InfoFile_ infoFile = new InfoFile_(context);
		if (StringUtil.isNotTrimBlank(token)) {
			String[] tokenArray = token.split("&");
			for (int i = 0, len = tokenArray.length; i < len; i++) {
				String[] temp = tokenArray[i].split("=");
				if (temp.length == 2) {
					if (temp[0].trim().equals("customerId")) {
						// 保存id
//						infoFile.edit().userId().put(temp[1].trim()).apply();
//					} else if (temp[0].equals("cloopenId")) {
//						infoFile.edit().ccpCloopenId().put(temp[1].trim()).apply();
//					} else if (temp[0].equals("cloopenToken")) {
//						infoFile.edit().ccpCloopenToken().put(temp[1].trim()).apply();
//					} else if (temp[0].equals("voIPNo")) {
//						infoFile.edit().ccpVoIPNo().put(temp[1].trim()).apply();
//					} else if (temp[0].equals("voIPPassword")) {
//						infoFile.edit().ccpVoIPPassword().put(temp[1].trim()).apply();
//					} else if (temp[0].equals("customerName")) {
//						infoFile.edit().userName().put(temp[1].trim()).apply();
//					} else if (temp[0].equals("")) {
////						infoFile.edit().userName().put(temp[1].trim()).apply();
					}
				}
			}
		}
	}

	/**
	 * 清空用户数据
	 * @param context
	 * @author yubin
	 * @date 2014-6-5
	 */
	public static void clearUserInfo(Context context) {
		InfoFile_ infoFile = new InfoFile_(context);
//		infoFile.edit()//
//				.userAutoLogin().remove()//
////				.userPhone().remove()//
//				.userPassword().remove()//
//				.userToken().remove()//
//				.userId().remove()//
//				.userName().remove()//
//				.userAvatar().remove()//
//				.ccpIsInit().remove()//
//				.ccpIsInitDevice().remove()//
//				.ccpCloopenId().remove()//
//				.ccpCloopenToken().remove()//
//				.ccpVoIPNo().remove()//
//				.ccpVoIPPassword().remove()//
//				.apply();
	}

	// 重置listview高度
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}
	
	 /**
	   * 获取版本号
	   * @return 当前应用的版本号
	   */
	  public static String getVersion(Context context) {
	      try {
	          PackageManager manager = context.getPackageManager();
	          PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
	          String version = info.versionName;
	         return version;
	     } catch (Exception e) {
	         e.printStackTrace();
	         return "";
	     }
	 }
	  
	  public static int getAndroidOSVersion()  
	    {  
	         int osVersion;  
	         try  
	         {  
	            osVersion = Integer.valueOf(android.os.Build.VERSION.SDK);  
	         }  
	         catch (NumberFormatException e)  
	         {  
	            osVersion = 0;  
	         }  
	           
	         return osVersion;  
	   }  
		/**
		 * 根据Uri获取图片绝对路径，解决Android4.4以上版本Uri转换
		 * @param activity
		 *  @param imageUri 
		 * @author yaoxing
		 * @date 2014-10-12
		 */
	  public static String getImageAbsolutePath(Activity activity, Uri imageUri){
		  Uri uri = null;
		  if(activity == null || imageUri == null ) return null;
		    if(CommUtil.getAndroidOSVersion() >= 19){
		    	try {
					Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), imageUri);
				    uri = Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(), bitmap, null,null));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		    if(uri == null) uri = imageUri;
		    else imageUri = uri;
		    Cursor cursor = null;
			int column_index = -1;
			try {
				String[] proj = { MediaStore.Images.Media.DATA };
				cursor = activity.managedQuery(uri, proj, null, null, null);
				column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				cursor.moveToFirst();
			} catch (Exception e) {
				return null;
			}
			if (column_index == -1) {
				return null;
			}
			return cursor.getString(column_index);
	  }

	public static boolean isBackground(Context context) {
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
		for (RunningAppProcessInfo appProcess : appProcesses) {
			if (appProcess.processName.equals(context.getPackageName())) {
				if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
					Log.i("后台", appProcess.processName);
					return true;
				} else {
					Log.i("前台", appProcess.processName);
					return false;
				}
			}
		}
		return false;
	}
}
