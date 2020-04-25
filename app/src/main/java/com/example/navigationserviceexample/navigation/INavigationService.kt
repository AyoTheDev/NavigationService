/*
 * Copyright (C) Fluidic Analytics Limited, 2020.
 * All rights reserved.
 */

package com.example.navigationserviceexample.navigation

import android.content.Context
import android.os.Bundle

interface INavigationService {

    fun openExampleScreenOne(bundle: Bundle?)

    fun openExampleScreenTwo()

    fun attachToActivity(context: Context)

    fun detachFromActivity()

}