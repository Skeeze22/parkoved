package com.eticon.parkoved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class InfoAttracFragment : Fragment() {

    lateinit var label: TextView
    lateinit var img: ImageView
    lateinit var back_btn: ImageView
    lateinit var buy: Button

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

        val view = inflater.inflate(R.layout.fragment_info_attrac, container, false)
        label = view.findViewById(R.id.text_label)
        img = view.findViewById(R.id.image_info)
        back_btn = view.findViewById(R.id.back_btn)
        buy = view.findViewById(R.id.buy_ticket)

        label.text = arguments!!.getString("text")
        val res = arguments!!.getInt("img")
        img.setImageResource(res)

        back_btn.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, MapFragment()).commit()
        }

        buy.setOnClickListener {
            val fr = BuyTicketFragment()
            val bundle = Bundle()
            bundle.putString("text", label.text.toString())
            bundle.putInt("img", res)
            fr.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoAttracFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}