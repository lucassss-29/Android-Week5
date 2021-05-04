package com.thesis.week5.Onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.thesis.week5.R

class Onboarding1Activity: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_onboarding1,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.btn_onboarding1)
        button.setOnClickListener {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<Onboarding2Activity>(R.id.fragment_container_view)
            addToBackStack(null)
        }
        }
    }
}