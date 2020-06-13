package com.example.bottomnavi;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

public class Fragment2 extends Fragment {


    private View view ;
    private ListView listView ;
    private CustomAdapter adapter ;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false) ;

        adapter = new CustomAdapter() ;
        listView = (ListView)view.findViewById(R.id.listView) ;

        return super.onCreateView(inflater, container, savedInstanceState) ;


    }

    private void setData() {
        TypedArray arrResId = getResources().obtainTypedArray(R.array.resId) ;
        String[] title = getResources().getStringArray(R.array.title) ;
        String[] contents = getResources().getStringArray(R.array.content) ;

        for (int i = 0; i < arrResId.length(); i++) {
            CustomDTO dto= new CustomDTO() ;
            dto.setResId(arrResId.getResourceId(i, 0));
            dto.setTitle(title[i]);
            dto.setContent(contents[i]);

            adapter.addItem(dto);
        }
    }






}


