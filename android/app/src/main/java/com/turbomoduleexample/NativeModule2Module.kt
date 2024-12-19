package com.turbomoduleexample

import android.content.Context
import android.content.SharedPreferences
import com.turbomoduleexample.NativeModule2Spec
import com.facebook.react.bridge.ReactApplicationContext

class NativeModule2Module(reactContext: ReactApplicationContext) : NativeModule2Spec(reactContext) {

  override fun getName() = NAME

  override fun masti(): String {
    return "10"
  }
  companion object {
    const val NAME = "NativeModule2"
  }
}