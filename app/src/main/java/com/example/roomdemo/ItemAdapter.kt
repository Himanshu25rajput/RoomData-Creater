package com.example.roomdemo

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.databinding.ItemsListBinding

class ItemAdapter(private var list:ArrayList<EmployeeEntity>,
                    private var updateListener:(id:Int)->Unit,
                  private var deleteListener:(id:Int)->Unit
):RecyclerView.Adapter<ItemAdapter.viewholder>() {

    class viewholder(binding: ItemsListBinding):RecyclerView.ViewHolder(binding.root) {

        val llMain = binding.llMain
        val tvname = binding.tvName
        val tvEmail = binding.tvEmail
        val ivEdit  = binding.ivEdit
        val ivDelete = binding.ivDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(ItemsListBinding.inflate
                                      (LayoutInflater.from(parent.context)
                                                   ,parent,false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val contex=holder.itemView.context
        val list=list[position]
        holder.tvname.text=list.name
        holder.tvEmail.text=list.email
        if (position %2==0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
            R.color.Lightgrey))
        }else{
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.white))
        }
        holder.ivEdit.setOnClickListener(){
            updateListener.invoke(list.id)
        }
        holder.ivDelete.setOnClickListener(){
            deleteListener.invoke(list.id)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }


}