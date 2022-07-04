package com.international.xsbcliuapp.app.common

import androidx.fragment.app.Fragment
import com.international.xsbcliuapp.app.common.Details.detailsList
import com.international.xsbcliuapp.fragments.details.presentation.DetailsFragment
import com.international.xsbcliuapp.fragments.webpage.WebFragment

class Default {

    companion object {

        private const val LOTTERY_PREDICTION = "https://lotteryguru.com/vietnam-lottery-results"

        fun getFragmentList() : List<Fragment> {
            val fragments = mutableListOf<Fragment>()
            for (index in 0 until detailsList.size) fragments.add(DetailsFragment(detailsList[index]))
            fragments.add(1, WebFragment(LOTTERY_PREDICTION))
            return fragments
        }
    }
}