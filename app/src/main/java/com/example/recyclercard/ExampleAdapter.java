package com.example.recyclercard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    //6.2
    private ArrayList<ExampleItem> mExampleList; //type of data want to store

   //1create ExampleView Holder class
      public static class ExampleViewHolder extends RecyclerView.ViewHolder{ //in this we have to write what we want to show
          //4
       public ImageView imageView;
       public TextView textView;


          //2 create constructor of ExampleViewHolder
        public ExampleViewHolder(@NonNull View itemView) { //so that we dont have to call all the time image and text
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);

        }
    }
    //3 implements three method by clicking on debug bulb on error
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) { //what is gonna show in view
       //5
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card,parent,false);
ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
return  exampleViewHolder;
    }
    //6.1
    public ExampleAdapter(ArrayList<ExampleItem>examplelist){ //to add data in our view
          mExampleList=examplelist;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) { //it recreate the view for next item after sliding up a view by user
//7
        ExampleItem currentItem=mExampleList.get(i);
        exampleViewHolder.imageView.setImageResource(currentItem.getMimageResource());
        exampleViewHolder.textView.setText(currentItem.getMtext());
    }

    @Override
    public int getItemCount() {  //it count the item
        return mExampleList.size();
    }


        }


