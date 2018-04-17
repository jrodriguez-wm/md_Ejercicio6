package mx.com.webmaps.md_ejercicio6;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    AlertDialog.Builder builder;
    String[] items = {" Easy ", " Medium ", " Hard ", " Very Hard "};
    String result="";

    ProgressDialog dialog;

    Handler handler;
    Runnable runnable;
    Timer timer;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialog = new ProgressDialog(MainActivity.this);

        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setIndeterminate(false);

        dialog.setTitle("Progress Dialog");

        dialog.setMessage("Please Wait...");

        dialog.show();

        dialog.setProgress(0);
        dialog.setMax(100);

        handler = new Handler();

        runnable= new Runnable() {
            @Override
            public void run() {
                i+=5;

                if(i<=100){
                    dialog.setProgress(i);
                }
                else{
                    timer.cancel();
                    dialog.cancel();
                    i=0;
                }

            }
        };

        timer= new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },400, 500);

        //dialog.cancel();


        //alertDialogExample();
        //confirmDialogExample();
        //progressDialogExample();

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

    public  void confirmDialogExample(){
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
    }

    public void progressDialogExample(){
        dialog = new ProgressDialog(MainActivity.this);

        dialog.setTitle("Progress Dialog");

        dialog.setMessage("Please Wait...");

        dialog.show();

        //dialog.cancel();
    }


}
