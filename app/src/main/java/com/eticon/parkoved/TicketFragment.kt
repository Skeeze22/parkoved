package com.eticon.parkoved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TicketFragment : Fragment() {

    lateinit var line_1: ConstraintLayout
    lateinit var line_2: ConstraintLayout
    lateinit var line_3: ConstraintLayout

    lateinit var label_1: TextView
    lateinit var label_2: TextView
    lateinit var label_3: TextView

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
        val view = inflater.inflate(R.layout.fragment_ticket, container, false)

        line_1 = view.findViewById(R.id.line_1)
        line_2 = view.findViewById(R.id.line_2)
        line_3 = view.findViewById(R.id.line_3)

        label_1 = view.findViewById(R.id.label_1)
        label_2 = view.findViewById(R.id.label_2)
        label_3 = view.findViewById(R.id.label_3)

        line_1.setOnClickListener {
            val fr = CurrentTicketFragment()
            val bundle = Bundle()
            bundle.putString("text", label_1.text.toString())
            fr.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
        }

        line_2.setOnClickListener {
            val fr = CurrentTicketFragment()
            val bundle = Bundle()
            bundle.putString("text", label_2.text.toString())
            fr.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
        }

        line_3.setOnClickListener {
            val fr = CurrentTicketFragment()
            val bundle = Bundle()
            bundle.putString("text", label_3.text.toString())
            fr.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TicketFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}