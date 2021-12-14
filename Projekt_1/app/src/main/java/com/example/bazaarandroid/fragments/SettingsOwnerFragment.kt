package com.example.bazaarandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bazaarandroid.R
import com.example.bazaarandroid.utils.Constants.USER_NAME


class SettingsOwnerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inf: View = inflater.inflate(R.layout.fragment_settings_owner, container, false)
        val tv = inf.findViewById<View>(R.id.textView_name) as TextView
        tv.text = USER_NAME
        return inf
    }
}