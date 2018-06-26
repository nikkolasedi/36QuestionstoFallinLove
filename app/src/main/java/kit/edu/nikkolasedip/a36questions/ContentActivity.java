package kit.edu.nikkolasedip.a36questions;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ContentActivity extends AppCompatActivity {

    public int currentRow = 0;
    public int currentCol = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        TextView textView = (TextView) findViewById(R.id.textView1) ;
        TextView textView3 = (TextView) findViewById(R.id.textView3) ;
        Typeface tf = Typeface.createFromAsset(getAssets(),"font2source.ttf");
        textView.setTypeface(tf);
        textView3.setTypeface(tf);
        display("Set I", "I");

        BottomNavigationView bottomNavigationView =(BottomNavigationView) findViewById(R.id.NavBot);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        changeActivity();
                        break;
                    case R.id.menu_left:
                        back();
                        break;
                    case R.id.menu_right:
                        next();
                        break;
                    default: break;
                }
                return true;
            }
        });
    }
    public void display(String value, String value3){
        TextView textView = (TextView) findViewById(R.id.textView1);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView.setText(value);
        textView3.setText(value3);
    }
    public void next(){
        try{
            AssetManager am = getAssets();
            InputStream is = am.open("fragenzumverlieben.xls");
            Workbook wb =  Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int totalrow = s.getRows();
            int totalcol = s.getColumns();
            String content="";
            String content3="";
            if(currentRow<totalrow-2&&currentCol==0){
                currentRow++;
                Cell cell =s.getCell(currentCol,currentRow);
                Cell cell3 =s.getCell(1,currentRow);
                content=cell.getContents();
                content3=cell3.getContents();
                display(content,content3);
            }else{
                //Here comments if outside table
            }

        }catch(Exception e){

        }
    }
    public void back(){
        try{
            AssetManager am = getAssets();
            InputStream is = am.open("fragenzumverlieben.xls");
            Workbook wb =  Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int totalrow = s.getRows();
            int totalcol = s.getColumns();
            String content="";
            String content3="";
            if(currentRow>0&&currentCol==0){
                currentRow--;
                Cell cell =s.getCell(currentCol,currentRow);
                Cell cell3 =s.getCell(1,currentRow);
                content=cell.getContents();
                content3=cell3.getContents();
                display(content,content3);
            }else{
                //Here comments if outside table
            }

        }catch(Exception e){

        }
    }
    public void changeActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
