package com.quen.ant.superkey.fourthqa.base

import android.app.Application
import com.quen.ant.superkey.fourthqa.data.BlackUtils

class App:Application() {
    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        instance = this
        super.onCreate()
        if(BlackUtils.fqa_id.isEmpty()){
            BlackUtils.fqa_id = BlackUtils.getUUID()
        }
        BlackUtils.getBlackList(this)
    }
}