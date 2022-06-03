import java.util.ArrayList;
import java.util.List;

public class RouteTable {
    private int id;
    private GateWay gateWay;
    private List<Subnet> subnetList = new ArrayList<>();


    public void setGateWay(GateWay gateWay) {
        this.gateWay = gateWay;
    }

    public void addSubnet(Subnet subnet) {
        this.subnetList.add(subnet);
    }

    public GateWay route(){
        return gateWay;
    }
}
