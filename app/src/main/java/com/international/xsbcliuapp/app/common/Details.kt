package com.international.xsbcliuapp.app.common

import com.international.xsbcliuapp.R

object Details {

    var detailsList = mutableListOf(
        DetailsModel(
            id = 1,
            title = "Home",
            background = R.drawable.info1,
            cellList = mutableListOf(
                CellsModel(title = "Lottery Guru", cellUrl = "https://www.vietnamyello.com/lottery"),
                CellsModel(title = "Latest Result", cellUrl = "https://lo24h.com"),
                CellsModel(title = "Lottery Blogs", cellUrl = "https://www.itourvn.com/blog/vietnamese-lottery"),
                CellsModel(title = "Winning Result", cellUrl = "https://www.magayo.com/lotto/vietnam/mega-645-results/")
            )
        ),
        DetailsModel(
            id = 3,
            title = "Guide",
            background = R.drawable.info3,cellList = mutableListOf(
                CellsModel(title = "Social Media", cellUrl = "https://www.facebook.com/Dingsheng-Company-111834618223556"),
                CellsModel(title = "Terms & Condition", cellUrl = "file:///android_asset/termscondition.html"),
                CellsModel(title = "Privacy Policy", cellUrl = "file:///android_asset/privacypolicy.html")
            )
        )
    )
}