package com.quen.ant.superkey.fourthqa

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.quen.ant.superkey.fourthqa.base.App
import com.quen.ant.superkey.fourthqa.base.BaseActivity
import com.quen.ant.superkey.fourthqa.data.UserPreferencesRepository
import com.quen.ant.superkey.fourthqa.databinding.ActivityMainBinding
import com.quen.ant.superkey.fourthqa.databinding.ActivitySettingBinding
import com.quen.ant.superkey.fourthqa.databinding.ActivityWelcomeBinding
import com.quen.ant.superkey.fourthqa.net.NetActivity

class SettingActivity : BaseActivity<MainViewModel, ActivitySettingBinding>() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_setting
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initViews() {
        val trueNum = intent.getIntExtra("trueNum", 0)
        val fractionNum = intent.getIntExtra("fractionNum", 0)
        binding.imgNotification.text = fractionNum.toString()
        binding.progressBarSetting.progress = ((trueNum.toDouble() / 6) * 100).toInt()
        binding.imgExit.setOnClickListener {
            finish()
        }

    }

}
