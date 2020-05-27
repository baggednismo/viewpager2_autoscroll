package com.devinmartinolich.viewpager2autoscroll.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devinmartinolich.viewpager2autoscroll.R
import com.devinmartinolich.viewpager2autoscroll.models.UpdatesSeriesModel
import kotlinx.android.synthetic.main.fragment_updates.view.*

class ViewPagerAdapter(private val updatesData: List<UpdatesSeriesModel>) : RecyclerView.Adapter<UpdatesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdatesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UpdatesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: UpdatesViewHolder, position: Int) {
        if (position % 2 == 0) holder.itemView.background_circle_ko.visibility = View.VISIBLE
        else holder.itemView.background_circle.visibility = View.VISIBLE
        holder.bind(updatesData[position])
    }

    override fun getItemCount() = updatesData.size
}

class UpdatesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_updates, parent, false)) {
    private var title: TextView? = null
    private var subtitle: TextView? = null
    private var description: TextView? = null
    private var image: ImageView? = null

    init {
        title = itemView.findViewById(R.id.title)
        subtitle = itemView.findViewById(R.id.subtitle)
        description = itemView.findViewById(R.id.description)
        image = itemView.findViewById(R.id.screenshot)
    }

    fun bind(dataModel: UpdatesSeriesModel) {
        itemView.title.text = dataModel.title
        itemView.subtitle.text = dataModel.subtitle
        itemView.description.text = dataModel.description
        itemView.screenshot.setImageResource(dataModel.image)
    }

}