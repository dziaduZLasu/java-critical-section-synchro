/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadeditor;

/**
 *
 * @author artur
 */
public class ThreadEditor extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
         * pure resource object with some amount inside
         */
        Resource res = new Resource(100);

        /*
         *pass ref to res. and send obj to thread
         */
        new Thread(new Consumer(res)).start();
        new Thread(new Consumer(res)).start();        
    }
}
