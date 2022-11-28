package main;

public class Conflict {
    private final String name;
    private static boolean joy;

    public Conflict (String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public synchronized void bow(Conflict bower) {
        while (joy) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        joy = true;
        notifyAll();

        System.out.format("%s: %s"
                        + " пропускає мене!%n",
                this.name, bower.getName());
        bower.bowBack(this);
    }
    public synchronized void bowBack(Conflict bower) {
        while (!joy) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        joy = false;

        System.out.format("%s: %s"
                        + " пропускає мене у відповідь!%n",
                this.name, bower.getName());

        notifyAll();
    }

}
