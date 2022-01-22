package com.zuyatna.listmaker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zuyatna.listmaker.R

class ListDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListDetailFragment.newInstance())
                .commitNow()
        }
    }
}