package com.example.agrishop;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.HttpCookie;
import java.text.BreakIterator;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> implements OnClickListener {
     public Model model;
    private Context context;
    private ArrayList<Model> arrayList;
    DatabaseHelper databaseHelper;
    Uri uri;
    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        databaseHelper=new DatabaseHelper(context);
    }

    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        model = arrayList.get(position);
        String id = model.getId();
        String image = model.getImage();
        String name = model.getName();
        String price = model.getPrice();
        String quantity=model.getQuantity();
        String contact=model.getContact();
        String desc = model.getDesc();
        holder.t4.setText(id);
        holder.i1.setImageURI(Uri.parse(image));
        holder.t1.setText(name);
        holder.t2.setText(price);
        holder.t5.setText(quantity);
        holder.t6.setText(contact);
        holder.t7.setText(desc);
        holder.b1.setOnClickListener( this);



 }




    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,Order.class);

        intent.putExtra("ID",model.getId());
        intent.putExtra("NAME",model.getName());
        intent.putExtra("PRICE",model.getPrice());
        intent.putExtra("CONTACT",model.getContact());
        intent.putExtra("DESC",model.getDesc());
        context.startActivity(intent);
    }


    public static class Holder extends RecyclerView.ViewHolder{

        ImageView i1;
        TextView t1,t2,t7,t4,t5,t6;
        Button b1;
        public Holder(@NonNull View itemView) {
            super(itemView);
            i1=itemView.findViewById(R.id.profile);
            t4=itemView.findViewById(R.id.sino);
            t1=itemView.findViewById(R.id.name);
            t2=itemView.findViewById(R.id.price);
            t5=itemView.findViewById(R.id.quantity);
            t6=itemView.findViewById(R.id.contact);
             t7=itemView.findViewById(R.id.desc);
             b1=itemView.findViewById(R.id.button1);




        }


    }
}
