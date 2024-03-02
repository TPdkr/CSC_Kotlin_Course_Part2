package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service
typealias GameResult=List<Team>
@Service
class GameResultsService {
    companion object{
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }
    fun saveGameResults(result: GameResult): Unit {
        require(result.isNotEmpty() && result.all{TeamService.teamsStorage.contains(it.id)})
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}

