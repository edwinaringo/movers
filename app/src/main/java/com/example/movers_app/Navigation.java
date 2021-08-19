package com.example.movers_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class Navigation extends AppCompatActivity {

    private final int ID_HOME =1;
    private final int ID_MESSAGE =2;
    private final int ID_NOTIFICATION=3;
    private final int ID_ACCOUNT =4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        TextView selected_page = findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation =findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_MESSAGE,R.drawable.ic_baseline_chat_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION,R.drawable.ic_baseline_notifications_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT,R.drawable.ic_baseline_person_24));

//


        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                    Toast.makeText(com.example.movers_app.Navigation.this, model.getId() +"", Toast.LENGTH_SHORT).show();
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                String name = null;


                switch(model.getId()){
                    case ID_HOME:
                        name="Home";
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                            break;
                    case ID_MESSAGE:
                        name="Message";
                        Intent intent2 = new Intent(getApplicationContext(),HouseActivity.class);
                        startActivity(intent2);
                        break;
                    case ID_NOTIFICATION:
                        name="Notification";
                        Intent intent3 = new Intent(getApplicationContext(),ProfileActivity.class);
                        startActivity(intent3);
                        break;
                    case ID_ACCOUNT:
                        Intent intent4 = new Intent(getApplicationContext(),MovingOrdersActivity.class);
                        startActivity(intent4);
                        break;

                    default:name="";
                }

                selected_page.setText(getString(R.string.main_page_selected,name));

                // YOUR CODES
                return null;
            }
        });

//        bottomNavigation.setCount(ID_NOTIFICATION,"4");
        bottomNavigation.show(ID_HOME,true);




    }
}