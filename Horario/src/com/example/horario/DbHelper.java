package com.example.horario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table lunes(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("create table martes(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("create table miercoles(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("create table jueves(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("create table viernes(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("create table sabado(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("create table domingo(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists lunes");
		db.execSQL("create table lunes(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("drop table if exists martes");
		db.execSQL("create table martes(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("drop table if exists miercoles");
		db.execSQL("create table miercoles(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("drop table if exists jueves");
		db.execSQL("create table jueves(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("drop table if exists viernes");
		db.execSQL("create table viernes(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("drop table if exists sabado");
		db.execSQL("create table sabado(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
		db.execSQL("drop table if exists domingo");
		db.execSQL("create table domingo(Id integer primary key autoincrement, " +
				"Materia text, Horai text, Horaf text)");
	}

}
