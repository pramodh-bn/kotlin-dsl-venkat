import domain.May
import domain.begin
import domain.end
import java.time.LocalDate

print(May in begin..end)

operator fun ClosedRange<LocalDate>.contains(month: java.time.Month): Boolean =
    month.value >= start.month.value && month.value <= endInclusive.month.value
