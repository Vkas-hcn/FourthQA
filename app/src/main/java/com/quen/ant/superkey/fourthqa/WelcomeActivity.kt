package com.quen.ant.superkey.fourthqa

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.quen.ant.superkey.fourthqa.base.BaseActivity
import com.quen.ant.superkey.fourthqa.databinding.ActivityMainBinding
import com.quen.ant.superkey.fourthqa.databinding.ActivityWelcomeBinding

class WelcomeActivity : BaseActivity<MainViewModel, ActivityWelcomeBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_welcome
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initViews() {
        startCountdown()
    }
    private fun startCountdown() {
        val animator = ValueAnimator.ofInt(0, 100)
        animator.duration = 2000 // 2秒钟
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            binding.progressBar.progress = progress
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                finish()
            }
        })
        animator.start()
    }
}
