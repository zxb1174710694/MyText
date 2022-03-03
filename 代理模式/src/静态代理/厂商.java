package 静态代理;

public class 厂商 implements U盘 {

    //假设一个U盘85元
    @Override
    public double sell(int x) {
        return 85;
    }
}
