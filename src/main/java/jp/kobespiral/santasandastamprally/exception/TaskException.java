package jp.kobespiral.santasandastamprally.exception;

public class TaskException extends RuntimeException{
    public static final int NO_SUCH_TASK = 101;
    int code;

    public TaskException(int code, String message){
        super(message);
        this.code = code;
    }
}
