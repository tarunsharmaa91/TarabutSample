package com.app.tarabutsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.blog.ui.list.view.GamesListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}