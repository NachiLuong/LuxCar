package com.luxcar.utillities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;

import com.luxcar.configurations.ApplicationProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageHandler {

    private static ImageHandler imageHandler;

    @NonNull
    public static ImageHandler instance() {
        if (!Optional.ofNullable(imageHandler).isPresent()) {
            imageHandler = new ImageHandler();
        }
        return imageHandler;
    }

    public Bitmap getImage(@NonNull String path) {
        try {
            InputStream ip = ApplicationProperties.CONTEXT.getAssets().open(path);
            return BitmapFactory.decodeStream(ip);
        } catch (IOException e) {
            Log.e("Image", e.getMessage());
        }
        return null;
    }

}
