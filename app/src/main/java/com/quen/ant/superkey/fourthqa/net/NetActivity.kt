package com.quen.ant.superkey.fourthqa.net

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.webkit.WebView
import android.widget.FrameLayout
import com.quen.ant.superkey.fourthqa.R
import com.quen.ant.superkey.fourthqa.base.BaseActivity
import com.quen.ant.superkey.fourthqa.databinding.ActivityMainBinding
import com.quen.ant.superkey.fourthqa.databinding.ActivityNetBinding
import com.quen.ant.superkey.fourthqa.databinding.ActivityWelcomeBinding

class NetActivity : BaseActivity<NetViewModel, ActivityNetBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_net
    }

    override fun getViewModelClass(): Class<NetViewModel> {
        return NetViewModel::class.java
    }

    override fun initViews() {
        addWebView()
    }
    private fun addWebView() {
        val webView = WebView(this)
        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        webView.layoutParams = layoutParams
        binding.frameLayoutWeb.addView(webView)
        webView.loadUrl("https://www.baidu.com")
    }
}
