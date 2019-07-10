package net.lzzy.algorithm;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import net.lzzy.algorithm.chazhao.BaseSearch;
import net.lzzy.algorithm.algorlib.BaseSort;
//import net.lzzy.algorithm.algorlib.HillRank;
import net.lzzy.algorithm.chazhao.SortChazhao;
import net.lzzy.algorithm.algorlib.SortFactory;

import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    Spinner spinner;
    Spinner spinnerchazhao;
    Button buttonshengcheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        spinner=findViewById(R.id.sp1);
        spinnerchazhao=findViewById(R.id.spinnerchazhao);
        buttonshengcheng=findViewById(R.id.btshengcheng);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                BaseSort sort=SortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                sort.sort();
                String str="排序耗时："+sort.getRuntime()
                        +"\n比较次数："+sort.getCompareCount()
                        +"\n交换次数："+sort.getSwapCount()
                        +"\n移动次数："+sort.getMovCount();
                Dialog(MainActivity.this,str);

                displayItems(tvResult);
                break;
            case R.id.btshengcheng:
                BaseSearch search= SortChazhao.getInstance(spinner.getSelectedItemPosition(),items);
                search.search(spinner.getSelectedItemPosition());
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

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
    public static void Dialog(Context context, String msg){
        new AlertDialog.Builder(context)
                .setTitle("结果")
                .setMessage(msg)
                .setPositiveButton("确定",null)
                .show();
    }
}
