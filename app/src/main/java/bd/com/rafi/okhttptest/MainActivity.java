package bd.com.rafi.okhttptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 public static List<Model> data=new ArrayList<>();
  static  TextView id,email,fname,lname;
 static ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(TextView)findViewById(R.id.email);
        listView=findViewById(R.id.list);
        Respons respons=new Respons("https://resttestmico.000webhostapp.com/apptesting/V1/doctorlist.php",MainActivity.this);
        //Toast.makeText(MainActivity.this,respons.data().getEmail(),Toast.LENGTH_SHORT).show();

    }
/*public static void fun(){
        id.setText(data.get(2).getFname());
    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data);
}*/

}
