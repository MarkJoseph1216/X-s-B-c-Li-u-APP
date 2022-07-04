package com.international.xsbcliuapp.app.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM: ViewModel, VB: ViewBinding> : Fragment() {

    lateinit var binding: VB

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected open fun beforeLayout(savedInstanceState: Bundle?) = Unit
    protected open fun afterLayout(savedInstanceState: Bundle?) = Unit

    protected open fun onViewBound() = Unit
    protected open fun onViewModelBound() = Unit
    protected open fun onInitializeListener() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeLayout(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterLayout(savedInstanceState)
        onViewModelBound()
        onViewBound()
        onInitializeListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false)
        return binding.root
    }
}