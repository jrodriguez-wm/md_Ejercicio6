package mx.com.webmaps.md_ejercicio6;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    String[] items = {" Easy ", " Medium ", " Hard ", " Very Hard "};
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(MainActivity.this, R.style.ConfirmationDialogTheme);

        builder.setTitle("Select the difficulty level");

        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                result = items[which];
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Your option is "+ result, Toast.LENGTH_SHORT).show();

            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        alertDialog = builder.create();
        alertDialog.show();



        //alertDialogExample();

    }


    public void alertDialogExample(){
        builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        builder.setMessage("Discard Draft");

        builder.setPositiveButton("DISCARD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Discard");

            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("cancel");
            }
        });

        alertDialog = builder.create();
        alertDialog.show();

        //Forma 1 Definir estilos a los botones
        //alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));
        //alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorAlertDialog));

    }


}
