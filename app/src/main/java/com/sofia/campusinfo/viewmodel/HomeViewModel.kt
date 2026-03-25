package com.sofia.campusinfo.viewmodel

import androidx.lifecycle.ViewModel
import com.sofia.campusinfo.model.Announcement

class HomeViewModel : ViewModel() {

    val announcements = listOf(
        Announcement(1, "Libur Nasional", "20 Mar 2026", "Penting", "Kampus libur total."),
        Announcement(2, "Kuliah Online", "21 Mar 2026", "Info", "Via Zoom."),
        Announcement(3, "Beasiswa Dibuka", "22 Mar 2026", "Penting", "Segera daftar."),
        Announcement(4, "Event Kampus", "23 Mar 2026", "Info", "Festival kampus."),
        Announcement(5, "Maintenance Sistem", "24 Mar 2026", "Info", "Server update.")
    )
}
