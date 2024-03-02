package jetbrains.kotlin.course.words.generator.word

import jetbrains.kotlin.course.words.generator.util.words
import org.springframework.stereotype.Service

@Service
class WordService {
    companion object{
        val numberOfWords:Int = words.size
        val previousWords: MutableMap<String,MutableList<Word>> = mutableMapOf()
    }
    fun generateNextWord(): Word {
        require(words.isNotEmpty()){"No words left!"}
        val first=Word(words[0])
        words.removeFirst()
        return first
    }

    fun isValidWord(keyWord: String, newWord: String): Boolean {
        if(newWord.isEmpty()){
            return false
        }
        if (!newWord.all{keyWord.contains(it)}){
            return false
        }
        val newgroup=newWord.groupingBy{it}.eachCount()
        val keygroup=keyWord.groupingBy{it}.eachCount()

        if(newgroup.any{it.value > keygroup[it.key]!! }){
            return false
        }
        return true
    }

    fun isNewWord(keyWord: String, newWord: String): Boolean {
        if(!previousWords.contains(keyWord)){
            previousWords[keyWord]= mutableListOf(Word(newWord))
            return true
        }
        if(previousWords[keyWord]!!.contains(Word(newWord))){
            return false
        } else{
            previousWords[keyWord]!!.add(Word(newWord))
            return true
        }
    }
}
