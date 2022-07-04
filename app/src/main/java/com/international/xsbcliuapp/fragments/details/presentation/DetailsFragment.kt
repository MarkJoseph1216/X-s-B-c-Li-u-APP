package com.international.xsbcliuapp.fragments.details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.google.gson.Gson
import com.international.xsbcliuapp.app.Navigator.Companion.navigatePage
import com.international.xsbcliuapp.app.base.BaseFragment
import com.international.xsbcliuapp.app.common.CellsModel
import com.international.xsbcliuapp.app.common.DetailsModel
import com.international.xsbcliuapp.databinding.FragmentDetailsBinding
import com.international.xsbcliuapp.fragments.details.controller.DetailsController
import com.international.xsbcliuapp.fragments.webpage.WebActivity
import com.international.xsbcliuapp.fragments.webpage.WebActivity.Companion.WEB_URL

class DetailsFragment(
    private val details: DetailsModel
) : BaseFragment<DetailsViewModel, FragmentDetailsBinding>(),
    DetailsController.DetailsListener {

    private val controller by lazy {
        DetailsController(this)
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun onViewBound() {
        super.onViewBound()
        setupComponents()
    }

    private fun setupComponents() {
        binding.recyclerButton.apply {
            layoutManager = LinearLayoutManager(context, VERTICAL, false)
            setController(controller)
            controller.detailList = details.cellList
        }
    }

    override fun onButtonClicked(cellData: CellsModel) {
        navigatePage(
            context = context,
            className = WebActivity::class.java,
            bundleName = WEB_URL,
            bundle = Gson().toJson(cellData)
        )
    }
}