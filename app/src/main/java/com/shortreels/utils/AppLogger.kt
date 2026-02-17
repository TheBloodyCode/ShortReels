package com.shortreels.utils

import android.util.Log

object AppLogger {
    private var isDebug = false
    private const val TAG = "ShortReels"

    fun init(debug: Boolean) { isDebug = debug }

    fun d(tag: String = TAG, msg: String) { if (isDebug) Log.d(tag, msg) }
    fun e(tag: String = TAG, msg: String, t: Throwable? = null) { if (isDebug) Log.e(tag, msg, t) }
    fun i(tag: String = TAG, msg: String) { if (isDebug) Log.i(tag, msg) }
    fun w(tag: String = TAG, msg: String) { if (isDebug) Log.w(tag, msg) }
}
