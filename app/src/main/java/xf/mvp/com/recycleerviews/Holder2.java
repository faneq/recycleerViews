package xf.mvp.com.recycleerviews;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by feq on 2017/10/15.
 */

public class Holder2 extends BaseViewHolder {
    RecyclerView recyclerView;

    public Holder2(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView) itemView.findViewById(R.id.rc_content);
    }

    @Override
    public void bindHolder(final List<String> dataBean, int position) {
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new MyHolder(View.inflate(parent.getContext(), R.layout.item, null));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return dataBean.size();
            }
        });

    }

    class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
