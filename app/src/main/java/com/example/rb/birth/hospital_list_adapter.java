package com.example.rb.birth;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class hospital_list_adapter extends ArrayAdapter<hospital_model> {
    private Activity context;
    static int i=1;
    private List<hospital_model> list;
    TextView t1,t2,t3,t4;
    public hospital_list_adapter(Activity context,List<hospital_model> list)
    {
        super(context,R.layout.list_layout_hospital,list);
        this.context=context;
        this.list=list;

    }

    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
      //  return super.getView(position, convertView, parent);
        LayoutInflater inflator=context.getLayoutInflater();
        View item=inflator.inflate(R.layout.list_layout_hospital,null,true);
       t1=item.findViewById(R.id.registrationno);
        t2=item.findViewById(R.id.temporary_name);
        t3=item.findViewById(R.id.fathername);
        t4=item.findViewById(R.id.place);

        hospital_model model=list.get(position);
        t1.setText("R.NO: "+model.getRegistration_no());
        t2.setText("Name: "+model.getName());
        t3.setText("Father name: "+model.getFather());
        t4.setText("Place of birth: "+model.getPlace());
        return item;


    }
}
