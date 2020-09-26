package com.eticon.parkoved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RoutesFragment : Fragment() {

    lateinit var line_1: ConstraintLayout
    lateinit var line_2: ConstraintLayout

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

        val view = inflater.inflate(R.layout.fragment_routes, container, false)

        line_1 = view.findViewById(R.id.line_1)
        line_2 = view.findViewById(R.id.line_2)

        line_1.setOnClickListener {

        }

        line_2.setOnClickListener {

        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoutesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}