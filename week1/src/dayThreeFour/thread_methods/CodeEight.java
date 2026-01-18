package dayThreeFour.thread_methods;
// IllegalArgumentException when sleep time is Negative
public class CodeEight {
    public static void main(String[] args) {
        try{
            for(int i = 0; i < 5; i++) {
                // this will throw the
                // IllegalArgumentException
                Thread.sleep(-100);
                System.out.println(i);
            }
        }
        catch (Exception e){
            //catching the exception
            System.out.println("Caught: " + e);
            System.out.println("Timeout value should be positive to avoid");
        }
    }
}
