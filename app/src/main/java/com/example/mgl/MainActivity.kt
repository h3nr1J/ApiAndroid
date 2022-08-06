package com.example.mgl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //android:name="com.example.mgl.firstFragment" --> Primera manera de hacerlo se copia este codigo en "activity.main.xml"
        //Otra forma para que se muestre el fragment en el activity_main.xml
        supportFragmentManager.commit {
            setReorderingAllowed(true) //Para que las animaciones y transiciones se ejecuten correctamente
            add(R.id.fragment_container_view,firstFragment()) //Nos pide Container Id  + nombre del fragment
        }
    }
}