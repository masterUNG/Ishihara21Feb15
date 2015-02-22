package appewtc.masterung.ishihara21feb15;

/**
 * Created by masterUNG on 2/22/15 AD.
 */
public class MyModel {

    private int intButton;

    public interface OnMyModelChangeListener {
        void onMyModelChangeListener(MyModel myModel);
    }   // Class Interface

    private OnMyModelChangeListener onMyModelChangeListener;

    public void setOnMyModelChangeListener(OnMyModelChangeListener onMyModelChangeListener) {
        this.onMyModelChangeListener = onMyModelChangeListener;
    }

    public int getIntButton() {
        return intButton;
    }   // getter

    public void setIntButton(int intButton) {
        this.intButton = intButton;

        if (this.onMyModelChangeListener != null) {
            this.onMyModelChangeListener.onMyModelChangeListener(this);
        }


    }   // setter

}   // Main Class
