package main;

public class SecondStream {
    static FirstStream mAnotherStream;

    public static Conflict conflict2 = new Conflict("secondConflict");

    public static void main(String[] args)
    {
        mAnotherStream = new FirstStream();
        mAnotherStream.start();

        conflict2.bow(mAnotherStream.conflict1);

    }

}
