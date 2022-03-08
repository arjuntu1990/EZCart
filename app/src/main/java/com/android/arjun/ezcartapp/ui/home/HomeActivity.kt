package com.android.arjun.ezcartapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.android.arjun.ezcartapp.R
import com.android.arjun.ezcartapp.ui.auth.AuthActivity
import com.android.arjun.shared.data.PreferenceStorage
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var preferenceStorage: PreferenceStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            preferenceStorage.clearAll()
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
        return true
    }
}