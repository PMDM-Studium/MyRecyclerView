package es.studium.myrecyclerview;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaletteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final View circleView;
    private final TextView titleTextView;
    private final TextView subtitleView;
    private final RecyclerViewOnItemClickListener listener;

    public PaletteViewHolder(@NonNull View itemView,
                             @NonNull RecyclerViewOnItemClickListener listener){
        super(itemView);
        circleView=itemView.findViewById(R.id.circleView);
        titleTextView =itemView.findViewById(R.id.titleTextView);
        subtitleView=itemView.findViewById(R.id.subtitleTextView);
        this.listener=listener;
        itemView.setOnClickListener(this);
    }
    public void bindRow(@NonNull Color color){
        titleTextView.setText(color.getName());
        subtitleView.setText(color.getHex());
        GradientDrawable gradientDrawable =(GradientDrawable) circleView.getBackground();
        int colorID=android.graphics.Color.parseColor(color.getHex());
        gradientDrawable.setColor(colorID);
    }
    @Override
    public void onClick(View v){
        listener.onClick(v, getAdapterPosition());
    }

}
