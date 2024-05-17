package com.example.runandtrack.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.runandtrack.data.repos.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(repository: MainRepository) : ViewModel() {

    val totaltimeRun = repository.getTotalTimeInMillis()
    val totalDistance = repository.getTotalDistance()
    val totalCaloriesBurned = repository.getTotalCaloriesBurned()
    val totalAvgSpeed = repository.getTotalAvgSpeed()

}