import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompleteableFutureDemo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Rajeev";
        });

        Thread.sleep(3000);

        completableFuture.thenAccept((String name) -> {
            System.out.println(name);
        });

        System.out.println("Main thread code");

        for (int i = 0; i < 5; i++) {
            System.out.println("Inside for loop");
        }

    }
}
