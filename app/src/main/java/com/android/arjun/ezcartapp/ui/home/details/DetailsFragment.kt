package com.android.arjun.ezcartapp.ui.home.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.android.arjun.ezcartapp.R
import com.android.arjun.ezcartapp.databinding.FragmentDetailsBinding
import com.android.arjun.ezcartapp.ui.home.list.ListViewModel
import com.android.arjun.ezcartapp.utils.viewModelProvider
import com.android.arjun.shared.db.CartItem
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailsFragment : DaggerFragment() {
    private lateinit var binding: FragmentDetailsBinding

    private lateinit var viewModel: DetailsViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = viewModelProvider(viewModelFactory)
        binding = FragmentDetailsBinding.bind(
            inflater.inflate(
                R.layout.fragment_details,
                container,
                false
            )
        ).apply {
            lifecycleOwner = this@DetailsFragment
            viewModel = this@DetailsFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cartItem = arguments?.getParcelable<CartItem>("cartItem")!!
    }
}