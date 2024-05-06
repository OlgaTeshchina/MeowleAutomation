package ru.tinkoff.fintech.meowle.helpers

class Helpers {

    companion object {
        fun randomCyrillicString(length: Int): String {
            val cyrillicCharacters = ('А'..'я') + 'ё'
            return (1..length)
                .map { cyrillicCharacters.random() }
                .joinToString("")
        }

        fun getRandomName(): String {
            val name = randomCyrillicString(11)
            return name.take(1).uppercase() + name.takeLast(10).lowercase()
        }
    }
}

object Constants {
    const val APP_PCKG = "ru.tinkoff.fintech.meowle"
}