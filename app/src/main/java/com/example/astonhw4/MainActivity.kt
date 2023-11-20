package com.example.astonhw4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(),
    FragmentA.FragmentToBButtonClickListener,
    FragmentB.FragmentToCButtonClickListener,
    FragmentB.BackButtonClickListener,
    FragmentC.FragmentToDButtonClickListener,
    FragmentC.FragmentToAButtonClickListener,
    FragmentD.FragmentToBButtonListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FragmentA())
            .commit()
    }

    override fun onFragmentButtonClickListener() {
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container, FragmentB.newInstance(), FragmentB.FRAGMENT_B_TAG)
            addToBackStack(FragmentB.FRAGMENT_B_TAG)
            commit()
        }
    }

    override fun onFragmentToCButtonClickListener(msg: String) {
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container, FragmentC.newInstance(msg), FragmentC.FRAGMENT_C_TAG)
            addToBackStack(FragmentC.FRAGMENT_C_TAG)
            commit()
        }
    }

    override fun onFragmentToDButtonClickListener() {
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container, FragmentD.newInstance(), FragmentD.FRAGMENT_D_TAG)
            addToBackStack(FragmentD.FRAGMENT_D_TAG)
            commit()
        }
    }

    override fun onFragmentToAButtonClickListener() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.container, FragmentA.newInstance(), FragmentA.FRAGMENT_A_TAG)
            addToBackStack(FragmentA.FRAGMENT_A_TAG)
            commit()
        }
    }

    override fun onFragmentToBButtonListener() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.container, FragmentB.newInstance(), FragmentB.FRAGMENT_B_TAG)
            addToBackStack(FragmentB.FRAGMENT_B_TAG)
            commit()
        }
    }

    override fun onBackButtonClickListener() {
        onBackPressed()
    }

    companion object{
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}