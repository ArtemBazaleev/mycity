package com.mycity.presintation.base

import android.content.res.Resources
import android.util.TypedValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

val Int.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

val Float.dp: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

fun LifecycleOwner.doDelayed(delayMillis: Long, executeUi: () -> Unit) {
    this.lifecycleScope.launch(Dispatchers.Main) {
        delay(delayMillis)
        try {
            executeUi.invoke()
        } catch (e: Exception) { }
    }
}

//    inline fun <reified T> Gson.fromJson(json: String) =
//        this.fromJson<T>(json, object : TypeToken<T>() {}.type)
//
//    inline fun <reified T> Gson.fromJson(map: Map<String, Any?>) =
//        this.fromJson<T>(this.toJson(map), object : TypeToken<T>() {}.type)
