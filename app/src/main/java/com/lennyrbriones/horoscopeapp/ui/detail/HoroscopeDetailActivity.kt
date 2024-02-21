package com.lennyrbriones.horoscopeapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.lennyrbriones.horoscopeapp.R
import com.lennyrbriones.horoscopeapp.databinding.ActivityHoroscopeDetailBinding
import com.lennyrbriones.horoscopeapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs() //safe arg set
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI() //saving the type
        horoscopeDetailViewModel.getHoroscope(args.type.name)
    }

    private fun initUI() {
        initUIState()
        initUIListeners()

    }

    private fun initUIListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Error -> loadingState()

                        HoroscopeDetailState.Loading -> errorState()

                        is HoroscopeDetailState.Success -> successState(it)
                    }

                }
            }
        }
    }

    private fun successState(state : HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
    }

    private fun errorState() {
        binding.pb.isVisible = false

    }

    private fun loadingState() {
        binding.pb.isVisible = true

    }
}