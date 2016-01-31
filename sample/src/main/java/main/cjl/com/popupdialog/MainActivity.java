package main.cjl.com.popupdialog;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import main.cjl.com.library.PopupDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupDialog.OnItemClickListener {
    
    private View rootView;
    private PopupDialog dialog;
    private List<String> mData1;
    private List<String> mData2;
    private boolean isChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initDialog();
        rootView = findViewById(R.id.rootView);
        findViewById(R.id.test_btn).setOnClickListener(this);
        findViewById(R.id.test_btn_change).setOnClickListener(this);
    }
    
    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void initDialog(){
        mData1 = new ArrayList<>();
        mData1.add("first");
        mData1.add("second");
        mData1.add("third");
        mData1.add("four");
        mData1.add("five");

        mData2 = new ArrayList<>();
        mData2.add("Hello World!");
        mData2.add("Hello Android!");
        dialog = new PopupDialog(this, mData1);
        dialog.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_btn:
                dialog.show();
                break;
            case R.id.test_btn_change:
                dialog.setData((isChange = !isChange) ? mData2 : mData1);
                Snackbar.make(rootView, "change data success", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(View v, int position) {
        Snackbar.make(rootView, "你点击了第" + position + "项", Snackbar.LENGTH_SHORT).show();
    }
}
