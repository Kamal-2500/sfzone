package com.example.sfzone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class NotesActivity extends AppCompatActivity {

//    ListView notesListView;
//    String mtitle[]={"Note 1","Note 2","Note 3","Note 4","Note 5"};
//    Object[] mimages ={R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notes);
//
//        notesListView = (ListView) findViewById(R.id.notesListView);
//
//        MyAdapter adapter = new MyAdapter(this, mtitle, mimages);
//        notesListView.setAdapter(adapter);
//
//        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position == 0){
//                    Toast.makeText(NotesActivity.this, "Note 1", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(NotesActivity.this, "Note 2", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(NotesActivity.this, "Note 3", Toast.LENGTH_SHORT).show();
//                }
//                if(position == 0){
//                    Toast.makeText(NotesActivity.this, "Note 4", Toast.LENGTH_SHORT).show();
//                }if(position == 0){
//                    Toast.makeText(NotesActivity.this, "Note 5", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
        super.onCreate(savedInstanceState);
    }

//    class MyAdapter extends ArrayAdapter<String>{
//
//        Context context;
//        String rtitle[];
//        Object rImgs[];
//
//        MyAdapter(Context c,String title[],Object imgs[]){
//            super(c,R.layout.notes_row,R.id.note_title1, title);
//            this.context=c;
//            this.rtitle=title;
//            this.rImgs=imgs;
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = layoutInflater.inflate(R.layout.notes_row, parent, false);
//            ImageView images=row.findViewById(R.id.image);
//            TextView myTitle=row.findViewById(R.id.note_title1);
//
//
//            images.setImageResource((Integer) rImgs[position]);
//            myTitle.setText(rtitle[position]);
//
//
//
//            return row;
//        }
//    }
}