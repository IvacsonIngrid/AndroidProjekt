package com.example.bazaarandroid.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bazaarandroid.R
import com.example.bazaarandroid.model.Orders
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.utils.Constants
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DataAdapter2(
    private var list: ArrayList<Orders>,
    private val context: Context,
    private val listener: OnItemClickListener,
    private val listener2: OnItemLongClickListener
) :
    RecyclerView.Adapter<DataAdapter2.DataViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener{
        fun onItemLongClick(position: Int)
    }

    // 1. user defined ViewHolder type - Embedded class!
    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {
        val textView_name: TextView = itemView.findViewById(R.id.textView_name_item_layout)
        val textView_price: TextView = itemView.findViewById(R.id.textView_price_item_layout)
        val textView_seller: TextView = itemView.findViewById(R.id.textView_seller_item_layout)
        val textView_amount: TextView = itemView.findViewById(R.id.amount)

        val button_accept: FloatingActionButton = itemView.findViewById(R.id.floatingActionButton3)
        val button_close: FloatingActionButton = itemView.findViewById(R.id.floatingActionButton4)


        init{
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }

        override fun onClick(p0: View?) {
            val currentPosition = this.adapterPosition
            listener.onItemClick(currentPosition)

        }

        override fun onLongClick(p0: View?): Boolean {
            val currentPosition = this.adapterPosition
            listener2.onItemLongClick(currentPosition)
            return true
        }
    }

    // 2. Called only a few times = number of items on screen + a few more ones
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.ongoind_sales, parent, false)

        /*val buttonProfile: TextView = itemView.findViewById(R.id.text_name)
        buttonProfile.setOnClickListener{
            Log.d("xxx", "navigate to forgot password")
            //findNavController()
        }*/

        return DataViewHolder(itemView)
    }


    // 3. Called many times, when we scroll the list
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentItem = list[position]

        holder.textView_name.text = currentItem.title
        holder.textView_price.text = currentItem.price_per_unit
        holder.textView_seller.text = currentItem.username
        holder.textView_amount.text = currentItem.units
    }

    override fun getItemCount() = list.size

    // Update the list
    fun setData(newlist: ArrayList<Orders>){
        list = newlist
    }


}

