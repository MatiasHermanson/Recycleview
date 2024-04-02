package com.example.recycleview

import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.Data.Companion.details
import com.example.recycleview.Data.Companion.images
import com.example.recycleview.Data.Companion.titles
import kotlin.random.Random

class RecyclerAdapter (titles: Array<String>, details: Array<String>, images: Array<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var dataBind = Data()
    private var titles = titles
    private var details = details
    private var images = images

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = dataBind.titles[Random.nextInt(0, dataBind.titles.size)]
        viewHolder.itemDetail.text = dataBind.details[Random.nextInt(0, dataBind.details.size)]
        viewHolder.itemImage.setImageResource(dataBind.images[Random.nextInt(0,dataBind.images.size)])
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataBind.titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                val position: Int = getAdapterPosition()
                val title: String = titles[position]
                val detail: String = details[position]
                val image: Int = images[position]
                val itemTitle = title
                val itemDetail = detail
                val itemImage = image

                val imageProps = TypedValue()
                this.itemImage.resources.getValue(image, imageProps, true)
            }
        }
    }
}
