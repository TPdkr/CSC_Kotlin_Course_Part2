package jetbrains.kotlin.course.alias

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

typealias Identifier= Int
class IdentifierFactory(private var counter: Identifier=0){
    fun uniqueIdentifier():Identifier = counter++
}

@SpringBootApplication
class AliasApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<AliasApplication>(*args)
}

