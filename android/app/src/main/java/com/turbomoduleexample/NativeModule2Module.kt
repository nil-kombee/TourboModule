// MyGeoModule.kt
package com.turbomoduleexample
import android.location.Address
import android.location.Geocoder
import android.util.Log
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import java.io.IOException
import java.util.Locale

// @ReactModule(name = MyGeoModule.NAME)
class NativeModule2Module(reactContext: ReactApplicationContext) : NativeModule2Spec(reactContext) {

    override fun getName() = NAME

    override fun geocodeAddress(address: String, promise: Promise) {
        val geocoder = Geocoder(reactApplicationContext, Locale.getDefault())
        try {
            val addresses: List<Address>? = geocoder.getFromLocationName(address, 1)
            if (!addresses.isNullOrEmpty()) {
                val location = addresses[0]
                val result = "Lat: ${location.latitude}, Lng: ${location.longitude}"
                promise.resolve(result)
            } else {
                promise.reject("GEOCODING_ERROR", "No location found for the given address")
            }
        } catch (e: IOException) {
            promise.reject("GEOCODING_ERROR", e.message)
        }
    }

    override fun reverseGeocode(latitude: Double, longitude: Double, promise: Promise) {
        val geocoder = Geocoder(reactApplicationContext, Locale.getDefault())
        try {
            val addresses: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)
            if (!addresses.isNullOrEmpty()) {
                val address = addresses[0]
                val fullAddress = address.getAddressLine(0) ?: ""
                promise.resolve(fullAddress)
            } else {
                promise.reject("GEOCODING_ERROR", "No address found for the given coordinates")
            }
        } catch (e: IOException) {
            promise.reject("GEOCODING_ERROR", e.message)
        }
    }

    companion object {
        const val NAME = "NativeModule2"
    }
}
