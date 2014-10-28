package com.vmingtang.data;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.androidannotations.annotations.RootContext;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

@EBean(scope = Scope.Singleton)
public class DataHelper {
	@RootContext
	protected Context context;
	private Handler callbackHandler;
	private Object tag;



	
	
	/**
	 * UI主线程，处理响应结果
	 * @param flag 数据请求标识
	 * @param result 返回的结果
	 */
	void callback(int flag, Object tag, Object result) {
		if (callbackHandler != null && this.tag == tag) {
			Message msg = Message.obtain();
			msg.what = flag;
			msg.obj = result;
			callbackHandler.sendMessage(msg);
		}
	}
	public void setCallbackHandler(Handler callbackHandler, Object tag) {
		this.callbackHandler = callbackHandler;
		this.tag = tag;
	}
}
