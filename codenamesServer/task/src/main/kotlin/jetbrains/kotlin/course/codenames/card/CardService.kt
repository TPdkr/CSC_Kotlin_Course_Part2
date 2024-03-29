package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils.TOTAL_NUMBER
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card> {
        require(words.size>=TOTAL_NUMBER){"error message"}
        words=words.shuffled()
        val new=words.take(TOTAL_NUMBER).map{Card(WordCardData(it),CardState.Front)}
        words=words.drop(TOTAL_NUMBER)
        return new
    }
}
