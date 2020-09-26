package com.eticon.parkoved

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eticon.parkoved.R
import com.eticon.parkoved.adapters.MapAdapter
import com.eticon.parkoved.adapters.RecomendAdapter
import com.eticon.parkoved.dataclasses.RecomendData
import kotlinx.android.synthetic.main.fragment_map.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MapFragment : Fragment() {
    lateinit var recycler: RecyclerView
    lateinit var recycler_recomend: RecyclerView
    lateinit var exitBtn: TextView

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

        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val items = listOf<String>("Аттракционы", "Кафе и рестораны", "Парковки", "Туалеты")
        val itemsRecomend = mutableListOf<RecomendData>()
        itemsRecomend.add(RecomendData("Колесо обзора", R.drawable.koleso))
        itemsRecomend.add(RecomendData("Свадебная карусель", R.drawable.karusel))
        itemsRecomend.add(RecomendData("Веселые горки", R.drawable.gorki))

        recycler = view.findViewById(R.id.recycler_map)
        recycler_recomend = view.findViewById(R.id.recycler_recomend)

        exitBtn = view.findViewById(R.id.exit)

        recycler.layoutManager = LinearLayoutManager(activity?.applicationContext , LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = MapAdapter(items)

        recycler_recomend.layoutManager = LinearLayoutManager(activity?.applicationContext , LinearLayoutManager.HORIZONTAL, false)
        recycler_recomend.adapter = RecomendAdapter(itemsRecomend)

        exitBtn.setOnClickListener {
            val intent = Intent(activity, CaseCityActivity::class.java)
            startActivity(intent)
            activity!!.finish()
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}