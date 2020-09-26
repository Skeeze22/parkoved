package com.eticon.parkoved

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eticon.parkoved.adapters.RecomendAdapter
import com.eticon.parkoved.dataclasses.RecomendData

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PersonalRoutFragment : Fragment() {

    lateinit var recycler_rout: RecyclerView
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
        val view = inflater.inflate(R.layout.fragment_personal_rout, container, false)

        val itemsRecomend = mutableListOf<RecomendData>()
        itemsRecomend.add(RecomendData("Колесо обзора", R.drawable.koleso2))
        itemsRecomend.add(RecomendData("Свадебная карусель", R.drawable.karusel))
        itemsRecomend.add(RecomendData("Веселые горки", R.drawable.gorki))

        recycler_rout = view.findViewById(R.id.recycler_rout)
        btn_back = view.findViewById(R.id.back_btn)

        recycler_rout.layoutManager = LinearLayoutManager(activity?.applicationContext , LinearLayoutManager.HORIZONTAL, false)

        val adapter = RecomendAdapter(itemsRecomend, object : RecomendAdapter.Callback {
            override fun onItemClicked(item: RecomendData) {
                val fr = InfoAttracFragment()
                val bundle = Bundle()
                bundle.putInt("img", item.image)
                bundle.putString("text", item.text)
                fr.arguments = bundle
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, fr).commit()
            }
        })

        btn_back.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fl_content, RoutesFragment()).commit()
        }


        recycler_rout.adapter = adapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PersonalRoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}