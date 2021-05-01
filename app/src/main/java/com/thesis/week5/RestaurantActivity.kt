package com.thesis.week5

import android.graphics.Insets
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
//import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thesis.week5.databinding.ActivityRestaurantBinding
import kotlinx.android.synthetic.main.activity_restaurant.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ReportFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_restaurant.rcList
import kotlinx.android.synthetic.main.fragment_fav.*
import kotlinx.android.synthetic.main.restaurant_item_view.*

class RestaurantActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRestaurantBinding
    private lateinit var viewModel: RestaurantViewModel

    private lateinit var adapter : RestaurantAdapter
    private lateinit var recyclerView: RecyclerView
    private var count : Int = 0


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)
        adapter = RestaurantAdapter()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<TopFragment>(R.id.fragment_container_view)
            addToBackStack(null)

        }
        binding.navigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.navigation_fav ->{
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<FavoriteFragment>(R.id.fragment_container_view)
                        addToBackStack(null)

                    }
                    true
                }
                R.id.navigation_top->{
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<TopFragment>(R.id.fragment_container_view)
                        addToBackStack(null)
                    }
                    true
                }
                else -> false
            }
        }
        setupToolbar()
    }
    fun setupToolbar(){
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Restaurants"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_layout -> {
                val isLinearSwitched : Boolean = adapter.toggleItemViewType()
                if (isLinearSwitched){
                    rcList.layoutManager = LinearLayoutManager(this)
                    item.title = "GRID"
                }
                else {
                    rcList.layoutManager = GridLayoutManager(this,2)
                    item.title = "LIST"
                }
            }
        }
        return  true
    }
}