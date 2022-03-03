package 静态代理;

public class 商家 implements U盘 {

    //模拟商家进货
    厂商  c = new 厂商();


    @Override
    public double sell(int x) {

        double price = c.sell(5000);
        System.out.println("商家向厂家进货价："+price);
        price += 25;
        return price;
    }
}
