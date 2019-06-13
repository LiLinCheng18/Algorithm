package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                directSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        int sum;                                   //创建局部变量
        for (int i=0;i<items.length-1;i++){       //利用循环i一个个全部循环j对比大小
            for(int j=0;j<items.length-1;j++){    //循环j，每循环一次i就循环items。length个j
                if(items[j]>items[j+1]){          //判断数组第[j]个是否大于第[j+1]个数
                    sum=items[j];                 //如果大于第[j+1]个数，就把它放入局部变量sum中
                    items[j]=items[j+1];          //再把它放到自己的上一个数的位置
                    items[j+1]=sum;               //最后还要把sum得到的数放到数组[j+1]的位置
                }
            }
        }
    }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
