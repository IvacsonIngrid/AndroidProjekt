package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.USER_NAME
import com.example.bazaarandroid.viewmodels.*

class MyDetailProductFragment : Fragment() {
    lateinit var detailViewModel: MyMarketViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = MyMarketViewModelFactory(Repository())
        detailViewModel = ViewModelProvider(requireActivity()).get(MyMarketViewModel::class.java)

        Constants.PAGE = "myDetail"
        //Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_my_detail_product, container, false)

        val name: TextView = layout.findViewById(R.id.myName)
        val title: TextView = layout.findViewById(R.id.myTitle)
        val price: TextView = layout.findViewById(R.id.myPrice)
        val is_active: TextView = layout.findViewById(R.id.myActive)
        val description: TextView = layout.findViewById(R.id.myDescription)
        val t_i: TextView = layout.findViewById(R.id.total_items)
        val p_i: TextView = layout.findViewById(R.id.price_per_item)
        val s_i: TextView = layout.findViewById(R.id.selled_items)
        val r: TextView = layout.findViewById(R.id.revenew)

        val item: Product = detailViewModel.getItem()

        name.setText(USER_NAME)
        title.setText(item.title)

        val str: String = item.price_per_unit + item.price_type + "/" + item.amount_type
        price.setText(str)
        Log.d("xxx", "${price.text}")

        if(item.is_active == true)
        {
            is_active.setText("Active")
        }
        else
        {
            is_active.setText("Inactive")
        }

        description.setText(item.description)
        Log.d("xxx", "${description.text}")

        val str1: String = item.units + item.amount_type
        t_i.setText(str1)
        Log.d("xxx", "${t_i.text}")

        val str2: String = item.price_per_unit + item.price_type
        p_i.setText(str2)
        Log.d("xxx", "${p_i.text}")

        val str3: String = "0 " + item.amount_type
        s_i.setText(str3)
        Log.d("xxx", "${s_i.text}")

        val str4: String = "0 " + item.price_type
        r.setText(str4)
        Log.d("xxx", "${r.text}")

        //navigalas
        val buttonEdit: ImageButton = layout.findViewById(R.id.imageButton_edit)
        buttonEdit.setOnClickListener {
            //findNavController().navigate(R.id.action_myDetailProductFragment_to_detailPageScretchFragment)
            Toast.makeText(context,"${title.text} ${price.text} ${description.text} ${t_i.text} ${p_i.text}", Toast.LENGTH_LONG).show()
        }

        return layout
    }

}