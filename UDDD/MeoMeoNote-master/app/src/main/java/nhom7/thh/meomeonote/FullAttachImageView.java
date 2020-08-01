package nhom7.thh.meomeonote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FullAttachImageView extends AppCompatActivity {

    ozaydin.serkan.com.image_zoom_view.ImageViewZoom fullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_attach_image_view);
        fullImage = findViewById(R.id.attach_image_full);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        fullImage.setImageBitmap(bitmap);

    }
}