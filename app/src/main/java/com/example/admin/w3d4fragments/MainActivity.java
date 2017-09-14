package com.example.admin.w3d4fragments;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListArtistFragment.OnFragmentInteractionListener, DetailsArtistFragment.OnFragmentInteractionListener{
    ArrayList<Famous> famousData;
    Famous famous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        famousData = new ArrayList<>();
        famousData.add(new Famous("CHARLIZE THERON", "Date of Birth: August 7, 1975 | Birth Place: Benoni, South Africa", R.drawable.charlize));
        famousData.add(new Famous("ANNA KENDRICK", "Date of Birth: August 9, 1985 | Birth Place: Portland, ME", R.drawable.annakendrick164008421));
        famousData.add(new Famous("CHANNING TATUM", "Date of Birth: April 26, 1980 | Birth Place: Cullman, AL", R.drawable.channing162613136));
        famousData.add(new Famous("CHRIS EVANS", "Date of Birth: June 13, 1981 | Birth Place: Sudbury, MA", R.drawable.chrisevans12));
        famousData.add(new Famous("GEORGE CLOONEY", "Date of Birth: May 6, 1961 | Birth Place: Lexington, KY", R.drawable.clooneyperfp));
        famousData.add(new Famous("GAL GADOT", "Date of Birth: April 30, 1985 | Birth Place: Rosh Ha'Ayin, Israel", R.drawable.gadot));
        famousData.add(new Famous("JOHNNY DEPP", "Date of Birth: June 9, 1963 | Birth Place: Owensboro, KY", R.drawable.johnnydeep));
        famousData.add(new Famous("Christine", "Actor2", R.drawable.kristinwiig162157550));
        famousData.add(new Famous("JENNIFER LAWRENCE", "Date of Birth: August 15, 1990 | Birth Place: Louisville, KY", R.drawable.lawrencejennifer));
        famousData.add(new Famous("JARED LETO", "Date of Birth: December 26, 1971 | Birth Place: Bossier City, LA", R.drawable.leto));
        famousData.add(new Famous("ROBERT DOWNEY, JR.", "Date of Birth: April 4, 1965 | Birth Place: New York, NY\n", R.drawable.robert162574544));
        famousData.add(new Famous("SCARLETT JOHANSSON", "Date of Birth: November 22, 1984 | Birth Place: New York, NY", R.drawable.scarlett159652076));
        famousData.add(new Famous("EMMA STONE", "Date of Birth: November 6, 1988  | Birth Place:Scottsdale, Arizona, U.S.", R.drawable.stone159231705));
        famousData.add(new Famous("WILL SMITH", "Date of Birth: September 25, 1968 | Birth Place: Philadelphia, PA", R.drawable.willsmith169638915));


        ListArtistFragment listArtistFragment =  ListArtistFragment.newInstance(famousData);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout_left, listArtistFragment, "list_artist_fragment_tag_id")
                .commit();



        Famous famous = famousData.get(0);

        DetailsArtistFragment detailsArtistFragment = DetailsArtistFragment.newInstance(famous);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_layout_right, detailsArtistFragment, "details_artist_fragment_tag_id")
                .commit();


    }

    @Override
    public void onFragmentInteraction(String data) {
        int position = Integer.parseInt(data);
        Log.d("TAG", "onButtonPressedFinallll: " + position);

        Famous famous = famousData.get(position);

        DetailsArtistFragment detailsArtistFragment = DetailsArtistFragment.newInstance(famous);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_right, detailsArtistFragment, "details_artist_fragment_tag_id")
                .commit();
    }
}
