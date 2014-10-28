package com.vmingtang.activity;


import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EApplication;

import android.app.Activity;
import android.app.Application;
@EApplication
public class ActivityApp extends Application{
	private List<Activity> activitys = new ArrayList<Activity>();

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public void addActivity(Activity activity) {
		if (!activitys.contains(activity)) {
			activitys.add(activity);
		}
	}
	public void removeActivity(Activity activity) {
		if (activitys.contains(activity)) {
			activitys.remove(activity);
		}
	}
	public void finishAllExcept(Activity activity) {
		for (Activity $activity : activitys) {
			if ($activity != activity) {
				$activity.finish();
			}
		}
	}

	public boolean finishAllExcept(Class<? extends Activity> clazz) {
		boolean hasClazz = false;
		for (Activity $activity : activitys) {
			if ($activity.getClass() != clazz) {
				$activity.finish();
			} else {
				hasClazz = true;
			}
		}
		return hasClazz;
	}
	public void finishAll() {
		for (Activity activity : activitys) {
			activity.finish();
		}
	}

	public boolean hasActivity() {
		return activitys.size() > 0;
	}

}
