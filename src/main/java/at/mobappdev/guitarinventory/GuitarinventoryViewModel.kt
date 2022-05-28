package at.mobappdev.guitarinventory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuitarinventoryViewModel : ViewModel() {

    val guitarList = MutableLiveData<MutableList<Guitar>>()
    var product    = MutableLiveData<String>()
    var style      = MutableLiveData<String>()
    var strings    = MutableLiveData<String>()
    var description = MutableLiveData<String>()

    fun addGuitar(){
        var pGuitar = Guitar(product.toString(), strings.toString(), style.toString(), description.toString())

        guitarList.value?.add(pGuitar)
        guitarList.value = guitarList.value
    } // end fun addGuitar()

    init {
        guitarList.value = ArrayList()
    }// end init

} // end class GuitarInventoryViewModel

