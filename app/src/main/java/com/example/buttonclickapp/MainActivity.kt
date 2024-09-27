package com.example.buttonclickapp
import androidx.appcompat.widget.Toolbar
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
private var TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "OnCreate: called")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.note_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val userInput = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        textView = findViewById(R.id.textView)
        /*findViewById: A method provided by Android to find a view in the current layout by its unique ID.
        <EditText>, <Button>, <TextView>: These are type parameters specifying the type of view you're expecting. Using generics here ensures type safety.
        R.id.editText: the id of the userInput widget is editText
        */

        textView?.text = ""  //Clears preexisting text of widget;
        //?.(Safe Call Operator): This operator used to safely access the textView variable in case it's null. If textView is null, this line does nothing, preventing a NullPointerException.
        textView?.movementMethod = ScrollingMovementMethod() //Adds scrolling capability in widget


        button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG, "onClick: called")
               textView?.append(userInput.text)
                textView?.append("\n")
            }
        })
        /*button?.setOnClickListener(...): Assigns a click listener to the button. When the button is tapped, the code inside the listener is executed
        setOnClickListener: A method to register a callback to be invoked when the view is clicked.
        object : View.OnClickListener { ... }: Creates an anonymous inner class that implements the View.OnClickListener interface, allowing you to define custom behavior when the button is clicked
        override fun onClick(v: View?):
            v: The parameter name, representing the view that was clicked.
            View?: The type of the parameter.
            View: The base class for all UI components in Android.
            ? (Nullable): Indicates that the parameter can be null. This is part of Kotlin's null safety feature.
         */
    }
//    override fun onStart() {
//        Log.d(TAG, "onStart: called")
//        super.onStart()
//    }
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        Log.d(TAG, "onRestoreInstanceState: called")
//        super.onRestoreInstanceState(savedInstanceState)
//    }
//    override fun onResume(){
//        Log.d(TAG, "onResume: called")
//        super.onResume()
//    }
//    override fun onPause(){
//        Log.d(TAG, "onPause: called")
//        super.onPause()
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        Log.d(TAG, "onSaveInstanceState: called")
//        if (outState != null) {
//            super.onSaveInstanceState(outState)
//        }
//    }
//
//    override fun onStop() {
//        Log.d(TAG, "onStop: called")
//        super.onStop()
//    }
//
//    override fun onRestart() {
//        Log.d(TAG, "onRestart: called")
//        super.onRestart()
//    }
//
//    override fun onDestroy() {
//        Log.d(TAG, "onDestroy: called")
//        super.onDestroy()
//    }
}