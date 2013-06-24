package threadeditor;

/**
 *
 * @author artur
 */
public class Resource {

    private int amount = 0;

    Resource(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    
    public void getBlob(int quant){
        this.amount = this.amount - quant;
    }
    
}
