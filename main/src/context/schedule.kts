// Use Inner classes to share state between contexts

schedule meeting {
    assign name "Meeting to discuss why meetings aren't effective"
    starts at 14..30
    ends at 15 ..30
    on date 15 March 2022
    participant include "Sara" and "Jake" and "Mani"
}