package com.example.navigationserviceexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationserviceexample.navigation.INavigationService

class MainActivity : AppCompatActivity() {

    //todo inject with dagger
    lateinit var navigationService: INavigationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
