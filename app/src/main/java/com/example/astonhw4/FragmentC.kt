package com.example.astonhw4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class FragmentC : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val msg = arguments?.getString(STRING_EXTRA)
        val msgTextView = view.findViewById<TextView>(R.id.tv_msg)
        msgTextView.text = msg

        view.findViewById<Button>(R.id.btn_fragment_d).setOnClickListener {
            (requireActivity() as FragmentToDButtonClickListener).onFragmentToDButtonClickListener()
        }

        view.findViewById<Button>(R.id.btn_fragment_a).setOnClickListener {
            (requireActivity() as FragmentToAButtonClickListener).onFragmentToAButtonClickListener()
        }

    }

    interface FragmentToDButtonClickListener{
        fun onFragmentToDButtonClickListener()
    }

    interface FragmentToAButtonClickListener{
        fun onFragmentToAButtonClickListener()
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        private const val STRING_EXTRA = "STRING"

        fun newInstance(msg: String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString(STRING_EXTRA, msg)
            }
        }
    }
}