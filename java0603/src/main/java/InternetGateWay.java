public class InternetGateWay implements GateWay {
    private int id;

    @Override
    public void send(String msg) {
        System.out.println(msg);
    }
}
