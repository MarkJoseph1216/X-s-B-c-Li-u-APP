package com.international.xsbcliuapp.fragments.details.itemmodel

import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.international.xsbcliuapp.R
import com.international.xsbcliuapp.app.common.CellsModel
import com.international.xsbcliuapp.databinding.ItemmodelDetailsListBinding
import com.international.xsbcliuapp.fragments.details.controller.DetailsController

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.itemmodel_details_list)
abstract class DetailsItemModel : EpoxyModelWithHolder<DetailsItemModel.ViewHolder>() {

    @EpoxyAttribute
    lateinit var details: CellsModel

    @EpoxyAttribute
    lateinit var listener: DetailsController.DetailsListener

    override fun bind(holder: ViewHolder) {
        super.bind(holder)
        setupComponents(holder.itemBinding)
        setupListener(holder.itemBinding)
    }

    private fun setupComponents(binding: ItemmodelDetailsListBinding) {
        binding.apply {
            cellTitle.text = details.title
        }
    }

    private fun setupListener(binding: ItemmodelDetailsListBinding) {
        binding.apply {
            cellButton.setOnClickListener {
                listener.onButtonClicked(details)
            }
        }
    }

    class ViewHolder : EpoxyHolder() {
        lateinit var itemBinding: ItemmodelDetailsListBinding
        override fun bindView(itemView: View) {
            itemBinding = ItemmodelDetailsListBinding.bind(itemView)
        }
    }
}