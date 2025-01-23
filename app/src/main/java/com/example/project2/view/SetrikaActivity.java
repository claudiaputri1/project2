package com.example.project2.view;

import android.app.Activity;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.project2.R;
import com.example.project2.utils.FunctionHelper;
import com.example.project2.viewmodel.AddDataViewModel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import im.delight.android.location.SimpleLocation;

public class SetrikaActivity extends AppCompatActivity {

    public static final String DATA_TITLE = "TITLE";
    int hargaKaos = 4000, hargaCelana = 5000, hargaJaket = 6000, hargaSprei = 15000, hargaKarpet = 0;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0, itemCount4 = 0, itemCount5 = 0;
    int countKaos, countCelana, countJaket, countSprei, countKarpet, totalItem, totalHarga;
    String strTitle, strCurrentLocation, strCurrentLatLong;
    double strCurrentLatitude;
    double strCurrentLongitude;
    SimpleLocation simpleLocation;
    AddDataViewModel addDataViewModel;
    Button btnCheckout;
    ImageView imageAdd1, imageAdd2, imageAdd3, imageAdd4, imageAdd5,
            imageMinus1, imageMinus2, imageMinus3, imageMinus4, imageMinus5;
    TextView tvTitle, tvInfo, tvJumlahBarang, tvTotalPrice, tvKaos, tvCelana, tvJaket, tvSprei, tvKarpet,
            tvPriceKaos, tvPriceCelana, tvPriceJaket, tvPriceSprei, tvPriceKarpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);

        setLocation();
        setStatusBar();
        setInitLayout();
        setDataKaos();
        setDataCelana();
        setDataJaket();
        setDataSprei();
        setDataKarpet();
        setInputData();
        getCurrentLocation();
    }

    private void setLocation() {
        simpleLocation = new SimpleLocation(this);

        if (!simpleLocation.hasLocationEnabled()) {
            SimpleLocation.openSettings(this);
        }

        // get location
        strCurrentLatitude = simpleLocation.getLatitude();
        strCurrentLongitude = simpleLocation.getLongitude();

        // set location lat long
        strCurrentLatLong = strCurrentLatitude + "," + strCurrentLongitude;
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(TextView.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void setInitLayout() {
        tvTitle = findViewById(R.id.tvTitle);
        tvInfo = findViewById(R.id.tvInfo);

        tvJumlahBarang = findViewById(R.id.tvJumlahBarang);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);

        tvKaos = findViewById(R.id.tvKaos);
        tvCelana = findViewById(R.id.tvCelana);
        tvJaket = findViewById(R.id.tvJaket);
        tvSprei = findViewById(R.id.tvSprei);
        tvKarpet = findViewById(R.id.tvKarpet);
        tvPriceKaos = findViewById(R.id.tvPriceKaos);
        tvPriceCelana = findViewById(R.id.tvPriceCelana);
        tvPriceJaket = findViewById(R.id.tvPriceJaket);
        tvPriceSprei = findViewById(R.id.tvPriceSprei);
        tvPriceKarpet = findViewById(R.id.tvPriceKarpet);

        imageAdd1 = findViewById(R.id.imageAdd1);
        imageAdd2 = findViewById(R.id.imageAdd2);
        imageAdd3 = findViewById(R.id.imageAdd3);
        imageAdd4 = findViewById(R.id.imageAdd4);
        imageAdd5 = findViewById(R.id.imageAdd5);
        imageMinus1 = findViewById(R.id.imageMinus1);
        imageMinus2 = findViewById(R.id.imageMinus2);
        imageMinus3 = findViewById(R.id.imageMinus3);
        imageMinus4 = findViewById(R.id.imageMinus4);
        imageMinus5 = findViewById(R.id.imageMinus5);

        btnCheckout = findViewById(R.id.btnCheckout);

        strTitle = getIntent().getExtras().getString(DATA_TITLE);
        if (strTitle != null) {
            tvTitle.setText(strTitle);
        }

        addDataViewModel = new ViewModelProvider(this, ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(this.getApplication()))
                .get(AddDataViewModel.class);

        tvJumlahBarang.setText("0 items");
        tvTotalPrice.setText("Rp 0");
        tvInfo.setText("Hilangkan kerutan dari pakaian Anda dengan setrika listrik & uap");
    }

    private void setDataKaos() {
        tvKaos.setText(FunctionHelper.rupiahFormat(hargaKaos));
        imageAdd1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            tvPriceKaos.setText(itemCount1);
            countKaos = hargaKaos * itemCount1;
            setTotalHarga();
        });

        imageMinus1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                tvPriceKaos.setText(itemCount1);
            }
            countKaos = hargaKaos * itemCount1;
            setTotalHarga();
        });
    }

    private void setDataCelana() {
        tvKaos.setText(FunctionHelper.rupiahFormat(hargaCelana));
        imageAdd2.setOnClickListener(v -> {
            itemCount2 = itemCount2 + 1;
            tvPriceCelana.setText(itemCount2);
            countCelana = hargaCelana * itemCount2;
            setTotalHarga();
        });

        imageMinus2.setOnClickListener(v -> {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1;
                tvPriceCelana.setText(itemCount2);
            }
            countCelana = hargaCelana * itemCount2;
            setTotalHarga();
        });
    }

    private void setDataJaket() {
        tvJaket.setText(FunctionHelper.rupiahFormat(hargaJaket));
        imageAdd3.setOnClickListener(v -> {
            itemCount3 = itemCount3 + 1;
            tvPriceJaket.setText(itemCount3);
            countJaket = hargaJaket * itemCount3;
            setTotalHarga();
        });

        imageMinus3.setOnClickListener(v -> {
            if (itemCount3 > 0) {
                itemCount3 = itemCount3 - 1;
                tvPriceJaket.setText(itemCount3);
            }
            countJaket = hargaJaket * itemCount3;
            setTotalHarga();
        });
    }

    private void setDataSprei() {
        tvSprei.setText(FunctionHelper.rupiahFormat(hargaSprei));
        imageAdd4.setOnClickListener(v -> {
            itemCount4 = itemCount4 + 1;
            tvPriceSprei.setText(itemCount4);
            countSprei = hargaSprei * itemCount4;
            setTotalHarga();
        });

        imageMinus4.setOnClickListener(v -> {
            if (itemCount4 > 0) {
                itemCount4 = itemCount4 - 1;
                tvPriceSprei.setText(itemCount4);
            }
            countSprei = hargaSprei * itemCount4;
            setTotalHarga();
        });
    }

    private void setDataKarpet() {
        tvKarpet.setText(FunctionHelper.rupiahFormat(hargaKarpet));
        imageAdd5.setOnClickListener(v -> {
            itemCount5 = itemCount5 + 1;
            tvPriceKarpet.setText(itemCount5);
            countKarpet = hargaKarpet * itemCount5;
            setTotalHarga();
        });

        imageMinus5.setOnClickListener(v -> {
            if (itemCount5 > 0) {
                itemCount5 = itemCount5 - 1;
                tvPriceKarpet.setText(itemCount5);
            }
            countKarpet = hargaKarpet * itemCount5;
            setTotalHarga();
        });
    }

    private void setTotalHarga() {
        totalItem = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5;
        totalHarga = countKaos + countCelana + countJaket + countSprei + countKarpet;

        tvJumlahBarang.setText(totalItem + "items");
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalHarga));
    }

    private void getCurrentLocation() {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(strCurrentLatitude, strCurrentLongitude, 1);
            if (addressList != null && addressList.size() > 0) {
                strCurrentLocation = addressList.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setInputData() {
        btnCheckout.setOnClickListener(v -> {
            if (totalItem == 0 || totalHarga == 0) {
                Toast.makeText(SetrikaActivity.this, "Harap pilih jenis barang!", Toast.LENGTH_SHORT).show();
            } else {
                addDataViewModel.addDataLaundry(strTitle, totalItem, strCurrentLocation, totalHarga);
                Toast.makeText(SetrikaActivity.this, "Pesanan Anda sedang diproses, silahkan cek di menu riwayat", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= bits;
        }
        window.setAttributes(layoutParams);
    }
}