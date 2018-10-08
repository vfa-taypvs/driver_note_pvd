package app.camnanglaixe.com.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.camnanglaixe.com.android.R;
import app.camnanglaixe.com.android.models.ContentDetailRule;

/**
 * Created by taypham on 06/12/2016.
 */
public class ListContentAdapter extends BaseAdapter {

    public List<ContentDetailRule> contentDetailRules;
    private LayoutInflater mInflater;
    private Context context;

    public ListContentAdapter(Context context, List<ContentDetailRule> contentDetailRules){
        this.context = context;
        this.contentDetailRules = contentDetailRules;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contentDetailRules.size();
    }

    @Override
    public Object getItem(int i) {
        return contentDetailRules.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.adapter_list_sub_topic, null);
            holder.title = (TextView) view.findViewById(R.id.sub_topic_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.title.setText(contentDetailRules.get(i).title.toUpperCase());
        return view;
    }

    class ViewHolder {
        TextView title;
    }

}
