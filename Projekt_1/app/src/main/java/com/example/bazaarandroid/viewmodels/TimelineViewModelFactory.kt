package com.example.bazaarandroid.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.bazaarandroid.repository.Repository

class TimelineViewModelFactory(private val repository: Repository) : Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TimelineViewModel(repository) as T
    }
}