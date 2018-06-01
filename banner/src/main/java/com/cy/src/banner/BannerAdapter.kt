package com.cy.src.banner

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * @author CY 2018/5/29
 */
abstract class BannerAdapter : PagerAdapter() {

    val datas: ArrayList<BannerModel> = arrayListOf()

    fun addData(model: BannerModel) {
        datas.add(model)
        notifyDataSetChanged()
    }


    override fun getCount(): Int = datas.size

    override fun isViewFromObject(view: View, any: Any): Boolean = view == any

    abstract override fun instantiateItem(container: ViewGroup, position: Int): Any

    abstract override fun destroyItem(container: ViewGroup, position: Int, any: Any)

}