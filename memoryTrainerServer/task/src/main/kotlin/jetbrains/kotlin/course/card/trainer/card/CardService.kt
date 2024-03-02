package jetbrains.kotlin.course.card.trainer.card

import jetbrains.kotlin.course.card.trainer.util.countries
import org.springframework.stereotype.Service

@Service
class CardService {
    companion object {
        val randomCardGenerator= object:CardSequenceGenerator{
            override fun generateCards(): List<Card>{
                val lst= countries.map{Card(Front(it.key), Back(it.value))}
                return lst.shuffled()
            }
        }
        private fun generateNewCardsSequence(): MutableList<Card> = randomCardGenerator.generateCards().toMutableList()
        var cards= generateNewCardsSequence()
    }
    fun getNextCard(): Card {
        require(cards.isNotEmpty()){"can't take element from empty"}
        val first=cards[0]
        cards.removeFirst()
        return first
    }

    fun startNewGame(): Card {
        cards= generateNewCardsSequence()
        return getNextCard()
    }
}
