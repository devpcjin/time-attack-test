public class Subnet {
    private int id;
    private String ip;
    private String region;

    private RouteTable routeTable;

    public Subnet(int id, String ip, String region) {
        this.id = id;
        this.ip = ip;
        this.region = region;
    }

    public void transfer(String msg) {
    }
}
