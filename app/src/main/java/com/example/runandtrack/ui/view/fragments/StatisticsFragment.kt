package com.example.runandtrack.ui.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runandtrack.R
import com.example.runandtrack.databinding.FragmentStatisticsBinding
import com.example.runandtrack.ui.viewmodel.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import kotlin.math.round


@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private lateinit var binding: FragmentStatisticsBinding
    private val viewModel: StatisticsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatisticsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
    }

    private fun subscribeToObservers() {

        viewModel.totaltimeRun.observe(viewLifecycleOwner) { timeInMillis ->
            timeInMillis?.let {
                var milliseconds = timeInMillis
                val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
                milliseconds -= TimeUnit.HOURS.toMillis(hours)
                val minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
                milliseconds -= TimeUnit.MINUTES.toMillis(minutes)

                val totalTimeRun = "${hours}h ${minutes}m"
                if (hours < 10) binding.tvTime.text = totalTimeRun
                else "${hours}h".also { binding.tvTime.text = it }

            }
        }

        viewModel.totalDistance.observe(viewLifecycleOwner) {
            it?.let {
                val km = it / 1000f
                val totalDistance = round(km * 10f) / 10f
                binding.tvDistance.text = "$totalDistance"
            }
        }

        viewModel.totalCaloriesBurned.observe(viewLifecycleOwner) {
            it?.let {
                binding.tvCalorie.text = "$it"
            }
        }

        viewModel.totalAvgSpeed.observe(viewLifecycleOwner) {
            it?.let {
                val avgSpeed = round(it * 10f) / 10f
                binding.tvSpeed.text = "$avgSpeed"
            }
        }


    }

}