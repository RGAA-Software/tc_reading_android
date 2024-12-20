package com.tc.reading.util

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import android.view.WindowManager


class ScreenUtil {

    companion object {
        fun isPad(context: Context): Boolean {
            val isPad: Boolean = (context.resources.configuration.screenLayout
                    and Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val dm = DisplayMetrics()
            display.getMetrics(dm)
            val x = Math.pow((dm.widthPixels / dm.xdpi).toDouble(), 2.0)
            val y = Math.pow((dm.heightPixels / dm.ydpi).toDouble(), 2.0)
            val screenInches = Math.sqrt(x + y) // 屏幕尺寸
            return isPad || screenInches >= 7.0
        }

        fun makeActivityFullScreen(activity: Activity) {
            activity.requestWindowFeature(Window.FEATURE_NO_TITLE);

            activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

            activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
//            activity.window.statusBarColor = activity.resources.getColor(com.rajat.pdfviewer.R.color.colorPrimary);
        }

    }

}