package main;

public class FirstStream extends Thread{
    static SecondStream mAnotherStream;
    public Conflict conflict1 = new Conflict("firstConflict");
    public static boolean joy;

    @Override
    public void run()
    {
        conflict1.bow(mAnotherStream.conflict2);
    }

}
