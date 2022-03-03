package 静态代理;

public class 用户 {
    public static void main(String[] args) {
        商家 s = new 商家();
        double price = s.sell(1);
        System.out.println("向商家购买的价格："+price);
    }
}
