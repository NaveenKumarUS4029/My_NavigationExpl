package ran.am.mynavigationexpl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.RCViewHolder> {

    HomeFragment context;
    ArrayList<RCModel> modelArrayList;
    ItemClickListener mItemClickListener;

    public RCAdapter(ArrayList<RCModel> modell, ItemClickListener itemClickListener) {
        this.context = context;
        this.modelArrayList = modell;
        this.mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rc_item_view, parent, false);
        return new RCViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RCViewHolder holder, int position) {

        RCModel rcModel = modelArrayList.get(position);
        holder.rc_title.setText(rcModel.title);
        holder.rc_subTitle.setText(rcModel.subTitle);
        holder.rc_image.setImageResource(rcModel.image);

//        setAnimation(holder.itemView,position);

        holder.rc_cardView.setOnClickListener(view -> {
            mItemClickListener.onItemClick(modelArrayList.get(position));

        });

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public interface ItemClickListener {
        void onItemClick(RCModel details);// we have to create interface for listener
    }

    public class RCViewHolder extends RecyclerView.ViewHolder implements ran.am.mynavigationexpl.RCViewHolder {

        ImageView rc_image;
        TextView rc_title, rc_subTitle;
        CardView rc_cardView;

        public RCViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener((View.OnClickListener) this);
//            itemView.setOnClickListener((View.OnClickListener) this);
            this.rc_image = itemView.findViewById(R.id.rc_img);
            this.rc_title = itemView.findViewById(R.id.rc_title);
            this.rc_subTitle = itemView.findViewById(R.id.rc_subtitle);
            this.rc_cardView = itemView.findViewById(R.id.rc_cardvieww);

        }
    }
}
//    private void setAnimation(View viewToAnimate, int position)
//    {
//        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
//            Animation animation = AnimationUtils.loadAnimation(context.getContext(), android.R.anim.slide_in_left);
//            viewToAnimate.startAnimation(animation);
//            lastPosition = position;
//        }
//    }

