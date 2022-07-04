package com.international.xsbcliuapp.fragments.webpage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.Gson
import com.international.xsbcliuapp.R
import com.international.xsbcliuapp.app.base.BaseActivity
import com.international.xsbcliuapp.app.common.CellsModel
import com.international.xsbcliuapp.databinding.ActivityWebBinding


class WebActivity : BaseActivity<WebViewModel, ActivityWebBinding>(), View.OnClickListener {

    override val bindingInflater: (LayoutInflater) -> ActivityWebBinding
        get() = ActivityWebBinding::inflate

    private val cellData: CellsModel by lazy {
        Gson().fromJson(
            intent.getStringExtra(WEB_URL),
            CellsModel::class.java
        )
    }

    override fun onViewsBound() {
        super.onViewsBound()
        setupWebPage()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onInitializeListener() {
        super.onInitializeListener()
        setupComponents()
        setupListener()
    }

    private fun setupComponents(){
        binding.apply {
            webTitle.text = cellData.title
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebPage() {
        binding.webPage.apply {
            loadUrl(cellData.cellUrl)
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    binding.progressWebPage.visibility = View.GONE

                    loadUrl("javascript:var footer = document.getElementById(\"footer\"); " +
                            "footer.parentNode.removeChild(footer); " +
                            "var header = document.getElementById(\"header-full\"); " +
                            "header.parentNode.removeChild(header);"
                    )
                }
            }
        }
    }

    private fun setupListener() {
        binding.apply {
            closeWebPage.setOnClickListener(this@WebActivity)
            backward.setOnClickListener(this@WebActivity)
            forward.setOnClickListener(this@WebActivity)
        }
    }

    companion object {
        const val WEB_URL = "webUrl"
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.closeWebPage -> finish()
            R.id.backward -> binding.apply { if (webPage.canGoBack()) webPage.goBack() }
            R.id.forward -> binding.apply { if (webPage.canGoForward()) webPage.goForward() }
        }
    }
}