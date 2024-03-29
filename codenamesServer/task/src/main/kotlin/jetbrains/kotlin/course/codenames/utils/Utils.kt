package jetbrains.kotlin.course.codenames.utils

import jetbrains.kotlin.course.codenames.keyCard.KeyCardCell
import jetbrains.kotlin.course.codenames.keyCard.KeyCardType

fun interface KeyCardGenerator{
    fun generateData(): List<KeyCardCell>

}
object Utils {
    private const val N = 5
    const val TOTAL_NUMBER = N * N
    const val PINK_CARDS_NUMBER = 8
    const val VIOLET_CARDS_NUMBER = 9
    const val GRAY_CARDS_NUMBER = 7
    const val BLACK_CARDS_NUMBER = 1

    init {
        require(PINK_CARDS_NUMBER + VIOLET_CARDS_NUMBER + GRAY_CARDS_NUMBER + BLACK_CARDS_NUMBER == TOTAL_NUMBER) { "The total number in the game must be: $TOTAL_NUMBER" }
    }
    private val previousAttempts: MutableList<List<KeyCardCell>> = mutableListOf()
    val uniqueKeyCardGenerator= object:KeyCardGenerator {
        override fun generateData(): List<KeyCardCell>{
            val initialList = KeyCardType.values()
            val modifiedList = initialList.map { key -> List(key.number) { key } }
            val ls=modifiedList.flatten().map{KeyCardCell(it)}
            var shufld=ls.shuffled()
            while (previousAttempts.contains(shufld)){
                shufld=ls.shuffled()
            }
            previousAttempts.add(shufld)
            return shufld
        }
    }
}
