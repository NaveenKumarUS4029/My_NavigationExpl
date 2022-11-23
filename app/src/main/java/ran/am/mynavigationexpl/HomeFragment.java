package ran.am.mynavigationexpl;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<RCModel> modelArrayList;
    RCAdapter rcAdapter;

    String[] title = new String[]{
            "Topics to be Learned and its Output",
            "Course Syllabus",
            "Reviews",
            "About us",
            "Start Learning",
            "Contact us",
            "Training Album",
            "Github"
    };
    String[] subTitle = new String[]{
          "Contains basic Topics programs",
          "Contains Syllabus",
          "You can review here",
          "About us With my profile",
          "Start Learn in this Platform",
          "Contact us of our Location",
          "Here you can see my Training Album",
          "Get a android codes from Github"

    };


    int[] image = new int[]{
            R.drawable.checklist, R.drawable.syllabus,
            R.drawable.comment, R.drawable.personaldata,
            R.drawable.read, R.drawable.phone,
            R.drawable.gallery_img, R.drawable.github
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        modelArrayList = new ArrayList<>();

        rcAdapter = new RCAdapter(modelArrayList, new RCAdapter.ItemClickListener() {
            @Override
            public void onItemClick(RCModel details) {
//                startActivity(new Intent(getActivity(),SettingFragment.class));

                showToast(details.title+ " Clicked!");

            }
        });

        recyclerView.setAdapter(rcAdapter);

        for (int i = 0; i < title.length; i++) {
            RCModel rcModel = new RCModel(title[i],subTitle[i], image[i] );
            modelArrayList.add(rcModel);
        }
        rcAdapter.notifyDataSetChanged();

        return view;
    }
    public void showToast(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}