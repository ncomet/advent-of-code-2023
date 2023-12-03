import kotlin.streams.asSequence

val convertToChar = mapOf(
    "zero" to "0",
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9",
)

val allNumbers = convertToChar.keys + convertToChar.values

fun Sequence<String>.solve(): Int =
    map { line ->
        line.findFirstOccurrence()
            ?.let { firstMatch ->
                (firstMatch + line.findLastOccurrence()).toInt()
            } ?: 0
    }.sum()

fun String.findFirstOccurrence(): String? =
    findAnyOf(allNumbers)?.let {
        val matchedNumber = it.second
        if (matchedNumber.length > 1) {
            convertToChar[matchedNumber]
        } else {
            matchedNumber
        }
    }

fun String.findLastOccurrence(): String? =
    findLastAnyOf(allNumbers)?.let {
        val matchedNumber = it.second
        if (matchedNumber.length > 1) {
            convertToChar[matchedNumber]
        } else {
            matchedNumber
        }
    }