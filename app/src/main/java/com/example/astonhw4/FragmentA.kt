package com.example.astonhw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentA : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_fragment_b).setOnClickListener {
            (requireActivity() as FragmentToBButtonClickListener).onFragmentButtonClickListener()
        }
    }

    interface FragmentToBButtonClickListener{
        fun onFragmentButtonClickListener()
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        fun newInstance() = FragmentA()
    }
}