public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public CommandNotFoundException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}