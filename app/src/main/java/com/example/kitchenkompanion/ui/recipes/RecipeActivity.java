package com.example.kitchenkompanion.ui.recipes;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kitchenkompanion.MainActivity;
import com.example.kitchenkompanion.R;

public class RecipeActivity extends AppCompatActivity {
    Context context;
    TextView title;
    ImageView food_image, recipe_image;
    ActionBar actionBar;
    Bundle bundle;;
    String recipe_name;
    int food_pic, recipe_pic;

    private Button switch_list_button;

    //confirm add to shopping list popup
    private AlertDialog.Builder dialogBuilder5;
    private AlertDialog dialog5;
    private Button no_purchase_button, purchase_button;
    private TextView purchase_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        title = (TextView)findViewById(R.id.title);
        //Recieve arguments from other class
        bundle = getIntent().getExtras();
        recipe_name = bundle.getString("recipe_name");
        food_pic = bundle.getInt("food_pic");
        recipe_pic = bundle.getInt("recipe_pic");
        title.setText(recipe_name);
        food_image = (ImageView)findViewById(R.id.picture);
        food_image.setImageResource(food_pic);
        recipe_image = (ImageView) findViewById(R.id.recipe);
        recipe_image.setImageResource(recipe_pic);

        switch_list_button = (Button) this.findViewById(R.id.shoppingButton);
        switch_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MyDebugTag", "Recipe Name: " + recipe_name);
                confirmAddPopup(recipe_name);
            }
        });
    }

    public void confirmAddPopup(String recipe_name) {
        if (recipe_name.equals("Baked Potato") || recipe_name.equals("Chocolate Chip Pancakes")) {
            dialogBuilder5 = new AlertDialog.Builder(this);
            final View confirmPurchasePopup = getLayoutInflater().inflate(R.layout.shop_confirm_purchase_popup1, null);
            no_purchase_button = (Button) confirmPurchasePopup.findViewById(R.id.cancel_button77);
            purchase_button = (Button) confirmPurchasePopup.findViewById(R.id.confirm_button77);
            purchase_message = (TextView) confirmPurchasePopup.findViewById(R.id.remove_confirm_text);

            dialogBuilder5.setView(confirmPurchasePopup);
            dialog5 = dialogBuilder5.create();
            dialog5.show();

            String[] item_names;
            String[] item_counts;

            if (recipe_name.equals("Baked Potato")) {
                item_names = new String[]{"Potato", "Olive Oil", "Garlic Powder", "Paprika"};
                item_counts = new String[]{"1 ", "1 ", "1 ", "1 "};
            } else {
                item_names = new String[]{"Flour", "Sugar", "Cinnamon", "Baking Powder", "Egg", "Milk", "Butter", "Vanilla", "Chocolate Chips"};
                item_counts = new String[]{"1 ", "1 ", "1 ", "1 ", "2 ", "1 ", "4 ", "1 ", "1 "};
            }

            String message = "Add these items to Shopping List?\n";
            for (int i = 0; i < item_names.length; i++) {
                message += item_counts[i].trim() + " " + item_names[i].trim() + "\n";
            }

            purchase_message.setText(message);

            no_purchase_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog5.dismiss();
                }
            });

            purchase_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < item_names.length; i++) {
                        MainActivity.addToShoppingList(item_names[i], item_counts[i], false);
                    }
                    Toast.makeText(getApplicationContext(),"Items added",Toast.LENGTH_SHORT).show();
                    dialog5.dismiss();
                }
            });
        } else {
            Toast.makeText(getApplicationContext(),"CAN ONLY ADD ITEMS FOR\n\"Baked Potato\"\n or \n\"Chocolate Chip Pancakes\"",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
