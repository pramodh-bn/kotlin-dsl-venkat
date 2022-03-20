import context.build

/**
 * Design for separate Implicit contexts
 * In a more complext DSL, where many different groups of
 * variables and functions are used, keeping everything in one context
 * can get complex and hard to maintain
 * */

build {
    version = "1.2"
    src = "/src"
    test = "/test"

    dependency("some.library")
    dependency("another.library")

    task("test") {
        jvmArgs = "-p somepath"
    }
}

/**
 * As you can see there are multiple variables version, src, test, jvmArgs
 * also functions like task, dependency, and build
 * We will design in a way that the code within the lambda passed to build()
 * runs in one execution context.
 * The code within lambda passed to the task function call,
 * which is embedded within the call to the build function in a different context
 * */