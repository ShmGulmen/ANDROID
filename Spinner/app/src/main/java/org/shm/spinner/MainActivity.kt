package org.shm.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

typealias CityInfo = Pair<Int, String>

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    private lateinit var mAdapter : ArrayAdapter<CityInfo>

    private fun readCities() : ArrayList<CityInfo> //Datayı doldurduk.
    {
        var cities = ArrayList<CityInfo>()

        cities.add(Pair(34, "İstanbul"))
        cities.add(Pair(35, "İzmir"))
        cities.add(Pair(31, "Hatay"))
        cities.add(Pair(6, "Ankara"))

        cities.sortBy { it.first }//ArrayListi sıraladım.first = Plakaya göre sıraladım

        return cities
    }

    private fun initViews()
    {
        mAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, readCities())
        MainActivitySpinnerCities.adapter = mAdapter
        MainActivitySpinnerCities.onItemSelectedListener = this
    }

    private fun init()
    {
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var cities = mAdapter.getItem(position)

        Toast.makeText(this, "Selected position: ${cities?.second}", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    fun onDisplayButtonClicked(view: View)
    {
        var cities = MainActivitySpinnerCities.selectedItem as CityInfo

        Toast.makeText(this, "selected item: ${cities.second}", Toast.LENGTH_SHORT).show()

        cities = mAdapter.getItem(MainActivitySpinnerCities.selectedItemPosition)!!

        Toast.makeText(this, "selected index : ${cities.second}", Toast.LENGTH_SHORT).show()
    }
    fun onExitButtonClicked(view: View) {}
}
