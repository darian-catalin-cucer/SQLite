package cucerdariancatalin.sqlite.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import cucerdariancatalin.sqlite.R
import cucerdariancatalin.sqlite.model.CityModel

class CityAdapter(private val context: Context, private val cities: ArrayList<CityModel>?) : BaseAdapter() {
    class ViewHolder(itemView: View) {
        var city = itemView.findViewById<TextView>(R.id.tv_city)!!
        var country = itemView.findViewById<TextView>(R.id.tv_country)!!
        var population = itemView.findViewById<TextView>(R.id.tv_population)!!
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view : View?
        var viewHolder : ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        val city : CityModel = getItem(position) as CityModel
        viewHolder.city.text = city.city
        viewHolder.country.text = city.country
        viewHolder.population.text = city.population.toString()
        return view
    }

    override fun getItem(position: Int): Any {
        return cities!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cities?.size as Int
    }
}