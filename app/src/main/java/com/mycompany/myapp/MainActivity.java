package com.mycompany.myapp;

import android.content.*;
import android.os.*;
import android.widget.*;
import com.mycompany.myapp.base.*;
import dalvik.annotation.*;
import java.util.*;

public class MainActivity extends BaseActivity{
    //BaseActivity中的abstract initView方法
	@Override
	public void initView(){
		Toast.makeText(mContext,"initView 儿子方法",0).show();
	}
	/*
	(interface只管实现方法，不管调用,
	如onSucess,onFaileure等方法，都是在相应的地方被调用的)
	方法中的ICallback只管实现里面需要的方法
	调用还得自己调用
	*/
	@TestTarget
	public void showMsg(String msg,ICallback back){
		Random ran=new Random();
		int rand= ran.nextInt(2);
		if(rand!=1){
			msg="成功";
			back.onSucess("我调用成功方法"+rand);
		}
		else{
			msg="失败";
			back.onFailure("我调用失败方法"+rand);
		}


	}
	private Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		//initData();//这里调用会被调用两次这个方法
		initView();
		showMsg("",new ICallback(){
				@Override
				public void onSucess(String msg){
					Toast.makeText(mContext,"onSucess方法"+msg,0).show();
				}
				@Override
				public void onFailure(String err){
					Toast.makeText(mContext,"onFailure方法"+err,0).show();
				}
			});
    }

	@Override
	public void initData(){
		Toast.makeText(mContext,"initData 儿子方法",0).show();
		super.initData();
	}

}
