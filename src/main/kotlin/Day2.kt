data class Draw(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
)

typealias Game = Draw

fun List<Game>.sumIdsCompliantTo(game: Game): Int =
    mapIndexed { i, g ->
        if (g.compliesTo(game)) {
            i + 1
        } else {
            0
        }
    }.sum()

private fun Game.compliesTo(game: Game): Boolean =
    red <= game.red && green <= game.green && blue <= game.blue

private fun Iterable<Game>.maxOfAllGames(): Game =
    reduce { game, nextGame ->
        game.copy(
            red = maxOf(game.red, nextGame.red),
            green = maxOf(game.green, nextGame.green),
            blue = maxOf(game.blue, nextGame.blue),
        )
    }

fun String.toMaxGame(): Game {
    val withoutGame = split(": ").drop(1).first()
    val draws = withoutGame.split("; ")
    return draws
        .map { it.toDraw() }
        .maxOfAllGames()
}

fun Game.power(): Int = red * green * blue

fun String.toDraw(): Draw = split(", ")
    .flatMap { it.split(" ") }
    .chunked(2)
    .map { it[0] to it[1] }
    .fold(Draw()) { draw, pair ->
        when (pair.second) {
            "red" -> draw.copy(red = pair.first.toInt())
            "blue" -> draw.copy(blue = pair.first.toInt())
            "green" -> draw.copy(green = pair.first.toInt())
            else -> throw IllegalArgumentException()
        }
    }