package com.international.xsbcliuapp.app

import android.content.Context
import android.content.Intent

class Navigator {
    companion object {

        fun navigatePage(
            context: Context?,
            className: Class<*>,
            bundleName: String,
            bundle: String) {

            val intent = Intent(context, className)
            intent.putExtra(bundleName, bundle)
            context?.startActivity(intent)
        }
    }
}