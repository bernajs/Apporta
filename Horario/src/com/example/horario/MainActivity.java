package com.example.horario;

import java.io.File;
import java.io.FileOutputStream;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	

	//String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
	//int cont=0;
	/*String materias[] = new String[6];
	String horai[] = new String[6];
	String horaf[] = new String[6];
	int cont=0;*/
	private Button btncrear, btnagregar;
	private ImageButton btncamara;
	private EditText nombremateria;
	private EditText horailun, horaimar, horaimie, horaijue, horaivie;
	private EditText horaflun, horafmar, horafmie, horafjue, horafvie;
	private CheckBox lunes, martes, miercoles, jueves, viernes;
	String nomdir;
	//int band = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		btncrear = (Button)findViewById(R.id.Btncrear);
		return true;
	}	
	
	public void Horario(View v){
		setContentView(R.layout.crear_horario);
		//band = 1;
	}
	
	public void Menu(View v){
//		btncrear = (Button)findViewById(R.id.Btncrear);
		setContentView(R.layout.activity_main);
		btncrear.setEnabled(false);
	}
	
	public void IrCamara(Bitmap imageToSave, String fileName){
		btncamara = (ImageButton)findViewById(R.id.Btncamara);
		Intent camaraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
		startActivity(camaraIntent);
		
		File file = new File(new File(Environment.getExternalStorageDirectory()+File.separator+"BookTure"), fileName);
		if(file.exists()){
			file.delete();
		}
		try{
			FileOutputStream out = new FileOutputStream(file);
			imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
			out.flush();
			out.close();			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void AgregarMateria(View v){
		File folder = new File(Environment.getExternalStorageDirectory()+File.separator+"BookTure");
		boolean success = true;
		if (folder.exists()) {		    
		    /*Toast.makeText(this, "BookTure ya existente", Toast.LENGTH_SHORT).show();
		    Toast.makeText(this, "Carpeta no agregada", Toast.LENGTH_SHORT).show();*/
		}else{
		    // Do something on success
			success = folder.mkdir();
			Toast.makeText(this, "BookTure creada", Toast.LENGTH_SHORT).show();
			Toast.makeText(this, "Carpeta agregada correctamente", Toast.LENGTH_SHORT).show();}
		
		nombremateria = (EditText)findViewById(R.id.Nombremat);
		lunes = (CheckBox)findViewById(R.id.Lunes);
		martes = (CheckBox)findViewById(R.id.Martes);
		miercoles = (CheckBox)findViewById(R.id.Miercoles);
		jueves = (CheckBox)findViewById(R.id.Jueves);
		viernes = (CheckBox)findViewById(R.id.Viernes);
		horailun = (EditText)findViewById(R.id.Horailun);
		horaimar = (EditText)findViewById(R.id.Horaimar);
		horaimie = (EditText)findViewById(R.id.Horaimie);
		horaijue = (EditText)findViewById(R.id.Horaijue);
		horaivie = (EditText)findViewById(R.id.Horaivie);
		horaflun = (EditText)findViewById(R.id.Horaflun);
		horafmar = (EditText)findViewById(R.id.Horafmar);
		horafmie = (EditText)findViewById(R.id.Horafmie);
		horafjue = (EditText)findViewById(R.id.Horafjue);
		horafvie = (EditText)findViewById(R.id.Horafvie);
		DbHelper horari = new DbHelper(this, "horario", null, 1);
		SQLiteDatabase db = horari.getWritableDatabase();
		String mat = nombremateria.getText().toString();
		String hrailun = horailun.getText().toString();
		String hraflun = horaflun.getText().toString();
		String hraimar = horaimar.getText().toString();
		String hrafmar = horafmar.getText().toString();
		String hraimie = horaimie.getText().toString();
		String hrafmie = horafmie.getText().toString();
		String hraijue = horaijue.getText().toString();
		String hrafjue = horafjue.getText().toString();
		String hraivie = horaivie.getText().toString();
		String hrafvie = horafvie.getText().toString();
		if(lunes.isChecked() == true){
			ContentValues registro = new ContentValues();
			registro.put("Materia", mat);
			registro.put("Horai", hrailun);
			registro.put("Horaf", hraflun);
			db.insert("lunes", null, registro);
		}
		if(martes.isChecked() == true){
			ContentValues registro = new ContentValues();
			registro.put("Materia", mat);
			registro.put("Horai", hraimar);
			registro.put("Horaf", hrafmar);
			db.insert("martes", null, registro);
		}
		if(miercoles.isChecked() == true){
			ContentValues registro = new ContentValues();
			registro.put("Materia", mat);
			registro.put("Horai", hraimie);
			registro.put("Horaf", hrafmie);
			db.insert("miercoles", null, registro);
		}
		if(jueves.isChecked() == true){
			ContentValues registro = new ContentValues();
			registro.put("Materia", mat);
			registro.put("Horai", hraijue);
			registro.put("Horaf", hrafjue);
			db.insert("jueves", null, registro);
		}
		if(viernes.isChecked() == true){
			ContentValues registro = new ContentValues();
			registro.put("Materia", mat);
			registro.put("Horai", hraivie);
			registro.put("Horaf", hrafvie);
			db.insert("viernes", null, registro);
		}
		//File directory = new File(Environment.getExternalStorageDirectory()+File.separator+mat);
		//directory.mkdir();		
		File folder1 = new File(Environment.getExternalStorageDirectory()+File.separator+"BookTure"+File.separator+mat);
		boolean success1 = true;
		if (folder1.exists()) {		    
		    Toast.makeText(this, "Carpeta ya existente", Toast.LENGTH_SHORT).show();
		    Toast.makeText(this, "Materia no agregada", Toast.LENGTH_SHORT).show();
		}else{
		    // Do something on success
			success1 = folder1.mkdir();
			Toast.makeText(this, "Carpeta creada", Toast.LENGTH_SHORT).show();
			Toast.makeText(this, "Materia agregada correctamente", Toast.LENGTH_SHORT).show();}
		nomdir = mat;	
		/*} else {
		    // Do something else on failure 
			Toast.makeText(this, "Carpeta ya existente", Toast.LENGTH_SHORT).show();
		}	*/	
		db.close();
		nombremateria.setText("");
		if(lunes.isChecked()==true){
			lunes.toggle();
		}
		horailun.setText("");
		horaflun.setText("");
		if(martes.isChecked()==true){
			martes.toggle();
		}
		horaimar.setText("");
		horafmar.setText("");
		if(miercoles.isChecked()==true){
			miercoles.toggle();
		}
		horaimie.setText("");
		horafmie.setText("");
		if(jueves.isChecked()==true){
			jueves.toggle();
		}
		horaijue.setText("");
		horafjue.setText("");
		if(viernes.isChecked()==true){
			viernes.toggle();
		}
		horaivie.setText("");
		horafvie.setText("");		
		
	}
	
	
	
}
