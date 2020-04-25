/*
 * Copyright (C) Fluidic Analytics Limited, 2020.
 * All rights reserved.
 */

package com.example.navigationserviceexample

import com.example.navigationserviceexample.navigation.INavigationService
import com.example.navigationserviceexample.navigation.NavigationService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen


class NavigationServiceTest {

    private lateinit var underTest: INavigationService


    @Mock
    lateinit var router: Router

    @Mock
    lateinit var navigatorHolder: NavigatorHolder

    @Mock
    lateinit var cicerone: Cicerone<Router>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        `when`<Router>(cicerone.router).thenReturn(router)
        `when`<NavigatorHolder>(cicerone.navigatorHolder).thenReturn(navigatorHolder)
        underTest = NavigationService(cicerone)
    }

    @Test
    fun `open example screen one`() {
        //given
        val expectedScreenKey = ".ExampleScreenOne"
        val argument: ArgumentCaptor<SupportAppScreen> =
            ArgumentCaptor.forClass(SupportAppScreen::class.java)

        //when
        underTest.openExampleScreenOne(null)

        //then
        verify(router).replaceScreen(argument.capture())
        assertEquals(expectedScreenKey, argument.value.screenKey)

    }
}