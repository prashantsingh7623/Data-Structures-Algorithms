 interface a{
     void draw();
     int a = 0;
}

abstract class b{
    int a;
    abstract void draw();
    b() {
        a = 10;
    }
}

class c extends b implements a {

    @Override
    public void draw() {
        System.out.println("hello");
    }

}
class Solution{
    public static void main(String[] args) {
        c obj = new c();
        obj.draw();
        System.out.println(obj);
    }
}