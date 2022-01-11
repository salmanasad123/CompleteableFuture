import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompleteableFutureDemo3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

        CompletableFuture<String> resultCompletableFuture = completableFuture.thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("Callback gets called when future is completed");
                return "hello " + s;
            }
        });

        String result = resultCompletableFuture.get();
        System.out.println(result);


        System.out.println("After get method");
    }
}
