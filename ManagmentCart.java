package com.example.myapp.helper;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.project167.domain.PopularDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    private ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public static ManagementCart createInstance(Context context) {
        return new ManagementCart(context);
    }

    public void insertFood(PopularDomain item) {
        ArrayList<PopularDomain> listPop = getListCart();
        boolean existsAlready = false;
        int index = 0;

        for (int i = 0; i < listPop.size(); i++) {
            if (listPop.get(i).getTitle().equals(item.getTitle())) {
                existsAlready = true;
                index = i;
                break;
            }
        }

        if (existsAlready) {
            listPop.get(index).setNumberInCart(item.getNumberInCart());
        } else {
            listPop.add(item);
        }

        tinyDB.putListObject("CartList", listPop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PopularDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public Double getTotalFee() {
        ArrayList<PopularDomain> listItem = getListCart();
        double fee = 0;

        for (int i = 0; i < listItem.size(); i++) {
            fee += (listItem.get(i).getPrice() * listItem.get(i).getNumberInCart());
        }

        return fee;
   
