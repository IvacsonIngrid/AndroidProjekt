package com.example.bazaarandroid.fragments

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.service.controls.actions.FloatAction
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaarandroid.R
import com.example.bazaarandroid.adapters.DataAdapter
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.EMAIL
import com.example.bazaarandroid.utils.Constants.ERROR
import com.example.bazaarandroid.utils.Constants.PHONE_NUMBER
import com.example.bazaarandroid.utils.Constants.USER_NAME
import com.example.bazaarandroid.viewmodels.DetailScretchViewModel
import com.example.bazaarandroid.viewmodels.DetailScretchViewModelFactory
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class DetailPageScretchFragment : Fragment() {
    lateinit var detailScretchViewModel: DetailScretchViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: DataAdapter

    lateinit var filepath: Uri

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

        //kep
        val button_image: FloatingActionButton = layout.findViewById(R.id.floatingActionButton)

        button_image.setOnClickListener {
            startFileChooser()
        }

        //inactive/active
        val switch: Switch = layout.findViewById(R.id.switch1)

        //adatok
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

        var number = PHONE_NUMBER.toString()
        editText_phone_number.setText(number)
        Log.d("xxx", "Telefonszam beallitva")

        val dropDown1: AutoCompleteTextView = layout.findViewById(R.id.autoCompleteTextView)
        val dropDown2: AutoCompleteTextView = layout.findViewById(R.id.autoCompleteTextView_2)

        //ha kozze teszem
        val button: Button = layout.findViewById(R.id.button_launch_my_fair)
        button.setOnClickListener {
            detailScretchViewModel.product.value.let {
                if (it != null) {
                    if(editText_title.text.toString() == "")
                    {
                        val helperText: TextInputLayout = layout.findViewById(R.id.textInputLayout_title)
                        helperText.helperText = "Your fair needs to have a title"
                        ERROR = 3
                    }
                    else
                    {
                        it.title = editText_title.text.toString()
                        Log.d("xxx", "Title -> String: ${editText_title.text.toString()}")
                    }

                    if(editText_price.text.toString() == "")
                    {
                        val helperText: TextInputLayout = layout.findViewById(R.id.textInputLayout_price)
                        helperText.helperText = "Give your fare a fair price"
                        ERROR = 3
                    }
                    else
                    {
                        it.price_per_unit = editText_price.text.toString()
                        Log.d("xxx", "Price -> String: ${editText_price.text.toString()}")
                    }

                    if(editText_amount.text.toString() == "")
                    {
                        val helperText: TextInputLayout = layout.findViewById(R.id.textInputLayout_amount)
                        helperText.helperText = "Select an amount"
                        ERROR = 3
                    }
                    else
                    {
                        it.units = editText_amount.text.toString()
                        Log.d("xxx", "Amount -> String: ${editText_amount.text.toString()}")
                    }

                    if(editText_description.text.toString() == "")
                    {
                        val helperText: TextInputLayout = layout.findViewById(R.id.textInputLayout_description)
                        helperText.helperText = "Describe your product"
                        ERROR = 3
                    }
                    else
                    {
                        it.description = editText_description.text.toString()
                        Log.d("xxx", "Description -> String: ${editText_description.text.toString()}")
                    }

                    it.price_type = dropDown1.text.toString()
                    Log.d("xxx", "price_type -> String: ${dropDown1.text.toString()}")

                    it.amount_type = dropDown2.text.toString()
                    Log.d("xxx", "amount_type -> String: ${dropDown2.text.toString()}")

                    it.is_active = switch.isActivated
                    Log.d("xxx", "is_active -> Boolean: ${switch.isActivated}")
                }
            }

            if(ERROR != 3) {
                lifecycleScope.launch {
                    detailScretchViewModel.addProduct()
                    if (ERROR != 2) {
                        Log.d("xxx", "Meg volt az elem hozzaadasa:")
                        Toast.makeText(context,"You have successfully added an item!", Toast.LENGTH_SHORT).show()
                        ERROR = 4 //most mar nezhetem a reszleteket
                    } else {
                        Log.d("xxx", "Nincs Hozzaadas:")
                        Toast.makeText(context,"Failed to add an item!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else
            {
                Log.d("xxx", "Nincs Hozzaadas: ures mezo miatt")
                Toast.makeText(context,"Failed to add an item!", Toast.LENGTH_SHORT).show()
            }
        }

        val button2: Button = layout.findViewById(R.id.button_preview_my_fair)
        button2.setOnClickListener {
            if(ERROR == 4)
            {
                findNavController().navigate(R.id.action_detailPageScretchFragment_to_myDetailProductFragment)
            }
            else
            {
                Toast.makeText(context,"Firstly launch your fare!", Toast.LENGTH_SHORT).show()
            }
        }

        return layout
    }

    private fun startFileChooser() {
        var i = Intent()
        i.setType("image/*")
        i.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(i, "Choose Picture!"), 111)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == Activity.RESULT_OK && data != null)
        {
            filepath = data.data!!

            //var bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            //imageView.setImage(bitmap)
        }
    }
}