package com.example.astonhw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val msg = "Hello Fragment C"

        view.findViewById<Button>(R.id.btn_fragment_c).setOnClickListener {
            (requireActivity() as FragmentToCButtonClickListener).onFragmentToCButtonClickListener(msg)
        }

        view.findViewById<Button>(R.id.btn_back).setOnClickListener {
            (requireActivity() as BackButtonClickListener).onBackButtonClickListener()
        }

    }

    interface FragmentToCButtonClickListener{
        fun onFragmentToCButtonClickListener(msg: String)
    }

    interface BackButtonClickListener{
        fun onBackButtonClickListener()
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        fun newInstance() = FragmentB()
    }


}