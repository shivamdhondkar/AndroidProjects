package com.example.myapplication.Design;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.AlphabetModel;

import java.util.ArrayList;

public class GridviewAdapter extends ArrayAdapter<AlphabetModel> {

    public GridviewAdapter(@NonNull Context context, ArrayList<AlphabetModel>alphabetModels) {
        super(context, 0,alphabetModels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        HolderView holderView;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate((R.layout.grid ), parent , false);
            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        }
        else{
            holderView = (HolderView) convertView.getTag();
        }

        AlphabetModel model = getItem(position);
        holderView.icons.setImageResource(model.getIconId());
        holderView.tv.setText(model.getLetters());


        return convertView;
    }

    private static class HolderView{
        private final ImageView icons;
        private final TextView tv;

        public HolderView(View view)
        {
            icons = view.findViewById(R.id.icon_id);
            tv = view.findViewById(R.id.textview);
        }
    }
}
