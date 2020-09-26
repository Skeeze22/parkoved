package com.eticon.parkoved.Personal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.eticon.parkoved.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PersonKassaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonKassaFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        var view = inflater.inflate(R.layout.fragment_person_kassa, container, false)
        var btn = view.findViewById<ConstraintLayout>(R.id.start_det)
        btn.setOnClickListener {
            if (btn.findViewById<TextView>(R.id.text_btn).text == "Переключить на детский"){
                view.findViewById<TextView>(R.id.discription).text = "Билет детский - 100 рублей"
                btn.findViewById<TextView>(R.id.text_btn).text = "Переключить на взрослый"
            }
            else{
                btn.findViewById<TextView>(R.id.text_btn).text = "Переключить на детский"
                view.findViewById<TextView>(R.id.discription).text = "Билет взрослый - 100 рублей"
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PersonKassaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PersonKassaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}