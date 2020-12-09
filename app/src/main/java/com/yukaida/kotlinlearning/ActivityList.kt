package com.yukaida.kotlinlearning

import android.app.Activity
import android.util.Log

/**
 * @author yukaida
 * @DATE 2020/12/8.
 */
object ActivityList {
    val TAG="ActivityList"
    private val activityList=ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activityList.add(activity)
        Log.d(TAG, "addActivity: ${activity.localClassName}")
    }

    fun removeActivity(activity: Activity){
        activityList.remove(activity)
        Log.d(TAG, "removeActivity: ${activity.localClassName}")
    }

    fun finishAllActivity(){
        for (activity in activityList) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activityList.clear()
    }

}