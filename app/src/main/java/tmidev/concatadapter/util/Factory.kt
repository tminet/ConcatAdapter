package tmidev.concatadapter.util

import tmidev.concatadapter.R
import tmidev.concatadapter.domain.ProgrammingLanguage
import tmidev.concatadapter.domain.Tip

object Factory {
    fun createTipList() = listOf(
        Tip(
            id = 1,
            description = "This is a sample project using ConcatAdapter and DiffUtil."
        )
    )

    fun createProgrammingLanguageList() = listOf(
        ProgrammingLanguage(
            name = "Kotlin",
            description = "An open-source, statically-typed programming language that supports both object-oriented and functional programming",
            logo = R.drawable.logo_kotlin
        ),
        ProgrammingLanguage(
            name = "Java",
            description = "A widely used object-oriented programming language and software platform that runs on billions of devices",
            logo = R.drawable.logo_java
        ),
        ProgrammingLanguage(
            name = "Swift",
            description = "The programming language for iOS and OS X development",
            logo = R.drawable.logo_swift
        ),
        ProgrammingLanguage(
            name = "JavaScript",
            description = "A dynamic computer programming language",
            logo = R.drawable.logo_javascript
        ),
        ProgrammingLanguage(
            name = "PHP",
            description = "A server side scripting language that is embedded in HTML",
            logo = R.drawable.logo_php
        ),
        ProgrammingLanguage(
            name = "Python",
            description = "An interpreted, object-oriented, high-level programming language with dynamic semantics",
            logo = R.drawable.logo_python
        ),
        ProgrammingLanguage(
            name = "C#",
            description = "An object-oriented programming language that aims to combine the computing power of C++ with the programming ease of Visual Basic",
            logo = R.drawable.logo_c_sharp
        )
    )
}