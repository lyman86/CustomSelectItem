package ly.mysummery.adapter;

import android.content.Context;
import java.util.List;
import ly.mysummery.R;
import ly.mysummery.commom.CommonAdapter;
import ly.mysummery.utils.ViewHolder;

public class MainAdapter extends CommonAdapter<String> {

    public MainAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, String mainBean, int position) {
        holder.setText(R.id.tvName,mainBean);
    }
}
