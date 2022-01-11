import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Result of the asynchronous computation";
            }
        });

        System.out.println("Code executing inside main thread");

        // blocks the main thread
        String result = completableFuture.get();
        System.out.println(result);


        System.out.println("After get method");

    }
}
