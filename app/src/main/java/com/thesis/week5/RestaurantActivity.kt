package com.thesis.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
//import android.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thesis.week5.databinding.ActivityRestaurantBinding
import kotlinx.android.synthetic.main.activity_restaurant.*
import androidx.appcompat.widget.Toolbar

class RestaurantActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRestaurantBinding
    private lateinit var viewModel: RestaurantViewModel

    private lateinit var adapter : RestaurantAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)
        viewModel = ViewModelProvider(this).get(RestaurantViewModel::class.java)

        adapter = RestaurantAdapter()
        binding.rcList.adapter = adapter
        adapter.data = getRestaurantDataSet()

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
//        if (item?.itemId == R.id.change_layout){
//            Log.d("debug", "list_icon")
//            adapter.toggleItemViewType()
//            binding.rcList.layoutManager = GridLayoutManager(this, 3)
//        }
//        else {
//            binding.rcList.layoutManager = LinearLayoutManager(this)
//            Log.d("debug", "linear")
//        }
//        adapter.notifyDataSetChanged()
//        return super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.change_layout -> {
                val isLinearSwitched : Boolean = adapter.toggleItemViewType()
                if (isLinearSwitched){
                    binding.rcList.layoutManager = LinearLayoutManager(this)
                    item.title = "GRID"
                }
                else {
                    binding.rcList.layoutManager = GridLayoutManager(this,3)
                    item.title = "LIST"
                }
            }
        }
        return  true
    }
}