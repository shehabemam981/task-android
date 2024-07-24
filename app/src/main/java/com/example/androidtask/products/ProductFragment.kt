package com.example.androidtask.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidtask.databinding.FragmentProductBinding
import com.example.androidtask.products.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    var _fragmentProductBinding:FragmentProductBinding? =null
    val fragmentProductBinding:FragmentProductBinding get() = _fragmentProductBinding!!
   private val pviewModel:ViewModelProducts by viewModels<ViewModelProducts>()

   var productAdapter = ProductAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _fragmentProductBinding =
           FragmentProductBinding.inflate(layoutInflater,container,false)
    return  fragmentProductBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    initRv()
        pviewModel.getProducts()
        observeData()
    }

    private fun observeData() {
   pviewModel.products.observe(viewLifecycleOwner){
       it.let {
           fragmentProductBinding.productShimmer.isGone = true
           productAdapter.bindProducts(it)
       }
   }
    }

    private fun initRv() {
        fragmentProductBinding.rvProducts.adapter = productAdapter
    }

    override fun onDestroy() {
        _fragmentProductBinding = null
        super.onDestroy()
    }

}