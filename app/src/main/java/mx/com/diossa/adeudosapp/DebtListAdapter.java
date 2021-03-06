package mx.com.diossa.adeudosapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SALAS on 10/09/2017.
 */

public class DebtListAdapter extends ArrayAdapter<Debt> {

    private Context context;
    private int layoutId;
    private ArrayList<Debt> debtArrayList;

    public DebtListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Debt> objects) {
        super(context, resource, objects);

        this.context = context;
        this.layoutId = resource;
        this.debtArrayList = objects;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DebtViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layoutId,parent,false);

            viewHolder = new DebtViewHolder();

            viewHolder.debtImage = (ImageView)convertView.findViewById(R.id.img_debt);
            viewHolder.debtCreditor = (TextView)convertView.findViewById(R.id.txt_debt_creditor);
            viewHolder.debtTotal = (TextView)convertView.findViewById(R.id.txt_debt_total);
            viewHolder.debtMonths = (TextView)convertView.findViewById(R.id.txt_debt_months);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (DebtViewHolder)convertView.getTag();
        }

        Debt debt = debtArrayList.get(position);
        viewHolder.debtImage.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.deuda));
        viewHolder.debtCreditor.setText(debt.getCreditor());
        viewHolder.debtTotal.setText(String.valueOf(debt.getTotal()));
        viewHolder.debtMonths.setText(String.valueOf(debt.getMonths()));

        return convertView;
        /*
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutId,parent,false);

        ImageView debtImage = (ImageView)view.findViewById(R.id.img_debt);
        TextView debtTitle = (TextView)view.findViewById(R.id.txt_debt_creditor);
        TextView debtTotal = (TextView)view.findViewById(R.id.txt_debt_total);
        TextView debtMonths = (TextView)view.findViewById(R.id.txt_debt_months);

        Debt debt = debtArrayList.get(position);
        debtImage.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.deuda));
        debtTitle.setText(debt.getCreditor());
        debtTotal.setText(String.valueOf(debt.getTotal()));
        debtMonths.setText(String.valueOf(debt.getMonths()));

        return view;*/
    }

    private class DebtViewHolder{
        ImageView debtImage;
        TextView debtCreditor;
        TextView debtTotal;
        TextView debtMonths;
    }

}
