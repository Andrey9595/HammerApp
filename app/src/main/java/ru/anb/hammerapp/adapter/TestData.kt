package ru.anb.hammerapp.adapter


import ru.anb.hammerapp.model.BannerModel
import ru.anb.hammerapp.model.TagModel

object TestData {
    val bannerList = listOf("Terminator 2: Judgment Day 3D", "Dunkirk", " Lion", " Star Wars: The Last Jedi", "Thor: Ragnarok", "Blade Runner 2049").map {
        BannerModel(it)
    }

    val tagList = listOf("Драма", "Комедия", "Боевик", "Фантастика", "Ужасы", "Триллер", "Документальный", "Анимационный").map {
        TagModel(it)
    }
}