package com.example.events;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class holder extends RecyclerView.ViewHolder {
    View view;
    public holder(@NonNull View itemView) {
        super(itemView);
        view=itemView;


    }

    public void setView(Context context,String EventDetail,String EventId,String EventImage,String EventName) {
        TextView name=view.findViewById(R.id.name);
        TextView id1=view.findViewById(R.id.id1);
        TextView ed=view.findViewById(R.id.ed);
        ImageView img=view.findViewById(R.id.img);
        name.setText(EventName);
        id1.setText(EventId);
        ed.setText(EventDetail);
        Uri myUri= Uri.parse(EventImage);
        img.setImageURI(myUri);



    }
}
