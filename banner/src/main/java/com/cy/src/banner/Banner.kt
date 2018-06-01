package com.cy.src.banner

import android.content.Context
import android.support.design.widget.TabLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.layout_banner.view.*

/**
 * @author CY 2018/5/29
 */
class Banner : FrameLayout {

    private var mOnItemClickListener: OnItemClickListener? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }


    init {

    }

    private fun init() {

        val view = LayoutInflater.from(context).inflate(R.layout.layout_banner, this, true)

        val autoViewPager = view.findViewById<AutoViewPager>(R.id.autoViewPager)
        autoViewPager.adapter = adapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(autoViewPager, true)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    fun addItem(item: BannerModel) {

        adapter.addData(item)
        refurbishTab()
    }

    fun setItems(items: Collection<BannerModel>) {
        adapter.datas.clear()
        adapter.datas.addAll(items)
        refurbishTab()
    }

    private fun refurbishTab() {
        adapter.notifyDataSetChanged()
        for (i in 0 until tabLayout.tabCount) {
            tabLayout.getTabAt(i)!!.setCustomView(R.layout.layout_dot)
        }
    }

    val adapter = object : BannerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val v = LayoutInflater.from(context).inflate(R.layout.layout_pager, container, false)
            v.findViewById<SimpleDraweeView>(R.id.simpleDraweeView).setImageURI(datas[position].imageUrl)
            container.addView(v)
            v.setOnClickListener {
                mOnItemClickListener?.onItemClick(it, position, datas[position])
            }
            return v
        }

        override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
            container.removeView(any as View)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int, model: BannerModel)
    }
}