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
}