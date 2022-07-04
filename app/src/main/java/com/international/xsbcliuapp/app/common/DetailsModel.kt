package com.international.xsbcliuapp.app.common

data class DetailsModel(
    var id: Int,
    var title: String,
    var background: Int,
    var cellList: List<CellsModel>
)

data class CellsModel(
    var title: String,
    var cellUrl: String
)