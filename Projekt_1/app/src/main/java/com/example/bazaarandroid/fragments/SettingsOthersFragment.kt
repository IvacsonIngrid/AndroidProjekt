package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bazaarandroid.R
import com.example.bazaarandroid.model.Product
import com.example.bazaarandroid.model.User
import com.example.bazaarandroid.repository.Repository
import com.example.bazaarandroid.utils.Constants
import com.example.bazaarandroid.utils.Constants.PAGE
import com.example.bazaarandroid.viewmodels.TimelineViewModel
import com.example.bazaarandroid.viewmodels.TimelineViewModelFactory

class SettingsOthersFragment : Fragment() {
    var user = MutableLiveData<User>()
    private lateinit var viewModel: TimelineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(TimelineViewModel::class.java)

        PAGE = "settingsOther"
        Log.d("xxx", "Page := $PAGE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_settings_others, container, false)
        Log.d("xxx", "Atvette a layout-ot")

        val email: EditText = layout.findViewById(R.id.text_emailU)
        val name: EditText = layout.findViewById(R.id.text_nameU)
        val phone_number: EditText = layout.findViewById(R.id.text_phoneU)
        Log.d("xxx", "Lekerdezte az editBoxokat")

        val item: Product = viewModel.getName()
        Log.d("xxx", "Lekerte az elemet")

        name.setText(item.username)
        Log.d("xxx", "Beallitotta a nevet")

        return layout
    }
}