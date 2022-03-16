package domain

enum class TimeAdverbs { ago, after }

infix fun Int.days(duration: TimeAdverbs) = when(duration) {
    TimeAdverbs.ago -> println("That is $this days ago")
    TimeAdverbs.after -> println("That is $this days after")
}

val ago = TimeAdverbs.ago
val after = TimeAdverbs.after

