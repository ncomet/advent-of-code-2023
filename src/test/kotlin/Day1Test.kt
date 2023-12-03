import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import kotlin.streams.asSequence

class Day1Test {

    @Test
    fun `Should compute first sample`() {
        val sum = object {}.javaClass.classLoader
            .getResourceAsStream("day1/sample1.txt")!!
            .bufferedReader().lines().asSequence()
            .solve()

        sum shouldBe 142
    }

    @Test
    fun `Should compute second sample`() {
        val sum = object {}.javaClass.classLoader
            .getResourceAsStream("day1/sample2.txt")!!
            .bufferedReader().lines().asSequence()
            .solve()

        sum shouldBe 281
    }

    @Test
    fun `Should compute input sample`() {
        val sum = object {}.javaClass.classLoader
            .getResourceAsStream("day1/input.txt")!!
            .bufferedReader().lines().asSequence()
            .solve()

        sum shouldBe 54_208
    }
}