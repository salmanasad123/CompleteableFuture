package proxyPattern;

public class ProxyInternetAccess implements OfficeInternetAccess {

    private String employeeName;
    private RealInternetAccess realInternetAccess;

    public ProxyInternetAccess(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public void grantInternetAccess() {
        if (getRole(employeeName) > 5) {
            RealInternetAccess realInternetAccess = new RealInternetAccess(employeeName);
            realInternetAccess.grantInternetAccess();
        } else {
            System.out.println("Employee level is below 5, cannot grant access");
        }
    }

    public int getRole(String employeeName) {
        // Check role from the database based on Name and designation
        // return job level or job designation.
        return 9;
    }
}
