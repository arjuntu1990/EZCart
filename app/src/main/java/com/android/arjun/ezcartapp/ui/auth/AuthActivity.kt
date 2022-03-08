package com.android.arjun.ezcartapp.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.arjun.ezcartapp.R
import com.android.arjun.ezcartapp.ui.auth.login.ActivityInteractor
import com.android.arjun.ezcartapp.ui.home.HomeActivity
import dagger.android.support.DaggerAppCompatActivity

class AuthActivity : AppCompatActivity(), ActivityInteractor {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }

    override fun goToListActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}