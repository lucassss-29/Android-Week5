package com.thesis.week5

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.restaurant_item_view.*

class RestaurantItemActivity : AppCompatActivity() {
    private var lastStatus = false
    //privare var restaurant : List
    private var flag : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_item_view)

        add_favourite.setOnClickListener {
            if(add_favourite.isChecked){
                AlertDialog.Builder(this)
                    .setMessage("Add to Favourite ?")
                    .setPositiveButton("ADD") { _, _ ->
                        add_favourite.isChecked = true
                        add_favourite.setBackgroundResource(R.drawable.favourite_on)
                    }
                    .setNegativeButton("CANCEL") { _, _ ->
                        add_favourite.isChecked = true
                    }
                    .show()
            }
            else{
                androidx.appcompat.app.AlertDialog.Builder(this)
                    .setMessage("Remove from Favourite ?")
                    .setPositiveButton("REMOVE") { _, _ ->
                        add_favourite.isChecked = false
                        add_favourite.setBackgroundResource(R.drawable.favourite)
                    }
                    .setNegativeButton("CANCEL") { _, _ ->
                        add_favourite.isChecked = true
                    }
                    .show()
            }
        }
    }

}