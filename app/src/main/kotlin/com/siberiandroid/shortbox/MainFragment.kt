package com.siberiandroid.shortbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.siberiandroid.shortbox.navigation.NavDestination
import com.siberiandroid.shortbox.navigation.navigate
import com.siberiandroid.shortbox.navigation.navigationData

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // навигация с передачей данных
        navigate(NavDestination(1), Kek("lol"))

        // получение данных из навигации
        val kek = navigationData as Kek
    }
}