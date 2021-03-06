package com.example.rb.birth;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class non_register_adapter extends ArrayAdapter<non_register_model> {
    private Activity context;

    private List<non_register_model> list;
    TextView t1,t2,t3,t4,t5;

    public non_register_adapter(Activity context,List<non_register_model> list)
    {
        super(context,R.layout.non_register_list_layout,list);
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //  return super.getView(position, convertView, parent);
        LayoutInflater inflator=context.getLayoutInflater();
        View item=inflator.inflate(R.layout.non_register_list_layout,null,true);

        t2=item.findViewById(R.id.temporary_name);
        t3=item.findViewById(R.id.fathername);
        t4=item.findViewById(R.id.place);
        t5=item.findViewById(R.id.phone);

        non_register_model model=list.get(position);
        //t1.setText("R.NO: "+model.getRegistration());
        t2.setText("Name: "+model.getName());
        t3.setText("Father name: "+model.getFather());
        t4.setText("Place of birth: "+model.getPlace());
        t5.setText("Phone number: "+model.getPhone());
        return item;


    }
}
