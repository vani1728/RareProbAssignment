package com.example.rareprobproject.ViewModel

import androidx.lifecycle.ViewModel
import com.example.rareprobproject.Adapters.BannerAdapter
import com.example.rareprobproject.Dataclasses.BannerData
import com.example.rareprobproject.Dataclasses.GameItem
import com.example.rareprobproject.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<GameItem>>(emptyList())
    private val _bottom_items = MutableStateFlow<List<String>>(emptyList())

    private val _banner_items = MutableStateFlow<List<BannerData>>(emptyList())

    val items: StateFlow<List<GameItem>> get() = _items
    val bannerItems: StateFlow<List<BannerData>> get() = _banner_items
    val bottomItem:StateFlow<List<String>> get() = _bottom_items


    init {
        loadItems()
        loadBannerItems()
        bottomItems()
    }

    private fun loadBannerItems() {
        val staticData = listOf(
            BannerData(R.drawable.knife, "Classic Block","Puzzle"),
            BannerData(R.drawable.game2, "Free Fire","Action"),
            BannerData(R.drawable.game3, "Classic Block","Action"),
            BannerData(R.drawable.game4, "Classic Block","Puzzle"),
            BannerData(R.drawable.knife,"Classic Block","Action"),

        )
        _banner_items.value = staticData
    }

    private fun loadItems() {
        val staticData = listOf(
            GameItem(R.drawable.game1, "Bouncy Ball"),
            GameItem(R.drawable.game2, "Gun Jump"),
            GameItem(R.drawable.game3, "Find the Different"),
            GameItem(R.drawable.game4, "KnifeHit"),
            GameItem(R.drawable.game5,"Shape Harvoc"),
            GameItem(R.drawable.game6,"Shot"),
            GameItem(R.drawable.game2,"Tank war"),
            GameItem(R.drawable.game1,"Tap Tap Ball")
        )
        _items.value = staticData
    }
    private fun bottomItems() {
        val staticData = listOf(
           "Cookies","About","Privacy","FAQ","Jobs","T&U"
        )
        _bottom_items.value = staticData
    }
}
