package com.international.xsbcliuapp.fragments.details.controller

import com.airbnb.epoxy.EpoxyController
import com.international.xsbcliuapp.app.common.CellsModel
import com.international.xsbcliuapp.fragments.details.itemmodel.DetailsItemModel
import com.international.xsbcliuapp.fragments.details.itemmodel.detailsItem

class DetailsController(
    val listener: DetailsListener
) : EpoxyController() {

    var detailList: List<CellsModel>? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        detailList?.forEach(this::setupButtons)
    }

    private fun setupButtons(cellsModel: CellsModel) {
        detailsItem {
            id(DetailsItemModel::class.simpleName)
            details(cellsModel)
            listener(this@DetailsController.listener)
        }
    }

    interface DetailsListener {
        fun onButtonClicked(cellData: CellsModel)
    }
}