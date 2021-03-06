package planner.venue.venue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;


public class displayMenu extends AppCompatActivity {

    final int menu_size = 7;
    double totalPrice;
    displayMenuController m1;

    Button mainMenuButton, restartOrderButton, payCashButton;
    Button chickenBurgerButton, Soft_Drink, Beef_Burger,Steak, Chicken_Nuggets, Fish_and_Chips, Fries;
    TextView totalTrollyPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulayout);
        String StringRawInfo = returnMenuString();
        m1 = new displayMenuController(StringRawInfo);

        ListView names = findViewById(R.id.ItemsInTrolly);
        final CustomListAdapter trollyList = new CustomListAdapter(this, m1.returnTrolly(), m1.returnTrollyPrice());

        names.setAdapter(trollyList);

        mainMenuButton = (Button)findViewById(R.id.endButton);
        restartOrderButton = (Button)findViewById(R.id.RestartOrderButton);
        payCashButton = (Button)findViewById(R.id.PayCashButton);

        chickenBurgerButton = (Button)findViewById(R.id.chickenBurgerButton);
        Soft_Drink  = (Button)findViewById(R.id.SoftDrinkButton);
        Beef_Burger = (Button)findViewById(R.id.BeefBurgerButton);
        Steak = (Button)findViewById(R.id.SteakButton);
        Chicken_Nuggets = (Button)findViewById(R.id.ChickenNuggetsButton);
        Fish_and_Chips = (Button)findViewById(R.id.FishChipsButton);
        Fries = (Button)findViewById(R.id.friesButton);


        totalTrollyPrice = (TextView)findViewById(R.id.totalTrollyPrice);

        mainMenuButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(displayMenu.this, mainMenu.class);
                startActivity(intent);
            }
        });



        Soft_Drink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               m1.itemButtonPress(0);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        chickenBurgerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(1);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        Beef_Burger.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(2);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        Steak.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(3);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        Chicken_Nuggets.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(4);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        Fish_and_Chips.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(5);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        Fries.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                m1.itemButtonPress(6);
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        restartOrderButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                m1.restartOrder();
                trollyList.clear();
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));


            }
        });

        payCashButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                m1.restartOrder();
                trollyList.clear();
                trollyList.notifyDataSetChanged();
                totalTrollyPrice.setText("$" + String.valueOf(m1.setPrice()));

            }
        });





    }



    public String returnMenuString(){


        String text = "";
        try {
            InputStream is = getAssets().open("menu.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return text;

    }


    public void addToInvoices(ArrayList<String> trolly) throws IOException {
        //TODO



    }
}
