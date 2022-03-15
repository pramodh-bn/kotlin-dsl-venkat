import java.time.LocalDate
import java.time.Period

val duedate = LocalDate.of(2021, 3, 15)

duedate.plusDays(15)

operator fun LocalDate.plus(days: Long) = plusDays(days)

duedate + 15

val Int.days get() = Period.ofDays(this)

duedate + 15.days



