package com.zero.android.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zero.android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zengfeng
 *create on 16/7/18.
 */

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.srl)
    SwipeRefreshLayout srl;

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private RecyclerView.Adapter       mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        rvList = (RecyclerView) findViewById(R.id.rv_list);
        srl = (SwipeRefreshLayout) findViewById(R.id.srl);
        srl.setOnRefreshListener(()-> {
            Snackbar.make(srl,"onRefreshListener",Snackbar.LENGTH_INDEFINITE).show();
        });
        // 设置了这个以后。我们的布局的大小将不会改变
        rvList.setHasFixedSize(true);

        // 使用一个线性管理器
        mLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);

        // 指定dataset
        List<Entity> myDataset = new ArrayList<>();
        for (int i = 0 ; i<10 ; i++ ){
            Entity entity = new Entity("hello beatiful girl ","gril Oh Oh Oh Oh Oh!!!!!!!!!!!!!!!!!!!");
            myDataset.add(entity);
        }
        mAdapter = new MyAdapter(myDataset);
        rvList.setAdapter(mAdapter);
    }

    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<Entity> mDataset;

        // 提供每个view 的data item
        public static class ViewHolder extends RecyclerView.ViewHolder {

            public View layoutView;
            public TextView tvTitle;
            private ImageView tvImg;
            private TextView tvContent;
            public ViewHolder(View v) {
                super(v);
                layoutView = v;
                tvTitle = (TextView) v.findViewById(R.id.tv_title);
                tvImg = (ImageView) v.findViewById(R.id.tvImg);
                tvContent = (TextView) v.findViewById(R.id.tv_content);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(List<Entity> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list, parent, false);
            TextView  tvTitle = (TextView) v.findViewById(R.id.tv_title);
            TextView  tvContent = (TextView) v.findViewById(R.id.tv_content);
            ImageView tvImg = (ImageView) v.findViewById(R.id.tvImg);


            //  set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            holder.tvTitle.setText(mDataset.get(position).getTitle());
            holder.tvContent.setText(mDataset.get(position).getContent());
//            holder.tvImg.setImageResource(R.drawable.);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size()+1;
        }
    }

    class Entity {
        private String title ;
        private String content ;
        private int img ;

        public Entity(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }
    }

}
