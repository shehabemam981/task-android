package com.example.androidtask.products
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Model.ProductsItem
import com.example.domain.UseCase
import com.example.domain.common.Resources
import com.example.routee_commerce.base.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ViewModelProducts @Inject constructor(val useCase: UseCase):ViewModel() {
    val products = MutableLiveData<List<ProductsItem>>()
    val progreesbar = MutableLiveData<Boolean>()
    val viewMessage = MutableLiveData<ViewMessage>()
    fun getProducts (){
     viewModelScope.launch{
         useCase.Invoke().collect{
              when(it){
                  Resources.Loading -> progreesbar.postValue(true)
                  is Resources.NetworkError ->viewMessage.postValue(ViewMessage(it.error.message.toString()))
                  is Resources.Success -> products.postValue(it.data)
                  is Resources.serverErrors -> viewMessage.postValue(ViewMessage(it.errors.message.toString()))
              }
         }
     }

    }
}