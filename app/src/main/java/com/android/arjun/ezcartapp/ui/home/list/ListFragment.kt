package com.android.arjun.ezcartapp.ui.home.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.arjun.ezcartapp.R
import com.android.arjun.ezcartapp.databinding.FragmentListBinding
import com.android.arjun.ezcartapp.utils.viewModelProvider
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment : DaggerFragment() {
    private lateinit var binding: FragmentListBinding

    private lateinit var viewModel: ListViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = viewModelProvider(viewModelFactory)
        binding =
            FragmentListBinding.bind(inflater.inflate(R.layout.fragment_list, container, false))
                .apply {
                    lifecycleOwner = this@ListFragment
                    viewModel = this@ListFragment.viewModel
                }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adap = CartRvAdap { cartItem ->
            findNavController().navigate(ListFragmentDirections.actionListToDetails(cartItem))
        }
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(false)
            this.adapter = adap
        }
        viewModel.cartItems.observe(viewLifecycleOwner, {
            if (it != null)
                adap.submitList(it.asList())
            viewModel.cartItems.removeObservers(this)
        })
        viewModel.loading.observe(viewLifecycleOwner, {
            binding.pb.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.toast.observe(viewLifecycleOwner, {
            Snackbar.make(requireContext(), binding.root, it, Snackbar.LENGTH_LONG).show()
        })
    }
}