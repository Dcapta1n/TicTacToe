package space.musicia.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int player=0;
    Board b;
    TextView tv[] = new TextView[10];

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = new Board();
        init(tv);
    }


    void initialize(View view){
        init(tv);
    }



    public void init(TextView tv[]){
        tv[0]=(TextView) findViewById(R.id.num1);
        tv[1]=(TextView) findViewById(R.id.num2);
        tv[2]=(TextView) findViewById(R.id.num3);
        tv[3]=(TextView) findViewById(R.id.num4);
        tv[4]=(TextView) findViewById(R.id.num5);
        tv[5]=(TextView) findViewById(R.id.num6);
        tv[6]=(TextView) findViewById(R.id.num7);
        tv[7]=(TextView) findViewById(R.id.num8);
        tv[8]=(TextView) findViewById(R.id.num9);
        for(int i=0;i<9;i++){
            tv[i].setTag(i);
            tv[i].setText(".");
        }
        player=0;
        b.init();
    }



    public void flip(View view){
        TextView number=(TextView) findViewById(view.getId());

        int pos = (int) view.getTag();
        int row = pos/3;
        int col = pos%3;

        if(b.canplay()){
            boolean  check =b.setText(row,col,player);
            if(check){
                //player won start new game

                Log.e("winner",player+"");
                //start new game
                init(tv);
                return;
            }
        }else{
            boolean c = b.check(player);
            if(!c) {
                Log.e("oohno", "tie");
                // show message tie
                //start new game after that
                init(tv);
                return;
            }
        }

        String massage=number.getText().toString();

        if(massage.equals(".")) {

            if (player % 2 == 0) {
                number.setText("X");
                player = player + 1;
                player %= 2;
            } else {
                number.setText("O");
                player = player + 1;
                player %= 2;
            }
        }


    }
}