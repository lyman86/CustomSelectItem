package ly.mysummery.ui.titlebar;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;
import ly.mysummery.R;
import ly.mysummery.adapter.MainAdapter;
import ly.mysummery.base.MyBaseActivity;

public class CusSelectActivity extends MyBaseActivity implements AdapterView.OnItemClickListener{

    private String[] strings = new String[]{"自定义titleBar01","自定义titleBar02","自定义titleBar03",
            "自定义titleBar04","自定义titleBar05","自定义titleBar06","自定义titleBar07"};

    private List<String> lists;

    private ListView lvInfo;

    @Override
    public void initLayout() {
        setContentView(R.layout.activity_cus_select);
    }

    @Override
    public void initId() {
        lvInfo = findViewById(R.id.lvInfo);
    }

    @Override
    public void initListener() {
        titleBar.setOnBarViewClickListener(this);
        lvInfo.setOnItemClickListener(this);
    }

    @Override
    public void initDatas() {
        titleBar.setCenterText("CusSelectActivity");
        lists = Arrays.asList(strings);
        MainAdapter adapter = new MainAdapter(this,null,R.layout.item_main_adapter);
        lvInfo.setAdapter(adapter);
        adapter.setList(lists);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,TitleBarShowActivity.class);
        intent.putExtra(TitleBarShowActivity.TITLE_TAG,position);
        if (position == 0){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar01");
        }else if (position == 1){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar02");
        }else if (position == 2){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar03");
        }else if (position == 3){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar04");
        }else if (position == 4){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar05");
        }else if (position == 5){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar06");
        }else if (position == 6){
            intent.putExtra(TitleBarShowActivity.TITLE_NAME,"titleBar07");
        }
        startActivity(intent);

    }
}
