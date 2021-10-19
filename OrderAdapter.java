package com.example.agrishop;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>  {
    public Model1 model;
    private Context context;
    private ArrayList<Model1> arrayList;
    OrderDB databaseHelper;
    Uri uri;
    public OrderAdapter(Context context, ArrayList<Model1> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        databaseHelper=new OrderDB(context);
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row1,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        model = arrayList.get(position);
        String id = model.getId();
        String Pid = model.getPid();
        String name = model.getName();
        String price=model.getPrice();
        String quantity=model.getQuantity();
        String contact=model.getContact();
        String desc=model.getDesc();

        String mail=model.getPhone();

        String address=model.getAddress();
        String units=model.getUnits();
        String total=model.getAmount();
        holder.t1.setText(id);
        holder.t2.setText(Pid);
        holder.t3.setText(name);
        holder.t12.setText(price);
        holder.t4.setText(quantity);
        holder.t10.setText(contact);
        holder.t11.setText(desc);
        holder.t5.setText(mail);
        holder.t8.setText(address);
        holder.t7.setText(units);
        holder.t9.setText(total);


    }







    @Override
    public int getItemCount() {
        return arrayList.size();
    }




    class OrderHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;

        public OrderHolder(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.ord);
            t2=itemView.findViewById(R.id.sino);
            t3=itemView.findViewById(R.id.name);
            t12=itemView.findViewById(R.id.orgi);
            t4=itemView.findViewById(R.id.quantity);
            t10=itemView.findViewById(R.id.cont);
            t11=itemView.findViewById(R.id.des);
            t5=itemView.findViewById(R.id.phone);
            t6=itemView.findViewById(R.id.contact);

            t8=itemView.findViewById(R.id.addr1);

            t7=itemView.findViewById(R.id.units1);
            t9=itemView.findViewById(R.id.price);

        }
    }
}
