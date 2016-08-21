package com.zero.android.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v4.util.CircularArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zero.android.R;
import com.zero.android.common.view.BaseLoadingAdapter;

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
//        rvList.setHasFixedSize(true);

        // 使用一个线性管理器
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);

        // 指定dataset
        CircularArray<Entity> myDataset = new CircularArray<>();
        for (int i = 0 ; i<10 ; i++ ){
            Entity entity = new Entity("hello beatiful girl ","gril Oh Oh Oh Oh Oh!!!!!!!!!!!!!!!!!!!");
            myDataset.addLast(entity);
        }
        DesignLoaderMoreAdapter moreAdapter = new DesignLoaderMoreAdapter(rvList,myDataset);
        moreAdapter.setOnLoadingListener(()->{
            Toast.makeText(ListActivity.this,"loading",Toast.LENGTH_SHORT).show();
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    moreAdapter.setLoadingComplete();

                    for (int i = 0 ; i<10 ; i++ ){
                        Entity entity = new Entity("hello beatiful girl ","gril Oh Oh Oh Oh Oh!!!!!!!!!!!!!!!!!!!");
                        myDataset.addLast(entity);
                    }
                    moreAdapter.notifyDataSetChanged();
                }
            }.start();
        });
        rvList.setAdapter(moreAdapter);
    }


    public class DesignLoaderMoreAdapter extends BaseLoadingAdapter<Entity> {

        private CircularArray<Entity> mDesignItems;

        public DesignLoaderMoreAdapter(RecyclerView recyclerView, CircularArray<Entity> datas) {
            super(recyclerView, datas);

            mDesignItems = datas;
        }

        //正常条目
        public  class DesignViewHolder extends RecyclerView.ViewHolder {

            public View layoutView;
            public TextView tvTitle;
            public ImageView tvImg;
            public TextView tvContent;
            public DesignViewHolder(View v) {
                super(v);
                layoutView = v;
                tvTitle = (TextView) v.findViewById(R.id.tv_title);
                tvImg = (ImageView) v.findViewById(R.id.tvImg);
                tvContent = (TextView) v.findViewById(R.id.tv_content);
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_list, parent, false);
            return new DesignViewHolder(view);
        }

        @Override
        public void onBindNormalViewHolder(RecyclerView.ViewHolder holder, int position) {
            DesignViewHolder viewHolder = (DesignViewHolder)holder;
            viewHolder.tvTitle.setText(mDesignItems.get(position).getTitle());
            viewHolder.tvContent.setText(mDesignItems.get(position).getContent());
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
