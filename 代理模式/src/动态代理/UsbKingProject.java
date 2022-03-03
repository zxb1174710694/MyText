package 动态代理;

//定义厂家
public class UsbKingProject implements UsbSell{
    @Override
    public double sell(int amout) {
        return 85;  //假设一个U盘价格85元
    }

    public void print(){

        System.out.println("hello world");

    }
}
