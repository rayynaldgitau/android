package com.raynaldgitaz.augustmidmorningnavigationapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.raynaldgitaz.augustmidmorningnavigationapp.models.Product
import com.raynaldgitaz.augustmidmorningnavigationapp.navigation.ROUTE_LOGIN

class ProductRepository(navController: NavHostController, var context:Context) {
    var authRepository:AuthRepository
    var progress:ProgressDialog
    init{
        authRepository = AuthRepository(navController, context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun saveProduct(name:String, quantity:String, price:String){
        var id = System.currentTimeMillis().toString()
        var productData = Product(name, quantity,price,id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener{
            progress.dismiss()
            if(it.isSuccessful){
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun viewProducts(){

    }
    fun deleteProducts(){

    }
    fun updateProducts(){

    }
}