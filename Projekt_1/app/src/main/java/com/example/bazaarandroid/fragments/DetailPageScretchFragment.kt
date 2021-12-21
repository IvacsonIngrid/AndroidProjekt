package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaarandroid.R
import com.example.bazaarandroid.adapters.DataAdapter
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.EMAIL
import com.example.bazaarandroid.utils.Constants.PHONE_NUMBER
import com.example.bazaarandroid.utils.Constants.USER_NAME
import com.example.bazaarandroid.viewmodels.DetailScretchViewModel
import com.example.bazaarandroid.viewmodels.DetailScretchViewModelFactory
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class DetailPageScretchFragment : Fragment() {
    lateinit var detailScretchViewModel: DetailScretchViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("xxx", "Valtozok megvannak")

        val factory = DetailScretchViewModelFactory(this.requireContext(), Repository())
        Log.d("xxx", "Factory megvan")

        detailScretchViewModel = ViewModelProvider(this, factory).get(DetailScretchViewModel::class.java)
        Log.d("xxx", "Provider megvan")

        //Constants.PAGE = "detailProductAdd"
        //Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_detail_page_scretch, container, false)
        Log.d("xxx", "Layout megvan")

        //drop-down lists
        val price = resources.getStringArray(R.array.price)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_menu, price)

        var k = layout.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        k.setAdapter(arrayAdapter)


        val amount = resources.getStringArray(R.array.amount)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.drop_down_menu, amount)

        var k2 = layout.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_2)
        k2.setAdapter(arrayAdapter2)

        Log.d("xxx", "Drop-down listak megvannak")

        //adatok lekerese
        val editText_title: TextInputEditText = layout.findViewById(R.id.textInputEdit_title)
        val editText_price: TextInputEditText = layout.findViewById(R.id.textInputEdit_price)
        val editText_amount: TextInputEditText = layout.findViewById(R.id.textInputEdit_amount)
        val editText_description: TextInputEditText = layout.findViewById(R.id.textInputEdit_description)
        val editText_name: TextInputEditText = layout.findViewById(R.id.textInputEdit_name)
        val editText_email: TextInputEditText = layout.findViewById(R.id.textInputEdit_email)
        val editText_phone_number: TextInputEditText = layout.findViewById(R.id.textInputEdit_phone_number)

        Log.d("xxx", "Id lekerdezesek megvannak")

        editText_name.setText(USER_NAME)
        Log.d("xxx", "Username beallitva")

        editText_email.setText(EMAIL)
        Log.d("xxx", "Email beallitva")

        //editText_phone_number.setText(PHONE_NUMBER)

        val dropDown1: AutoCompleteTextView = layout.findViewById(R.id.autoCompleteTextView)
        val dropDown2: AutoCompleteTextView = layout.findViewById(R.id.autoCompleteTextView_2)

        //ha kozze teszem
        val button: Button = layout.findViewById(R.id.button_launch_my_fair)
        button.setOnClickListener {
            detailScretchViewModel.product.value.let {
                if (it != null) {
                    it.title = editText_title.text.toString()
                    Log.d("xxx", "Title -> String:")
                }
                if (it != null) {
                    it.price_per_unit = editText_price.text.toString()
                    Log.d("xxx", "Price -> String:")
                }
                if (it != null) {
                    it.units = editText_amount.text.toString()
                    Log.d("xxx", "Amount -> String:")
                }
                if (it != null) {
                    it.description = editText_description.text.toString()
                    Log.d("xxx", "Description -> String:")
                }
                if (it != null) {
                    it.price_type = dropDown1.text.toString()
                    Log.d("xxx", "price_type -> String:")
                }
                if (it != null) {
                    it.amount_type = dropDown2.text.toString()
                    Log.d("xxx", "amount_type -> String:")
                }

            }
            lifecycleScope.launch {
                detailScretchViewModel.addProduct()
                if (Constants.ERROR != 2)
                {
                    Log.d("xxx", "Meg volt az elem hozzaadasa:")
                }
                else
                {
                    Log.d("xxx", "Nincs Hozzaadas:")
                }
            }

        }

        return layout
    }
}