import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CompleteableFeatureDemo5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> userNameFuture = getUser("Ali");

        CompletableFuture<String> completableFuture1 = userNameFuture.thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                return greetUser(s);
            }
        });

        System.out.println(completableFuture1.get());
    }


    public static CompletableFuture<String> getUser(String userName) {
        return CompletableFuture.supplyAsync(() -> {
            return userName;
        });
    }

    public static CompletableFuture<String> greetUser(String userName) {
        return CompletableFuture.supplyAsync(() -> {
            return "Welcome " + userName;
        });
    }

}