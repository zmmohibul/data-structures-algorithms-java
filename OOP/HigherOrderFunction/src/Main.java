public class Main {

    public static int doTwice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        System.out.println(doTwice(new TenX(), 20));
        System.out.println(doTwice(new TwoX(), 20));
    }
}
