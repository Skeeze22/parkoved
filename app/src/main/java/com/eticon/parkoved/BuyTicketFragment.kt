package com.eticon.parkoved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BuyTicketFragment : Fragment() {

    lateinit var img: CircleImageView
    lateinit var label: TextView
    lateinit var back_btn: ImageView
    lateinit var pay_money: Button
    lateinit var pay_bonus: Button

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buy_ticket, container, false)

        img = view.findViewById(R.id.imaga_pay)
        label = view.findViewById(R.id.text_pay)
        back_btn = view.findViewById(R.id.back_btn)
        pay_money = view.findViewById(R.id.pay_money)
        pay_bonus = view.findViewById(R.id.pay_bonus)

        back_btn.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, MapFragment()).commit()
        }

        pay_money.setOnClickListener {
            val fr = CurrentTicketFragment()
            val bundle = Bundle()
            bundle.putString("text", label.text.toString())
            fr.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
        }

        pay_bonus.setOnClickListener {
            val fr = CurrentTicketFragment()
            val bundle = Bundle()
            bundle.putString("text", label.text.toString())
            fr.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
        }

        label.text = arguments!!.getString("text")



        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BuyTicketFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}