package pt.apt.bobi

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

private  const val REQUEST_IMAGE_CAPTURE = 100
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            openNativeCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            findViewById<ImageView>(R.id.imageView).setImageBitmap(imageBitmap)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
    private fun openNativeCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)

    }
}