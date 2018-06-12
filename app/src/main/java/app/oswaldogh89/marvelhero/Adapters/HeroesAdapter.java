package app.oswaldogh89.marvelhero.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import app.oswaldogh89.marvelhero.Entities.Heroe;
import app.oswaldogh89.marvelhero.R;

/**
 * Created by oswaldogh89 on 22/04/18.
 */


public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ListViewHolder> {

    private ArrayList<Heroe> heroes;
    private Context context;
    private static final int LIMIT_CHARACTERES = 80;

    public HeroesAdapter(Context context, ArrayList<Heroe> heroes) {
        this.heroes = heroes;
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_heroes, parent, false));
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {
        Heroe res = heroes.get(position);

        Glide.with(context)
                .load(res.getThumbnail().getPath() + "." + res.getThumbnail().getExtension())
                .apply(new RequestOptions().override(200, 200).placeholder(R.drawable.marvel).centerCrop())
                .into(holder.thumbnail);

        holder.name.setText(res.getName());
        holder.description.setText(prepareDescription(res.getDescription()));
    }

    private String prepareDescription(String description) {
        return description.length() > LIMIT_CHARACTERES ? description.substring(0, LIMIT_CHARACTERES) : description;
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView thumbnail;

        ListViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

}
