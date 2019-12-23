package com.treefintech.jetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.treefintech.jetpack.bean.LoadState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var userProfileFragment: UserProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userProfileFragment = UserProfileFragment.newInstance("123")

//        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.imageData.observe(this, Observer {
            Glide.with(this).load(it[0]).into(imageView1)
            Glide.with(this).load(it[1]).into(imageView2)
            Glide.with(this).load(it[2]).into(imageView3)
        })

        mainViewModel.loadState.observe(this, Observer {
            when (it) {
                is LoadState.Fail -> {
                    btnLoadImage.isEnabled = true
                    Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                }
                is LoadState.Success -> {
                    btnLoadImage.isEnabled = true
                }
                is LoadState.Loading -> {
                    btnLoadImage.isEnabled = false
                }
            }
        })

        btnLoadImage.setOnClickListener {
            mainViewModel.getData()
        }

        supportFragmentManager.beginTransaction().add(R.id.frameContainer,userProfileFragment).commit()
    }
}
