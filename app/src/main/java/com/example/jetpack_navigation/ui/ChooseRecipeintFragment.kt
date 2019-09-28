package com.example.jetpack_navigation.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.jetpack_navigation.R
import kotlinx.android.synthetic.main.fragment_choose_recipeint.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseRecipeintFragment : Fragment(), View.OnClickListener{
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipeint, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        next_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.next_btn -> {
                navController.navigate(R.id.action_chooseRecipeintFragment_to_specifyAmountFragment)
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }


}
