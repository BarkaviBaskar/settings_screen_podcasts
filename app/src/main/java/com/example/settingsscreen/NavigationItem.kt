package com.example.settingsscreen

import com.example.podcastssetting.R

sealed class NavigationItem(var route: String, var icon: Int, var label: String) {
    object Weather: NavigationItem("weather", R.drawable.baseline_wb_sunny_24, "Weather")
    object Radio: NavigationItem("radio", R.drawable.baseline_radio_24, "Radio")
    object Rosary : NavigationItem("rosary", R.drawable.baseline_add_circle_outline_24, "Rosary")
    object PodCasts : NavigationItem("podcasts", R.drawable.baseline_mic_none_24, "PodCasts")
    object Settings : NavigationItem("settings", R.drawable.baseline_settings_24, "Settings")
}
