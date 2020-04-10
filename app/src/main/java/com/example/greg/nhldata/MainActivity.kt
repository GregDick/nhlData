package com.example.greg.nhldata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.greg.nhldata.ui.main.fragment.LeagueFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LeagueFragment.newInstance())
                    .commitNow()
        }
    }
}
