package context

enum class Direction { left, right }
enum class Speed { fast, slow }

object DirectionSpeedReceiver {
    val left = Direction.left
    val right = Direction.right
    val fast = Speed.fast
}
// Next we create Robot singleton which will hold operate()
// function and also serve as a parameter to the lambda passed to that
// function.
object Robot {
    infix fun turns(direction: Direction) = println("Robot turns $direction")
    infix fun runs(speed: Speed) = println("Robot runs $speed")
    infix fun operate(instructions: DirectionSpeedReceiver.(Robot) -> Unit) =
        DirectionSpeedReceiver.instructions(Robot)
}