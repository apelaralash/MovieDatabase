package com.example.myapplication.listeners

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity

class ActivityLifecycleListener : Application.ActivityLifecycleCallbacks {

    fun init(application: Application){
        application.registerActivityLifecycleCallbacks(ActivityLifecycleListener())
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if(activity is FragmentActivity){
            FragmentLifecycleListener().init(activity.supportFragmentManager)
        }
        Log.d(activity.javaClass.simpleName,"is OnCreate")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(activity.javaClass.simpleName,"is OnStart")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(activity.javaClass.simpleName,"is OnResume")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(activity.javaClass.simpleName,"is OnPause")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(activity.javaClass.simpleName,"is OnStop")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(activity.javaClass.simpleName,"is OnDestroy")
    }
}