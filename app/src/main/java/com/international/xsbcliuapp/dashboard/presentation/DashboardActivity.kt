package com.international.xsbcliuapp.dashboard.presentation

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.international.xsbcliuapp.app.base.BaseActivity
import com.international.xsbcliuapp.app.common.Default.Companion.getFragmentList
import com.international.xsbcliuapp.dashboard.adapter.SlidePagerAdapter
import com.international.xsbcliuapp.databinding.ActivityDashboardBinding

class DashboardActivity : BaseActivity<DashboardViewModel, ActivityDashboardBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityDashboardBinding
        get() = ActivityDashboardBinding::inflate

    override fun onViewModelBound() {
        super.onViewModelBound()
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
    }

    override fun onViewsBound() {
        super.onViewsBound()
        setupViewPager()
    }

    override fun onInitializeListener() {
        super.onInitializeListener()
        setupListener()
    }

    private fun setupViewPager() {
        binding.slidePager.apply {
            adapter = SlidePagerAdapter(
                fragmentActivity = this@DashboardActivity,
                fragmentList = getFragmentList()
            )
            offscreenPageLimit = 3
        }
    }

    private fun setupListener() {
        binding.apply {
            bottomNavigation.setOnItemSelectedListener {
                slidePager.currentItem = it.order
                true
            }
        }
    }
}