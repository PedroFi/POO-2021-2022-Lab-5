class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(final B b) {
        this.b = b;
    }
}

class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(final A a) {
        this.a = a;
    }
}


public class ReferenceLoop {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
        System.out.println(a);
        System.out.println(a.getB().getA());
        System.out.println(a.getB().getA().getB().getA());
    }
}
