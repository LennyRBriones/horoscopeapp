package com.lennyrbriones.horoscopeapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//avoiding to use values not in strings or drawable
data class LuckyModel (
    @DrawableRes val image:Int,
    @StringRes val text:Int
)