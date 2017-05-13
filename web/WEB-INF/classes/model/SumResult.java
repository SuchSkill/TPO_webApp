package model;

/**
 * Created by Eugene on 29-Mar-17.
 */
public class SumResult {
    private int result;
    private boolean isOkay = true;

    public boolean isOkay() {
        return isOkay;
    }

    public void setOkay(boolean okay) {
        isOkay = okay;
    }

    public SumResult(Integer result) {
        if (result == null)
            isOkay = false;

        this.result = result;
    }

    public int getResult() {

        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
