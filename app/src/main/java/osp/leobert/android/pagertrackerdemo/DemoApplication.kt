package osp.leobert.android.pagertrackerdemo

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.Pair
import com.google.gson.Gson
import osp.leobert.android.tracker.BuryPointContext
import osp.leobert.android.tracker.pager.PagerChainTracker

/**
 * <p><b>Package:</b> osp.leobert.android.pagertrackerdemo </p>
 * <p><b>Project:</b> PagerTrackerDemo </p>
 * <p><b>Classname:</b> DemoApplication </p>
 * Created by leobert on 2020/6/30.
 */
class DemoApplication : Application() {
    companion object {
        val gson: Gson = Gson()
    }

    override fun onCreate() {
        super.onCreate()
        PagerChainTracker.debug = true
        BuryPointContext.buryPointUploader =
            BuryPointContext.BuryPointUploader { pointKey, params ->
                pointKey?.let {
                    Log.d("tracker_msg", "onPointUpload:$it , params: ${gson.toJson(params)}")
                }
            }
    }
}

fun Intent.launchActivity(context: Context) {
    context.startActivity(this)
}