operator fun Int.invoke(operand: Int) = this * operand

println((4+3) (5-2))
/**
 * The compiler replaces internally the expression passed to    println() method to
 * (4+3).invoke(5-2)
 * The + is evaluated first and the - is evaluated second
 * */