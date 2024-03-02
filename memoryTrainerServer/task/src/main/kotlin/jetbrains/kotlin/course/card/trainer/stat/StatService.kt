package jetbrains.kotlin.course.card.trainer.stat

import jetbrains.kotlin.course.card.trainer.card.Back
import org.springframework.stereotype.Service

@Service
class StatService {
    companion object{
        val history: MutableList<Stat> = mutableListOf()
    }
    fun getHistory(): MutableList<Stat> {
        return history.reversed().toMutableList()
    }

    fun save(knownBacks: List<String>, unknownBacks: List<String>): Unit {
        val new= Stat(knownBacks.map{ Back(it) }, unknownBacks.map{ Back(it)})
        history.add(new)
    }
}
