package com.peter.appwork_midterm.data

//data class product (
//    val dataId = List<Product>
//        )



data class ContentData(
    val author: author,
    val createdTime: Int,
    val id: String,
    val title: String,
    val category: String,
    val content: String
        )


data class author (
    val name: String,
    val id: String,
    val email : String


)