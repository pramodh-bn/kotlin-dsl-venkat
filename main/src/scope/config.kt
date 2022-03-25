package scope
@DslMarker
annotation class ConfigMarker

@ConfigMarker
class Config {
    var version = ""
    var src = ""
    var test = ""
    var tasks = ""

    private val dependencies = mutableListOf<String>()

    fun dependency(library: String) = dependencies.add(library)

    fun task(type:String, commands:CommandContext.() -> Unit) {
        var commandContext = CommandContext().apply(commands)

        tasks = "$tasks--$type configured with ${commandContext}"
    }

    override fun toString() = """Config:
        |Version: $version
        |Source path: $src
        |Test path: $test
        |Dependencies: ${dependencies.joinToString()}
        |Tasks: $tasks
    """.trimMargin()
}

@ConfigMarker
class CommandContext {
    var jvmArgs = ""
    override fun toString() = "jvmArgs: $jvmArgs"
}

// Defining the build function
fun build(block: Config.() -> Unit) = println(Config().apply(block))