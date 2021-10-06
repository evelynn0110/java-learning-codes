class StaticSuper{

    static{
        System.out.println("super static block");
    }

    StaticSuper(){
        System.out.println("super constructor");
    }
}




public class StaticTests {
    static int rand;

    static{
        rand=(int)(Math.random()*6);
        System.out.println("static block"+rand);
    }
}
