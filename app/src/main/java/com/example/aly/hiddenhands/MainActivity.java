package com.example.aly.hiddenhands;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aly.hiddenhands.fragments.About;
import com.example.aly.hiddenhands.fragments.ChooseDoctor;
import com.example.aly.hiddenhands.fragments.DoctorHomePage;
import com.example.aly.hiddenhands.fragments.FavouriteDoctors;
import com.example.aly.hiddenhands.fragments.HowToUse;
import com.example.aly.hiddenhands.fragments.Login;
import com.example.aly.hiddenhands.fragments.PatientHomePage;
import com.example.aly.hiddenhands.fragments.SignupDoctor;
import com.example.aly.hiddenhands.fragments.SignupUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    android.widget.SearchView searchView;
    ProgressBar progressBar;

    long type; //1->patient  , 2->doctor
    //My Fragments
    private PatientHomePage patientHomePage;
    private DoctorHomePage doctorHomePage;
    private About about;
    private HowToUse howToUse;
    private FavouriteDoctors favouriteDoctors;
    private SignupUser signupUser;
    private Login login;
    private SignupDoctor signupDoctor;
    private ChooseDoctor chooseDoctor;

    //Firebase
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mUserTypeDatabaseReference;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private boolean Auth=false;


    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mAuthStateListener!=null)
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase initialize
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mFirebaseAuth=FirebaseAuth.getInstance();

        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                progressBar.setVisibility(View.VISIBLE);
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser!=null){
                    searchView.setVisibility(View.VISIBLE);

                    navigationView.getMenu().getItem(0).setVisible(true);
                    navigationView.getMenu().getItem(1).setVisible(false);
                    navigationView.getMenu().getItem(2).setVisible(false);
                    navigationView.getMenu().getItem(3).setVisible(false);
                    navigationView.getMenu().getItem(4).setVisible(true);
                    navigationView.getMenu().getItem(5).setVisible(true);
                    navigationView.getMenu().getItem(6).setVisible(true);
                    navigationView.getMenu().getItem(7).setVisible(true);

                    login=null;
                    signupDoctor=null;
                    signupUser=null;
                    patientHomePage=new PatientHomePage();
                    favouriteDoctors=new FavouriteDoctors();
                    navigationView.getMenu().getItem(0).setChecked(true);

                    mUserTypeDatabaseReference=mFirebaseDatabase.getReference().child("Users").child(firebaseUser.getUid()).child("type");
                    mUserTypeDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                           // Toast.makeText(getApplicationContext(),dataSnapshot.getValue(long.class).toString(),Toast.LENGTH_SHORT).show();
                            type=dataSnapshot.getValue(long.class);
                            progressBar.setVisibility(View.GONE);
                            if(type==1){
                                navigationView.getMenu().getItem(4).setVisible(true);
                                doctorHomePage=null;
                                patientHomePage=new PatientHomePage();
                                favouriteDoctors=new FavouriteDoctors();
                                loadFragment(patientHomePage);
                            }
                            else{
                                navigationView.getMenu().getItem(4).setVisible(false);
                                patientHomePage=null;
                                favouriteDoctors=null;
                                doctorHomePage=new DoctorHomePage();
                                loadFragment(doctorHomePage);

                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                    Toast.makeText(MainActivity.this, "Welcome To HiddenHands", Toast.LENGTH_SHORT).show();

                }
                else{
                    progressBar.setVisibility(View.GONE);
                    searchView.setVisibility(View.VISIBLE);
                    navigationView.getMenu().getItem(0).setVisible(false);
                    navigationView.getMenu().getItem(1).setVisible(true);
                    navigationView.getMenu().getItem(2).setVisible(true);
                    navigationView.getMenu().getItem(3).setVisible(true);
                    navigationView.getMenu().getItem(4).setVisible(false);
                    navigationView.getMenu().getItem(5).setVisible(true);
                    navigationView.getMenu().getItem(6).setVisible(true);
                    navigationView.getMenu().getItem(7).setVisible(false);
                    patientHomePage=null;
                    favouriteDoctors=null;
                    login=new Login();
                    signupDoctor=new SignupDoctor();
                    signupUser=new SignupUser();
                    navigationView.getMenu().getItem(5).setChecked(true);
                    loadFragment(about);
                }

            }
        };
        if(mFirebaseAuth.getCurrentUser()!=null){
            Auth=true;
        }


        searchView=(android.widget.SearchView)findViewById(R.id.search_bar);
        progressBar=(ProgressBar) findViewById(R.id.progress_homepage);
        progressBar.setVisibility(View.VISIBLE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //initialize Fragments
        about=new About();
        howToUse=new HowToUse();
        chooseDoctor=new ChooseDoctor();
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setVisibility(View.GONE);
                loadFragment(chooseDoctor);
            }
        });

       /* if(Auth){
            patientHomePage=new PatientHomePage();
            favouriteDoctors=new FavouriteDoctors();
            navigationView.getMenu().getItem(0).setChecked(true);
            loadFragment(patientHomePage);

        }
        else{
            signupUser=new SignupUser();
            signupDoctor=new SignupDoctor();
            login=new Login();
            navigationView.getMenu().getItem(5).setChecked(true);
            loadFragment(about);
        }
*/





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

        if (id == R.id.signin) {
            searchView.setVisibility(View.GONE);
            loadFragment(login);
        } else if (id == R.id.signup_user) {
            searchView.setVisibility(View.GONE);
            loadFragment(signupUser);

        } else if (id == R.id.signup_doctor) {
            searchView.setVisibility(View.GONE);
            loadFragment(signupDoctor);


        } else if (id == R.id.fav_doctors) {
            searchView.setVisibility(View.VISIBLE);
            loadFragment(favouriteDoctors);

        } else if (id == R.id.about) {
            searchView.setVisibility(View.VISIBLE);
            loadFragment(about);

        } else if (id == R.id.howtouse) {
            searchView.setVisibility(View.VISIBLE);
            loadFragment(howToUse);

        } else if (id == R.id.profile) {

        } else if (id == R.id.logout) {
            mFirebaseAuth.signOut();

        }else if(id==R.id.home){
            searchView.setVisibility(View.VISIBLE);
            if(type==1){
                loadFragment(patientHomePage);

            }
            else{
                loadFragment(doctorHomePage);
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commitAllowingStateLoss();

            fragmentManager.executePendingTransactions();
            return true;
        } else return false;
    }
}
