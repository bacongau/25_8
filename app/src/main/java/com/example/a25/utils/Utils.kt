package com.example.a25.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utils {

    val error = "error"
    fun checkNetwork(context: Context): Boolean {
        var available = false
        var cn = context.getSystemService((Context.CONNECTIVITY_SERVICE)) as ConnectivityManager
        var info = cn.getActiveNetworkInfo() as NetworkInfo
        if (info != null && info.isAvailable && info.isConnected){
            available = true
        }
        return available
    }

}