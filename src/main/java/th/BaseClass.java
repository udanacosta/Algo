package th;

public class BaseClass {
  
  public AA m1() {
    System.out.println("In BaseClass method");
    return new AA();
  }
  
  public static void main(String args[]) {
    BaseClass b = new SubClass();
    b.m1();
  }
}

class SubClass extends BaseClass {
  
  public AA m1() {
    System.out.println("In SubClass method");
    return new AA();
    
  }
}

class AA {

}

class BB extends AA {

}

class CC {

}