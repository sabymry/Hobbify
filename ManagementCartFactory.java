package com.example.myapp.helper;

public class ManagementCartFactory {
    public static ManagementCart createManagementCart(Context context) {
        return new ManagementCart(context);
    }
}
