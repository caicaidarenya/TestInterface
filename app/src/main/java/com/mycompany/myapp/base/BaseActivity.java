package com.mycompany.myapp.base;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
/*
测试抽象类与抽象方法

1.要声明abstract方法，首先要把类用abstract修饰
2.abstract类可以有abstract方法，也可以有非abstract方法
3.abstract类不能被实例化，实例化就没意义了
 (1).final和abstract，private和abstract，static和abstract，
 不允许放一起
4.子类实现方法就不允许有abstract了
*/
public abstract class BaseActivity extends Activity{
	private Context mContext=this;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		initData();
		//abstract方法也能被调用
		initView();
	}
	public void initData(){
	     //如果有继承这个的方法,只要有super.initData,那么这里的代码会被全部执行
	    //已经在BaseActivity.class的onCreate方法执行，所以子类不必继续放入onCreate
	    //否则会执行两次
		Toast.makeText(mContext,"initData Super方法"+BaseActivity.class.getSimpleName(),0).show();
	}
	/*public void initView(){
		Toast.makeText(mContext,"initView Super方法"+BaseActivity.class.getSimpleName(),0).show();
	}*/
	
	public abstract void initView()//子类必须实现这个方法
}
