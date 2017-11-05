package xf.mvp.com.recycleerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    private List<String> datas = new ArrayList<>();
    private List<NameBean> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 10; i++) {
            datas.add("" + i);
            NameBean nameBean = new NameBean();
            nameBean.setName("这个是吸顶标题"+i);
            titles.add(nameBean);
        }
        recyclerView.addItemDecoration(new SectionDecoration(titles, this, new SectionDecoration.DecorationCallback() {
            @Override
            public String getGroupId(int position) {
                if (titles.get(position).getName()!=null){
                    return titles.get(position).getName();
                }
                return "-1";
            }

            @Override
            public String getGroupFirstLine(int position) {
                if (titles.get(position).getName()!=null){
                    return titles.get(position).getName();
                }
                return "";
            }
        }));
        recyclerView.setAdapter(new Myadapter());
    }

    class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case 1:
                    return new Holder2(View.inflate(parent.getContext(), R.layout.holder_view, null));
                case 2:
                    return new Holder2(View.inflate(parent.getContext(), R.layout.holder_view, null));
                case 0:
                    return new Holder2(View.inflate(parent.getContext(), R.layout.holder_view, null));
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((BaseViewHolder) holder).bindHolder(datas, position);
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return 0;
            } else if (position == 1) {
                return 1;
            } else if (position == 2) {
                return 2;
            }
            return 0;
        }

    }
}
