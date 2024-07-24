package com.example.androidtask.products.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.databinding.ItemProductBinding
import com.example.androidtask.databinding.ItemProductRvBinding
import com.example.domain.Model.ProductsItem
import kotlin.coroutines.coroutineContext

class ProductAdapter(private var products: List<ProductsItem>? = null) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    class MyViewHolder(val itemProductRvBinding: ItemProductRvBinding) :
        RecyclerView.ViewHolder(itemProductRvBinding.root) {
        fun bind(product: ProductsItem) {
            itemProductRvBinding.product = product
            itemProductRvBinding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(ItemProductRvBinding.inflate(
          LayoutInflater.from(parent.context),parent,false
      ))
    }

    override fun getItemCount(): Int =products?.size?:0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bind(products!![position])
    }
    fun bindProducts(products: List<ProductsItem>?){
        this.products = products
        notifyDataSetChanged()
    }
}