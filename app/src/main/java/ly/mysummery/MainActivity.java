package ly.mysummery;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;
import ly.mysummery.adapter.MainAdapter;
import ly.mysummery.base.MyBaseActivity;
import ly.mysummery.ui.titlebar.CusSelectActivity;

public class MainActivity extends MyBaseActivity implements AdapterView.OnItemClickListener{

    private ListView lvInfo;

    private  List<String>lists;

    private String[] strings = new String[]{"自定义titleBar（CusSelectActivity）"};

    @Override
    public void initLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initId() {
        lvInfo = findViewById(R.id.lvInfo);
    }

    @Override
    public void initListener() {
        lvInfo.setOnItemClickListener(this);
    }

    @Override
    public void initDatas() {
        lists = Arrays.asList(strings);
        titleBar.setCenterText("MainActivity");
        MainAdapter adapter = new MainAdapter(this,null,R.layout.item_main_adapter);
        lvInfo.setAdapter(adapter);
        adapter.setList(lists);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            startActivity(new Intent(this, CusSelectActivity.class));
        }
    }
}
