public class RecursionException extends Exception{
    @Override
    public String getMessage() {
        return "Эта команда создаст рекурсию!";
    }
}
