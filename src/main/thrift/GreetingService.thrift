exception InvalidOperationException {
    1: i32 code,
    2: string description
}

service GreetingService{
    bool ping() throws (1: InvalidOperationException e),
    string greetMsg(1: string msg) throws (1: InvalidOperationException e),
    oneway void printLog(1: string msg)
}