import domain.begin
import domain.end
import java.time.LocalDate
import java.time.Period

// Domain specific operators
begin - end
//DateUtil.durationBetween(begin, end)

operator fun LocalDate.minus(other: LocalDate) {
    Period.between(this, other).apply {
        println("$years years $months months $days days")
    }
}