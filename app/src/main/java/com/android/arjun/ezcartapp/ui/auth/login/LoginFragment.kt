package com.android.arjun.ezcartapp.ui.auth.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.android.arjun.ezcartapp.R
import com.android.arjun.ezcartapp.databinding.FragmentLoginBinding
import com.android.arjun.ezcartapp.ui.home.HomeActivity
import com.android.arjun.ezcartapp.ui.home.list.ListViewModel
import com.android.arjun.ezcartapp.utils.INVALID_PASSWORD
import com.android.arjun.ezcartapp.utils.INVALID_USER_ID
import com.android.arjun.ezcartapp.utils.viewModelProvider
import com.android.arjun.shared.data.PreferenceStorage
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import java.lang.Exception
import javax.inject.Inject


class LoginFragment : DaggerFragment() {
    private lateinit var binding: FragmentLoginBinding
    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by viewModels { viewModelFactory }

    private lateinit var activityInteractor: ActivityInteractor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (viewModel.userLoggedIn()) {
            startHomeActivity()
            return null
        }
        binding =
            FragmentLoginBinding.bind(inflater.inflate(R.layout.fragment_login, container, false))
                .apply {
                    viewModel = this@LoginFragment.viewModel
                    lifecycleOwner = this@LoginFragment
                }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ActivityInteractor) activityInteractor = context
        else throw Exception(getString(R.string.activity_interactor_is_not_implemented_by_auth_activity))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewModel.toast.observe(viewLifecycleOwner, {
            val msg = when(it) {
                INVALID_USER_ID -> getString(R.string.enter_a_valid_user_id)
                INVALID_PASSWORD -> getString(R.string.enter_a_valid_password)
                else -> it
            }
            Snackbar.make(requireContext(), binding.root, msg, Snackbar.LENGTH_LONG).show()
        })
        viewModel.loginResp.observe(viewLifecycleOwner, {
            startHomeActivity()
        })
    }

    private fun startHomeActivity() {
        activityInteractor.goToListActivity()
    }
}