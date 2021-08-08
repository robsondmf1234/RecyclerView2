package com.example.searchviewwithrecycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItens(model: Model) {
            itemView.titleTv.text = model.title
            itemView.descriptionTv.text = model.des
            itemView.imageTv.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItens(arrayList[position])

        holder.itemView.setOnClickListener {

            val model = arrayList.get(position)
            var gTitle :String = model.title
            var gDescription:String = model.des
            var gImageView:Int = model.image

            val intent = Intent(context,AnotherActivity::class.java)

            intent.putExtra("iTitle",gTitle)
            intent.putExtra("iDescription",gDescription)
            intent.putExtra("iImageView",gImageView)

            context.startActivity(intent)

            }
        }
    }
