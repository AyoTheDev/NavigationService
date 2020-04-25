/*
 * Copyright (C) Fluidic Analytics Limited, 2020.
 * All rights reserved.
 */

package com.example.navigationserviceexample.navigation

import android.content.Context
import android.os.Bundle
import com.example.navigationserviceexample.MainActivity
import com.example.navigationserviceexample.R
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen

//todo should use dagger for injection
class NavigationService(cicerone : Cicerone<Router>) : INavigationService {

    private val router: Router = cicerone.router
    private val navigatorHolder: NavigatorHolder = cicerone.navigatorHolder


    override fun openExampleScreenOne(bundle: Bundle?) {
        replaceScreen(Screens.ExampleScreenOne(bundle))
    }

    override fun openExampleScreenTwo() {
        replaceScreen(Screens.ExampleScreenTwo())
    }


    override fun attachToActivity(context: Context) {
        context as MainActivity
        navigatorHolder.setNavigator(SupportAppNavigator(context, R.id.main_screen))
    }

    override fun detachFromActivity() {
        navigatorHolder.removeNavigator()
    }

    private fun replaceScreen(screen: SupportAppScreen) {
        router.replaceScreen(screen)
    }

}