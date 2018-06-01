package com.cy.src.banner

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet

/**
 * @author CY 2018/5/29
 */
class AutoViewPager : ViewPager {

//    var autoScrollEnabled: Boolean = false
//        set(value) {
//            println("value=$value  autoScrollEnabled=$autoScrollEnabled")
//            if (value == autoScrollEnabled) {
//
//                field=value//field 幕后字段
//            }
//        }

    private var mAutoScrollEnabled: Boolean = false

    var delayMillis: Long = 2000//默认间隔时间2秒

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    fun setAutoScrollEnabled(enabled: Boolean) {

        if (mAutoScrollEnabled != enabled) {
            mAutoScrollEnabled = enabled
            if (enabled) {
                startAutoScroll()
            } else {
                stopAutoScroll()
            }
        }

    }

    /**
     * 关联Window 在Activity#onPostResume()时调用
     */
    override fun onAttachedToWindow() {
        setAutoScrollEnabled(true)
        super.onAttachedToWindow()
    }

    /**
     * 解除关联Window 在Activity#onDestory()时调用
     */
    override fun onDetachedFromWindow() {
        setAutoScrollEnabled(false)
        super.onDetachedFromWindow()
    }

    private fun startAutoScroll() {
        postDelayed(play, delayMillis)

    }

    private fun stopAutoScroll() {
        removeCallbacks(play)
    }

    private val play: Runnable = object : Runnable {
        override fun run() {
            if (adapter == null || adapter!!.count <= 1) return

            val index = if (currentItem < adapter!!.count - 1) currentItem + 1 else 0

            setCurrentItem(index, index != 0)

            postDelayed(this, delayMillis)
        }

    }


}