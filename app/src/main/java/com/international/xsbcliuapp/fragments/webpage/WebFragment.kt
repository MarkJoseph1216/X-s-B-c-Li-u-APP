package com.international.xsbcliuapp.fragments.webpage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.international.xsbcliuapp.app.base.BaseFragment
import com.international.xsbcliuapp.databinding.FragmentWebBinding

class WebFragment(
    private val lotteryUrl: String
) : BaseFragment<WebViewModel, FragmentWebBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebBinding
        get() = FragmentWebBinding::inflate

    override fun onViewBound() {
        super.onViewBound()
        setupWebPage()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebPage(){
        binding.webPage.apply {
            loadUrl(lotteryUrl)
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    loadUrl(
                        "javascript:(function() { " +
                                "document.getElementsByClassName('lg-header')[0].style.display='none'; " +
                                "document.getElementsByClassName('hero-body')[0].style.display='none'; " +
                                "})()"
                    )
                }
            }
        }
    }
}