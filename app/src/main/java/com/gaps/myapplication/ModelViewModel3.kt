package com.gaps.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.gaps.myapplication.data.RemoteServices
import com.gaps.myapplication.data.local.ModelDao
import com.gaps.myapplication.data.remote.ModelService
import com.gaps.myapplication.models.BaseModel
import com.gaps.myapplication.models.LocalModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ModelViewModel3(
    private val persistence: ModelDao
) : ViewModel() {

    fun insertModel(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            persistence.insertModel(LocalModel(
                data = text,
                id = 0
            ))
        }
    }

}

@Suppress("UNCHECKED_CAST")
class ModelViewModelFactory3(private val persistence: ModelDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ModelViewModel3(persistence) as T
    }
}