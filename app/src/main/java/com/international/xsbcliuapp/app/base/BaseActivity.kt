package com.international.xsbcliuapp.app.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM: ViewModel, VB: ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB

    lateinit var viewModel: VM

    abstract val bindingInflater: (LayoutInflater) -> VB

    protected open fun afterLayout(savedInstanceState: Bundle?) { initViewBinding() }
    protected open fun onViewsBound() = Unit
    protected open fun onInitializeListener() = Unit
    protected open fun onViewModelBound() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        afterLayout(savedInstanceState)
        onViewModelBound()
        onViewsBound()
        onInitializeListener()
    }

    private fun initViewBinding() {
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }
}