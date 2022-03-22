// Use Inner classes to share state between contexts

schedule meeting {
    assign name "Meeting to discuss why meetings aren't effective"
    starts at 14..30
    ends at 15 ..30
    on date 15 March 2022
    participant include "Sara" and "Jake" and "Mani"
}

// schedule can be a singleton with meeting() as a function that takes lambda as a parameter
// But what about assign, starts, ends, on, participant. One approach may be to define
// each one of them as singletons. However that approach as some problems
// in addition to name, at, date and include we also need to gather the data
// needed to define a meeting. Arbitrary singletons are not great to carry
// single representation of data; we need to look further.
