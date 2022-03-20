object register {
    var total = 0

    infix fun add(op1: Int): register {
        total += op1
        return register
    }

    infix fun and(op2: Int) {
        println("adding $op2 to $total")
        total += op2
    }
}
// The benefit of this design is that functions may be used fluently
register add 4 and 3
// Unfortunately it has negative consequences
// It may not prevent a user from inadvertently making a few calls
// that may not make sense.
/*
register and 3 add 4 // ERROR
register and 3 and 4 // ERROR
register add 3 add 4 //oops


* A good design should enable ease of use and at the same time prevent
* users from advertently falling into traps. Ideally, an unintended or
* non-sensible use should result in an error instead of quietly misbehaving.
* */

