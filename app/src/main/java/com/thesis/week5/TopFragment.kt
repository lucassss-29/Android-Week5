package com.thesis.week5

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.week5.databinding.ActivityRestaurantBinding
import com.thesis.week5.databinding.FragmentFavBinding
import kotlinx.android.synthetic.main.activity_restaurant.*
import kotlinx.android.synthetic.main.fragment_fav.*
import kotlinx.android.synthetic.main.fragment_fav.rcList

class TopFragment : Fragment() {
    private lateinit var ResAdapter: RestaurantAdapter
    private lateinit var binding : FragmentFavBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fav, container, false)
        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rcList.apply {
            ResAdapter = RestaurantAdapter()
            adapter = ResAdapter
            ResAdapter.listener = object : RestaurantAdapter.RestaurantAdapterListener {
                override fun onClickCheckBox(Res: Restaurant,isChecked:Boolean) {
                    if (isChecked) {
                        addRestaurantData(Res)
                    } else {
                        RemoveRestaurantData(Res)
                    }
                }
            }
            ResAdapter.data = setFAV()
        }
    }

}

