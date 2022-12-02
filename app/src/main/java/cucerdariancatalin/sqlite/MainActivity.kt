package cucerdariancatalin.sqlite

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import cucerdariancatalin.sqlite.adapter.CityAdapter
import cucerdariancatalin.sqlite.utils.Utils
import cucerdariancatalin.sqlite.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var cityListView: ListView
    private lateinit var adapter: CityAdapter
    private lateinit var viewModel: CityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityListView = findViewById(R.id.rvCityList)

        val factory = Utils.provideViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(CityViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        loadCities()
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        viewModel.closeDatabase(this)
        super.onDestroy()
    }

    private fun loadCities() {
        val cities = viewModel.loadCities(this)
        adapter = CityAdapter(this, cities)
        cityListView.adapter = adapter
    }
}
