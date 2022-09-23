public class Launcher {

    /*
     * Instantiate and start each thread from "t" with its OWN Counter object,
     * then wait for all threads to finish and return the set of Counter objects
     * the threads ran on. Each thread must be named according to its index in the
     * "t" array.
     */
    public static Counter[] init(Thread[] t){
        Counter[] c = new Counter[t.length];
        for (int j = 0; j < t.length; j++){
            c[j] = new Counter();
            t[j] = new Thread(c[j],String.valueOf(j));
            t[j].start();
        }
        for (Thread thread : t) {
            try {thread.join();}
            catch (InterruptedException ignored) {}
        }
        return c;
    }
}
