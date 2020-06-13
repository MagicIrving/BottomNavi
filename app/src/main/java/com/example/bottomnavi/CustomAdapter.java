package com.example.bottomnavi;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavi.CustomDTO;
import com.example.bottomnavi.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<CustomDTO> listCustom = new ArrayList<>();

    @Override
    public int getCount() {
        return listCustom.size();
    }

    @Override
    public Object getItem(int position) {
        return listCustom.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, null, false);

            holder = new CustomViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.textTitle = (TextView) convertView.findViewById(R.id.text_title);
            holder.textContent = (TextView) convertView.findViewById(R.id.text_content);

            convertView.setTag(holder);
            LinearLayout cmdArea=(LinearLayout)convertView.findViewById(R.id.cmdArea);
            cmdArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
                    dlg.setTitle("상품 구매");
                    dlg.setMessage("상품을 구매하시려면 구매 버튼을 눌러 주세요");
                    Toast.makeText(view.getContext(),listCustom.get(position).getContent(),Toast.LENGTH_LONG).show();
                    dlg.setPositiveButton("구매",null);
                    dlg.setNegativeButton("취소",null);
                    dlg.show();
                }
            });

        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        CustomDTO dto = listCustom.get(position);

        holder.imageView.setImageResource(dto.getResId());
        holder.textTitle.setText(dto.getTitle());
        holder.textContent.setText(dto.getContent());

        return convertView;
    }

    class CustomViewHolder {
        ImageView imageView;
        TextView textTitle;
        TextView textContent;
    }



    public void addItem(CustomDTO dto) {
        listCustom.add(dto);
    }
}