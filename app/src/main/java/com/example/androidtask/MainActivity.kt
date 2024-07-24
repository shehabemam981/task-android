package com.example.androidtask

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidtask.databinding.ActivityMainBinding
import com.example.androidtask.products.ProductFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
     var _mainBinding: ActivityMainBinding? = null
    val mainbinding:ActivityMainBinding get() = _mainBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainbinding.root)
     initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHome,ProductFragment())
    }

    override fun onDestroy() {
        _mainBinding = null
        super.onDestroy()
    }
}