package tmidev.concatadapter.domain

import androidx.annotation.DrawableRes

data class ProgrammingLanguage(
    val name: String,
    val description: String,
    @DrawableRes val logo: Int
)