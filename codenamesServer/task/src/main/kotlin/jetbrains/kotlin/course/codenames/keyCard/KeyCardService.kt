package jetbrains.kotlin.course.codenames.keyCard

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.codenames.utils.Utils
import jetbrains.kotlin.course.codenames.keyCard.KeyCard

@Service
class KeyCardService {
    fun generateKeyCard(): KeyCard = KeyCard(Utils.uniqueKeyCardGenerator.generateData())
}