package com.quen.ant.superkey.fourthqa

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.quen.ant.superkey.fourthqa.base.App
import com.quen.ant.superkey.fourthqa.base.BaseActivity
import com.quen.ant.superkey.fourthqa.data.DataUtils
import com.quen.ant.superkey.fourthqa.data.FootballIssuesBean
import com.quen.ant.superkey.fourthqa.data.FootballIssuesList
import com.quen.ant.superkey.fourthqa.data.UserPreferencesRepository
import com.quen.ant.superkey.fourthqa.databinding.ActivityMainBinding
import com.quen.ant.superkey.fourthqa.net.NetActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private lateinit var qaDataList: ArrayList<FootballIssuesBean>
    private lateinit var qaData: FootballIssuesBean
    val userPreferencesRepository = UserPreferencesRepository(App.instance)
    private var posNum = 0
    private var trueNum = 0
    private var falseNum = 0
    private var levelNum = 1
    private var fractionNum = 0
    private var qaState = false
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initViews() {
        initData()
        clickInitViews()
        liveDataObserve()
    }

    private fun liveDataObserve() {
        viewModel.countDownTime.observe(this) {
            binding.tvTime.text = String.format("${it}s")
            if (binding.clMainQa.isVisible) {
                if (it == 0) {
                    clickFalse(0)
                }
            }
        }
    }

    private fun initData() {
        qaData = FootballIssuesBean("", "", "", "", "", 0)
        qaDataList = DataUtils.getQaList()
        viewModel.onGetErrorNum(userPreferencesRepository) {
            falseNum = it
        }
        viewModel.onGetRightNum(userPreferencesRepository) {
            trueNum = it
        }
        viewModel.onGetFraction(userPreferencesRepository) {
            fractionNum = it
            binding.imgNotification.text = fractionNum.toString()
        }
        viewModel.onGetLevel(userPreferencesRepository) {
            levelNum = it
            binding.imgLevel.text = "Level $levelNum"
        }
        viewModel.onGetPosition(userPreferencesRepository) {
            posNum = it
        }
    }

    private fun clickInitViews() {
        binding.imgSM.setOnClickListener {
            binding.imgSM.visibility = View.GONE
            binding.clMainQa.visibility = View.VISIBLE
            binding.llTime.visibility = View.VISIBLE
            binding.imgExit.visibility = View.VISIBLE
            setQaDataList()
        }
        binding.constraintLayout1.setOnClickListener {
            clickTOAnswer(it)
        }
        binding.constraintLayout2.setOnClickListener {
            clickTOAnswer(it)
        }
        binding.constraintLayout3.setOnClickListener {
            clickTOAnswer(it)
        }
        binding.constraintLayout4.setOnClickListener {
            clickTOAnswer(it)
        }
        binding.tvTryAgain.setOnClickListener {
            binding.imgExit.visibility = View.VISIBLE
            binding.clMainWrong.visibility = View.GONE
            binding.clMainQa.visibility = View.VISIBLE
            binding.llTime.visibility = View.GONE
            setQaDataList()
        }
        binding.imgSetting.setOnClickListener {
            if (binding.clMainSetting.isVisible) {
                return@setOnClickListener
            }
            qaState = binding.clMainQa.isVisible
            binding.clMainSetting.visibility = View.VISIBLE
            binding.imgSM.visibility = View.GONE
            binding.clMainQa.visibility = View.GONE
            binding.clMainWrong.visibility = View.GONE
            binding.llTime.visibility = View.GONE
            binding.imgExit.visibility = View.VISIBLE
            if (viewModel.isCounting) {
                binding.tvStartOrStop.setImageResource(R.drawable.icon_stop)
            } else {
                binding.tvStartOrStop.setImageResource(R.drawable.icon_play)
            }
        }
        binding.imgExit.setOnClickListener {
            if (qaState) {
                binding.clMainQa.visibility = View.VISIBLE
                binding.llTime.visibility = View.VISIBLE
                binding.clMainWrong.visibility = View.GONE
                binding.clMainSetting.visibility = View.GONE
                binding.imgSM.visibility = View.GONE
                qaState = false
            } else {
                binding.imgSM.visibility = View.VISIBLE
                binding.clMainQa.visibility = View.GONE
                binding.clMainWrong.visibility = View.GONE
                binding.llTime.visibility = View.GONE
                binding.clMainSetting.visibility = View.GONE
            }
        }
        binding.atvPrivacyPolicy.setOnClickListener {
            navigateTo(NetActivity::class.java)
        }
        binding.tvStartOrStop.setOnClickListener {
            if (viewModel.isCounting) {
                binding.tvStartOrStop.setImageResource(R.drawable.icon_play)
                viewModel.countDownTime(1, this)
            } else {
                binding.tvStartOrStop.setImageResource(R.drawable.icon_stop)
                viewModel.countDownTime(2, this)
            }
        }
    }

    private fun setQaDataList() {
        refreshUI()
        if (posNum > qaDataList.size - 1) {
            posNum = 0
        }
        qaData = qaDataList[posNum]
        binding.tvTopic.text = qaData.content
        binding.tvState1.text = qaData.first
        binding.tvState2.text = qaData.second
        binding.tvState3.text = qaData.third
        binding.tvState4.text = qaData.fourth
        viewModel.countDownTime(0, this)
    }

    private fun showTrueQaUI(result: Int) {
        when (result) {
            1 -> {
                binding.imgState1.visibility = View.VISIBLE
                binding.imgState1.setImageResource(R.drawable.icon_true)
                binding.constraintLayout1.background =
                    resources.getDrawable(R.drawable.icon_true_lt)
            }

            2 -> {
                binding.imgState2.visibility = View.VISIBLE
                binding.imgState2.setImageResource(R.drawable.icon_true)
                binding.constraintLayout2.background =
                    resources.getDrawable(R.drawable.icon_true_rt)
            }

            3 -> {
                binding.imgState3.visibility = View.VISIBLE
                binding.imgState3.setImageResource(R.drawable.icon_true)
                binding.constraintLayout3.background =
                    resources.getDrawable(R.drawable.icon_true_lb)
            }

            4 -> {
                binding.imgState4.visibility = View.VISIBLE
                binding.imgState4.setImageResource(R.drawable.icon_true)
                binding.constraintLayout4.background =
                    resources.getDrawable(R.drawable.icon_true_rb)
            }
        }
    }

    private fun showFalseNumQaUI(result: Int) {
        when (result) {
            1 -> {
                binding.imgState1.visibility = View.VISIBLE
                binding.imgState1.setImageResource(R.drawable.icon_error)
                binding.constraintLayout1.background =
                    resources.getDrawable(R.drawable.icon_error_lt)
            }

            2 -> {
                binding.imgState2.visibility = View.VISIBLE
                binding.imgState2.setImageResource(R.drawable.icon_error)
                binding.constraintLayout2.background =
                    resources.getDrawable(R.drawable.icon_error_rt)
            }

            3 -> {
                binding.imgState3.visibility = View.VISIBLE
                binding.imgState3.setImageResource(R.drawable.icon_error)
                binding.constraintLayout3.background =
                    resources.getDrawable(R.drawable.icon_error_lb)
            }

            4 -> {
                binding.imgState4.visibility = View.VISIBLE
                binding.imgState4.setImageResource(R.drawable.icon_error)
                binding.constraintLayout4.background =
                    resources.getDrawable(R.drawable.icon_error_rb)
            }
        }
    }

    private fun clickTrue(result: Int) {
        posNum++
        trueNum++
        falseNum = 0
        fractionNum += levelNum * 100
        if (trueNum >= 6) {
            levelNum++
            viewModel.onSaveLevel(userPreferencesRepository, levelNum)
            trueNum = 0
        }
        saveData()
        showTrueQaUI(result)
        lifecycleScope.launch {
            delay(1000)
            setQaDataList()
        }
    }

    private fun clickFalse(result: Int) {
        falseNum++
        if (falseNum >= 5) {
            fractionNum = 0
            falseNum = 0
        }
        showFalseNumQaUI(result)
        saveData()
        lifecycleScope.launch {
            delay(1000)
            binding.clMainWrong.visibility = View.VISIBLE
            binding.clMainQa.visibility = View.GONE
            updateProgress()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun clickTOAnswer(view: View) {
        when (view.id) {
            R.id.constraintLayout_1 -> {
                if (qaData.result == 1) {
                    clickTrue(1)
                } else {
                    clickFalse(1)
                }
            }

            R.id.constraintLayout_2 -> {
                if (qaData.result == 2) {
                    clickTrue(2)
                } else {
                    clickFalse(2)
                }
            }

            R.id.constraintLayout_3 -> {
                if (qaData.result == 3) {
                    clickTrue(3)
                } else {
                    clickFalse(3)
                }
            }

            R.id.constraintLayout_4 -> {
                if (qaData.result == 4) {
                    clickTrue(4)
                } else {
                    clickFalse(4)
                }
            }
        }
    }

    private fun saveData() {
        viewModel.onSaveLevel(userPreferencesRepository, levelNum)
        viewModel.onSavePosition(userPreferencesRepository, posNum)
        viewModel.onSaveFraction(userPreferencesRepository, fractionNum)
        viewModel.onSaveErrorNum(userPreferencesRepository, falseNum)
        viewModel.onSaveRightNum(userPreferencesRepository, trueNum)
    }

    private fun refreshUI() {
        binding.imgState1.visibility = View.INVISIBLE
        binding.imgState2.visibility = View.INVISIBLE
        binding.imgState3.visibility = View.INVISIBLE
        binding.imgState4.visibility = View.INVISIBLE
        binding.constraintLayout1.background = resources.getDrawable(R.drawable.icon_def_lt)
        binding.constraintLayout2.background = resources.getDrawable(R.drawable.icon_def_rt)
        binding.constraintLayout3.background = resources.getDrawable(R.drawable.icon_def_lb)
        binding.constraintLayout4.background = resources.getDrawable(R.drawable.icon_def_rb)
    }

    private fun updateProgress() {
        binding.progressBar.progress = ((trueNum.toDouble() / 6) * 100).toInt()
        binding.progressBarSetting.progress = ((trueNum.toDouble() / 6) * 100).toInt()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.keyCode == KeyEvent.KEYCODE_BACK) {
            if (binding.clMainSetting.isVisible) {
                if (qaState) {
                    binding.clMainQa.visibility = View.VISIBLE
                    binding.llTime.visibility = View.VISIBLE
                    binding.clMainWrong.visibility = View.GONE
                    binding.clMainSetting.visibility = View.GONE
                    binding.imgSM.visibility = View.GONE
                } else {
                    binding.imgSM.visibility = View.VISIBLE
                    binding.clMainQa.visibility = View.GONE
                    binding.clMainWrong.visibility = View.GONE
                    binding.llTime.visibility = View.GONE
                    binding.clMainSetting.visibility = View.GONE
                }
                return true
            }
            if (!binding.imgSM.isVisible) {
                binding.clMainQa.visibility = View.GONE
                binding.llTime.visibility = View.GONE
                binding.clMainWrong.visibility = View.GONE
                binding.clMainSetting.visibility = View.GONE
                binding.imgSM.visibility = View.VISIBLE
                return true
            }
            finish()
        }
        return true
    }

}
