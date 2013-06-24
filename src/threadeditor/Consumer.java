/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadeditor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artur
 */
public class Consumer implements Runnable {

    private int capacity = 0;
    static Resource res;

    Consumer(Resource k) {
        res = k;
    }

    @Override
    public void run() {
        
        /*
         * set mutex over res
         */
        synchronized (res) {
            try {
                while (this.capacity < 60 && res.getAmount() > 0) {
                    consumeRes();
                    res.wait();
                }
                if (this.capacity == 60) {
                    System.out.println("Buffer full, going idle. Consumer Obj: " + this.toString() + " from " + Thread.currentThread());
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("Resource EOF. Consumer Obj: " + this.toString() + " from " + Thread.currentThread());
                    System.out.println("Obj consumed: " + this.capacity + " of shared resource");
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                }
                res.notifyAll();

            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void consumeRes() throws InterruptedException {
        this.capacity += 10;
        res.getBlob( 10);
        System.out.println("Processing res. "+res.getAmount()+" left Consumer Obj: " + this.toString() + " from " + Thread.currentThread());
        System.out.println("-------------------------------------------------------------------------------------------------------"); 
        res.notifyAll();
    }
    
    
}
