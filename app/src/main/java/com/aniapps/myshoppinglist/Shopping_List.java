package com.aniapps.myshoppinglist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shopping_List extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ExpandableListView exlv_shopping;
    ArrayList<MainList> mainLists = new ArrayList<>();

    ArrayList<SubList> mySelectedList = new ArrayList<>();
    SubList subList = new SubList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView();

        loadAllData();

    }

    private void navigationView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySelectedList=new ArrayList<>();
                for (int k = 0; k < allChecks.size(); k++) {
                    if(allChecks.get(k).isChecked()){
                        subList=new SubList(categoryTitle.get(k).toString(),0,allTitles.get(k).getText().toString(),allUnits.get(k).getText().toString(),allNotes.get(k).getText().toString(),true);
                        mySelectedList.add(subList);
                    }
                }




              /*  for (int i = 0; i < allNotes.size(); i++) {
                    strings[i] = allNotes.get(i).getText().toString();
                    Log.e("#####", "my Notes" + strings[i]);
                }*/

                for (int i = 0; i < mySelectedList.size(); i++) {

                    Log.e("My List: ", mySelectedList.get(i).getCategory()+": "+mySelectedList.get(i).getSub_title()+" "+ mySelectedList.get(i).getQuantity()+" "+mySelectedList.get(i).getNote());


                }

                /*Intent intent = new Intent(Shopping_List.this, CheckedActivity.class);
                startActivity(intent);*/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        //https://trinitytuts.com/create-pdf-file-in-android/
        //https://medium.com/android-school/exploring-itext-to-create-pdf-in-android-5577881998c8
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    LayoutInflater inflater;
    LinearLayout lay_main;

    View subRow, childRow;
    int row_index = 0, veg_index = 0;
    TextView tv_maintitle;
    List<String> categoryTitle = new ArrayList<String>();
    List<TextView> allTitles = new ArrayList<TextView>();
    List<CheckBox> allChecks = new ArrayList<CheckBox>();
    List<EditText> allNotes = new ArrayList<EditText>();
    List<EditText> allUnits = new ArrayList<EditText>();

    public void loadAllData() {
        //main_layout, sub_layout, child_layout
        lay_main = (LinearLayout) findViewById(R.id.lay_main);


        String[] main_list = getResources().getStringArray(R.array.array_main);
        String[] veg_list = getResources().getStringArray(R.array.array_vegetables);
        String[] furits_list = getResources().getStringArray(R.array.array_furits);
        String[] refrigerated_list = getResources().getStringArray(R.array.array_refrigerated);
        String[] frozen_list = getResources().getStringArray(R.array.array_frozen);
        String[] condiments_list = getResources().getStringArray(R.array.array_condiments);

        for (int i = 0; i < main_list.length; i++) {
            LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View laysub = mInflater.inflate(R.layout.sub_layout, null);
            tv_maintitle = (TextView) laysub.findViewById(R.id.tv_maintitle);
            final LinearLayout lay_child = (LinearLayout) laysub.findViewById(R.id.lay_child);
            tv_maintitle.setText(main_list[i]);
            tv_maintitle.setTag(i);


            switch (i) {
                case 0:
                    for (String aVegList : veg_list) {
                        LayoutInflater mInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View laychild = mInflater1.inflate(R.layout.child_layout, null);
                        TextView tv_childtitle = (TextView) laychild.findViewById(R.id.tv_childtitle);
                        ImageView list_image = (ImageView) laychild.findViewById(R.id.list_image);
                        CheckBox cb_child = (CheckBox) laychild.findViewById(R.id.cb_child);
                        EditText et_units = (EditText) laychild.findViewById(R.id.et_units);
                        EditText et_notes = (EditText) laychild.findViewById(R.id.et_notes);
                        tv_childtitle.setText(aVegList);
                        categoryTitle.add(main_list[0]);
                        allTitles.add(tv_childtitle);
                        allChecks.add(cb_child);
                        allUnits.add(et_units);
                        allNotes.add(et_notes);
                        lay_child.addView(laychild);
                    }
                    break;
                case 1:

                    for (String aVegList : furits_list) {
                        LayoutInflater mInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View laychild = mInflater1.inflate(R.layout.child_layout, null);
                        TextView tv_childtitle = (TextView) laychild.findViewById(R.id.tv_childtitle);
                        ImageView list_image = (ImageView) laychild.findViewById(R.id.list_image);
                        CheckBox cb_child = (CheckBox) laychild.findViewById(R.id.cb_child);
                        EditText et_units = (EditText) laychild.findViewById(R.id.et_units);
                        EditText et_notes = (EditText) laychild.findViewById(R.id.et_notes);
                        tv_childtitle.setText(aVegList);
                        categoryTitle.add(main_list[1]);
                        allTitles.add(tv_childtitle);
                        allChecks.add(cb_child);
                        allUnits.add(et_units);
                        allNotes.add(et_notes);
                        lay_child.addView(laychild);


                    }
                    break;
                case 2:

                    for (String aVegList : refrigerated_list) {
                        LayoutInflater mInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View laychild = mInflater1.inflate(R.layout.child_layout, null);
                        TextView tv_childtitle = (TextView) laychild.findViewById(R.id.tv_childtitle);
                        ImageView list_image = (ImageView) laychild.findViewById(R.id.list_image);
                        CheckBox cb_child = (CheckBox) laychild.findViewById(R.id.cb_child);
                        EditText et_units = (EditText) laychild.findViewById(R.id.et_units);
                        EditText et_notes = (EditText) laychild.findViewById(R.id.et_notes);
                        tv_childtitle.setText(aVegList);
                        categoryTitle.add(main_list[2]);
                        allTitles.add(tv_childtitle);
                        allChecks.add(cb_child);
                        allUnits.add(et_units);
                        allNotes.add(et_notes);
                        lay_child.addView(laychild);
                    }
                    break;
                default:

                    for (String aVegList : frozen_list) {
                        LayoutInflater mInflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View laychild = mInflater1.inflate(R.layout.child_layout, null);
                        TextView tv_childtitle = (TextView) laychild.findViewById(R.id.tv_childtitle);
                        ImageView list_image = (ImageView) laychild.findViewById(R.id.list_image);
                        CheckBox cb_child = (CheckBox) laychild.findViewById(R.id.cb_child);
                        EditText et_units = (EditText) laychild.findViewById(R.id.et_units);
                        EditText et_notes = (EditText) laychild.findViewById(R.id.et_notes);
                        tv_childtitle.setText(aVegList);
                        categoryTitle.add(main_list[3]);
                        allTitles.add(tv_childtitle);
                        allChecks.add(cb_child);
                        allUnits.add(et_units);
                        allNotes.add(et_notes);
                        lay_child.addView(laychild);
                    }
                    break;

            }
          //  mySelectedList.add(subList);
            //  mainTitle.add("Condiments");
            //                    mainTitle.add("Groceries");


            tv_maintitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (lay_child.getVisibility() == View.VISIBLE) {
                        lay_child.setVisibility(View.GONE);
                    } else {
                        lay_child.setVisibility(View.VISIBLE);
                    }
                }
            });
            lay_main.addView(laysub);


        }
    }

}
