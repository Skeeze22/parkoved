package com.eticon.parkoved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class KvestFragment : Fragment() {

    lateinit var btn_back: ImageView

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
        val view = inflater.inflate(R.layout.fragment_kvest, container, false)

        btn_back = view.findViewById(R.id.back_btn)

        btn_back.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, RoutesFragment()).commit()
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            KvestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}