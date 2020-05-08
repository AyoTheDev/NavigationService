package com.example.navigationserviceexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationserviceexample.databinding.ActivityMainBinding
import com.example.navigationserviceexample.navigation.INavigationService
import com.example.navigationserviceexample.navigation.NavigationService
import ru.terrakok.cicerone.Cicerone

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val navigationService: INavigationService = NavigationService(Cicerone.create())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        navigationService.openExampleScreenOne(null)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationService.attachToActivity(this)
    }

    override fun onPause() {
        navigationService.detachFromActivity()
        super.onPause()
    }

}
