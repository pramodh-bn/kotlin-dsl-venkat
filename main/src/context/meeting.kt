package context

object schedule {
    infix fun meeting(block: Meeting.() -> Unit) =
        print(Meeting().apply(block))
}
// The meeting function in the schedule singleton has been marked infix.
// The parameter declaration of the function shows that the lambda provided
// as parameter will be executed in the context of a Meeting instance.
// The Meeting class will hold the details about the meeting.

class Meeting {
    var meetingName = ""
    var startTime = IntRange.EMPTY
    var endTime = IntRange.EMPTY
    var scheduledOn = ""
    var attending = ""

    val assign = this
    infix fun name(name:String) {
        meetingName = name
    }

    // Lets create a starts property within Meeting but assign it to an instance of
    // Starts, which is an inner class within Meeting. The benefit of an inner class
    // is that its instance can provide a new context, and yet those instances can access
    // the state in the outer instance.

    val starts = Starts()

    inner class Starts {
        infix fun at(time: IntRange) {
            startTime = time
        }
    }

    val ends = Ends()

    inner class Ends {
        infix fun at(time: IntRange) {
            endTime = time
        }
    }

    val on = On()

    inner class On {
        infix fun date(day: Int) = DateCreator(day, this@Meeting)
    }

    val participants = Participants()

    inner class Participants {
        infix fun include(name: String): Participants = apply {
            attending = name
        }

        infix fun and(name: String): Participants = apply {
            attending = "$attending, $name"
        }
    }
    class DateCreator(val day: Int, val meeting: Meeting) {
        private fun setScheduledOn(month: Int, year: Int) {
            meeting.scheduledOn = java.time.LocalDate.of(year, month, day).toString()
        }

        infix fun January(year: Int) = setScheduledOn(1, year)
        infix fun February(year: Int) = setScheduledOn(2, year)
        infix fun March(year: Int) = setScheduledOn(3, year)
        infix fun April(year: Int) = setScheduledOn(4, year)
        infix fun May(year: Int) = setScheduledOn(5, year)
        infix fun June(year: Int) = setScheduledOn(6, year)
        infix fun July(year: Int) = setScheduledOn(7, year)
        infix fun August(year: Int) = setScheduledOn(8, year)
        infix fun September(year: Int) = setScheduledOn(9, year)
        infix fun October(year: Int) = setScheduledOn(10, year)
        infix fun November(year: Int) = setScheduledOn(11, year)
        infix fun December(year: Int) = setScheduledOn(12, year)
    }

    override fun toString(): String = """Meeting: $meetingName
        |Starts at ${startTime.start}:${startTime.endInclusive}
        |Ends at ${endTime.start}:${endTime.endInclusive}
        |On $scheduledOn
        |Participants: ${attending}
        |
    """.trimMargin()
}

