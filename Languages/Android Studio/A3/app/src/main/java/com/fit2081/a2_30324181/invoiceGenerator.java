package com.fit2081.a2_30324181;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.fit2081.a2_30324181.provider.Invoice;
import com.fit2081.a2_30324181.provider.InvoiceViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

import java.util.StringTokenizer;

//A2



public class invoiceGenerator extends AppCompatActivity {

    EditText issuerName, buyerName, buyerAddress, itemName, itemQuantity, itemCost;
    Switch isPaid;
    SharedPreferences sP;
    final String INVOICE_PREF = "InvoicePref";
    private float totalInvoiceValue = 0;


    //A2
    DrawerLayout drawerLayout;

    NavigationView navigationView;

    Toolbar toolbar;
    FloatingActionButton fab;

    ArrayList<String> dataSource;
    ListView listView;
    ArrayList<item> data = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    itemAdapter adapter;
    InvoiceViewModel viewModel;

    GestureDetectorCompat mDetector;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_activity_invoice);

        issuerName = findViewById(R.id.issuerName);
        buyerName = findViewById(R.id.buyerName);
        buyerAddress = findViewById(R.id.buyerAddress);
        isPaid = findViewById(R.id.paidSwitch);
        itemName = findViewById(R.id.itemName);
        itemQuantity = findViewById(R.id.itemQuantity);
        itemCost = findViewById(R.id.itemCost);


        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS, android.Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 0);

        sP = getSharedPreferences(INVOICE_PREF, MODE_PRIVATE);

        MyCustomBroadcastReceiver myCustomBroadcastReciever = new MyCustomBroadcastReceiver();
        registerReceiver(myCustomBroadcastReciever, new IntentFilter(SMSReciever.SMS_FILTER),RECEIVER_EXPORTED);


        //A2
        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new Week3NavListener());


        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInvoiceDatabasae();
            }
        });
        if (recyclerView == null) {
            recyclerView = findViewById(R.id.recyclerItem);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new itemAdapter();
            recyclerView.setAdapter(adapter);
        }



        viewModel = new ViewModelProvider(this).get(InvoiceViewModel.class);

        //A3
        View gesturesView = findViewById(R.id.gesturesView);
        mDetector=new GestureDetectorCompat(this,new MyGestureListener());

        gesturesView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });

    }


    //A2
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.options_add_item) {
            saveItemData();

        } else if (id == R.id.options_clear_field) {
            clearEditText();
        }
        return true;
    }



    class Week3NavListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();

            if (id == R.id.nav_add_item) {
                saveItemData();

            } else if (id == R.id.nav_add_invoice) {
                saveInvoiceDatabasae();

            } else if (id == R.id.nav_clear_fields) {
                clearEditText();
            } else if (id == R.id.nav_items_map) {
                Intent intent = new Intent(invoiceGenerator.this, ItemMap.class);
                startActivity(intent);
            }

            else if (id == R.id.nav_list_invoice) {
                Intent intent = new Intent(invoiceGenerator.this, invoiceListView.class);
                startActivity(intent);
            }
            else if (id == R.id.nav_exit) {
                finishAffinity();
            }

            return true;
        }
    }

    private void clearEditText(){
        issuerName.setText("");
        buyerName.setText("");
        buyerAddress.setText("");
        isPaid.setChecked(false);
        itemName.setText("");
        itemQuantity.setText("");
        itemCost.setText("");
    }


    //A2
    class MyCustomBroadcastReceiver  extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra(SMSReciever.SMS_MSG_KEY);

            String[] parts = msg.split(":", 2);
            if (parts.length < 2) {
                Toast.makeText(context, "Invalid command format", Toast.LENGTH_SHORT).show();
                return;
            }

            String command = parts[0].toLowerCase();
            String details = parts[1];

            StringTokenizer sT = new StringTokenizer(details, ";");

            switch (command) {
                case "invoice":
                    if (sT.countTokens() >= 4) {
                        issuerName.setText(sT.nextToken());
                        buyerName.setText(sT.nextToken());
                        buyerAddress.setText(sT.nextToken());
                        isPaid.setChecked("true".equalsIgnoreCase(sT.nextToken()));
                    } else {
                        Toast.makeText(invoiceGenerator.this, "Incomplete invoice data", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "item":
                    if (sT.countTokens() >= 3) {
                        itemName.setText(sT.nextToken());
                        itemQuantity.setText(sT.nextToken());
                        itemCost.setText(sT.nextToken());
                    } else {
                        Toast.makeText(invoiceGenerator.this, "Incomplete item data", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case "save":
                    if (sT.hasMoreTokens() && "invoice".equals(sT.nextToken())) {
                        try {
                            saveInvoiceData();
                        } catch (Exception e) {
                            Toast.makeText(invoiceGenerator.this, "Please fill out the information properly.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

                case "load":
                    if (sT.hasMoreTokens() && "invoice".equals(sT.nextToken())) {
                        loadInvoiceData();
                    }
                    break;
                default:
                    Toast.makeText(context, "Unrecognized command", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //A2
    private void saveItemData(){
        //itemName, itemquantity, itemcost
        String itemNameSt = itemName.getText().toString();
        String itemQuantitySt = itemQuantity.getText().toString();
        String itemCostSt = itemCost.getText().toString();

        int itemQuantityInt = Integer.parseInt(itemQuantitySt);
        float itemCostFloat = Float.valueOf(itemCostSt);


        item item  = new item(itemNameSt,itemQuantityInt,itemCostFloat);

        data.add(item);
        adapter.setData(data);
        adapter.notifyDataSetChanged();
        totalInvoiceValue += itemCostFloat * itemQuantityInt;

        TextView invoiceTotalView = findViewById(R.id.invoiceTotal);
        invoiceTotalView.setText(String.format("%.1f", totalInvoiceValue));

    }
    //A2

    private void saveInvoiceDatabasae() {


        String issuerNameStr = issuerName.getText().toString();
        String buyerNameStr = buyerName.getText().toString();
        TextView invoiceTotalView = findViewById(R.id.invoiceTotal);
        float invoiceTotal = Float.parseFloat(invoiceTotalView.getText().toString());

        String invoiceId = generateId("invoice", "");

        Invoice invoice = new Invoice(invoiceId, issuerNameStr, buyerNameStr, invoiceTotal);

        viewModel.insertNewInvoice(invoice);

        data.clear();
        totalInvoiceValue = 0;

        adapter.setData(data);
        adapter.notifyDataSetChanged();
        invoiceTotalView.setText(String.format("%.1f", totalInvoiceValue));

    }



    //A2


    private void saveInvoiceData() {
        String invoiceId = generateId("invoice", "");
        String buyerId = generateId("buyer", buyerName.getText().toString());
        String itemId = generateId("item", itemName.getText().toString());
        SharedPreferences.Editor editor = sP.edit();


        editor.putString("IssuerName", issuerName.getText().toString());
        editor.putString("BuyerName", buyerName.getText().toString());
        editor.putString("BuyerAddress", buyerAddress.getText().toString());
        editor.putBoolean("IsPaid", isPaid.isChecked());
        editor.putString("ItemName", itemName.getText().toString());
        editor.putInt("ItemQuantity", Integer.parseInt(itemQuantity.getText().toString()));
        editor.putFloat("ItemCost", Float.parseFloat(itemCost.getText().toString()));

        editor.apply();
        Toast.makeText(this, "Invoice ID: " + invoiceId + "\nBuyer ID: " + buyerId + "\nItem ID: " + itemId, Toast.LENGTH_LONG).show();


        //Total Value and items

        int itemQuantityValue = Integer.parseInt(itemQuantity.getText().toString());
        float itemCostValue = Float.parseFloat(itemCost.getText().toString());
        float totalValue = itemQuantityValue * itemCostValue;
        editor.putFloat("TotalValue", totalValue);
        editor.putString("Items", itemName.getText().toString());


        //reset the initial value
        issuerName.setText("");
        buyerName.setText("");
        buyerAddress.setText("");
        isPaid.setChecked(false);
        itemName.setText("");
        itemQuantity.setText("");
        itemCost.setText("");

    }


    private String generateId(String type, String name) {
        final Random random = new Random();
        StringBuilder id = new StringBuilder();

        try {
            switch (type) {
                case "invoice":
                    id.append("I");
                    for (int i = 0; i < 2; i++) {
                        id.append((char) (random.nextInt(26) + 'A')); // Directly appending ASCII character
                    }
                    id.append("-");
                    for (int i = 0; i < 4; i++) {
                        id.append(random.nextInt(10));
                    }
                    break;
                case "buyer":
                    id.append("B").append(name.substring(0, 2));
                    id.append("-");
                    for (int i = 0; i < 3; i++) {
                        id.append(random.nextInt(10));
                    }
                    break;
                case "item":
                    id.append("T").append(name.substring(0, 2));
                    id.append("-");
                    for (int i = 0; i < 4; i++) {
                        id.append(random.nextInt(10));
                    }
                    break;
            }
        } catch (StringIndexOutOfBoundsException e) {
            Toast.makeText(getApplicationContext(), "Missing required name for " + type + " ID generation.", Toast.LENGTH_SHORT).show();
        }
        return id.toString();
    }


    private void loadInvoiceData() {
        // Read all the invoice data
        String issuerNameValue = sP.getString("IssuerName", "");
        String buyerNameValue = sP.getString("BuyerName", "");
        String buyerAddressValue = sP.getString("BuyerAddress", "");
        boolean isPaidValue = sP.getBoolean("IsPaid", false);
        String itemNameValue = sP.getString("ItemName", "");
        int itemQuantityValue = sP.getInt("ItemQuantity", 0);
        float itemCostValue = sP.getFloat("ItemCost", 0);

        // Update the UI components
        issuerName.setText(issuerNameValue);
        buyerName.setText(buyerNameValue);
        buyerAddress.setText(buyerAddressValue);
        isPaid.setChecked(isPaidValue);
        itemName.setText(itemNameValue);
        itemQuantity.setText(String.valueOf(itemQuantityValue));
        itemCost.setText(String.format("%.0f", itemCostValue));

        Toast.makeText(this, "Invoice data loaded", Toast.LENGTH_SHORT).show();
    }

    //A3
    public void wikiBtn(View view){
        String itemNameSt = itemName.getText().toString().trim();
        Intent intent = new Intent(invoiceGenerator.this, WebWiki.class);
        intent.putExtra("ITEM_NAME", itemNameSt);
        startActivity(intent);

    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            saveInvoiceDatabasae();
            return true;
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            saveItemData();

        }

        @Override
        public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceX) > Math.abs(distanceY)) {
                adjustItemCost(distanceX);
            } else if (Math.abs(distanceY) > Math.abs(distanceX)) {
                adjustItemQuantity(distanceY);
            }
            return true;
        }

        private void adjustItemCost(float distanceX) {
            String costString = itemCost.getText().toString();
            int currentCost;
            if (costString.isEmpty()) {
                currentCost = 0;
            } else {
                currentCost = Integer.parseInt(costString);
            }

            currentCost += (int)distanceX;
            currentCost = Math.max(0, currentCost);
            currentCost = Math.min(currentCost, 3000);
            itemCost.setText(String.valueOf(currentCost));
        }

        private void adjustItemQuantity(float distanceY) {
            String quantityString = itemQuantity.getText().toString();
            int currentQuantity;
            if (quantityString.isEmpty()) {
                currentQuantity = 0;
            } else {
                currentQuantity = Integer.parseInt(quantityString);
            }
            currentQuantity += distanceY;
            currentQuantity = Math.max(0, currentQuantity);
            itemQuantity.setText(String.valueOf(Math.max(0, currentQuantity)));
        }
    }


}