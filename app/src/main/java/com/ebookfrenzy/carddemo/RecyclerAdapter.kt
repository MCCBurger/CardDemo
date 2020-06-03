package com.ebookfrenzy.carddemo

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup:ViewGroup, i:Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder:ViewHolder, i:Int) {
       viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner  class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDetail:TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail=itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                v: View ->
                var position:Int = adapterPosition

                Snackbar.make(v,"Click detected on item $position",Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }



    }

    private val titles = arrayOf("Super Mario Bros","Excitebike","Mario Bros","Baseball", "Ghosts N Goblins","Pro Wrestling", "Commando", "Ice Climber")
    private val details = arrayOf("Item one details","Item two details","Item three details","Item four details","Item five details","Item six details","Item seven details","Item eight details")
    private val images = intArrayOf(R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight)


}