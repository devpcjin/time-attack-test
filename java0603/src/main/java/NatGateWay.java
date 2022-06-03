public class NatGateWay implements GateWay {

    private int id;
    private Subnet subent;
    public NatGateWay(Subnet subnet) {
        this.subent = subnet;
    }


    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
