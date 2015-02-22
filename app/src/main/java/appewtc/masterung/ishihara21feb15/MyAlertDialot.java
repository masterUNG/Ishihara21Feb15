package appewtc.masterung.ishihara21feb15;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by masterUNG on 2/21/15 AD.
 */
public class MyAlertDialot {

    public void myDialog(Context context) {

        AlertDialog.Builder objAlert = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.icon_question);
        objAlert.setTitle("มีช่องว่าง");
        objAlert.setMessage("กรุณาตอบคำถาม ด้วยครับ");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }   // event
        });
        objAlert.show();

    }   // myDialog

}   // Main Class
