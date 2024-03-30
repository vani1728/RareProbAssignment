package com.example.rareprobproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rareprobproject.Adapters.BannerAdapter
import com.example.rareprobproject.Adapters.BottomListAdapter
import com.example.rareprobproject.Adapters.GameItemAdapter
import com.example.rareprobproject.Dataclasses.BannerData
import com.example.rareprobproject.ViewModel.MyViewModel
import com.example.rareprobproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityBinding:ActivityMainBinding
    val viewModel=MyViewModel()
    var listBanner=ArrayList<BannerData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)
        iniView()
    }

    private fun iniView() {
        val gameItemAdapterWithPlay=GameItemAdapter(this,true);
        val gameItemAdapterWithoutPlay=GameItemAdapter(this,false);
        val bottomAdapter=BottomListAdapter(this);

        lifecycleScope.launchWhenStarted {
            viewModel.items.collect { items ->
                gameItemAdapterWithPlay.setItems(items)
                gameItemAdapterWithoutPlay.setItems(items)
            }
        }
        lifecycleScope.launchWhenStarted {
            listBanner.clear()
            viewModel.bannerItems.collect { items ->
                listBanner.addAll(items)
            }
        }
        lifecycleScope.launchWhenStarted {

            viewModel.bottomItem.collect { items ->
                bottomAdapter.setBottomItems(items)
            }
        }
        activityBinding.BannerRV.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        activityBinding.BannerRV.adapter=BannerAdapter( listBanner);

        recyclerViewInitial(activityBinding.RecentPlayed,gameItemAdapterWithPlay)
        recyclerViewInitial( activityBinding.newReleasedOne,gameItemAdapterWithoutPlay)
        recyclerViewInitial( activityBinding.newReleasedTwo,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.ArcadeRV,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.puzzleGamesOne,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.puzzleGamesTwo,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.actionGamesOne,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.actionGamesTwo,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.brainGamesTwo,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.brainGamesOne,gameItemAdapterWithoutPlay)
        recyclerViewInitial(activityBinding.CasualRV,gameItemAdapterWithoutPlay)
        activityBinding.bottomRV.layoutManager = GridLayoutManager(this@MainActivity, 2, LinearLayoutManager.HORIZONTAL, false)
        activityBinding.bottomRV.adapter=bottomAdapter;


    }



    private fun recyclerViewInitial(rv: RecyclerView, gameItemAdapterWithoutPlay: GameItemAdapter) {
        rv.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        rv.adapter=gameItemAdapterWithoutPlay;

    }


}