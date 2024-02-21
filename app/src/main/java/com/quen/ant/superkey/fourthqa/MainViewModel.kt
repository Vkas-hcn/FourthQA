package com.quen.ant.superkey.fourthqa

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.quen.ant.superkey.fourthqa.data.UserPreferencesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    fun onSavePosition(userPreferencesRepository: UserPreferencesRepository, position: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.saveQaPoint(position)
        }
    }

    fun onGetPosition(
        userPreferencesRepository: UserPreferencesRepository,
        nextFun: (Int) -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.qaPointFlow.collect { num ->
                withContext(Dispatchers.Main) {
                    nextFun(num)
                }
            }
        }
    }

    fun onSaveFraction(userPreferencesRepository: UserPreferencesRepository, num: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.saveFraction(num)
        }
    }

    fun onGetFraction(
        userPreferencesRepository: UserPreferencesRepository,
        nextFun: (Int) -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.fractionFlow.collect { num ->
                withContext(Dispatchers.Main) {
                    nextFun(num)
                }
            }
        }
    }

    fun onSaveLevel(userPreferencesRepository: UserPreferencesRepository, level: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.saveLevel(level)
        }
    }

    fun onGetLevel(userPreferencesRepository: UserPreferencesRepository, nextFun: (Int) -> Unit) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.levelFlow.collect { num ->
                withContext(Dispatchers.Main) {
                    nextFun(num)
                }
            }
        }
    }

    fun onSaveErrorNum(userPreferencesRepository: UserPreferencesRepository, num: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.saveErrorNum(num)
        }
    }

    fun onGetErrorNum(
        userPreferencesRepository: UserPreferencesRepository,
        nextFun: (Int) -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.errorNumFlow.collect { num ->
                withContext(Dispatchers.Main) {
                    nextFun(num)
                }
            }
        }
    }

    fun onSaveRightNum(userPreferencesRepository: UserPreferencesRepository, num: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.saveRightNum(num)
        }
    }

    fun onGetRightNum(
        userPreferencesRepository: UserPreferencesRepository,
        nextFun: (Int) -> Unit
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            userPreferencesRepository.rightNumFlow.collect { num ->
                withContext(Dispatchers.Main) {
                    nextFun(num)
                }
            }
        }
    }

    var countDownTime = MutableLiveData<Int>()
    var countDow: Job? = null
    var count: Int = 0
    var isCounting = false
    val timeData = 30

    //30秒倒计时(isPause,0:开始，1：暂停，2恢复,3:重置)
    fun countDownTime(isPause: Int, activity: AppCompatActivity) {
        countDow?.cancel()
        countDow = null
        when (isPause) {
            0 -> {
                isCounting = true
                count = timeData
            }

            1 -> {
                isCounting = false
                count = countDownTime.value ?: timeData
            }

            2 -> {
                isCounting = true
                count = countDownTime.value ?: timeData
            }

            3 -> {
                isCounting = false
            }
        }
        countDow = activity.lifecycleScope.launch {
            while (count >= 0 && isCounting) {
                countDownTime.value = count
                count--
                delay(1000)
            }
        }
    }


}