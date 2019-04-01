import controller.Run;

public class Main {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        Run.startMultiThread();
//        Run.start();

        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}
