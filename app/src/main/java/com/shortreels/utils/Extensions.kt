package com.shortreels.utils

import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.shortreels.R
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.abs

// ===== Number formatters =====
fun Long.toFormattedCount(): String {
    return when {
        this >= 1_000_000_000 -> String.format("%.1fB", this / 1_000_000_000.0)
        this >= 1_000_000 -> String.format("%.1fM", this / 1_000_000.0)
        this >= 1_000 -> String.format("%.1fK", this / 1_000.0)
        else -> this.toString()
    }
}

fun Int.toFormattedCount(): String = this.toLong().toFormattedCount()

fun Long.toTimeString(): String {
    val minutes = this / 60
    val seconds = this % 60
    return String.format("%d:%02d", minutes, seconds)
}

fun Long.toTimeDiff(): String {
    val now = System.currentTimeMillis() / 1000
    val diff = abs(now - this)
    return when {
        diff < 60 -> "hace un momento"
        diff < 3600 -> "${diff / 60}m"
        diff < 86400 -> "${diff / 3600}h"
        diff < 2592000 -> "${diff / 86400}d"
        diff < 31536000 -> "${diff / 2592000}sem"
        else -> "${diff / 31536000}a"
    }
}

// ===== View extensions =====
fun View.visible() { isVisible = true }
fun View.gone() { isVisible = false }
fun View.invisible() { visibility = View.INVISIBLE }

fun View.animateIn() {
    isVisible = true
    alpha = 0f
    animate().alpha(1f).setDuration(200).start()
}

fun View.animateOut(onEnd: (() -> Unit)? = null) {
    animate().alpha(0f).setDuration(200).withEndAction {
        isVisible = false
        onEnd?.invoke()
    }.start()
}

fun View.setMargins(left: Int = 0, top: Int = 0, right: Int = 0, bottom: Int = 0) {
    (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
        setMargins(left, top, right, bottom)
    }
    requestLayout()
}

// ===== ImageView extensions =====
fun ImageView.loadUrl(url: String?, placeholder: Int = R.drawable.placeholder_thumbnail) {
    Glide.with(this)
        .load(url)
        .placeholder(placeholder)
        .error(placeholder)
        .transition(DrawableTransitionOptions.withCrossFade(200))
        .into(this)
}

fun ImageView.loadCircle(url: String?, placeholder: Int = R.drawable.placeholder_avatar) {
    Glide.with(this)
        .load(url)
        .circleCrop()
        .placeholder(placeholder)
        .error(placeholder)
        .transition(DrawableTransitionOptions.withCrossFade(200))
        .into(this)
}

// ===== Context extensions =====
fun Context.toast(msg: String, long: Boolean = false) {
    Toast.makeText(this, msg, if (long) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}

val Int.dp: Int get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
val Float.dp: Float get() = this * Resources.getSystem().displayMetrics.density

// ===== Fragment extensions =====
fun Fragment.toast(msg: String) = requireContext().toast(msg)
