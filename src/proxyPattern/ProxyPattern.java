package proxyPattern;

public class ProxyPattern {

    public static void main(String[] args) {

        ProxyInternetAccess proxyInternetAccess = new ProxyInternetAccess("Ali");
        proxyInternetAccess.grantInternetAccess();
    }
}
