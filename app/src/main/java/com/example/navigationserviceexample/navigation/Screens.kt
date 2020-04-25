/*
 * Copyright (C) Fluidic Analytics Limited, 2020.
 * All rights reserved.
 */

package com.example.navigationserviceexample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    /**
     * --------------------------------------------------------------------------
     * This is where you define your screens which return which ever fragment you're inflating
     * (replace with your fragments)
     * --------------------------------------------------------------------------
     */

    class ExampleScreenOne(private val bundle: Bundle?) : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            val fragment = Fragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    class ExampleScreenTwo : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return Fragment()
        }
    }

    /**
     * --------------------------------------------------------------------------
     * --------------------------------------------------------------------------
     */
}