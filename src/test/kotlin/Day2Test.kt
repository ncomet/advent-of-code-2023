import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import kotlin.streams.asSequence

class Day2Test {
    @Test
    fun `toDraw should convert a Draw`() {
        "5 blue, 4 red, 13 green".toDraw() shouldBeEqual Draw(red = 4, green = 13, blue = 5)
    }

    @Test
    fun `toMaxGame should maxBy colors and return the Game`() {
        val maxGame = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
            .toMaxGame()

        maxGame shouldBeEqual Game(red = 20, green = 13, blue = 6)
    }

    @Test
    fun `Should get sum of possible Ids given a Game objective on sample`() {
        val allGames = object {}.javaClass.classLoader
            .getResourceAsStream("day2/sample1.txt")!!
            .bufferedReader().lines()
            .asSequence()
            .map { it.toMaxGame() }
            .toList()

        allGames.sumIdsCompliantTo(Game(red = 12, green = 13, blue = 14)) shouldBe 8
    }

    @Test
    fun `Should get sum of possible Ids given a Game objective on input`() {
        val allGames = object {}.javaClass.classLoader
            .getResourceAsStream("day2/input.txt")!!
            .bufferedReader().lines()
            .asSequence()
            .map { it.toMaxGame() }
            .toList()

        allGames.sumIdsCompliantTo(Game(red = 12, green = 13, blue = 14)) shouldBe 2_439
    }

    @Test
    fun `Should get power of all games on sample`() {
        val allMinGames = object {}.javaClass.classLoader
            .getResourceAsStream("day2/sample1.txt")!!
            .bufferedReader().lines()
            .asSequence()
            .map { it.toMaxGame() }
            .toList()


        allMinGames.sumOf { it.power() } shouldBe 2_286
    }

    @Test
    fun `Should get power of all games on input`() {
        val allMinGames = object {}.javaClass.classLoader
            .getResourceAsStream("day2/input.txt")!!
            .bufferedReader().lines()
            .asSequence()
            .map { it.toMaxGame() }
            .toList()


        allMinGames.sumOf { it.power() } shouldBe 63_711
    }
}