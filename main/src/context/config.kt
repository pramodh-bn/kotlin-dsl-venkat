package context
// Defining the build function
fun build(block: Config.() -> Unit) {
    val configuraton = Config()
    configuraton.block()
    println(configuration)
    // This could be made concise by
    // println(Config().apply(block))
}
