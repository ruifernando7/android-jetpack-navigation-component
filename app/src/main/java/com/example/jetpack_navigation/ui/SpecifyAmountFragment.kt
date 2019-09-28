package com.example.jetpack_navigation.ui


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.jetpack_navigation.R
import com.example.jetpack_navigation.helper.Money
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController
    private var r: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        r = arguments?.getString("recipient")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
        val message = "Sending money to $r"
        recipient.text = message
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.send_btn -> {
                if(!TextUtils.isEmpty(input_amount.text.toString())){
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to r,
                        "amount" to amount
                    )
                    navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle)
                }else{
                    Toast.makeText(requireContext(),"Enter amount",Toast.LENGTH_LONG).show()
                }
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }

}
