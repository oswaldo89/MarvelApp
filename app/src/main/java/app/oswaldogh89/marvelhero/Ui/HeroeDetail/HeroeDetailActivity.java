package app.oswaldogh89.marvelhero.Ui.HeroeDetail;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import app.oswaldogh89.marvelhero.Adapters.ComicsAdapter;
import app.oswaldogh89.marvelhero.Entities.Heroe;
import app.oswaldogh89.marvelhero.R;

public class HeroeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe_detail);

        Bundle extras = getIntent().getExtras();
        Gson gson = new Gson();
        Heroe heroe = gson.fromJson(extras.getString("heroe_data"), Heroe.class);

        ImageView backdrop = findViewById(R.id.backdrop);
        Glide.with(this).load(heroe.getThumbnail().getPath() + "." + heroe.getThumbnail().getExtension()).into(backdrop);

        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Detalle");

        TextView txtName = findViewById(R.id.txtName);
        txtName.setText(heroe.getName());

        TextView txtDescription = findViewById(R.id.descriptionProduct);
        txtDescription.setText(heroe.getDescription().equals("") ? "Sin descripción" : heroe.getDescription());

        /* Comics en los que ha participado */

        ListView listPessoas = findViewById(R.id.listView);
        ComicsAdapter adapter = new ComicsAdapter(this, heroe.getComics().getItems());
        listPessoas.setAdapter(adapter);

    }
}
