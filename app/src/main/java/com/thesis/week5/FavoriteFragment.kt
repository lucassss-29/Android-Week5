package com.thesis.week5

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.week5.databinding.ActivityRestaurantBinding
import com.thesis.week5.databinding.FragmentFavBinding
import kotlinx.android.synthetic.main.fragment_fav.*
import kotlinx.android.synthetic.main.fragment_fav.view.*
import kotlinx.android.synthetic.main.restaurant_item_view.*
import java.nio.file.Files.list

class FavoriteFragment: Fragment() {
    private lateinit var adapter1 : RestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fav,container,false)
        return view
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rcList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter1 = RestaurantAdapter()
            adapter = adapter1
            adapter1.data = getdataRestaurant()
            }
        }
    }
