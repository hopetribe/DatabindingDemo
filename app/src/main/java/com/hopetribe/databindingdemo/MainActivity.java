package com.hopetribe.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hopetribe.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    UserInfo mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 注意：这里要设置Presenter，否则无法回到相应的函数
        binding.setPresenter(new Presenter());
        mUserInfo = new UserInfo("test1", "test2");
        binding.setUsrInfo(mUserInfo);
        setContentView(binding.getRoot());
    }

    public class Presenter {
        public void onBtnClick(String name){
            Toast.makeText(MainActivity.this, "onClick @ onBtnClick name = " + name, Toast.LENGTH_SHORT).show();
            binding.fullName.setText(binding.getLastName() + binding.getFirstName());
            mUserInfo.setFirstName("Chengzong");
            mUserInfo.setLastName("Huang");
        }
    }

    public class UserInfo extends BaseObservable {
        public String firstName;
        public String lastName;

        UserInfo(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Bindable
        public String getFirstName(){
            return firstName;
        }

        @Bindable
        public String getLastName(){
            return lastName;
        }

        public void setFirstName(String firstName){
            this.firstName = firstName;
            notifyPropertyChanged(BR.firstName);
        }

        public void setLastName(String lastName){
            this.lastName = lastName;
            notifyPropertyChanged(BR.lastName);
        }
    }
}
