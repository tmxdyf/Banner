package com.cy.src.banner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cy.src.banner.R.id.banner
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author CY 2018/5/29
 */
class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        val model = BannerModel()
//        model.imageUrl = "https://www.baidu.com/img/baidu_jgylogo3.gif"
//
//        banner.addItem(model)
//        banner.addItem(model)
//        banner.addItem(model)
//        banner.addItem(model)
//
////        banner.setOnClickListener {it.visibility  }
//        banner.setOnItemClickListener(object : Banner.OnItemClickListener {
//            override fun onItemClick(view: View, position: Int, model: BannerModel) {
//                Toast.makeText(view.context, "position:$position", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

}
