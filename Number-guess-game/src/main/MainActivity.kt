import kotlin.random.Random

class GuessingGame(private val player1: Player, private val player2: Player) {
    private val secretNumber: Int = Random.nextInt(101)

    fun play() {
        println("${player1.name}, it's your turn to guess the number.")
        val player1Attempts = playTurn(player1)
        println("${player1.name} guessed the number in ${player1Attempts.size} attempts.")

        println("Now it's ${player2.name}'s turn to guess the number.")
        val player2Attempts = playTurn(player2)
        println("${player2.name} guessed the number in ${player2Attempts.size} attempts.")

        val player1Score = player1Attempts.size
        val player2Score = player2Attempts.size

        when {
            player1Score < player2Score -> println("${player1.name} wins!")
            player1Score > player2Score -> println("${player2.name} wins!")
            else -> println("It's a tie!")
        }
    }

    private fun playTurn(player: Player): MutableList<Int> {
        val attempts = mutableListOf<Int>()
        var guess: Int
        do {
            guess = player.guess()
            attempts.add(guess)
            val message = if (guess < secretNumber) "${player.name}'s guess is too low."
            else if (guess > secretNumber) "${player.name}'s guess is too high."
            else "Congratulations, ${player.name}! You guessed the number."
            println(message)
        } while (guess != secretNumber)
        return attempts
    }
}

interface Player {
    val name: String
    fun guess(): Int
}

class HumanPlayer(override val name: String) : Player {
    override fun guess(): Int {
        println("$name, please enter your guess: ")
        return readLine()?.toIntOrNull() ?: run {
            println("Invalid input. Please enter a valid number.")
            guess()
        }
    }
}

class ComputerPlayer(override val name: String = "Computer") : Player {
    private val unsuccessfulGuesses = mutableSetOf<Int>()

    override fun guess(): Int {
        var guess: Int
        do {
            guess = Random.nextInt(101)
        } while (guess in unsuccessfulGuesses)
        return guess
    }

    fun addUnsuccessfulGuess(guess: Int) {
        unsuccessfulGuesses.add(guess)
    }
}

fun main() {
    val player1 = HumanPlayer("Player 1")
    val player2 = ComputerPlayer()

    val game = GuessingGame(player1, player2)
    game.play()
}
