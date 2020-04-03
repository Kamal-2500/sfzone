package com.example.sfzone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TimeTableActivity extends AppCompatActivity {

    ListView timetableListView;
    String mtitle[]={"TYBCA_B_TimeTable","FirstExam_TimeTable"};
    Object[] images ={R.drawable.pdf2,R.drawable.pdf2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        timetableListView = (ListView) findViewById(R.id.timetableListView);


        MyAdapter adapter = new MyAdapter(this, mtitle, images);
        timetableListView.setAdapter(adapter);

        timetableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(TimeTableActivity.this, "TYBCA_B_TimeTable", Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(TimeTableActivity.this, "FirstExam_TimeTable", Toast.LENGTH_SHORT).show();
                }
            }
    });
    }


    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rtitle[];
        Object rImgs[];

        MyAdapter(Context c,String title[],Object imgs[]) {
            super(c, R.layout.timetable_row, R.id.timetable_title1, title);
            this.context = c;
            this.rtitle = title;
            this.rImgs = imgs;
        }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View row = layoutInflater.inflate(R.layout.timetable_row, parent, false);
                ImageView images = row.findViewById(R.id.timetable_image);
                TextView myTitle=row.findViewById(R.id.timetable_title1);

                images.setImageResource((Integer) rImgs[position]);
                myTitle.setText(rtitle[position]);

                return row;
            }
        }
    }


