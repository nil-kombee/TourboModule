// NativeModule2Package.kt
package com.turbomoduleexample

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class NativeModule2Package : TurboReactPackage() {

    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
        return if (name == NativeModule2Module.NAME) {
            NativeModule2Module(reactContext)
        } else {
            null
        }
    }

    override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
        return ReactModuleInfoProvider {
            mapOf(
                NativeModule2Module.NAME to ReactModuleInfo(
                    _name = NativeModule2Module.NAME,
                    _className = NativeModule2Module::class.java.name,
                    _canOverrideExistingModule = false,
                    _needsEagerInit = false,
                    isCxxModule = false,
                    isTurboModule = true
                )
            )
        }
    }
}
