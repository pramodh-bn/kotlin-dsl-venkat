object register {
    infix fun add(op1: Int): AndOp {
        return AndOp(op1)
    }
    class AndOp(val total: Int) {
        infix fun and(op2: Int) {
            println("Adding $op2 to $total ")
        }
    }
}

register add 4 and 3