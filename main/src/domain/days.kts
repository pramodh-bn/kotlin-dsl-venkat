import domain.after
import domain.ago
import domain.days

2 days ago
5 days after

// This could get translated to 2.days(ago), 5.days(after)
// First we define the words ago and after as variables that are available in the execution context of the DSL
// Kotlin allows extensions on functions on existing classes. So will extend Int to add days() function

