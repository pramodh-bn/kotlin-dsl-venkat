import Send.Message.*

enum class Message{
    statementReady,
    lowBalanceAlert;

    infix fun to(number: Int) = println("sending message $this to $number")
}

object send {
    infix fun message(messageId: Message) = messageId
}

send message statementReady to 1234

// you can do something like the send message statementReady to 1234