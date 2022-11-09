package com.example.buylist.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buylist.LocationDetailsActivity;
import com.example.buylist.R;
import com.example.buylist.models.DataManager;
import com.example.buylist.models.Location;

import java.util.ArrayList;

public class ShoppingLocationAdapter extends RecyclerView.Adapter<ShoppingLocationAdapter.ViewHolder> {

    private ArrayList<Location> locations;
    //ID of each item used to navigate to or manipulate each item
    public static final String EXTRA_LOCATION_ID = "location_id";
    //Context of the RecyclerView activity
    private Activity activity;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    Intent intent;

    public void setLocations(ArrayList<Location> locations){
        this.locations=locations;
    }

    public void setActivity(Activity activity){
        this.activity=activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_shoping_location,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.locationName.setText(locations.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            Button editLocation, deleteLocation;
            TextView locationName;
            RelativeLayout relativeLayout;
            DataManager dataManager;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            locationName = itemView.findViewById(R.id.locationName);
            editLocation = itemView.findViewById(R.id.btnEditLocation);
            deleteLocation = itemView.findViewById(R.id.btnDeleteLocation);
            relativeLayout = itemView.findViewById(R.id.simpleShoppingLocation);

            editLocation.setOnClickListener(this);
            deleteLocation.setOnClickListener(this);
            relativeLayout.setOnClickListener(this);

            dataManager = new DataManager(itemView.getContext());

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.simpleShoppingLocation:
                    intent = new Intent(activity, LocationDetailsActivity.class);
                    intent.putExtra(EXTRA_LOCATION_ID,getAdapterPosition());
                    activity.startActivity(intent);

                case R.id.btnEditLocation:
                    break;

                case R.id.btnDeleteLocation:
                    dialogBuilder = new AlertDialog.Builder(activity);
                    final View viewDeleteLocation = activity.getLayoutInflater().inflate(R.layout.delete_item_popup,null);

                    Button yesBtn = viewDeleteLocation.findViewById(R.id.yesDelete);
                    Button noBtn = viewDeleteLocation.findViewById(R.id.noDelete);
                    TextView message = viewDeleteLocation.findViewById(R.id.deleteItemLabel);

                    message.setText("Do you wish do delete this Location?");

                    dialogBuilder.setView(viewDeleteLocation);
                    dialog = dialogBuilder.create();
                    dialog.show();


                    noBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });


                    yesBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            locations.remove(getAdapterPosition());
                            dataManager.deleteLocation(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            dialog.dismiss();
                        }
                    });


                    break;



            }




        }
    }
}
